package system.service;

import system.dao.RoleDao;
import system.dao.EmployeeDao;
import system.model.Role;
import system.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link EmployeeService} interface.
 *
 * @author Stanislav Popovich
 * @version 1.0
 */

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Long getEmployeeID(Employee employee){
        return employee.getId();
    }
    @Override
    public void save(Employee employee) {
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        employee.setRoles(roles);
        employeeDao.save(employee);
    }

    @Override
    public Employee findByLogin(String login) {
        return employeeDao.findByLogin(login);
    }
}
