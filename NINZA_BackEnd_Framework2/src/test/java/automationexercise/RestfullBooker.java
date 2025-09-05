package automationexercise;
import static io.restassured.RestAssured.*;
import static org.mockito.ArgumentMatchers.booleanThat;

import java.io.File;

import org.testng.annotations.Test;

import com.ninza.hrm.api.genericutility.JavaUtility;

import automationexercise.bookingPojo.bookingdates;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class RestfullBooker {
	public static JavaUtility jlib =new JavaUtility();
		public static String tokenres;
		public static int  pid;
		
	@Test
	public void TokenTest() {
		
		String token="{\r\n"
				+ "	    \"username\" : \"admin\",\r\n"
				+ "	    \"password\" : \"password123\"\r\n"
				+ "	}";
			Response resp = given()
			.contentType(ContentType.JSON)
			.body(token)
		     .when()
		     .post("https://restful-booker.herokuapp.com/auth");
			resp.then()
		     .assertThat().statusCode(200)
		     .log().all();
			tokenres= resp.jsonPath().get("token");
			System.out.println(tokenres);
	}		


		@Test(dependsOnMethods = "TokenTest")
		public void getDataToServer() {
	Response resp = given().relaxedHTTPSValidation()
			.auth().oauth2(tokenres)
		     .when()
		     .get("https://restful-booker.herokuapp.com/booking");
	      resp.then()
		     .assertThat().statusCode(200)
		     .log().all();
	     pid = resp.jsonPath().get("[0].bookingid");
	     System.out.println(pid);
			
	}
		
			@Test(dependsOnMethods = "getDataToServer")
			public void fetchDataToServer() {
		Response resp = given().relaxedHTTPSValidation()
				.cookie(tokenres)
			     .when()
			     .get("https://restful-booker.herokuapp.com/booking/"+pid);
		      resp.then()
			     .assertThat().statusCode(200)
			     .log().all();
				
		}

			@Test(dependsOnMethods = "fetchDataToServer")
			public void postDataToServer() {
//				bookingdates bd=new bookingdates(jlib.getSystemDateYYYYMMDD(),jlib.getRequireDateYYYYMMDD(0));
			bookingPojo bP= new bookingPojo(tokenres, tokenres, null, null, null, tokenres);
			
			Response resp = given().relaxedHTTPSValidation()
				.cookie("token",tokenres)
				 .contentType(ContentType.JSON)
				     .body(bP)
				     .when()
				     .post("https://restful-booker.herokuapp.com/booking");
			      resp.then()
			     .assertThat().statusCode(200)
				     .log().all();
				
		
		}

		@Test(dependsOnMethods = "fetchDataToServer")
		public void patchDataToServer() {
		
			File fObj =new File("./partialupdate.json");
		Response resp = given().relaxedHTTPSValidation()
			.cookie("token",tokenres)
			 .contentType(ContentType.JSON)
			     .body(fObj)
			     .when()
			     .patch("https://restful-booker.herokuapp.com/booking/"+pid);
		      resp.then()
//			     .assertThat().statusCode(200)
			     .log().all();
//				
//		}
	}

}
