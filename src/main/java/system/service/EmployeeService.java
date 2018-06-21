package system.service;

import system.model.Employee;

/**
 * Service class for {@link system.model.Employee}
 *
 * @author Stanislav Popovich
 * @version 1.0
 */

public interface EmployeeService {
    void save(Employee employee);

    Employee findByLogin(String login);
}
