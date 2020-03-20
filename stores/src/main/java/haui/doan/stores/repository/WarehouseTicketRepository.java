package haui.doan.stores.repository;

import haui.doan.stores.domain.WarehouseTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseTicketRepository extends JpaRepository<WarehouseTicket, Long> {

}
