package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int classId;

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

	public Section(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Classes [name=" + name + ", description=" + description + "]";
	}
	
	
    
    

}