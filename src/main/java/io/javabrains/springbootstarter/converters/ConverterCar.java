package io.javabrains.springbootstarter.converters;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.javabrains.springbootstarter.DTOs.CarDto;
import io.javabrains.springbootstarter.entities.Car;

@Component
public class ConverterCar {

	public  ConverterCar() {
		
	}
	public CarDto carToDto(Car car) {
		/*CarDto dto =new CarDto();
		dto.setId(car.getId());
	    dto.setName(car.getName());
	    dto.setDescription(car.getDescription());
	    return dto;*/
		
		ModelMapper mapper =new ModelMapper();
		CarDto map =	mapper.map(car, CarDto.class);
		return map;
	}
	


		public List<CarDto> carToDtoList(List<Car> car) {
	return	car.stream().map(x->carToDto(x)).collect(Collectors.toList());
		 
		}
		
	public Car dtoToCar(CarDto dto)
	{
		/*Car car = new Car();
		car.setId(dto.getId());
        car.setName(dto.getName());
		car.setDescription(dto.getDescription());
		
		return car;
		*/
		ModelMapper mapper =new ModelMapper();
		Car map =	mapper.map(dto, Car.class);
		return map;
		
	}
	
	public List<Car> DtoToCarList(List<CarDto> dto) {
	return	dto.stream().map(x->dtoToCar(x)).collect(Collectors.toList());
		 
		}
		
}
