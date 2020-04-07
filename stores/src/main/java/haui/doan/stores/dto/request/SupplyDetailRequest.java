package haui.doan.stores.dto.request;

import haui.doan.stores.dto.dxo.DXO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplyDetailRequest extends REQUEST {
    @Override
    public <T extends DXO> T toDxo() {
        return null;
    }
}
