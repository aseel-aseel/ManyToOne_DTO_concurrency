package io.javabrains.springbootstarter.controllers;


import java.util.List;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.DTOs.CarDto;
import io.javabrains.springbootstarter.converters.ConverterCar;
import io.javabrains.springbootstarter.entities.Car;
import io.javabrains.springbootstarter.services.CarService;


@RestController
public class CarController {
	
@Autowired
private CarService serviceCar;

@Autowired
private ConverterCar converterCar;
	
//GET//GET//GET//GET//GET//GET//GET
//GET all Cars DTO
@RequestMapping("/cars")
 public List<CarDto> FindallCars() {

return serviceCar.getallCars();
	 }



//GET a car DTO
@RequestMapping("/cars/{id}")
public   CarDto FindCar(@PathVariable String id) 
{ 
return serviceCar.getCar(id);
 }


	 
//POST DTO
	 @RequestMapping(method=RequestMethod.POST,value="/cars")
	 public   CarDto increaseCar(@RequestBody CarDto dto) {
		return serviceCar.addCar(dto);
	 }                                                      

	 
//PUT//PUT//PUT//PUT//PUT DTO
	 @RequestMapping(method=RequestMethod.PUT,value="/cars/{id}")//بالاصل هي جيت كيف بدي اخليها بوست
	 public   CarDto EditCar(@RequestBody CarDto dto,@PathVariable String id) {
	
			return serviceCar.updateCar(dto, id);
	 } 


@RequestMapping("/cars/test")
public void testConcurrency() {
	
		 
Car car1=new Car("car1","car1","car1");	
CarDto dto1=converterCar.carToDto(car1);
serviceCar.addCar(dto1);


Car car=new Car("5","5","5");
CarDto dto=converterCar.carToDto(car);

Car car2=new Car("6","6","6");
CarDto dto2=converterCar.carToDto(car2);


		( new Thread() { public void run()
		{
			
			serviceCar.updateCar(dto, "car1");
		
			try {
			Thread.sleep(200);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		} } ).start();
		
		( new Thread() { public void run()
		{
			
			serviceCar.updateCar(dto2, "car1");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} } ).start();
		 }


	 
	 
}
