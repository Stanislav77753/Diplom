package system.validator;
import system.model.Employee;
import system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link system.model.Employee} class,
 * implements {@link Validator} interface.
 *
 * @author Stanislav Popovich
 * @version 1.0
 */

@Component
public class EmployeeValidator implements Validator  {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Employee employee = (Employee) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required");
        if (employee.getLogin().length() < 8 || employee.getLogin().length() > 32) {
            errors.rejectValue("login", "Size.employeeForm.login");
        }

        if (employeeService.findByLogin(employee.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.employeeForm.login");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (employee.getPassword().length() < 8 || employee.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.employeeForm.password");
        }

        if (!employee.getConfirmPassword().equals(employee.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.employeeForm.password");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Required");
        if (employee.getFirstName().length() < 1 || employee.getFirstName().length() > 32) {
            errors.rejectValue("firstName", "Size.employeeForm.firstName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "secondName", "Required");
        if (employee.getSecondName().length() < 1 || employee.getSecondName().length() > 32) {
            errors.rejectValue("secondName", "Size.employeeForm.secondName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
        if (employee.getEmail().length() < 1 || employee.getEmail().length() > 32) {
            errors.rejectValue("email", "Size.employeeForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "Required");
        if (employee.getPhone().length() < 1 || employee.getPhone().length() > 32) {
            errors.rejectValue("phone", "Size.employeeForm.phone");
        }
    }
}
