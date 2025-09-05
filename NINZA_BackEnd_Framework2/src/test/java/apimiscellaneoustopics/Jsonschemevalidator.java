package apimiscellaneoustopics;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import com.ninza.hrm.api.genericutility.JavaUtility;
import com.ninza.hrm.api.pojoclass.ProjectPOJO;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class Jsonschemevalidator {
	JavaUtility jlib = new JavaUtility();

	@Test
	public  void addProject() {
		ProjectPOJO pObj =new	ProjectPOJO("Zee", "Created", 0,"Dell_"+jlib.getRandomNumber());
	Response res = given()
		.contentType(ContentType.JSON)
		.body( pObj)
		.when()
		.post("http://49.249.28.218:8091/addProject");
		res.then()
		.body(JsonSchemaValidator.matchesJsonSchema(new File("./src/test/resources/jsonschema.json")))
		.log().all();

}
	
	
	}
