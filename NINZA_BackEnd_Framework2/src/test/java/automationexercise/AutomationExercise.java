package automationexercise;

import org.testng.annotations.Test;

import com.ninza.hrm.api.genericutility.JavaUtility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class AutomationExercise {
	String email;
	Random ran = new Random();
	int ranum=ran.nextInt(1000);
	@Test
	public void RegisterUserAccount() {
		 email="email"+ranum+"@yahoo.com";
		given()
		.formParam("name","Madhura")
		.formParam("email",email)
		.formParam("password","airportgappassword")
		.formParam("title","Mrs")
		.formParam("birth_date",02)
		.formParam("birth_month","july")
		.formParam("birth_year",1996)
		.formParam("firstname","sai")
		.formParam("lastname","meena")
		.formParam("company","groups")
		.formParam("address1","home")
		.formParam("address2", "Office")
		.formParam("country", "India")
		.formParam("zipcode",560062)
		.formParam("state", "karnataka")
		.formParam("city","mysore")
		.formParam("mobile_number",9164922899l)
		.relaxedHTTPSValidation()
		.when()
		.post("https://automationexercise.com/api/createAccount")
		.then()
		.log().all();
	}
	
	@Test(dependsOnMethods ="RegisterUserAccount" )
	public void verfyLogin() {
		given()
		.relaxedHTTPSValidation()
		.formParam("email",email)
		.formParam("password","airportgappassword")
		.when()
		.post("https://automationexercise.com/api/verifyLogin")
		.then()
		.log().all();
	}
	
	@Test
	public void GetAllProductsList() {
		given()
		.relaxedHTTPSValidation()
		.get(" https://automationexercise.com/api/productsList")
		.then()
		.log().all();
	}
	
	@Test
	public void POSTToAllProductsList() {
		given()
		.relaxedHTTPSValidation()
		.post("https://automationexercise.com/api/productsList")
		.then()
		.log().all();
	}
	@Test
	public void GetAllBrandsList() {
		given()
		.relaxedHTTPSValidation()
		.get("https://automationexercise.com/api/brandsList")
		.then()
		.log().all();
	}
	@Test
	public void  PUTToAllBrandsList() {
		given()
		.relaxedHTTPSValidation()
		.put("https://automationexercise.com/api/brandsList")
		.then()
		.log().all();
	}
	@Test
	public void  POSTToSearchProduct() {
		given()
		.relaxedHTTPSValidation()
		.formParam("search_product","tshirt")
		.formParam("search_product","tshirt")
		.formParam("search_product","tshirt")
		.when()
		.post("https://automationexercise.com/api/searchProduct")
		.then()
		.log().all();
	}
	@Test
	public void  POSTToSearchProductwithoutsearch_productparameter() {
		given()
		.relaxedHTTPSValidation()
		.when()
		.post("https://automationexercise.com/api/searchProduct")
		.then()
		.log().all();
	}
	@Test
	public void POSTToVerifyLoginwithoutemailparameter() {
		given()
		.relaxedHTTPSValidation()
		.formParam("password","airportgappassword")
		.when()
		.post("https://automationexercise.com/api/verifyLogin")
		.then()
		.log().all();
	}
	 	@Test
		public void DELETEToVerifyLogin() {
			given()
			.relaxedHTTPSValidation()
			.delete("https://automationexercise.com/api/verifyLogin")
			.then()
			.log().all();
		}
	 	@Test
	 	public void POSTToVerifyLoginwithinvaliddetails() {
			given()
			.relaxedHTTPSValidation()
			.formParam("email","airportgappassword")
			.formParam("password","airportgappassword")
			.when()
			.post("https://automationexercise.com/api/verifyLogin")
			.then()
			.log().all();
		}
	 	@Test(dependsOnMethods ="RegisterUserAccount")
	 	public void DELETEMETHODToDeleteUserAccount() {
			given()
			.relaxedHTTPSValidation()
			.formParam("email",email)
			.formParam("password","airportgappassword")
			.delete("https://automationexercise.com/api/deleteAccount")
			.then()
			.log().all();
	 	}
	 	@Test(dependsOnMethods ="RegisterUserAccount")
	 	public void PUTMETHODToUpdateUserAccount() {
			given()
			.relaxedHTTPSValidation()
			.formParam("name","Madhura")
			.formParam("email",email)
			.formParam("password","airportgappassword")
			.formParam("title","Mrs")
			.formParam("birth_date",02)
			.formParam("birth_month","july")
			.formParam("birth_year",1996)
			.formParam("firstname","sai")
			.formParam("lastname","meena")
			.formParam("company","group")
			.formParam("address1","home")
			.formParam("address2", "Office")
			.formParam("country", "India")
			.formParam("zipcode",560062)
			.formParam("state", "karnataka")
			.formParam("city","mysore")
			.formParam("mobile_number",9164922899l)
			.put(" https://automationexercise.com/api/updateAccount")
			.then()
			.log().all();
	 	}
	 	@Test(dependsOnMethods ="RegisterUserAccount")
	 	public void DELETEMETHODToDeleteUserAccountGETuseraccountdetailbyemail() {
			given()
			.relaxedHTTPSValidation()
			.formParam("email",email)
			.get(" https://automationexercise.com/api/getUserDetailByEmail")
			.then()
			.log().all();
	 	}
	 	
}