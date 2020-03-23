package haui.doan.stores.dto.response;

import haui.doan.stores.dto.data.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHistoryResponse extends RESPONSE {

    private Long userId;

    private List<Order> orders;
}
