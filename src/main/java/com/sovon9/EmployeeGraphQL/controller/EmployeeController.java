package com.sovon9.EmployeeGraphQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.sovon9.EmployeeGraphQL.model.Employee;
import com.sovon9.EmployeeGraphQL.service.EmployeeService;

@Controller
public class EmployeeController
{
	@Autowired
	EmployeeService employeeService;
	
	@QueryMapping
	public Employee getEmployee(@Argument Long id) {
        return employeeService.getEmployee(id);
    }

	@QueryMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
	
	@QueryMapping
	public Employee getEmpByDeptName(@Argument String department)
	{
		return employeeService.getEmployeeByDeptName(department);
	}
	
}
