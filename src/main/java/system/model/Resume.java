package system.model;

import javax.persistence.*;

@Entity
@Table(name = "resume", schema = "searchjob")
public class Resume {

    @Id
    @Column(name = "ID_resume")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String nameResume;

    @Column(name = "Salary")
    private String salaryResume;

    @Column(name = "Experience")
    private String experienceResume;

    @Column(name = "Description")
    private String descriptionResume;

    @Column(name = "ID_employee")
    private Long employeeId;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getNameResume() {
        return nameResume;
    }

    public void setNameResume(String nameResume) {
        this.nameResume = nameResume;
    }

    public String getSalaryResume() {
        return salaryResume;
    }

    public void setSalaryResume(String salaryResume) {
        this.salaryResume = salaryResume;
    }

    public String getExperienceResume() {
        return experienceResume;
    }

    public void setExperienceResume(String experienceResume) {
        this.experienceResume = experienceResume;
    }

    public String getDescriptionResume() {
        return descriptionResume;
    }

    public void setDescriptionResume(String descriptionResume) {
        this.descriptionResume = descriptionResume;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", nameResume='" + nameResume + '\'' +
                ", salaryResume='" + salaryResume + '\'' +
                ", experienceResume='" + experienceResume + '\'' +
                ", descriptionResume='" + descriptionResume + '\'' +
                '}';
    }
}
