package haui.doan.stores.dto.rst;

import haui.doan.stores.dto.errors.ErrorService;
import haui.doan.stores.dto.response.ChangePasswordResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRst extends RST {

    private static final long serialVersionUID = 6873956566045124843L;

    private boolean status;

    List<ErrorService> errorServices;

    @Override
    public ChangePasswordResponse toResponse() {
        ChangePasswordResponse response = new ChangePasswordResponse();
        response.setResult(status);
        response.setErrorServices(errorServices);
        return response;
    }
}
