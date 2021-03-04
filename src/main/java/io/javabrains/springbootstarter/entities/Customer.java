package io.javabrains.springbootstarter.entities;
import javax.persistence.*;

@Entity
@Table(name="Customer")
public class Customer {

	@Id
	@Column(name="id")
	private String id;
	@Column(name="Name")
	private String Name;
	@Column(name="description")
	private String description;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Car car;
	
	public Customer() {}
	
	public Customer(String name, String description,String carId) {
		super();
		this.Name = name;
		this.description = description;
		this.car=new Car(carId,"","");
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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
