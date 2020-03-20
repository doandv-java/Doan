package haui.doan.stores.business.service;

import haui.doan.stores.dto.dxo.UserDxo;
import haui.doan.stores.dto.rst.UserRst;

public interface UserService {

    UserRst saveUser(UserDxo userDxo);
}
