package com.example.demo;

import java.util.List;



public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(int id);
    void deleteEmployeeById(int id);
}
