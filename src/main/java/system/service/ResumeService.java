package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.ResumeDao;
import system.model.Resume;

@Service
public class ResumeService {
    @Autowired
    private ResumeDao resumeDao;

    public void save(Resume resume) {
        resumeDao.save(resume);
    }
}
