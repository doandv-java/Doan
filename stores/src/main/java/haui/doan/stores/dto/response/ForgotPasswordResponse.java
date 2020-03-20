package haui.doan.stores.dto.response;

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
public class ForgotPasswordResponse extends RESPONSE {

    private static final long serialVersionUID = 6673149973188109004L;

    private boolean result;

    private List<ErrorService> errorServices;

    private List<ErrorValidator> errorValidators;
}
