package com.sovon9.EmployeeGraphQL.controller;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import com.sovon9.EmployeeGraphQL.model.Employee;
import com.sovon9.EmployeeGraphQL.model.EmployeePublisher;

import reactor.core.publisher.Flux;

@Controller
public class EmployeeSubscriptionController {

    private final EmployeePublisher publisher;

    public EmployeeSubscriptionController(EmployeePublisher publisher) {
        this.publisher = publisher;
    }

    @SubscriptionMapping
    public Flux<Employee> employeeAdded() {
    	System.out.println("subscription started.....");
        return publisher.getPublisher();
//    	Employee emp = new Employee();
//    	emp.setName("SS");
//    	emp.setId(1L);
//    	emp.setRole("dev");
//    	return Flux.just(emp);
    }
    
    @SubscriptionMapping
    public Flux<String> subsTest() {
    	System.out.println("subscription started.....");
        return Flux.interval(Duration.ofSeconds(1)).map(l->String.valueOf(l));
    }
}