package haui.doan.stores.dto.rst;

import haui.doan.stores.dto.errors.ErrorService;
import haui.doan.stores.dto.response.DeleteUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserRst extends RST {

    private boolean result;

    private List<ErrorService> errorServices;

    @Override
    public DeleteUserResponse toResponse() {
        DeleteUserResponse response = new DeleteUserResponse();
        response.setResult(result);
        response.setErrorServices(errorServices);
        return response;
    }
}
