package haui.doan.stores.dto.dxo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NotBlank
public class DeleteUserDxo extends DXO {

    private Long id;


}
