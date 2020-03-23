package haui.doan.stores.dto.rst;

import haui.doan.stores.dto.data.Order;
import haui.doan.stores.dto.response.OrderHistoryResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistoryRst extends RST {

    private Long userId;

    private List<Order> orders;

    @Override
    public OrderHistoryResponse toResponse() {
        return new OrderHistoryResponse(userId, orders);
    }
}
