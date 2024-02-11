package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "section")
	private String section;

	@ManyToOne
	@JoinColumn(name = "class_id")
	private Class classInfo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Class getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(Class classInfo) {
		this.classInfo = classInfo;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", section=" + section + ", classInfo=" + classInfo + "]";
	}

	public Student(String name, String section, Class classInfo) {
		super();
		this.name = name;
		this.section = section;
		this.classInfo = classInfo;
	}
	
	

}
