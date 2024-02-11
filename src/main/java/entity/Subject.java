package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private int subjectId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Subject(int subjectId, String name) {
		super();
		this.subjectId = subjectId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Subject [name=" + name + ", description=" + description + "]";
	}
    
    
    
}
