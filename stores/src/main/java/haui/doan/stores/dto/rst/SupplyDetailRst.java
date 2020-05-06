package haui.doan.stores.dto.rst;

import haui.doan.stores.dto.response.RESPONSE;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplyDetailRst extends RST {
    @Override
    public <T extends RESPONSE> T toResponse() {
        return null;
    }
}
