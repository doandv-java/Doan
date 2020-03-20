package haui.doan.stores.business.service;

import haui.doan.stores.domain.User;
import haui.doan.stores.dto.errors.ErrorValidator;
import org.springframework.validation.BindingResult;

import java.util.List;

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

    /**
     * Convert to binding result error to response
     *
     * @param result the binding result {@link BindingResult}
     * @return the List error validator {@link ErrorValidator}
     */
    List<ErrorValidator> bindResult(BindingResult result);

}
