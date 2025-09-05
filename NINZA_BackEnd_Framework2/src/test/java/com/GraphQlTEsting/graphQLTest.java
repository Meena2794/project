package com.GraphQlTEsting;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class graphQLTest {
	@Test
	public void sampleTest() {
		String query ="{ getAllProjects{ projectId projectName status } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.when()
		.post("http://49.249.28.218:8091/getAll")
		.then()
		.log().all();
	}
	
	@Test
	public void DemoTest() {
		String query ="{ getAllProjects{ projectId  } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.when()
		.post("http://49.249.28.218:8091/getAll")
		.then()
		.log().all();
	}

	@Test
	public void addProject() {
		String query =" mutation { addProject( projectName: \"Europe_22\", teamSize: 0, createdBy: \"Madhu\", createdOn: \"2024-07-05\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.when()
		.post("http://49.249.28.218:8091/addProject-graphql")
		.then()
		.log().all();
	}

	
	@Test
	public void getProjectByProjectId() {
		String query =" { findProject(projectId:\"NH_PROJ_30088\"){ projectId projectName status createdBy teamSize } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.when()
		.post("http://49.249.28.218:8091/getProjectByProjectId")
		.then()
		.log().all();
	}
	
	@Test
	public void updateProject() {
		String query ="mutation { updateProject( projectId: \"NH_PROJ_30088\" projectName: \"UpdatedEurope_22\", teamSize: 0, createdBy: \"madhu\", createdOn: \"2025-05-121\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
		
		given()
		.contentType(ContentType.JSON)
		.body(query)
		.when()
		.post("http://49.249.28.218:8091/updateProject-graphql")
		.then()
		.log().all();
	}
	
	
}
