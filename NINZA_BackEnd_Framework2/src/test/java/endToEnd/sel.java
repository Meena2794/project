package endToEnd;

import java.sql.SQLException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.ninza.hrm.api.genericutility.DataBaseUtility;
import com.ninza.hrm.api.genericutility.WebDriverUtility;

public class sel {
		WebDriverUtility wlib= new WebDriverUtility();
		DataBaseUtility dblib=new DataBaseUtility();
		Random ran = new Random();
		int ranum=ran.nextInt(1000);
		String proName="Jansi"+ranum;
	@Test
	public void FECreateProject() throws SQLException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.youtube.com ");
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("Ala vykuntapuramulo songs",Keys.ENTER);
		
}
}
	
