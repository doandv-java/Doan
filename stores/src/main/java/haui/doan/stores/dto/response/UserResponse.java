package haui.doan.stores.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UserResponse extends RESPONSE {

    private static final long serialVersionUID = -66940075860921561L;


    private boolean result;

    @JsonIgnore
    private List<ErrorService> errorServices;

    @JsonIgnore
    private List<ErrorValidator> errorValidators;

    public UserResponse(boolean result, List<ErrorValidator> errorValidators) {
        this.result = result;
        this.errorValidators = errorValidators;
    }
}
