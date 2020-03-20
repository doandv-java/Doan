package haui.doan.stores.dto.rst;

import haui.doan.stores.dto.errors.ErrorService;
import haui.doan.stores.dto.response.ForgotPasswordResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordRst extends RST {

    private static final long serialVersionUID = 1649574859823161728L;

    private boolean result;

    private List<ErrorService> errorServices;

    @Override
    public ForgotPasswordResponse toResponse() {
        ForgotPasswordResponse response = new ForgotPasswordResponse();
        response.setResult(result);
        response.setErrorServices(errorServices);
        return response;
    }
}
