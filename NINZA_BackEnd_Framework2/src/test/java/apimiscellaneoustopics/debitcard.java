package apimiscellaneoustopics;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class debitcard {
	@Test
	public void DebitcardTest() {
		String req="{\r\n"
				+ "    \"debitCardNum\":\"1234567887654321\",\r\n"
				+ "    \"cvv\":543,\r\n"
				+ "    \"expDate\":\"28/30\"\r\n"
				+ "}";
given()
.contentType(ContentType.JSON)
.body(req)
.when().post("http://localhost:9990/debitCard")
.then()
.assertThat().statusCode(200)
.log().all();

}

}
