package model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Employee extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date dateOfBirth;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false, precision = 2)
    private float salary;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Location location;

    public Employee() {
    }

    public Employee(String name, Date dateOfBirth, String jobTitle, float salary) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public Employee(String name, Date dateOfBirth, String jobTitle, float salary, Department department, Location location) {
        this(name, dateOfBirth, jobTitle, salary);
        this.department = department;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
