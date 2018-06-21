package system.dao;

import system.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
    Employee findByLogin(String login);

}
