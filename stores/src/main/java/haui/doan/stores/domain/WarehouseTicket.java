package haui.doan.stores.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "warehouse_ticket")
@Data
public class WarehouseTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "warehouse_day")
    private Date warehouseDay;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
    List<TicketItem> items = Collections.emptyList();
}
