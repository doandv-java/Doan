package haui.doan.stores.business.service;

import haui.doan.stores.dto.dxo.ChangePasswordDxo;
import haui.doan.stores.dto.dxo.ForgotPasswordDxo;
import haui.doan.stores.dto.dxo.UserDxo;
import haui.doan.stores.dto.rst.ChangePasswordRst;
import haui.doan.stores.dto.rst.ForgotPasswordRst;
import haui.doan.stores.dto.rst.UserRst;

public interface UserService {

    UserRst saveUser(UserDxo userDxo);

    ChangePasswordRst changePassword(ChangePasswordDxo dxo);

    ForgotPasswordRst forgotPassword(ForgotPasswordDxo dxo);

    boolean existUser(String userName, String userNameOld);
}
