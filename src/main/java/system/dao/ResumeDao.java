package system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import system.model.Resume;

public interface ResumeDao extends JpaRepository<Resume, Long> {
    //Resume findByName(String name);
}
