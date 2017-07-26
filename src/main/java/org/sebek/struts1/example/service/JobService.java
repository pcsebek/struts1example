package org.sebek.struts1.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.sebek.struts1.example.dto.JobDTO;
import org.sebek.struts1.example.utils.JobCodes;

public class JobService {
	
	private static final JobService instance = new JobService();
	
	private static SortedMap<String,JobDTO> jobMap;
	
	{
		jobMap = new TreeMap<String,JobDTO>();
		for (JobCodes jobCode : JobCodes.values()) {
			jobMap.put(jobCode.getId(),new JobDTO(jobCode.getId(),jobCode.toString()));
		}
	}
	
	private JobService() {
	// intentionally left blank	
	}

	public static JobService getInstance() {
		return instance;
	}
	
	/**
	 * Retrieves jobList
	 * @return List<JobDTO>
	 */
	public List<JobDTO> getJobList() {

		List<JobDTO> list = new ArrayList<JobDTO>();
		list.addAll(jobMap.values());
		return list;
	}
	
	/**
	 * Returns a JobDTO that matches jobId
	 * @param jobId
	 * @return JobDTO or null
	 */
	public JobDTO getJobById(String jobId) {
		
		JobDTO job = null;
		if (jobId == null) {
			return job;
		}
		
		if (jobMap.containsKey(jobId)) {
			job = jobMap.get(jobId);
		}
		return job;
	}
}
