package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeeServiceImp1 implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployees() {
	return employeeRepository.findAll();//get the list of employees
		//return null;
	}
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);		
	}
	@Override
	public Employee getEmployeeById(int id) {
	Optional<Employee> optional = employeeRepository.findById(id);
	Employee employee = null;
	if(optional.isPresent()) {
		employee =optional.get();
		
	}else {
		throw new RuntimeException("Employee not found ::"+id);
	}
		
		return employee;
	}
	@Override
	public void deleteEmployeeById(int id) {
		this.employeeRepository.deleteById(id);		
	}

}