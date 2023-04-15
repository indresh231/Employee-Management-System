package com.curd.spring.repository;


/*
@Indresh Pratap Arun

*/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curd.spring.Model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

}
