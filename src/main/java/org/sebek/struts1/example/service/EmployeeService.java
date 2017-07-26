package org.sebek.struts1.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.sebek.struts1.example.dto.EmployeeDTO;

public class EmployeeService {

	private static EmployeeService instance = new EmployeeService();
	
	private static SortedMap<Integer,EmployeeDTO> employees = new TreeMap<Integer,EmployeeDTO>();
	
	private EmployeeService() {
		// private because singleton
	}
	
	public static EmployeeService getInstance() {
		return instance;
	}
	
	/**
	 * Gets the list of employees
	 * @return List<EmployeeDTO>
	 * @throws Exception
	 */
	public List<EmployeeDTO> getEmployees() throws Exception {
		
		List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>(employees.values());
		return employeeList;
	}
	
	/**
	 * Gets employee record
	 * @param employeeId
	 * @return Employee record with a populated id field or a new employee record with a null id
	 * @throws Exception
	 */
	public EmployeeDTO getEmployeeData(Integer employeeId) throws Exception {
		
		EmployeeDTO employeeDTO = null;
		
		if (employeeId != null) {
			
			employeeDTO = employees.get(employeeId);
		}
		
		if (employeeId == null || employeeDTO == null) {
			employeeDTO = new EmployeeDTO();
		}
		return employeeDTO;
	}
	
	/**
	 * Add Employee record 
	 * @param employeeDTO
	 * @return Id of added record
	 * @throws Exception
	 */
	public Integer saveEmployeeData(EmployeeDTO employeeDTO) throws Exception {
		
		if (employeeDTO.getId() == null) {
			Integer nextId = determineNextEmployeeId();
			employeeDTO.setId(nextId);
		}
		employeeDTO.setFormattedName(formatName(employeeDTO));
		employees.put(employeeDTO.getId(), employeeDTO);
		return employeeDTO.getId();
	}
	
	/**
	 * Removes employee record
	 * @param Integer - employeeId
	 * @return Id of removed record
	 * @throws Exception
	 */
	public Integer deleteEmployeeData(Integer employeeId) throws Exception {
		
		employees.remove(employeeId);
		return employeeId;
	}
	
	/**
	 * Finds next employee id
	 */
	private Integer determineNextEmployeeId() {
		if (employees.isEmpty()) {
			return Integer.valueOf(1);
		}

		int value = employees.lastKey().intValue();
		return Integer.valueOf((++value));
	}
	
	/**
	 * Formats the name: lastName, firstName
	 * @param employeeDTO
	 * @return String
	 */
	private String formatName(EmployeeDTO employeeDTO) {
		
		String name =
				String.format("%s, %s", 
							  defaultStringValueSpace(employeeDTO.getLastName()),
							  defaultStringValueSpace(employeeDTO.getFirstName()));
		return name;
	}
	
	/**
	 * Returns the string that is passed in if the string is not null and not empty
	 * otherwise a single space string is returned.
	 * @param inString
	 * @return String
	 */
	private String defaultStringValueSpace(String inString) {
		
		if (inString == null || inString.isEmpty()) {
			return " ";
		}
		return inString;
	}
	
}
