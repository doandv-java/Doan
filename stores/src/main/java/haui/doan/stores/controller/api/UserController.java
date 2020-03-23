package haui.doan.stores.controller.api;

import haui.doan.stores.business.service.CommonService;
import haui.doan.stores.business.service.UserService;
import haui.doan.stores.dto.errors.ErrorValidator;
import haui.doan.stores.dto.request.DeleteUserRequest;
import haui.doan.stores.dto.request.ProfileRequest;
import haui.doan.stores.dto.request.UserRequest;
import haui.doan.stores.dto.response.DeleteUserResponse;
import haui.doan.stores.dto.response.ProfileResponse;
import haui.doan.stores.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(path = "/user", produces = "application/json;charset=UTF-8")
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
    public ResponseEntity<UserResponse> saveUser(@Valid UserRequest request, BindingResult result) {
        List<ErrorValidator> errorValidators = commonService.bindResult(result);
        if (CollectionUtils.isNotEmpty(errorValidators)) {
            return new ResponseEntity<>(new UserResponse(false, errorValidators), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(userService.saveUser(request.toDxo()).toResponse(), HttpStatus.OK);
        }
    }

    /**
     * Delete User with long id
     *
     * @param id the id of user
     * @return result of delete user {@link DeleteUserResponse}
     */
    @DeleteMapping("/{id}")
    public DeleteUserResponse deleteUser(@PathVariable("id") Long id) {
        DeleteUserRequest request = new DeleteUserRequest(id);
        return userService.deleteUser(request.toDxo()).toResponse();
    }

    /**
     * Get profile with long id
     *
     * @param id the key of user with long value
     * @return the data of user {@link ProfileResponse}
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfileResponse> getProfile(@PathVariable("id") Long id) {
        ProfileRequest request = new ProfileRequest(id);
        return new ResponseEntity<>(userService.getProfile(request.toDxo()).toResponse(), HttpStatus.OK);
    }

}
