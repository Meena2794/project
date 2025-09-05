package apimiscellaneoustopics;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import com.ninza.hrm.api.genericutility.JavaUtility;
import com.ninza.hrm.api.pojoclass.ProjectPOJO;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class Datamasking {
	JavaUtility jlib = new JavaUtility();

	@Test
	public void datamaskingTest() {
		ProjectPOJO pObj =new	ProjectPOJO("Zee", "Created", 0,"Dell_"+jlib.getRandomNumber());
	 given()
			.config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Transfer-Encoding")))
		.contentType(ContentType.JSON)
		.body( pObj)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.log().all();

}
	}


