package haui.doan.stores.business.implement;

import haui.doan.stores.business.service.SupplyService;
import haui.doan.stores.domain.Supply;
import haui.doan.stores.dto.rst.ListSupplyRst;
import haui.doan.stores.framework.Constants;
import haui.doan.stores.repository.SupplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The service for supply
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SupplyServiceImpl implements SupplyService {

    // data access layer for supply table
    private final SupplyRepository supplyRepository;

    /**
     * Get list supply is not deleted
     *
     * @return list supply
     */
    @Override
    public ListSupplyRst getListSupply() {
        ListSupplyRst rst = new ListSupplyRst();
        //Find list supply is not delete
        List<Supply> supplies = supplyRepository.findSuppliesByDeletedIs(Constants.DELETE.FALSE);
        rst.setSupplies(supplies);
        return rst;
    }
}
