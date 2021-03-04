package io.javabrains.springbootstarter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.DTOs.CustomerDto;
import io.javabrains.springbootstarter.converters.ConverterCustomer;
import io.javabrains.springbootstarter.entities.Car;
import io.javabrains.springbootstarter.entities.Customer;
import io.javabrains.springbootstarter.repositories.CustomerRepository;

@Service 
public class UserService {
	@Autowired
	private ConverterCustomer converterCustomer;
	@Autowired
	private CustomerRepository customerRepository;
	
//GET DTO
	 public List<CustomerDto> getallCustomer( String id) { 
	List <Customer> customers=new ArrayList<>();
	 customerRepository.findByCarId(id)
	 .forEach(customers::add);

		return converterCustomer.customerToDtoList(customers);
	 }                               /*
	                       @RequestMapping("/cars/{id}/Customer")//i want to return all customers refer to the car id
	                       public List<Customer> getallCustomer(@PathVariable String id) { 
	                       List <Customer> customer=new ArrayList<>();
	                        customerRepository.findByCarId(id)
	                        .forEach(customer::add);

		                 return customer;
	                          }*/

//Get by id DTO  
	 public CustomerDto getCustomer( String id) {
		Customer customer=  customerRepository.findById(id).get();
		 return converterCustomer.customerToDto(customer);
	 }                                 /*
	                       @RequestMapping("/cars/{carId}/Customer/{id}")//لما حطيت id لازم احط تحت باث فاريبل
	                  	 public Customer getCustomer(@PathVariable String id) {
	                  		Customer customer=  customerRepository.findById(id).get();
	                  		 return customer;
	                  	 }*/
	 
	
	//POST DTO
		 public CustomerDto addCustomer( CustomerDto dto, String carId ) {
			 Customer customer =converterCustomer.dtoToCustomer(dto);
				 customer.setCar(new Car(carId,"",""));
				 customer=	 customerRepository.save(customer);
				return converterCustomer.customerToDto(customer);
			
		 }                       /*
	                       @RequestMapping(method=RequestMethod.POST,value="/cars/{carId}/Customer")//بالاصل هي جيت كيف بدي اخليها بوست
	              		  void addCustomer(@RequestBody Customer customer,@PathVariable String carId ) {
	              				 customer.setCar(new Car(carId,"",""));
	              					 customerRepository.save(customer);
	              			
	              		 }*/
		 
//PUT DTO

	 public CustomerDto updateCar( CustomerDto dto, String carId, String id ) {
		 Customer customer =converterCustomer.dtoToCustomer(dto);
		 customer.setCar(new Car(carId,"",""));
		customer= customerRepository.save(customer);
		return converterCustomer.customerToDto(customer);
	 }                                 
	                            /*
                       @RequestMapping(method=RequestMethod.PUT,value="/cars/{carId}/Customer/{id}")//بالاصل هي جيت كيف بدي اخليها بوست
	                  	  void updateCar(@RequestBody Customer customer,@PathVariable String carId,@PathVariable String id ) {
	                	 customer.setCar(new Car(carId,"",""));
	                  		 customerRepository.save(customer);
	                  		
	                  	 }*/

	 
}
