package haui.doan.stores.dto.request;

import haui.doan.stores.dto.dxo.ForgotPasswordDxo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordRequest extends REQUEST {

    @NotBlank
    private String userName;

    @Override
    public ForgotPasswordDxo toDxo() {
        ForgotPasswordDxo dxo = new ForgotPasswordDxo();
        dxo.setUserName(StringUtils.trimToEmpty(userName));
        return dxo;
    }
}
