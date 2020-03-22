package haui.doan.stores.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import haui.doan.stores.dto.errors.ErrorService;
import haui.doan.stores.dto.errors.ErrorValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse extends RESPONSE {

    private boolean result;

    @JsonInclude(NON_NULL)
    private List<ErrorValidator> errorValidators;

    @JsonInclude(NON_NULL)
    private List<ErrorService> errorServices;

    public RegisterResponse(boolean result, List<ErrorValidator> errorValidators) {
        this.result = result;
        this.errorValidators = errorValidators;
    }
}
