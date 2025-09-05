package com.ninza.hrm.api.projectTest;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza.hrm.api.baseclass.BasAPIClass;
import com.ninza.hrm.api.pojoclass.ProjectPOJO;
import com.ninza.hrm.constants.endpoints.IEndpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.sql.SQLException;

public class ProjectTest extends BasAPIClass {
	ProjectPOJO pP;
	String BASEURI;
@Test
public void addSingleProjectWithCreatedTest() throws IOException, SQLException{
	//create a object to pojoclass
	
	 BASEURI=flib.getDataFromProperties("BASEUri");
	String ExpectedSucMsg = "Successfully Added";
	 String projectName = "Jansi"+jlib.getRandomNumber();
	 pP= new ProjectPOJO("Zee", "Created", 0,projectName );
	
	//verify the projectName in API layer
Response resp = given()
.spec(specobj)
.body(pP)
.when().post(IEndpoints.ADDProj);
resp.then()
.assertThat().statusCode(201)
.assertThat().time(Matchers.lessThan(3000L))
.spec(SpecrespObj)
.log().all();

String actMsg= resp.jsonPath().get("msg");
Assert.assertEquals(ExpectedSucMsg, actMsg);
//verify the projectName in API layer

boolean flag = dblib.executeQueryVerifyAndGetData("select * from project", 4, projectName);
			Assert.assertTrue(flag,"project in DB is not verified");
			
}

@Test(dependsOnMethods = "addSingleProjectWithCreatedTest")
public void createDuplicateProject() {
		//verify the projectName in API layer
 given()
 .spec(specobj)
	.body(pP)
	.when().post(IEndpoints.ADDProj)
	.then()
	.assertThat().statusCode(409)
	.log().all();
 
	
}



}



