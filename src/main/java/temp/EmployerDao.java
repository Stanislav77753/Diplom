package temp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer, Long> {
    Employer findByEmployerLogin(String login);

}
