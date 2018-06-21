package system.model;

import javax.persistence.*;

@Entity
@Table(name = "vacancy")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name_Vacancy")
    private String nameVacancy;

    @Column(name = "Field_Vacancy")
    private String fieldVacancy;

    @Column(name = "Salary_Vacancy")
    private int salaryVacancy;

    @Column(name = "Experience_Vacancy")
    private int experienceVacancy;



}
