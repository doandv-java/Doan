package haui.doan.stores.dto.request;

import haui.doan.stores.domain.enums.EGender;
import haui.doan.stores.domain.enums.ERole;
import haui.doan.stores.dto.dxo.RegisterDxo;
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
public class RegisterRequest extends REQUEST {

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String name;

    @Override
    public RegisterDxo toDxo() {
        RegisterDxo dxo = new RegisterDxo();
        dxo.setUsername(StringUtils.trimToEmpty(userName));
        dxo.setName(StringUtils.capitalize(StringUtils.trimToEmpty(name)));
        dxo.setPassword(password);
        dxo.setRole(ERole.CUSTOMER);
        dxo.setGender(EGender.FEMALE);
        return dxo;
    }
}
