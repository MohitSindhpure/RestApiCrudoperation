package com.BikkadIT.RestApiCrudoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.RestApiCrudoperation.model.Employee;
import com.BikkadIT.RestApiCrudoperation.service.EmployeeServiceI;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceI employeeServiceI;
	
	@PostMapping(value = "/savedata",consumes = "application/json")
	public ResponseEntity<String> saveData(@RequestBody Employee emp){
		boolean saveEmployee = employeeServiceI.saveEmployee(emp);
		
		if (saveEmployee) {
			return new ResponseEntity<String>("Emplyee Data Save Successfully",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("Emplyee Data Not Save Successfully",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/savealldata",consumes = "application/json")
	public ResponseEntity<String> savaAllData(@RequestBody List<Employee> list){
		
		boolean saveAllEmployee = employeeServiceI.saveAllEmployee(list);
		
		if (saveAllEmployee) {
			
			return new ResponseEntity<String> ("Employeee Save All Data SUccessfuly!!!!!!!!!!!!",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String> ("Employeee Save Not All Data SUccessfuly!!!!!!!!!!!!",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value ="/getalldata",produces = "application/json")
	public ResponseEntity<List<Employee>> getData(){
		List<Employee> allEmployee = employeeServiceI.getAllEmployee();
		if (allEmployee != null) {
			return new ResponseEntity<List<Employee>>(allEmployee,HttpStatus.OK);
		}
		else {
			System.out.println("Value Is Not Available....");
			return null;
		}
	}
	
	@GetMapping(value = "/getquery",produces = "application/json")
	public ResponseEntity<Employee> getQuerybyid(@RequestParam int empId){
		
		Employee byEmployeeIdQueryParam = employeeServiceI.getByEmployeeIdQueryParam(empId);
		
		if (byEmployeeIdQueryParam != null) {
			
			return new ResponseEntity<Employee>(byEmployeeIdQueryParam,HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	
	@GetMapping(value = "/getpath/{empId}",produces = "application/json")
	public ResponseEntity<Employee> getpathbyid(@PathVariable int empId){
		
	 Employee employeeIdPathParam = employeeServiceI.getEmployeeIdPathParam(empId);
		
		if (employeeIdPathParam != null) {
			
			return new ResponseEntity<Employee>(employeeIdPathParam,HttpStatus.OK);
		}
		else {
			return null;
		}
	}	
	@PostMapping(value = "/getrequest",consumes = "application/json",produces = "application/json")
	public ResponseEntity<Employee> getEmployeeRequest(@RequestBody Employee emp) {
		
		Employee employeeByRequestBody = employeeServiceI.getEmployeeByRequestBody(emp);
		if (employeeByRequestBody != null) {
			return new ResponseEntity<Employee>(employeeByRequestBody,HttpStatus.OK);
		}
		else {
			System.out.println("No Value Present Database");
		return null;
		}
	}
	
	@PutMapping(value = "/updatedata",consumes = "application/json")
	public ResponseEntity<String> updateData(@RequestBody Employee emp){

		boolean updateEmployee = employeeServiceI.updateEmployee(emp);
		if (updateEmployee) {
			String msg ="updated Successfully...!!!";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}	
		else {
			String msg ="No updated Successfully...!!!";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}	
	}
	
	@PutMapping(value = "/updatealldata",consumes = "application/json")
	public ResponseEntity<String> updateAllData(@RequestBody List<Employee> emp){

		boolean updateAllEmployee = employeeServiceI.updateAllEmployee(emp);
		if (updateAllEmployee) {
			String msg ="updated ALlData Successfully...!!!";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}	
		else {
			String msg ="No updated All Data Successfully...!!!";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping(value = "/deletedata",consumes = "application/json ")
	public ResponseEntity<String> deleteEmployee(@RequestBody int empId){
		
		boolean deleteById = employeeServiceI.deleteById(empId);
		if (deleteById) {
			String msg ="Deleted Data Successfully...!!!";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		else {
			String msg ="No Deleted Data Successfully...!!!";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
	}

	@DeleteMapping("/deleteall")
	public ResponseEntity<String> deleteAllData(){
		
		boolean deleteAllEmployee = employeeServiceI.deleteAllEmployee();
		if (deleteAllEmployee) {
			String msg ="Deleted All Data Successfully...!!!";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		else {
			String msg ="No Deleted All Data Successfully...!!!";
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
		
		
	}
	
  }
