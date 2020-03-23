package haui.doan.stores.dto.request;

import haui.doan.stores.dto.dxo.OrderHistoryDxo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistoryRequest extends REQUEST {

    private Long userId;

    @Override
    public OrderHistoryDxo toDxo() {
        return new OrderHistoryDxo(userId);
    }
}
