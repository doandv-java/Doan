package haui.doan.stores.business.implement;

import haui.doan.stores.business.service.CommonService;
import haui.doan.stores.domain.User;
import haui.doan.stores.domain.UserPrincipal;
import haui.doan.stores.dto.errors.ErrorValidator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

/**
 * The service for common utils
 */
@Service
@AllArgsConstructor
public class CommonServiceImpl implements CommonService {

    /**
     * Get information of user login
     *
     * @return {@link User}
     */
    @Override
    public User loadUserDetail() {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((UserPrincipal) userDetails).getUser();
    }

    /**
     * The method is used to get validate error when request send controller
     *
     * @param result the result of validator {@link BindingResult}
     * @return list error validator {@link ErrorValidator}
     */
    @Override
    public List<ErrorValidator> bindResult(BindingResult result) {
        List<ErrorValidator> errorValidators = new ArrayList<>();
        if (result.hasErrors()) {
            result.getFieldErrors().forEach(fieldError -> {
                errorValidators.add(new ErrorValidator(fieldError.getField(), fieldError.getDefaultMessage()));
            });
        }
        return errorValidators;
    }
}
