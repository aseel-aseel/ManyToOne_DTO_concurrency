package io.javabrains.springbootstarter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.javabrains.springbootstarter.entities.Car;

public interface CarRepository extends JpaRepository <Car,String>{//<اسم الانتتي , نوع الاي دي>//crudrepository يها فنكشنز جاهزة
	

}
