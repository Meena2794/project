package ecommerce.system;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderManagement {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d= new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application");
		d.findElement(By.xpath("//a[@href=\"admin\"]")).click();
		d.findElement(By.id("inputEmail")).sendKeys("admin");
		d.findElement(By.id("inputPassword")).sendKeys("Test@123");
		d.findElement(By.name("submit")).click();
		d.findElement(By.xpath("//a[contains(text(),' Create Category ')]")).click();
		d.findElement(By.name("category")).sendKeys("Bangales");
		d.findElement(By.name("description")).sendKeys("colourfull bangales");
		d.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(500);
		d.findElement(By.xpath("//a[@href='subcategory.php']")).click();
	 WebElement dropdowncat = d.findElement(By.xpath("//select[@name='category']"));
			Select s = new Select(dropdowncat);
			s.selectByValue("50");;
			d.findElement(By.xpath("//input[@name='subcategory']")).sendKeys("Black Metal");
		d.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(500);
		d.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys("Black Metal",Keys.ENTER);
		//td[text()='Black Metal']
	}

}
