package com.ninza.hrm.api.employeeTest;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.SQLException;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza.hrm.api.baseclass.BasAPIClass;
import com.ninza.hrm.api.pojoclass.EmployePojo;
import com.ninza.hrm.api.pojoclass.ProjectPOJO;
import com.ninza.hrm.constants.endpoints.IEndpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeeTest extends BasAPIClass {

	 String BASEURI;
	@Test
	public void addEmployeeTest() throws  IOException, SQLException {
		//create an object to pojoclass
		BASEURI=flib.getDataFromProperties("BASEUri");
		
	
	String  projectName = "Jansi"+jlib.getRandomNumber();
	String user="Madhu"+jlib.getRandomNumber();
	 ProjectPOJO pP= new ProjectPOJO("Zee", "Creat"
	 		+ "ed", 0,projectName );
	
	//verify the projectName in API layer
 given()
.spec(specobj)
.body(pP)
.when()
.post(IEndpoints.ADDProj)
.then()
.log().all();


//api-2==> add employee to same project
EmployePojo empObj= new EmployePojo("Tester","02/07/1996","Madhu123@gmail.com",user, 6,"9164922899",projectName,"Admin",user);
given()
.spec(specobj)
.body(empObj)
.when()
.post(IEndpoints.ADDEmp)
.then()
.assertThat().statusCode(201)
.and()
.time(Matchers.lessThan(3000L))
.spec(SpecrespObj)
.log().all();

//verify the EmpName in API layer
boolean flag = dblib.executeQueryVerifyAndGetData("select * from employee", 11, user);
			Assert.assertTrue(flag,"employee in DB is not verified");
			Assert.assertTrue(flag,"Project in DB is not verified");

	}
	
	
	@Test
	public void addEmployeWithOutEmail() throws Throwable {
		//create an object to pojoclass
		
		String  projectName = "Jansi"+jlib.getRandomNumber();
		String user="Madhu"+jlib.getRandomNumber();
		BASEURI=flib.getDataFromProperties("BASEUri");
		 ProjectPOJO pP= new ProjectPOJO("Zee", "Created", 0,projectName );
		
		//verify the projectName in API layer
	 Response res = given()
	.spec(specobj)
	.body(pP)
	.when()
	.post(IEndpoints.ADDProj);
	 System.out.println("hello");
	res.then()
	.log().all();


	//api-2==> add employee to same project
	EmployePojo empObj= new EmployePojo("Tester","02/07/1996"," ",user, 6,"9164922899",projectName,"Admin",user);
	given()
	.spec(specobj)
	.body(empObj)
	.when()
	.post(IEndpoints.ADDEmp)
	.then()
	.assertThat().statusCode(500)
	.spec(SpecrespObj)
	.log().all();
	}	
	
}
