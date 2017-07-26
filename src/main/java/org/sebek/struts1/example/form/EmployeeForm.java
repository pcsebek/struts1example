package org.sebek.struts1.example.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.validator.ValidatorForm;
import org.sebek.struts1.example.dto.JobDTO;

@SuppressWarnings("serial")
public class EmployeeForm extends ValidatorForm {

	String selectedId;
	String employeeId;
	String lastName;
	String firstName;
	String currentJobId;
	String priorJobId;
	String salary;
	
	List<JobDTO> previousJobs = new ArrayList<JobDTO>();	
	List<JobDTO> jobList = new ArrayList<JobDTO>();
	

	public String getSelectedId() {
		return selectedId;
	}
	
	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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

	public String getCurrentJobId() {
		return currentJobId;
	}

	public void setCurrentJobId(String currentJobId) {
		this.currentJobId = currentJobId;
	}

	public String getPriorJobId() {
		return priorJobId;
	}
	
	public void setPriorJobId(String priorJobId) {
		this.priorJobId = priorJobId;
	}
	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public List<JobDTO> getPreviousJobs() {
		return previousJobs;
	}

	public void setPreviousJobs(List<JobDTO> previousJobs) {
		this.previousJobs = previousJobs;
	}

	public List<JobDTO> getJobList() {
		return jobList;
	}

	public void setJobList(List<JobDTO> jobList) {
		this.jobList = jobList;
	}
	
	public void clearFields() {
		selectedId = null;
		employeeId = null;
		lastName = null;
		firstName = null;
		currentJobId = null;
		priorJobId = null;
		salary = null;
		
		previousJobs = new ArrayList<JobDTO>();	

	}
}
