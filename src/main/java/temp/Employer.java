package temp;

import system.model.Role;

import javax.persistence.*;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a Employee.
 *
 * @author Stanislav Popovich
 * @version 1.0
 */

@Entity
@Table(name = "employer", schema = "searchjob")
public class Employer {

    @Id
    @Column(name = "ID_employer")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

    @Column(name = "Name")
    private String nameEmployer;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Transient
    private String confirmPassword;

    @ManyToMany
    @JoinTable(name = "employer_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getNameEmployer() {
        return nameEmployer;
    }

    public void setNameEmployer(String nameEmployer) {
        this.nameEmployer = nameEmployer;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", nameEmployer='" + nameEmployer + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", roles=" + roles +
                '}';
    }
}
