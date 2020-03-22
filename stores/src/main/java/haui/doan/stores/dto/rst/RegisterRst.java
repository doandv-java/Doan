package haui.doan.stores.dto.rst;

import haui.doan.stores.dto.errors.ErrorService;
import haui.doan.stores.dto.response.RegisterResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRst extends RST {

    private boolean result;

    private List<ErrorService> errorServices;

    @Override
    public RegisterResponse toResponse() {
        RegisterResponse response = new RegisterResponse();
        response.setResult(result);
        response.setErrorServices(errorServices);
        return response;
    }
}
