package haui.doan.stores.repository;

import haui.doan.stores.domain.TicketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketItemRepository extends JpaRepository<TicketItem, Long> {

}
