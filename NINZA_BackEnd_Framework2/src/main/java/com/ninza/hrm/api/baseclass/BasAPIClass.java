package com.ninza.hrm.api.baseclass;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;
import com.ninza.hrm.api.genericutility.DataBaseUtility;
import com.ninza.hrm.api.genericutility.FileUtility;
import com.ninza.hrm.api.genericutility.JavaUtility;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class BasAPIClass {
	public static JavaUtility jlib= new JavaUtility();
	public static FileUtility flib =new FileUtility();
	public static DataBaseUtility dblib=new DataBaseUtility();
	public static RequestSpecification specobj;
	public static ResponseSpecification SpecrespObj;
	@BeforeSuite
	public void ConfigBS() throws SQLException, IOException {
		dblib.getDbconnection();
		System.out.println("==================connect to DB==================");
		RequestSpecBuilder builder= new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);
//		builder.setAuth(basic("username","password"));
//		builder.addHeader(" ", "");
		builder.setBaseUri(flib.getDataFromProperties("BASE_URI"));
		specobj = builder.build();
		ResponseSpecBuilder resBuilder= new ResponseSpecBuilder();
		resBuilder.expectContentType(ContentType.JSON);
		SpecrespObj = resBuilder.build();
		
		
	}
	
	@AfterSuite
	public void ConfigAS() throws SQLException {
		dblib.closeDbconnection();
		System.out.println("==================Disconnect to DB==================");
	}
}
