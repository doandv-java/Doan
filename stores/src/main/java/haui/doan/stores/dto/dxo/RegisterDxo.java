package haui.doan.stores.dto.dxo;

import haui.doan.stores.domain.enums.EGender;
import haui.doan.stores.domain.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDxo extends DXO {

    private String username;

    private String password;

    private String name;

    private ERole role;

    private EGender gender;

}
