package endToEnd;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ninza.hrm.api.genericutility.DataBaseUtility;
import com.ninza.hrm.api.genericutility.WebDriverUtility;

import io.restassured.http.ContentType;

public class scenerio_3 { 
	WebDriverUtility wlib= new WebDriverUtility();
	Random ran = new Random();
	int ranum=ran.nextInt(1000000);
	String proName="FB_"+ranum;
	String proId="NH_PROJ_"+ranum;
	DataBaseUtility dblib =new DataBaseUtility();
	@Test
	public void DBCreateProject() throws SQLException {
		dblib.getDbconnection();
		 dblib.excuteNonseletQuery("insert into project(project_id, created_by, created_on, project_name, status, team_size)values('"+proId+"','MEENA','16/05/2025','"+proName+"','Created','0');");
		 boolean flag = dblib.executeQueryVerifyAndGetData("select * from project", 1, proId);
           Assert.assertTrue(flag,"project in DB is not verified");
          dblib.closeDbconnection();
          
          
          

      	JSONObject jsonobj=new JSONObject();
      	jsonobj.put("createdBy","Madhu");
      		
      	given()
      	.contentType(ContentType.JSON)
      	.body(jsonobj)
      	.when()
      	.patch("http://49.249.28.218:8091/project/"+proId)
      	.then()
      .assertThat().statusCode(200)
      	.log().all();
      	
      	
      	WebDriver driver= new EdgeDriver();
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
    	driver.findElement(By.xpath("//i[@title='Delete']")).click();
    	driver.findElement(By.xpath("//input[@value='Delete']")).click();
    	WebElement pEle1 = driver.findElement(By.xpath("//div[1]/div/div[3]/select"));
    	wlib.SelectfromIndex(pEle1, 1);
    	driver.findElement(By.xpath("//div/div[4]/input")).sendKeys(proName);
    	driver.quit();
           }
	}


