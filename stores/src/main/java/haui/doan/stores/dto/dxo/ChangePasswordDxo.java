package haui.doan.stores.dto.dxo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDxo extends DXO {

    private static final long serialVersionUID = -2642179991725069513L;

    private Long id;

    private String passwordOld;

    private String passWordNew;
}
