package haui.doan.stores.business.implement;

import haui.doan.stores.business.service.CommonService;
import haui.doan.stores.domain.User;
import haui.doan.stores.framework.Constants;
import haui.doan.stores.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * The service for common utils
 */
@Service
@AllArgsConstructor
public class CommonServiceImpl implements CommonService {

    //Access table user of database
    private final UserRepository userRepository;

    /**
     * Get information of user login
     *
     * @return
     */
    @Override
    public User loadUserDetail() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails();
        return userRepository.findUserByUserNameIsAndDeleted(userDetails.getUsername(), Constants.DELETE.FALSE);
    }
}
