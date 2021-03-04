package io.javabrains.springbootstarter.converters;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import io.javabrains.springbootstarter.DTOs.CustomerDto;
import io.javabrains.springbootstarter.entities.Customer;
@Component
public class ConverterCustomer {

	public CustomerDto customerToDto(Customer customer) {
	/*	CustomerDto dto =new CustomerDto();
		dto.setId(customer.getId());
	    dto.setName(customer.getName());
	    dto.setDescription(customer.getDescription());
	    return dto;*/
		ModelMapper mapper =new ModelMapper();
		CustomerDto map =	mapper.map(customer, CustomerDto.class);
		return map;
	}
	


		public List<CustomerDto> customerToDtoList(List<Customer> customer) {
	return	customer.stream().map(x->customerToDto(x)).collect(Collectors.toList());
		 
		}
		
	public Customer dtoToCustomer(CustomerDto dto)
	{
		/*Customer customer = new Customer();
		customer.setId(dto.getId());
        customer.setName(dto.getName());
		customer.setDescription(dto.getDescription());
		
		return customer;
		*/
		ModelMapper mapper =new ModelMapper();
		Customer map =	mapper.map(dto, Customer.class);
		return map;
		
	}
	
	public List<Customer> DtoToCustomerList(List<CustomerDto> dto) {
	return	dto.stream().map(x->dtoToCustomer(x)).collect(Collectors.toList());
		 
		}
}
