package system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import system.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
}
