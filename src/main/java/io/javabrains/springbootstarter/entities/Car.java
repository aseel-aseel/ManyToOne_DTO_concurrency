package io.javabrains.springbootstarter.entities;
import javax.persistence.*;

@Entity
@Table(name="Car")
public class Car {

	@Id
	@Column(name="id")
	private String id;
	@Column(name="Name")
	private String Name;
	@Column(name="description")
	private String description;
	
	@Version
	@Column(name="Version")
    private int version;
	
	public Car() {}
	
	public Car(String id, String name, String description) {
		super();
		this.id = id;
		this.Name = name;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
