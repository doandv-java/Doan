package haui.doan.stores.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import haui.doan.stores.dto.errors.ErrorService;
import haui.doan.stores.dto.errors.ErrorValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordResponse extends RESPONSE {

    private boolean result;

    @JsonInclude(Include.NON_NULL)
    List<ErrorService> errorServices;

    @JsonInclude(Include.NON_NULL)
    List<ErrorValidator> errorValidators;

    public ChangePasswordResponse(boolean result, List<ErrorValidator> errorValidators) {
        this.result = result;
        this.errorValidators = errorValidators;
    }
}
