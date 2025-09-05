package com.ninza.hrm.api.pojoclass;

public class ProjectPOJO {
	String createdBy;
	String status;
	int teamSize;
	String projectName;
	
	public ProjectPOJO() {}
	
	public ProjectPOJO(String createdBy, String status, int teamSize, String projectName) {
		this.createdBy = createdBy;
		this.status = status;
		this.teamSize = teamSize;
		this.projectName = projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	

}
