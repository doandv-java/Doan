package haui.doan.stores.dto.dxo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotPasswordDxo extends DXO {

    private static final long serialVersionUID = 7773490879773652410L;

    private String userName;

}
