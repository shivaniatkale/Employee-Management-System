package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class EmployeeController {
	@Autowired
	private EmployeeServiceImp1 employeeService;
	
		@GetMapping("/emp")
		//@ResponseBody
		//public List<Employee> viewHomePage(Model model) {
		public String viewHomePage(Model model) {
			model.addAttribute("listEmployees", employeeService.getAllEmployees());//retrive list of employee
			return "index" ; //thymeleaf page
			//return employeeService.getAllEmployees();
			
		}
		
		@GetMapping("/shownewEmployeeForm")
     public String shownewEmployeeForm(Model model) {
			//create model attribute to bind form data
    	 Employee employee=new Employee();
    	 model.addAttribute("employee",employee);
    	 return "new_employee";
     }
		
		@PostMapping("/saveEmployee")
		public String saveEmployee(@ModelAttribute("employee") Employee employee){
			//save employee to database
			employeeService.saveEmployee(employee);
			return "redirect:/emp";
			//return "index";
			
		}
		
		@GetMapping("/showFormForUpadte/{id}")
		public String showFormForUpadte(@PathVariable (value="id") int id,Model model) {
			//get employee from the service
			Employee employee=employeeService.getEmployeeById(id);
			//set employee as a model attribute to pre-populate the form
			model.addAttribute("employee",employee);
			return "update_employee";
		}
		
		@GetMapping("/deleteEmployee/{id}")
		public String deleteEmployee(@PathVariable (value="id") int id,Model model) {
			//call delete employee method
			this.employeeService.deleteEmployeeById(id);
			return "redirect:/emp";
		}
		
		
		
	}

