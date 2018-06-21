package system.model;

import javax.persistence.*;

@Entity
@Table(name = "resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "UserID")
    private int userId;

    @Column(name = "Name_Resume")
    private String nameResume;

    @Column(name = "Field_Resume")
    private String fieldResume;

    @Column(name = "Salary_Resume")
    private int salaryResume;

    @Column(name = "Experience_Resume")
    private int experienceResume;


}
