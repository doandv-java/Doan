package haui.doan.stores.business.service;

import haui.doan.stores.dto.dxo.ChangePasswordDxo;
import haui.doan.stores.dto.dxo.ForgotPasswordDxo;
import haui.doan.stores.dto.dxo.RegisterDxo;
import haui.doan.stores.dto.dxo.UserDxo;
import haui.doan.stores.dto.rst.ChangePasswordRst;
import haui.doan.stores.dto.rst.ForgotPasswordRst;
import haui.doan.stores.dto.rst.RegisterRst;
import haui.doan.stores.dto.rst.UserRst;

/**
 * Service for user logic
 *
 * @author Duong Van Doan
 */
public interface UserService {

    /**
     * Save employee and admin with data
     *
     * @param userDxo the data of employee or admin
     * @return the result to save employee or admin
     */
    UserRst saveUser(UserDxo userDxo);

    /**
     * Change password of user with id, password old and password new
     *
     * @param dxo the data of change password {@link ChangePasswordDxo}
     * @return the result of change password {@link ChangePasswordRst}
     */
    ChangePasswordRst changePassword(ChangePasswordDxo dxo);

    /**
     * Forgot password of user
     *
     * @param dxo the data of forgot password {@link ForgotPasswordDxo}
     * @return the result of forgot password {@link ForgotPasswordRst}
     */
    ForgotPasswordRst forgotPassword(ForgotPasswordDxo dxo);

    /**
     * register of customer
     *
     * @param dxo the data of register of customer
     * @return the result of register password
     */
    RegisterRst registerCustomer(RegisterDxo dxo);

    /**
     * Check user exist with username or username old when create or update
     *
     * @param userName    the new user name
     * @param userNameOld the old user name
     * @return the boolean value
     */
    boolean existUser(String userName, String userNameOld);
}
