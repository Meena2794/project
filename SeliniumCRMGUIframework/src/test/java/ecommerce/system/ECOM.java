package ecommerce.system;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ECOM {
	public static void main(String[] args) throws Throwable {

	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/");
	driver.findElement(By.xpath("//a[text()='Login']")).click();
	driver.findElement(By.name("email")).sendKeys("anuj.lpu1@gmail.com");
	driver.findElement(By.name("password")).sendKeys("Test@123",Keys.ENTER);

}
}