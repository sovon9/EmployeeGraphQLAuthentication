package com.sovon9.EmployeeGraphQL.model;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Component
public class EmployeePublisher {

	private final Sinks.Many<Employee> sink;

    public EmployeePublisher() {
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void publish(Employee employee) {
    	System.out.println("publishing employee"+employee.getName());
        sink.tryEmitNext(employee); // Emit data to subscribers
    }

    public Flux<Employee> getPublisher() {
    	Flux<Employee> flux = sink.asFlux();
    	System.out.println("publisher: "+flux);
    	return flux; // Return as Flux to GraphQL subscription
    }
    
}
