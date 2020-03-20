package haui.doan.stores.business.implement;

import haui.doan.stores.business.service.UserService;
import haui.doan.stores.dto.dxo.UserDxo;
import haui.doan.stores.dto.rst.UserRst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public UserRst saveUser(UserDxo userDxo) {
        return new UserRst();
    }
}
