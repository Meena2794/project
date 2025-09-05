package com.ninza.hrm.api.genericutility;

import static io.restassured.RestAssured.*;

import java.util.List;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class Jsonutility {
	FileUtility flib =new FileUtility();
	 public String getDataonJsonpath(Response resp, String jsonXpath) {
		 List<String> lst = JsonPath.read(resp.asString(), jsonXpath);
		return lst.get(0).toString();
		 
	 }
	 
	 public String getDataonXpathpath(Response resp, String xmlXpath) {
		return resp.xmlPath().get(xmlXpath);
		 
	 }
	 
	 public boolean getDataonJsonpath(Response resp, String jsonXpath,String expectedData) {
		 List<String> lst = JsonPath.read(resp.asString(), jsonXpath);
		 boolean flag =false;
		 for(String str: lst) {
			 if (str.equals(expectedData)) {
				 System.out.println(expectedData +"is available==Pass");
				 flag =true;
			}
		 }
		 if (flag==false) {
			 System.out.println(expectedData +"is not available==Fail");
		 }
		return flag;
		 
	 }

	public String getAcessToken() throws Throwable {

		Response resp = given().formParam("client_id",flib.getDataFromProperties("clientID"))
				.formParam("client_secret", flib.getDataFromProperties("clientSecret"))
				.formParam("grant_type", "client_credentials").when()
				.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		resp.then()
		.log().all();
//		capture token from the respose[keyClock  (outh2.0)]
			String token = resp.jsonPath().get("access_token");
		return token;
	
	}
}
