package haui.doan.stores.business.service;

import haui.doan.stores.dto.rst.ListSupplyRst;

/**
 * The service logic for supply
 *
 * @author Duong Van Doan
 */
public interface SupplyService {

    /**
     * The method is used to get list supply
     *
     * @return list supply  {@link ListSupplyRst}
     */
    ListSupplyRst getListSupply();

}
