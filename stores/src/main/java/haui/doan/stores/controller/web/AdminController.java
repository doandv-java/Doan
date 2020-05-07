package haui.doan.stores.controller.web;

import haui.doan.stores.business.service.CommonService;
import haui.doan.stores.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * The admin controller view
 *
 * @author DoanDV
 */
@Controller
@RequestMapping(path = "/admin")
@RequiredArgsConstructor
public class AdminController {

    private final CommonService commonService;

    /**
     * The home of admin
     *
     * @return
     */
    @GetMapping(value = "/home")
    public ModelAndView viewHome() {
        User user = commonService.loadUserDetail();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/home");
        mav.addObject("user", user);
        return mav;
    }

    /**
     * The view profile of user
     *
     * @return
     */
    @GetMapping("/profile")
    public ModelAndView viewProfile() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/profile");
        return mav;
    }
}
