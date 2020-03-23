package haui.doan.stores.controller.web;

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
public class AdminController {

    /**
     * The home of admin
     *
     * @return
     */
    @GetMapping(value = "/home")
    public ModelAndView viewHome() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/home");
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
