package io.javabrains.springbootstarter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javabrains.springbootstarter.entities.Customer;

public interface CustomerRepository extends JpaRepository <Customer,String>{//<اسم الانتتي , نوع الاي دي>//crudrepository يها فنكشنز جاهزة
	
public List<Customer>  findByCarId(String carID);
}
