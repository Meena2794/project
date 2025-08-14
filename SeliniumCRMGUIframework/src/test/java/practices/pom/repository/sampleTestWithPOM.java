package practices.pom.repository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class sampleTestWithPOM {
	
	@FindBy(name= "user_name")
	WebElement ele1;
	
	@FindBy(name ="user_password")
	WebElement ele2;
	
	@FindBy(id ="submitButton")
	WebElement ele3;

@Test
public void sampleTest() {
	WebDriver d=new ChromeDriver();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	d.get("http://49.249.28.218:8888");
	d.manage().window().maximize();
	sampleTestWithPOM s = PageFactory.initElements(d, sampleTestWithPOM.class);
	s.ele1.sendKeys("admin");
	s.ele2.sendKeys("admin");
	
	d.navigate().refresh();

	s.ele1.sendKeys("admin");
	s.ele2.sendKeys("admin");
	s.ele3.click();
}
}
