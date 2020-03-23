package haui.doan.stores.dto.request;

import haui.doan.stores.dto.dxo.ProfileDxo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest extends REQUEST {

    private static final long serialVersionUID = 2114609742223253463L;

    private Long id;

    @Override
    public ProfileDxo toDxo() {
        ProfileDxo dxo = new ProfileDxo();
        dxo.setId(id);
        return dxo;
    }
}
