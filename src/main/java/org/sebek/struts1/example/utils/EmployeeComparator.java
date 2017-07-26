package org.sebek.struts1.example.utils;

import java.util.Comparator;

import org.sebek.struts1.example.dto.EmployeeDTO;

public class EmployeeComparator implements Comparator<EmployeeDTO> {

	@Override
	public int compare(EmployeeDTO employee1, EmployeeDTO employee2) {
		
		if (employee1 == null && employee2 == null) {
			return 0;
		}
		
		if (employee1 == null) {
			return -1;
		}
		
		if (employee2 == null) {
			return 1;
		}
		
		if (employee1.getFormattedName() == null && employee2.getFormattedName() == null) {
			return 0;
		}
		
		if (employee1.getFormattedName() == null) {
			return -1;
		}
		
		if (employee2.getFormattedName() == null) {
			return 1;
		}
		
		int result = employee1.getFormattedName().compareTo(employee2.getFormattedName()); 
		return (result < 0 ? -1 : result > 1 ? 1 : 0);
	}
}
