package system.service;

import system.dao.EmployeeDao;
import system.model.Role;
import system.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link org.springframework.security.core.userdetails.UserDetailsService} interface.
 *
 * @author Stanislav Popovich
 * @version 1.0
 */
public class EmployeeDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employee employee = employeeDao.findByLogin(login);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role : employee.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(employee.getLogin(), employee.getPassword(),
                grantedAuthorities);
    }
}
