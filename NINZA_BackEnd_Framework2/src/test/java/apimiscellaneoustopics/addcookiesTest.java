package apimiscellaneoustopics;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class addcookiesTest {
	@Test
	public void cookies() {
		given()
		.cookie("userName","madhura")
		.log().all()
		.when()
		.get("http://49.249.28.218:8091/project/NH_PROJ_30133")
		.then().log().all();
		
	}
}
