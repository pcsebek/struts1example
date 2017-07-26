package org.sebek.struts1.example.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.sebek.struts1.example.dto.EmployeeDTO;
import org.sebek.struts1.example.form.EmployeeForm;
import org.sebek.struts1.example.service.EmployeeService;
import org.sebek.struts1.example.service.JobService;

public class EmployeeAction extends DispatchAction {
	
	
	public ActionForward add (ActionMapping mapping, ActionForm form,
								 HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EmployeeForm employeeForm = (EmployeeForm)form;
		employeeForm.clearFields();
		employeeForm.setJobList(JobService.getInstance().getJobList());
		return mapping.findForward("success");
	}
	
	
	public ActionForward display (ActionMapping mapping, ActionForm form,
								 HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EmployeeForm employeeForm = (EmployeeForm)form;
		String employeeIdStr = determineEmployeeIdToUse(request, employeeForm);
		
		if (employeeIdStr == null || employeeIdStr.isEmpty()) {
			
			if (employeeForm.getEmployeeId() == null)
			employeeForm.clearFields();
		}
		else {
			Integer employeeId = Integer.valueOf(employeeIdStr);
			EmployeeDTO employeeDTO = EmployeeService.getInstance().getEmployeeData(employeeId);
			populateForm(employeeForm, employeeDTO);
		}
		employeeForm.setJobList(JobService.getInstance().getJobList());
		return mapping.findForward("success");
	}
	
	private String determineEmployeeIdToUse(HttpServletRequest request, EmployeeForm form) {
		
		String tempId = request.getParameter("employeeId");
		tempId = (tempId == null || tempId.isEmpty() ? form.getEmployeeId() : tempId);
		tempId = (tempId == null || tempId.isEmpty() ? form.getSelectedId() : tempId);
		return tempId;
	}
	
	
	private void populateForm(EmployeeForm form, EmployeeDTO dto) {
		form.setCurrentJobId((dto.getJob() == null ? null : dto.getJob().getId()));
		form.setEmployeeId(dto.getId() == null ? null : dto.getId().toString());
		form.setFirstName(dto.getFirstName());
		form.setLastName(dto.getLastName());
		form.setPreviousJobs(dto.getPreviousJobs());
		form.setSalary((dto.getSalary() == null ? null : dto.getSalary().toString()));
		form.setPriorJobId(form.getCurrentJobId());
	}
}
