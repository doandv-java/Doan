package haui.doan.stores.dto.rst;

import haui.doan.stores.dto.errors.ErrorService;
import haui.doan.stores.dto.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRst extends RST {

    private static final long serialVersionUID = 4721863767091665019L;

    private boolean result;

    private List<ErrorService> errorServices;

    @Override
    public UserResponse toResponse() {
        UserResponse userResponse = new UserResponse();
        userResponse.setResult(result);
        userResponse.setErrorServices(errorServices);
        return userResponse;
    }
}
