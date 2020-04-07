package haui.doan.stores.dto.rst;

import haui.doan.stores.domain.Supply;
import haui.doan.stores.dto.response.ListSupplyResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListSupplyRst extends RST {

    private List<Supply> supplies;

    @Override
    public ListSupplyResponse toResponse() {
        return new ListSupplyResponse(supplies);
    }
}
