package com.curd.spring.Service;


/*
@Indresh Pratap Arun

*/
import java.util.List;

import org.springframework.data.domain.Page;

import com.curd.spring.Model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	
	Page<Employee> findPaginated(int pageNo, int pageSize,String sortField,String sortDirection);
	
		
	}

