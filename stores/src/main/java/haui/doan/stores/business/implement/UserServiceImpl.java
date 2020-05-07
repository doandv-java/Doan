package haui.doan.stores.business.implement;

import haui.doan.stores.business.service.ImageService;
import haui.doan.stores.business.service.UserService;
import haui.doan.stores.domain.User;
import haui.doan.stores.domain.enums.EGender;
import haui.doan.stores.domain.enums.EOrderState;
import haui.doan.stores.dto.data.Order;
import haui.doan.stores.dto.data.Profile;
import haui.doan.stores.dto.dxo.ChangePasswordDxo;
import haui.doan.stores.dto.dxo.DeleteUserDxo;
import haui.doan.stores.dto.dxo.ForgotPasswordDxo;
import haui.doan.stores.dto.dxo.OrderHistoryDxo;
import haui.doan.stores.dto.dxo.ProfileDxo;
import haui.doan.stores.dto.dxo.RegisterDxo;
import haui.doan.stores.dto.dxo.UserDxo;
import haui.doan.stores.dto.errors.ErrorService;
import haui.doan.stores.dto.rst.ChangePasswordRst;
import haui.doan.stores.dto.rst.DeleteUserRst;
import haui.doan.stores.dto.rst.ForgotPasswordRst;
import haui.doan.stores.dto.rst.OrderHistoryRst;
import haui.doan.stores.dto.rst.ProfileRst;
import haui.doan.stores.dto.rst.RegisterRst;
import haui.doan.stores.dto.rst.UserRst;
import haui.doan.stores.framework.Constants;
import haui.doan.stores.repository.UserRepository;
import haui.doan.stores.utils.DateUtils;
import haui.doan.stores.utils.PasswordGenerate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The service for logic of user
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    // The class access with table user of DB
    private final UserRepository userRepository;

    //The BCrypt password encode password before save in databases
    private final BCryptPasswordEncoder passwordEncoder;

    //Service for image
    private final ImageService imageService;

    /**
     * The method is used to save User in to DB
     *
     * @param userDxo the information user in business layer input {@link UserDxo}
     * @return the user rst include result of save or error service {@link ErrorService}
     */
    @Override
    public UserRst saveUser(UserDxo userDxo) {
        UserRst userRst = new UserRst();
        //Check user exist in DB
        boolean existUser = existUser(userDxo.getUserName(), userDxo.getUsernameOld());
        if (existUser) {
            //Create user service errors
            ErrorService errorService = new ErrorService("userName", "user existed in DB");
            userRst.setResult(false);
            userRst.setErrorServices(Arrays.asList(errorService));
        } else {
            //Save user
            User user = userRepository.findUserById(userDxo.getId());
            if (user == null) {
                //Create user of datatables
                user = new User();
                String password = PasswordGenerate.generatePassword();
                log.info("{} has password:{}", userDxo.getUserName(), password);
                user.setPassword(passwordEncoder.encode(password));
            }
            //Convert dxo to domain
            user.setId(userDxo.getId());
            user.setUserName(userDxo.getUserName());
            user.setRole(userDxo.getRole().getText());
            user.setName(userDxo.getName());
            //Get link image save
            String imageLink = imageService.saveImage(userDxo.getImageLink(), userDxo.getImage());
            user.setImageLink(imageLink);
            user.setAddress(userDxo.getAddress());
            user.setPhone(userDxo.getPhone());
            user.setGender(userDxo.getGender().getValue());
            user.setBirthDay(userDxo.getBirthDay());
            user.setStatus(userDxo.getStatus());
            user.setDeleted(userDxo.getDeleted());
            userRst.setResult(true);
            userRepository.save(user);
        }
        return userRst;
    }


    /**
     * Change password of user
     *
     * @param dxo the data includes id, password Old, password New {@link ChangePasswordDxo}
     * @return the result and error service can exists {@link ChangePasswordRst}
     */
    @Override
    public ChangePasswordRst changePassword(ChangePasswordDxo dxo) {
        ChangePasswordRst rst = new ChangePasswordRst();
        //Get user with id
        User user = userRepository.findUserById(dxo.getId());
        if (user == null) {
            // User not exist
            ErrorService errorService = new ErrorService("id", "not exist user!");
            rst.setStatus(false);
            rst.setErrorServices(Arrays.asList(errorService));
        } else if (passwordEncoder.matches(dxo.getPasswordOld(), user.getPassword())) {
            //Password is matches password encode
            user.setPassword(passwordEncoder.encode(dxo.getPassWordNew()));
            log.info("{} has change password {}", user.getUserName(), dxo.getPassWordNew());
            userRepository.save(user);
            rst.setStatus(true);
        } else {
            //Not matches password encode
            ErrorService errorService = new ErrorService("passwordOld", "password not correct!");
            rst.setStatus(false);
            rst.setErrorServices(Arrays.asList(errorService));
        }
        return rst;
    }

    /**
     * Forgot password  with username
     *
     * @param dxo the data of forgot password {@link ForgotPasswordDxo}
     * @return the result of forgot password {@link ForgotPasswordRst}
     */
    @Override
    public ForgotPasswordRst forgotPassword(ForgotPasswordDxo dxo) {
        ForgotPasswordRst rst = new ForgotPasswordRst();
        User user = userRepository.findUserByUserNameIsAndDeleted(dxo.getUserName(), Constants.DELETE.FALSE);
        if (user == null) {
            rst.setResult(false);
            ErrorService errorService = new ErrorService("userName", "email is not exists!");
            rst.setErrorServices(Arrays.asList(errorService));
        } else {
            String password = PasswordGenerate.generatePassword();
            log.info("{} has change password: {}", dxo.getUserName(), password);
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
            rst.setResult(true);
        }
        return rst;
    }

    /**
     * Register user includes username, password and name with role customer and delete is no
     *
     * @param dxo the data of register {@link RegisterDxo}
     * @return the result of register {@link RegisterRst}
     */
    @Override
    public RegisterRst registerCustomer(RegisterDxo dxo) {
        RegisterRst rst = new RegisterRst();
        //Get user with username from dxo
        User existUser = userRepository.findUserByUserNameIsAndDeleted(dxo.getUsername(), Constants.DELETE.FALSE);
        if (existUser != null) {
            //user with user name register exists
            ErrorService errorService = new ErrorService("userName", "email is existed!");
            rst.setResult(false);
            rst.setErrorServices(Arrays.asList(errorService));
        } else {
            //no user exist with username of register
            existUser = new User();
            existUser.setUserName(dxo.getUsername());
            existUser.setName(dxo.getName());
            log.info("{} register success with password:{}", dxo.getUsername(), dxo.getPassword());
            existUser.setPassword(passwordEncoder.encode(dxo.getPassword()));
            existUser.setRole(dxo.getRole().getText());
            existUser.setGender(dxo.getGender().getValue());
            existUser.setImageLink(Constants.IMAGE_DEFAULT.NAME);
            existUser.setDeleted(Constants.DELETE.FALSE);
            //save user
            userRepository.save(existUser);
            //set result is true
            rst.setResult(true);
        }
        return rst;
    }

    /**
     * Check user exists in table user of database
     * if user exist return true or return false
     *
     * @param userName    email new of user
     * @param userNameOld email old of user before update
     * @return the boolean value of exist User in database
     */
    @Override
    public boolean existUser(String userName, String userNameOld) {
        //Get user with user name
        User user = userRepository.findUserByUserNameIsAndDeleted(userName, Constants.DELETE.FALSE);
        //Create user
        if (StringUtils.isEmpty(userNameOld)) {
            //Check user exists return true else return false
            return user != null;
        } else {
            //Update user information
            boolean notExist = (user == null) || userName.equals(userNameOld);
            return !notExist;
        }
    }

    /**
     * Delete user then change deleted from false into true
     *
     * @param dxo the id of delete user  {@link DeleteUserDxo}
     * @return the result of delete include result or error service {@link DeleteUserRst}
     */
    @Override
    public DeleteUserRst deleteUser(DeleteUserDxo dxo) {
        DeleteUserRst rst = new DeleteUserRst();
        //find user with id
        User existedUser = userRepository.findUserById(dxo.getId());
        if (existedUser == null) {
            //id not exist in database
            ErrorService errorService = new ErrorService("id", "user not exists");
            rst.setResult(false);
            rst.setErrorServices(Arrays.asList(errorService));
        } else {
            //user with id exists
            existedUser.setDeleted(Constants.DELETE.TRUE);
            userRepository.save(existedUser);
            rst.setResult(true);
        }
        return rst;
    }

    /**
     * Get profile of user
     *
     * @param dxo includes id {@link ProfileDxo}
     * @return data of user {@link ProfileRst}
     */
    @Override
    public ProfileRst getProfile(ProfileDxo dxo) {
        ProfileRst rst = new ProfileRst();
        //Retrieve user with id
        User user = userRepository.findUserById(dxo.getId());
        if (user == null) {
            //User is not exists
            rst.setResult(false);
        } else {
            //User is exists
            Profile profile = new Profile();
            profile.setId(user.getId());
            profile.setUserName(user.getUserName());
            profile.setPassword(user.getPassword());
            profile.setRole(user.getRole());
            profile.setName(user.getName());
            profile.setImageLink(user.getImageLink());
            profile.setPhone(user.getPhone());
            profile.setAddress(user.getAddress());
            profile.setGender(EGender.of(user.getGender()).getText());
            profile.setBirthDay(user.getBirthDay());
            profile.setStatus(user.getStatus());
            profile.setDeleted(user.getDeleted());
            rst.setResult(true);
            rst.setProfile(profile);
        }
        return rst;
    }


    /**
     * Get history order
     *
     * @param dxo includes userId {@link OrderHistoryDxo}
     * @return the Order History rst {@link OrderHistoryRst}
     */
    @Override
    public OrderHistoryRst getOrderHistory(OrderHistoryDxo dxo) {
        OrderHistoryRst rst = new OrderHistoryRst();
        List<Order> orderList = new ArrayList<>();
        User user = userRepository.findUserById(dxo.getUserId());
        if (user == null) {
            log.error("User not exists");
        } else {
            CollectionUtils.emptyIfNull(user.getOrders()).stream().forEach(item -> {
                Order order = new Order();
                order.setId(item.getId());
                order.setCreateOrderDate(DateUtils.format(item.getCreateOrderDate(), Constants.DATE_FORMAT.YYYY_MM_DD));
                order.setState(EOrderState.of(item.getStatus()));
                order.setTotal(item.getTotal());
                orderList.add(order);
            });
            rst.setUserId(dxo.getUserId());
            rst.setOrders(orderList);
        }

        return rst;
    }
}
