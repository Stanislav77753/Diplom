package system.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.ModelAndView;
import system.model.Employee;
import system.model.Resume;
import system.service.ResumeService;
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

    private ResumeService resumeService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private EmployeeValidator employeeValidator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
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

        return "employee_login";
    }


    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "employee_login_result";
    }

    @RequestMapping(value = "/create_resume", method = RequestMethod.GET)
    public String createResume(Model model) {
        model.addAttribute("resumeForm", new Resume());
        return "create_resume";
    }

/*    @RequestMapping(value = "/create_resume", method = RequestMethod.POST)
    public String createResume(@ModelAttribute("resumeForm") Resume resumeForm, BindingResult bindingResult,
                               @AuthenticationPrincipal UserDetails userDetails) {
       *//* employeeValidator.validate(resumeForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "create_resume";
        }*//*
        System.out.println("---------------------------");
       Employee employee = employeeService.findByLogin(userDetails.getUsername());
        resumeForm.setEmployeeId(employee.getId());
        System.out.println(employee.getId());
        resumeService.save(resumeForm);

        return "redirect:/employee_login_result";
    }*/
    @RequestMapping(value = "/create_resume", method = RequestMethod.POST)
    public ModelAndView createResume(@ModelAttribute("resumeForm") Resume resumeForm,
                                     @AuthenticationPrincipal UserDetails userDetails) {
        ModelAndView modelAndView = new ModelAndView();

        System.out.println("---------------------------");
        Employee employee = employeeService.findByLogin(userDetails.getUsername());
        resumeForm.setEmployeeId(employee.getId());
        System.out.println(employee.getId());
        resumeService.save(resumeForm);
        modelAndView.setViewName("employee_login_result");
        return modelAndView;
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }

}
