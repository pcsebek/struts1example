package org.sebek.struts1.example.controller;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.tiles.ComponentContext;
import org.apache.struts.tiles.actions.TilesAction;
import org.apache.struts.tiles.beans.SimpleMenuItem;

public class MenuControllerAction extends TilesAction {
	
	private static Map<String,String> linkMap; 
	
	static {
		linkMap = new LinkedHashMap<String,String>();
		linkMap.put("Welcome", "/do/welcome");
		linkMap.put("HelloWorld", "/do/helloWorld");
		linkMap.put("Employee", "/do/employeeSummary?method=add");
	}
		
	public ActionForward execute(ComponentContext componentContext,
								 ActionMapping mapping,
								 ActionForm form,
								 HttpServletRequest request,
								 HttpServletResponse response) {
		
			List<SimpleMenuItem> links = new ArrayList<SimpleMenuItem>(linkMap.size());
			
			for (String key : linkMap.keySet()) {
				SimpleMenuItem menuItem = new SimpleMenuItem();
				menuItem.setLink(linkMap.get(key));
				menuItem.setValue(key);
				links.add(menuItem);
			}
			
		componentContext.putAttribute("items", links);
//		request.setAttribute("items", links);
		return null;
	}
}
