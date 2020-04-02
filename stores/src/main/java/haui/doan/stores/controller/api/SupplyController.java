package haui.doan.stores.controller.api;

import haui.doan.stores.business.service.CommonService;
import haui.doan.stores.business.service.SupplyService;
import haui.doan.stores.dto.response.ListSupplyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Api for supply controller is used to get list detail, delete, save supply
 *
 * @author Duong Van Doan
 */
@RestController
@RequestMapping("/supply")
@RequiredArgsConstructor
public class SupplyController {

    /* service for process logic about supply */
    private final SupplyService supplyService;

    /**
     * Common service
     */
    private final CommonService commonService;


    @GetMapping("")
    public ListSupplyResponse getListSupply() {
        return supplyService.getListSupply().toResponse();
    }

    @GetMapping("/{id}")
    public void getSupplyDetail(@PathVariable("id") Long id) {

    }

    @PostMapping("")
    public void saveSupply() {

    }

    @DeleteMapping("/{id}")
    public void deleteSupply(@PathVariable("id") Long id) {

    }


}
