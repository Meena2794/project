package endToEnd;

import java.sql.SQLException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza.hrm.api.genericutility.DataBaseUtility;
import com.ninza.hrm.api.genericutility.WebDriverUtility;

import static io.restassured.RestAssured.*;

public class scenerio_1 {
	WebDriverUtility wlib= new WebDriverUtility();
	DataBaseUtility dblib=new DataBaseUtility();
	Random ran = new Random();
	int ranum=ran.nextInt(1000);
	String proName="Jansi"+ranum;
@Test
public void FECreateProject() throws SQLException {
	WebDriver driver= new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://49.249.28.218:8091");
	driver.findElement(By.id("username")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Projects')]")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Create Project')]")).click();
	driver.findElement(By.name("projectName")).sendKeys(proName);
	driver.findElement(By.name("createdBy")).sendKeys("Meena");
WebElement ele = driver.findElement( By.xpath("//label[contains(text(),'Project Status*')]/following-sibling::select"));
	wlib.SelectfromIndex(ele, 1);
	driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	WebElement pEle = driver.findElement(By.xpath("//div[1]/div/div[3]/select"));
	wlib.SelectfromIndex(pEle, 1);
	driver.findElement(By.xpath("//div/div[4]/input")).sendKeys(proName);
	String poid = driver.findElement(By.xpath("//td[text()='"+proName+"']/../td[1]")).getText();
	System.out.println(poid);
driver.quit();
	
	
	given()
	.get("http://49.249.28.218:8091/project?projectName="+proName)
	.then()
	.assertThat().statusCode(200)
	.log().all();
	
	dblib.getDbconnection();
	boolean flag = dblib.executeQueryVerifyAndGetData("select * from project", 4, proName);
	Assert.assertTrue(flag,"project in DB is not verified");
	dblib.closeDbconnection();
}

}
