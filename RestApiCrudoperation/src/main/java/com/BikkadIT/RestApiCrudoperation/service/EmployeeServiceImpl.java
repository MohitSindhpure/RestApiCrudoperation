package com.BikkadIT.RestApiCrudoperation.service;

import java.util.List;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.BikkadIT.RestApiCrudoperation.model.Employee;
import com.BikkadIT.RestApiCrudoperation.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public boolean saveEmployee(Employee emp) {
		Employee save = employeeRepository.save(emp);
		if (save != null) {
			System.out.println("Svae Data Successfully !!!!!!!!");
			return true;
		} else {
			System.out.println("Svae Data Not Successfully !!!!!!!!");
			return false;
		}
	}

	@Override
	public boolean saveAllEmployee(List<Employee> employee) {
		List<Employee> saveAll = employeeRepository.saveAll(employee);
		if (saveAll != null) {
			System.out.println("SvaeAll Data Successfully !!!!!!!!");
			return true;
		} else {
			System.out.println("SvaeAll Data Not Successfully !!!!!!!!");
			return false;
		}

	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> findAll = employeeRepository.findAll();

		if (findAll != null) {
			System.out.println("Find All Data Successfully...!!!!");

			return findAll;	
		}
		else {
			System.out.println("No Data Present........");
			return null;
		}
		
	}

	@Override
	public Employee getByEmployeeIdQueryParam(int empId) {
		Employee employee = employeeRepository.findById(empId).get();
		if (employee != null) {
			RestTemplate rt = new RestTemplate();
			
			String url="http://localhost:9090/getalldata";
			
			ResponseEntity<String> forEntity = rt.getForEntity(url, String.class);
			
			String body = forEntity.getBody();
			
			System.out.println(body);
			System.out.println("get data QueryParam Done...");
			return employee;
		}
		else {
			System.out.println("Not get data QueryParam....");
			return null;
		}
		
	}

	@Override
	public Employee getEmployeeIdPathParam(int empId) {
		Employee employee = employeeRepository.findById(empId).get();
		if (employee != null) {
			return employee;
		}
		else {
			return null;	
		}		
	}

	@Override
	public Employee getEmployeeByRequestBody(Employee emp) {
		
		int empId = emp.getEmpId();
		
		Employee employee = employeeRepository.findById(empId).get();
		
		return employee;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		Employee employee = employeeRepository.save(emp);
		if (employee != null) {
			System.out.println( "Updated Record Successfully........");
			return true;
		}
		else {
			System.out.println("No Updated Record Successfully........");
			return false;	
		}
	}

	@Override
	public boolean updateAllEmployee(List<Employee> list) {
		List<Employee> saveAll = employeeRepository.saveAll(list);
		if (saveAll != null) {
			System.out.println("Update All Data");
			return true;
		}
		else {
			System.out.println("No Update All Data");
			return false;	
		}
		
	}

	@Override
	public boolean deleteById(int empId) {
		boolean existsById = employeeRepository.existsById(empId);
		
		if (existsById) {
			employeeRepository.deleteById(empId);
			System.out.println("Delete By Id Successfully...");
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAllEmployee() {
		List<Employee> findAll = employeeRepository.findAll();
		if (findAll != null) {
			employeeRepository.deleteAll();
			System.out.println("All Data Has Been Deleted");
			return true;
		}
		else {
			System.out.println("All Data Has Not Been Deleted");
		return false;
		}
	}

}
