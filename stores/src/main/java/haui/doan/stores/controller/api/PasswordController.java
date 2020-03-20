package haui.doan.stores.controller.api;

import haui.doan.stores.business.service.CommonService;
import haui.doan.stores.business.service.UserService;
import haui.doan.stores.dto.errors.ErrorValidator;
import haui.doan.stores.dto.request.ChangePasswordRequest;
import haui.doan.stores.dto.response.ChangePasswordResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PasswordController {

    private final UserService userService;

    private final CommonService commonService;

    @PostMapping("/changePassword")
    public ChangePasswordResponse changePassword(@Valid ChangePasswordRequest request, BindingResult result) {
        List<ErrorValidator> errorValidators = commonService.bindResult(result);
        if (CollectionUtils.isEmpty(errorValidators)) {
            return userService.changePassword(request.toDxo()).toResponse();
        }
        return new ChangePasswordResponse(false, errorValidators);
    }
}
