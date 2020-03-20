package haui.doan.stores.dto.request;

import haui.doan.stores.dto.dxo.ChangePasswordDxo;
import haui.doan.stores.validate.annotations.Equals;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Equals(target = "confirmPassword", source = "passwordNew")
public class ChangePasswordRequest extends REQUEST {

    private Long id;

    @NotBlank
    private String passwordOld;

    @NotBlank
    private String passwordNew;


    @NotBlank
    private String confirmPassword;


    @Override
    public ChangePasswordDxo toDxo() {
        return new ChangePasswordDxo(id, passwordOld, passwordNew);
    }
}
