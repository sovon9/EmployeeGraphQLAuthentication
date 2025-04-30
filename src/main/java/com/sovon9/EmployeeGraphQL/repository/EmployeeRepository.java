package com.sovon9.EmployeeGraphQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sovon9.EmployeeGraphQL.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{

	Employee findByDepartmentName(String dept);

}
