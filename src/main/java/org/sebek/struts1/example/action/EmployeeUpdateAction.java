package org.sebek.struts1.example.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.sebek.struts1.example.dto.EmployeeDTO;
import org.sebek.struts1.example.dto.JobDTO;
import org.sebek.struts1.example.form.EmployeeForm;
import org.sebek.struts1.example.service.EmployeeService;
import org.sebek.struts1.example.service.JobService;

public class EmployeeUpdateAction extends DispatchAction {
	
	public ActionForward save (ActionMapping mapping, ActionForm form,
								 HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EmployeeForm employeeForm = (EmployeeForm)form;
		updateData(employeeForm);
		return mapping.findForward("success");
	}
	
	public ActionForward saveAndAdd(ActionMapping mapping, ActionForm form,
								    HttpServletRequest request, HttpServletResponse respone) throws Exception {
		
		EmployeeForm employeeForm = (EmployeeForm)form;
		updateData(employeeForm);
		return mapping.findForward("add");
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse respone) throws Exception {
		
		
		EmployeeForm employeeForm = (EmployeeForm)form;
		if (employeeForm.getEmployeeId() != null && !employeeForm.getEmployeeId().isEmpty()) {
			
			Integer employeeId = Integer.valueOf(employeeForm.getEmployeeId());
			EmployeeService.getInstance().deleteEmployeeData(employeeId);
		}
		return mapping.findForward("summary");
	}

	/*
	 * populates the DTO with action form data and calls "service" to update
	 */
	private void updateData(EmployeeForm employeeForm) throws Exception {

		Integer employeeId;
		EmployeeDTO employeeDTO;
		
		if (employeeForm.getEmployeeId() == null || employeeForm.getEmployeeId().isEmpty()) {
			
			// Add
			employeeId = null;
			employeeDTO = new EmployeeDTO();
		}
		
		else {
			// Update
			employeeId = Integer.valueOf(employeeForm.getEmployeeId());
			employeeDTO = EmployeeService.getInstance().getEmployeeData(employeeId);
		}
		
		employeeDTO.setFirstName(employeeForm.getFirstName());
		employeeDTO.setLastName(employeeForm.getLastName());
		
		employeeDTO.setSalary((employeeForm.getSalary() == null ? null : Integer.valueOf(employeeForm.getSalary())));
		
		List<JobDTO> previousJobs = employeeDTO.getPreviousJobs();
		
		if (employeeForm.getCurrentJobId() != null && !employeeForm.getCurrentJobId().isEmpty()) {
			
			// Initially prior job ID will be null/empty so set it to current job ID
			if (employeeForm.getPriorJobId() == null || employeeForm.getPriorJobId().isEmpty()) {
				employeeForm.setPriorJobId(employeeForm.getCurrentJobId());
			}
			
			// Current job change so add to previous job list and set prior job ID to current job ID
			if (!employeeForm.getCurrentJobId().equals(employeeForm.getPriorJobId())) {
				JobDTO priorJob = JobService.getInstance().getJobById(employeeForm.getPriorJobId());
				if (priorJob != null) {
					
					if (previousJobs == null) {
						previousJobs = new ArrayList<JobDTO>();
					}
					previousJobs.add(priorJob);
					employeeForm.setPriorJobId(employeeForm.getCurrentJobId());
				}
			}
		}
		
		employeeDTO.setPreviousJobs(previousJobs);
		employeeDTO.setJob(JobService.getInstance().getJobById(employeeForm.getCurrentJobId()));

		Integer id = EmployeeService.getInstance().saveEmployeeData(employeeDTO);
		
		employeeForm.setEmployeeId(id == null ? null : id.toString());
		employeeForm.setPreviousJobs(employeeDTO.getPreviousJobs());
		employeeForm.setJobList(JobService.getInstance().getJobList());
	}
}
