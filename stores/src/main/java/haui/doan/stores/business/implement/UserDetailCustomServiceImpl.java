package haui.doan.stores.business.implement;

import haui.doan.stores.business.service.UserDetailCustomService;
import haui.doan.stores.domain.User;
import haui.doan.stores.domain.UserPrincipal;
import haui.doan.stores.domain.enums.ERole;
import haui.doan.stores.framework.Constants;
import haui.doan.stores.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * The class check user login with user name and password  exists then create session login for user
 *
 * @author Duong Van Doan
 */
@Service
@AllArgsConstructor
@Slf4j
public class UserDetailCustomServiceImpl implements UserDetailCustomService {

    /**
     * The interface to access table  user of database
     */
    private final UserRepository userRepository;


    /**
     * Load user information and create session login if user login success
     *
     * @param username email of user
     * @return the UserPrincipal {@link UserPrincipal}
     * @throws UsernameNotFoundException message "Unknown User"
     */
    @Override
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        //Get user with user name and not deleted
        User user = userRepository.findUserByUserNameIsAndDeleted(username, Constants.DELETE.FALSE);
        if (user == null) {
            log.error("Unknown User");
            throw new UsernameNotFoundException("Unknown User");
        }
        //Set authority of user login
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        log.info("{} has role: {}", user.getUserName(), user.getRole());
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
        //Return session of user login
        return new UserPrincipal(
                user, true, true, true, true,
                grantedAuthorities);

    }
}
