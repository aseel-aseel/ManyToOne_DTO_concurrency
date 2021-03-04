package io.javabrains.springbootstarter.services;

import java.util.List;

import org.hibernate.OptimisticLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.retry.RetryException;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.javabrains.springbootstarter.DTOs.CarDto;
import io.javabrains.springbootstarter.converters.ConverterCar;
import io.javabrains.springbootstarter.entities.Car;
import io.javabrains.springbootstarter.repositories.CarRepository;

@Service 
public class CarService {
	
@Autowired
private CarRepository carRepository;

@Autowired
private ConverterCar converterCar;
	
public List<CarDto> getallCars() {
List<Car> listCars=	carRepository.findAll();
return converterCar.carToDtoList(listCars);
	 }
        
/*
public List<Car> getallCars() {
List<Car> listCars=	carRepository.findAll();
return listCars; }
         */
public CarDto getCar(String id) 
{ 
 Car  car  =	carRepository.findById(id).get();
return converterCar.carToDto(car);
 }

/* 
@RequestMapping("/cars/{id}")
public Car getCar(@PathVariable String id) 
{Car  car  =	carRepository.findById(id).orElse(null);
return car; }

      */

public CarDto addCar( CarDto dto) {
	
	Car car =converterCar.dtoToCar(dto);
	car=carRepository.save(car);
	return converterCar.carToDto(car);
 }  
/*
@RequestMapping(method=RequestMethod.POST,value="/cars")
 void addCar(@RequestBody Car car) {
	
	carRepository.save(car);
	
}*/

//@Retryable(value = RetryException.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 1))
//@RetryConcurrentOperation(exception = ConcurrencyFailureException.class, retries =12)// for customer annotation
@Transactional
@Retryable( maxAttempts = 3)
public CarDto updateCar( CarDto dto, String id) {

	 Car newCar =converterCar.dtoToCar(dto);
	String Newname= newCar.getName();
	String NewDesc= newCar.getDescription();
	Car  Oldcar  =	carRepository.findById(id).get();
	Oldcar.setDescription(NewDesc);
	Oldcar.setName(Newname);
	//carRepository.save(Oldcar);
		return converterCar.carToDto(Oldcar);
} 


/*
@RequestMapping(method=RequestMethod.PUT,value="/cars/{id}")//بالاصل هي جيت كيف بدي اخليها بوست
 void updateCar(@RequestBody Car car,@PathVariable String id) {
    carRepository.save(car);
 
   } */

   
}
