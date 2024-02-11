package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "customer")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private String dob;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "salary")
    private String salary;

    // Default constructor
    
    
    public Customer() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", lastName=" + lastName + ", dob=" + dob + ", occupation="
				+ occupation + ", salary=" + salary + "]";
	}

	public Customer(String name, String lastName, String dob, String occupation, String salary) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.dob = dob;
		this.occupation = occupation;
		this.salary = salary;
	}
	

}
