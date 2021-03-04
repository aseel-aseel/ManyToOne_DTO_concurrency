package io.javabrains.springbootstarter.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.DTOs.CustomerDto;
import io.javabrains.springbootstarter.services.UserService;


@RestController
public class CustomerController {

	@Autowired
	private UserService serviceUsers;
	
//GET DTO
@RequestMapping("/cars/{id}/Customer")//i want to return all customers refer to the car id
	 public  List<CustomerDto> FindallCustomer(@PathVariable String id) { 
	
		return 	 serviceUsers.getallCustomer(id);
	 }           


//Get by id DTO
	 @RequestMapping("/cars/{carId}/Customer/{id}")//لما حطيت id لازم احط تحت باث فاريبل
	 public   CustomerDto FindCustomer(@PathVariable String id) {
		return serviceUsers.getCustomer(id);
	 }                                
	 
	 
	
	//POST DTO
	 @RequestMapping(method=RequestMethod.POST,value="/cars/{carId}/Customer")//بالاصل هي جيت كيف بدي اخليها بوست
		 public   CustomerDto InsertCustomer(@RequestBody CustomerDto dto,@PathVariable String carId ) {
			 return serviceUsers.addCustomer(dto, carId);
			
		 }                     
	 
	 
//PUT DTO
	@RequestMapping(method=RequestMethod.PUT,value="/cars/{carId}/Customer/{id}")//بالاصل هي جيت كيف بدي اخليها بوست
	 public   CustomerDto EditeCar(@RequestBody CustomerDto dto,@PathVariable String carId,@PathVariable String id ) {
		
		return serviceUsers.updateCar(dto, carId, id);
	 }                                 
	                            
	 
	 
}
