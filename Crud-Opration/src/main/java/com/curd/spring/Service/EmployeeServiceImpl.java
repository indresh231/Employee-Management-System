package com.curd.spring.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.curd.spring.Model.Employee;
import com.curd.spring.repository.EmployeeRepository;

/*
@Indresh Pratap Arun

*/



@Service

public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById((int) id);
		Employee employee= null;
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("employee not found for id ::"+id);
		}
		return employee;
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField,String sortDirection) {
		Sort sort=sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortField).ascending():
			Sort.by(sortField).descending();
		
		Pageable pageble = PageRequest.of(pageNo-1, pageSize,sort);
		return this.employeeRepository.findAll(pageble);
	}

}
