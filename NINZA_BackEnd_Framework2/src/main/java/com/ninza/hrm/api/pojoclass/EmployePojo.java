package com.ninza.hrm.api.pojoclass;

public class EmployePojo {
	private String designation; 
	private String dob; 
	private String email; 
	private String empName; 
	private double experinence; 
	private String mobileNo; 
	private String project; 
	private String role;
	private String username; 
	
	public EmployePojo() {}

	public EmployePojo(String designation, String dob, String email, String empName, double experinence,
			String mobileNo, String project, String role, String username) {
		this.designation = designation;
		this.dob = dob;
		this.email = email;
		this.empName = empName;
		this.experinence = experinence;
		this.mobileNo = mobileNo;
		this.project = project;
		this.role = role;
		this.username = username;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getdob() {
		return dob;
	}

	public void setdob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getExperinence() {
		return experinence;
	}

	public void setExperinence(double experinence) {
		this.experinence = experinence;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	

	}
	
	


