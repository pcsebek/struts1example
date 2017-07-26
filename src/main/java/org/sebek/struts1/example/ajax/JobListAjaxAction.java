package org.sebek.struts1.example.ajax;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.sebek.struts1.example.dto.JobDTO;
import org.sebek.struts1.example.service.JobService;

public class JobListAjaxAction extends DispatchAction {
	
	private static String OPTION_STRING_FORMAT = "<option value=\"%s\">%s</option>";
	
	public ActionForward execute(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		List<JobDTO> theList = JobService.getInstance().getJobList();
		
		PrintWriter out = response.getWriter();
		for (JobDTO record : theList) {
			out.print(String.format(OPTION_STRING_FORMAT,record.getId(),record.getDescription()));
			out.flush();
		}
		return null;
	}
}
