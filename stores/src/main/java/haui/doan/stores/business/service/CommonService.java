package haui.doan.stores.business.service;

import haui.doan.stores.domain.User;

/**
 * The service for common action: get user login web
 *
 * @author Duong Van Doan
 */
public interface CommonService {

    /**
     * Load user is logging web
     *
     * @return the information of User
     */
    User loadUserDetail();


}
