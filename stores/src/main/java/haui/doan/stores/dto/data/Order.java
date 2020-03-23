package haui.doan.stores.dto.data;

import haui.doan.stores.domain.enums.EOrderState;
import lombok.Data;

@Data
public class Order {
    private Long id;
    private String createOrderDate;
    private double total;
    private EOrderState state;
}
