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

/**
 * The API of  user
 *
 * @author Duong Van Doan
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    //User service
    private final UserService userService;

    //Common service
    private final CommonService commonService;


    /**
     * The method of save user
     *
     * @param request the User request {@link UserRequest}
     * @param result  The binding result of validator of request
     * @return The result of save User {@link UserResponse}
     */
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
