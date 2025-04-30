package com.sovon9.EmployeeGraphQL.model;

public class AddEmployeeInput
{
	private String name;
    private Long departmentId;
    private String role;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Long getDepartmentId()
	{
		return departmentId;
	}
	public void setDepartmentId(Long departmentId)
	{
		this.departmentId = departmentId;
	}
	public String getRole()
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
}
