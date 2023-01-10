package com.BikkadIT.RestApiCrudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BikkadIT.RestApiCrudoperation.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
