package apimiscellaneoustopics;

import static io.restassured.RestAssured.*;

import java.io.File;

import javax.mail.Multipart;

import org.testng.annotations.Test;



public class UploadImage {

	@Test
	public  void addProject() {
	 given()
	 .multiPart(new File("C:\\Users\\admin\\OneDrive\\Desktop\\project software\\defect.jpg"))
	 .log().all()
		.when()
		.post("http://postman-echo.com/post")
		.then()
		.log().all();

}

}
