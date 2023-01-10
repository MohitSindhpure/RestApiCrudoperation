 package com.BikkadIT.RestApiCrudoperation.service;

import java.util.List;

import com.BikkadIT.RestApiCrudoperation.model.Employee;

public interface EmployeeServiceI {

	public  boolean saveEmployee(Employee emp);
	
	public boolean saveAllEmployee(List<Employee> employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee getByEmployeeIdQueryParam(int empId);
	
	public Employee getEmployeeIdPathParam(int empId);
	
	public Employee getEmployeeByRequestBody(Employee emp); 
	
	public  boolean updateEmployee(Employee emp);
	
	public boolean updateAllEmployee(List<Employee> list);
	
	public boolean deleteById(int empId);
	
	public boolean deleteAllEmployee();
}
