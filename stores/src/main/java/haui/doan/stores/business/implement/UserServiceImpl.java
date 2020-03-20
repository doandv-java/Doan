package haui.doan.stores.business.implement;

import haui.doan.stores.business.service.ImageService;
import haui.doan.stores.business.service.UserService;
import haui.doan.stores.domain.User;
import haui.doan.stores.dto.dxo.ChangePasswordDxo;
import haui.doan.stores.dto.dxo.ForgotPasswordDxo;
import haui.doan.stores.dto.dxo.UserDxo;
import haui.doan.stores.dto.errors.ErrorService;
import haui.doan.stores.dto.rst.ChangePasswordRst;
import haui.doan.stores.dto.rst.ForgotPasswordRst;
import haui.doan.stores.dto.rst.UserRst;
import haui.doan.stores.framework.Constants;
import haui.doan.stores.repository.UserRepository;
import haui.doan.stores.utils.PasswordGenerate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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

    @Override
    public ForgotPasswordRst forgotPassword(ForgotPasswordDxo dxo) {
        return null;
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
}
