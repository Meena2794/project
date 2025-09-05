package endToEnd;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;
import java.time.Duration;
import java.util.Random;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza.hrm.api.genericutility.DataBaseUtility;
import com.ninza.hrm.api.genericutility.WebDriverUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class scenerio_2 {
	WebDriverUtility wlib= new WebDriverUtility();
	DataBaseUtility dblib=new DataBaseUtility();
	Random ran = new Random();
	int ranum=ran.nextInt(100000);
	String proName="pumkin"+ranum;
	@Test
	public void createRequestBE() throws SQLException, InterruptedException {
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("createdBy","meena");
		jsonobj.put("projectName",proName);
		jsonobj.put("status","Created");
		jsonobj.put("teamSize",0);
		Response resp = given()
	.contentType(ContentType.JSON)
	.body(jsonobj)
	.when()
		.post("http://49.249.28.218:8091/addProject");
		resp	.then()
		.log().all()
		.assertThat().statusCode(201)
		.log().all();
	
	String proId= resp.jsonPath().get("projectId");
	System.out.println(proId);
	
	dblib.getDbconnection();
	boolean flag = dblib.executeQueryVerifyAndGetData("select * from project", 1, proId);
	Assert.assertTrue(flag,"project in DB is not verified");
	dblib.closeDbconnection();
	
	WebDriver driver =new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://49.249.28.218:8091");
	driver.findElement(By.id("username")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Projects')]")).click();
	WebElement pEle = driver.findElement(By.xpath("//div[1]/div/div[3]/select"));
	wlib.SelectfromIndex(pEle, 1);
	driver.findElement(By.xpath("//div/div[4]/input")).sendKeys(proName);
	String actualProjectId=proId;
	System.out.println(actualProjectId);

	String expectedProjectId;
	for(;;)
	{
		try {
		
			expectedProjectId=driver.findElement(By.xpath("//td[text()='"+proId+"']")).getText();
			System.out.println(expectedProjectId);
			break;
		}catch(Exception e)
		{
			WebElement nextBtn=driver.findElement(By.xpath("//a[@href='#']"));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
			Thread.sleep(500); // Small delay to ensure visibility
			nextBtn.click();
		}
	
	}
	
     Assert.assertEquals(actualProjectId, expectedProjectId);

	driver.quit();
}

}
