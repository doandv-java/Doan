package haui.doan.stores.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_item")
@Data
public class TicketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "warehouse_ticket_id", insertable = false, updatable = false)
    private Long warehouseTicketId;

    @Column(name = "product_id", insertable = false, updatable = false)
    private Long productId;

    @Column(name = "supply_id", insertable = false, updatable = false)
    private Long supplyId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "cost")
    private double cost;

    @ManyToOne
    @JoinColumn(name = "warehouse_ticket_id", referencedColumnName = "id", nullable = false)
    private WarehouseTicket ticket;

    @ManyToOne
    @JoinColumn(name = "supply_id", referencedColumnName = "id", nullable = false)
    private Supply supply;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;


}
