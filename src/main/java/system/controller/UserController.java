package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import system.model.User;
import system.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

  @RequestMapping(value = "/users_list", method = RequestMethod.GET)
  public  String getAllUsers(Model model){
     model.addAttribute("user", new User());
     model.addAttribute("listUsers", this.userService.getAllUser());
     return "/users_list";
  }


   @RequestMapping(value = "/users_add", method = RequestMethod.GET)
    public ModelAndView addUser(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userAdd", new User());
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @RequestMapping(value = "/users_add_result", method = RequestMethod.POST)
    public ModelAndView registerResult(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        try {
            this.userService.addUser(user);
            modelAndView.addObject("user", user);
        } catch (Exception e) {
           // modelAndView.addObject("exception", e.getMessage());
            System.out.println("ERROR");
        }
        return modelAndView;
    }
}
