package haui.doan.stores.controller.web;

import haui.doan.stores.business.service.CommonService;
import haui.doan.stores.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller for user view home , products cart or order
 */
@Controller
@RequiredArgsConstructor
public class HomeController {

    /* The common service */
    private final CommonService commonService;

    /**
     * View home page of customer
     *
     * @return Model and View {@link ModelAndView}
     */
    @GetMapping(value = "/home")
    public ModelAndView viewHome() {

        var mav = new ModelAndView();
        mav.setViewName("index");

        return mav;
    }
}
