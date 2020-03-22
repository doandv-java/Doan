package haui.doan.stores.dto.request;

import haui.doan.stores.dto.dxo.DeleteUserDxo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteUserRequest extends REQUEST {

    @NotBlank
    private Long id;


    @Override
    public DeleteUserDxo toDxo() {
        return new DeleteUserDxo(id);
    }
}
