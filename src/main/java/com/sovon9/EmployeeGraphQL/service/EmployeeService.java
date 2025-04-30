package com.sovon9.EmployeeGraphQL.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Service;

import com.sovon9.EmployeeGraphQL.model.Employee;
import com.sovon9.EmployeeGraphQL.repository.EmployeeRepository;

@Service
public class EmployeeService
{
	EmployeeRepository repository;
	@Autowired
	public EmployeeService(EmployeeRepository repository)
	{
		this.repository=repository;
	}
	
	public Employee getEmployee(@Argument Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

	public Employee getEmployeeByDeptName(String name)
	{
		return repository.findByDepartmentName(name);
	}
	
}
