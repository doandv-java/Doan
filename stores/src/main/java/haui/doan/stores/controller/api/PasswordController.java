package haui.doan.stores.controller.api;

import haui.doan.stores.business.service.CommonService;
import haui.doan.stores.business.service.UserService;
import haui.doan.stores.dto.errors.ErrorValidator;
import haui.doan.stores.dto.request.ChangePasswordRequest;
import haui.doan.stores.dto.request.ForgotPasswordRequest;
import haui.doan.stores.dto.request.RegisterRequest;
import haui.doan.stores.dto.response.ChangePasswordResponse;
import haui.doan.stores.dto.response.ForgotPasswordResponse;
import haui.doan.stores.dto.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * The controller is used to process about password for user
 *
 * @author Duong Van Doan
 */
@RestController
@RequiredArgsConstructor
public class PasswordController {

    //User service
    private final UserService userService;

    //Common service
    private final CommonService commonService;

    /**
     * The method is used to change password of user
     *
     * @param request the request change password {@link ChangePasswordRequest}
     * @param result  the binding  result includes validate error of request {@link BindingResult}
     * @return the result of  change password {@link ChangePasswordResponse}
     */
    @PostMapping("/changePassword")
    public ChangePasswordResponse changePassword(@Valid ChangePasswordRequest request, BindingResult result) {
        List<ErrorValidator> errorValidators = commonService.bindResult(result);
        if (CollectionUtils.isEmpty(errorValidators)) {
            return userService.changePassword(request.toDxo()).toResponse();
        }
        return new ChangePasswordResponse(false, errorValidators);
    }

    /**
     * Forgot password for user to get random password to mail of user mail
     *
     * @param request the request of users {@link ForgotPasswordRequest}
     * @param result  the binding result of validator of request
     * @return the result of forgot password {@link ForgotPasswordResponse}
     */
    @PostMapping("/forgotPassword")
    public ForgotPasswordResponse forgotPassword(@Valid ForgotPasswordRequest request, BindingResult result) {
        List<ErrorValidator> errorValidators = commonService.bindResult(result);
        if (CollectionUtils.isEmpty(errorValidators)) {
            return userService.forgotPassword(request.toDxo()).toResponse();
        }
        return new ForgotPasswordResponse(false, errorValidators);
    }

    /**
     * Register user of customer
     *
     * @param request the data register of customer {@link RegisterRequest}
     * @param result  the result of errorValidators {@link BindingResult}
     * @return the response of register {@link RegisterResponse}
     */
    @PostMapping("/register")
    public RegisterResponse registerCustomer(@Valid RegisterRequest request, BindingResult result) {
        List<ErrorValidator> errorValidators = commonService.bindResult(result);
        if (CollectionUtils.isEmpty(errorValidators)) {
            //register data
            return userService.registerCustomer(request.toDxo()).toResponse();
        }
        return new RegisterResponse(false, errorValidators);
    }


}
