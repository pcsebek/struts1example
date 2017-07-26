package org.sebek.struts1.example.ajax;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.sebek.struts1.example.dto.EmployeeDTO;
import org.sebek.struts1.example.service.EmployeeService;
import org.sebek.struts1.example.utils.EmployeeComparator;

public class EmployeeListAjaxAction extends Action {
	
	private static String OPTION_STRING_FORMAT = "<option value=\"%s\">%s</option>";
	
	public ActionForward execute(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
		List<EmployeeDTO> theList = EmployeeService.getInstance().getEmployees();
		
		// Sort the list
		theList.sort(new EmployeeComparator());
		PrintWriter out = response.getWriter();
		for (EmployeeDTO record : theList) {
			out.print(String.format(OPTION_STRING_FORMAT,record.getId(),record.getFormattedName()));
			out.flush();
		}
		return null;
	}
	

	
}
