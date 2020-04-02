package haui.doan.stores.repository;

import haui.doan.stores.domain.Supply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The layer access and process data in database
 *
 * @author Duong Van Doan
 */
@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {

    /**
     * Get list supply with deleted value
     * If deleted value is true to find supply deleted
     * else then fina supply is not deleted in table supply
     *
     * @param deleted the value of delete {@link haui.doan.stores.framework.Constants}
     * @return the List data information of supply
     */
    List<Supply> findSuppliesByDeletedIs(int deleted);
}
