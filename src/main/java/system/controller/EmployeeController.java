package system.controller;

import system.model.Employee;
import system.service.SecurityService;
import system.service.EmployeeService;
import system.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for {@link system.model.Employee}'s pages.
 *
 * @author Stanislav Popovich
 * @version 1.0
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private EmployeeValidator employeeValidator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/employee_login", method = RequestMethod.GET)
    public String userLogin(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Login or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "employee_login";
    }

    @RequestMapping(value = "/employee_registration", method = RequestMethod.GET)
    public String userRegistration(Model model) {
        model.addAttribute("employeeForm", new Employee());

        return "employee_registration";
    }

    @RequestMapping(value = "/employee_registration", method = RequestMethod.POST)
    public String userRegistration(@ModelAttribute("employeeForm") Employee employeeForm, BindingResult bindingResult, Model model) {
        employeeValidator.validate(employeeForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "employee_registration";
        }

        employeeService.save(employeeForm);

        securityService.autoLogin(employeeForm.getLogin(), employeeForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Login or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }

}
