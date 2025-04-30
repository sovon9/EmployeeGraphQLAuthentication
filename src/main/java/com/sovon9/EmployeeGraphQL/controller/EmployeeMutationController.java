package com.sovon9.EmployeeGraphQL.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.sovon9.EmployeeGraphQL.model.AddEmployeeInput;
import com.sovon9.EmployeeGraphQL.model.Department;
import com.sovon9.EmployeeGraphQL.model.Employee;
import com.sovon9.EmployeeGraphQL.model.EmployeePublisher;
import com.sovon9.EmployeeGraphQL.repository.EmployeeRepository;

@Controller
public class EmployeeMutationController
{
	private final EmployeeRepository repository;
    private final EmployeePublisher publisher;

    public EmployeeMutationController(EmployeeRepository repository, EmployeePublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @MutationMapping
    public Employee addEmployee(@Argument AddEmployeeInput input) {
        //Employee employee = new Employee(input.getName(), input.getDepartment(), input.getRole());
        //Employee saved = repository.save(employee);
    	Department dept = new Department(input.getDepartmentId(), "Engineering");
    	Employee employee = new Employee();
    	employee.setName(input.getName());
    	employee.setRole(input.getRole());
    	employee.setDepartment(dept);
    	Employee saved = repository.save(employee);
        publisher.publish(saved); // Notify subscribers
        System.out.println("publisher published: "+saved.getName());
        return saved;
    }
}
