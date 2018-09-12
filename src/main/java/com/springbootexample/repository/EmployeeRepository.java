package com.springbootexample.repository;

import com.springbootexample.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    //@Query("SELECT e FROM Employee e WHERE e.dept = ?1")
    public List<Employee> findByDept(String deptName, Sort sort);
}