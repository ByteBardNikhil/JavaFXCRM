package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String fName;

    @Column(name = "last_name")
    private String lName;

    @Column(name = "salary")
    private String salary;

    @Column(name = "subject")
    private String subject;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Faculty(String fName, String lName, String salary, String subject) {
	
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", fName=" + fName + ", lName=" + lName + ", salary=" + salary + ", subject="
				+ subject + "]";
	}
    
    
    

}
