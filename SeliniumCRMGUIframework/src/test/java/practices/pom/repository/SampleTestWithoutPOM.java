package practices.pom.repository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestWithoutPOM {

	public static void main(String[] args) {
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("http://49.249.28.218:8888");
		d.manage().window().maximize();
		 WebElement ele1 = d.findElement(By.name("user_name"));
		 WebElement ele2 = d.findElement(By.name("user_password"));
		 WebElement ele3 = d.findElement(By.id("submitButton"));
		ele1.sendKeys("admin");
		ele2.sendKeys("admin");
		
		d.navigate().refresh();
		ele1.sendKeys("admin");
		ele2.sendKeys("admin");
		ele3.click();
	}

}
