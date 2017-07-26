package org.sebek.struts1.example.dto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDTO {

	Integer id;
	String lastName;
	String firstName;
	Integer salary;
	JobDTO job;
	List<JobDTO> previousJobs = new ArrayList<JobDTO>();
	
	String formattedName;
	
	public EmployeeDTO() {
		// default constructor
	}
	
	public EmployeeDTO(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Integer getSalary() {
		return salary;
	}
	
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
	public JobDTO getJob() {
		return job;
	}
	
	public void setJob(JobDTO job) {
		this.job = job;
	}
	
	public List<JobDTO> getPreviousJobs() {
		return previousJobs;
	}
	
	public void setPreviousJobs(List<JobDTO> previousJobs) {
		this.previousJobs = previousJobs;
	}
	
	public String getFormattedName() {
		
		return formattedName;
	}
	
	public void setFormattedName(String formattedName) {
		this.formattedName = formattedName;
	}
}