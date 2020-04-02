package haui.doan.stores.dto.response;

import haui.doan.stores.domain.Supply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListSupplyResponse extends RESPONSE {
    private List<Supply> supplies;
}
