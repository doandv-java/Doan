package haui.doan.stores.controller.web;

import haui.doan.stores.business.service.CommonService;
import haui.doan.stores.domain.User;
import haui.doan.stores.domain.enums.ERole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller for login into home page of each user
 */
@Controller
@AllArgsConstructor
public class LoginController {

    // Common service
    private final CommonService commonService;


    /**
     * The method to view form login for each user to access web
     *
     * @return Model and view login form {@link ModelAndView}
     */
    @GetMapping(value = "/login")
    public ModelAndView viewLoginForm() {
        var mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    /**
     * The method for check role of user
     * If role of user has admin or employee then home admin page else then access home page of shop
     * Role of user :{@link haui.doan.stores.domain.enums.ERole}
     *
     * @return Model and view admin home or shop home
     */
    @GetMapping("/checkUser")
    public ModelAndView checkRoleUser() {
        var mav = new ModelAndView();
        //Check role of user login
        User user = commonService.loadUserDetail();
        if (user.getRole().equals(ERole.CUSTOMER.getText())) {
            mav.setViewName("redirect:/home");
        } else {
            mav.setViewName("redirect:/admin/home");
        }
        return mav;
    }

    @GetMapping("/register")
    public ModelAndView viewRegister() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        return mav;
    }

    @GetMapping("/404")
    public ModelAndView view404Page() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("404");
        return mav;
    }
}
