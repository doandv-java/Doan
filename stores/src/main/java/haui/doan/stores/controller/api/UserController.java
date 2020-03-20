package haui.doan.stores.controller.api;

import haui.doan.stores.business.service.CommonService;
import haui.doan.stores.business.service.UserService;
import haui.doan.stores.dto.errors.ErrorValidator;
import haui.doan.stores.dto.request.UserRequest;
import haui.doan.stores.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    //User service
    private final UserService userService;

    //Common service
    private final CommonService commonService;


    @PostMapping("")
    public UserResponse saveUser(@Valid UserRequest request, BindingResult result) {
        List<ErrorValidator> errorValidators = commonService.bindResult(result);
        if (CollectionUtils.isNotEmpty(errorValidators)) {
            return new UserResponse(false, errorValidators);
        } else {
            return userService.saveUser(request.toDxo()).toResponse();
        }
    }
}
