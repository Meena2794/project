package ecommerce.system;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class InsertProduct {

	public static void main(String[] args) throws InterruptedException {
//		Open the browser and Enter the URL 
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application");
//		click on admin login page
		d.findElement(By.xpath("//a[@href=\"admin\"]")).click();
//		Enter the valid admin name
		d.findElement(By.id("inputEmail")).sendKeys("admin");
//		Enter the valid password
		d.findElement(By.id("inputPassword")).sendKeys("Test@123");
//		Click on login button
		d.findElement(By.name("submit")).click();
//		click on Insert Product button

//		Select a Category dropdown list box
//		Select a Sub Category dropdown list box
//		Enter valid Product Name data in Text box
//		Enter valid Product Company data in Text box
//		Enter valid Product Price Before Discount data in Text box
//		Enter valid Product Price After Discount(Selling Price) data in Text box
//		Enter valid Product Description data in Text box
//		Enter valid Product Shipping Charge data in Text box
//		Select a Product Availability data in dropdown list box
//		Should be able to Upload image in Product Image button
//		Click on the Insert button
		Thread.sleep(500);
//		Click on logout button
		Actions a = new Actions(d);
		a.moveToElement(d.findElement(By.xpath("//img[@src='images/user.png']"))).perform();
		d.findElement(By.linkText("Logout")).click();
		// d.findElement(By.xpath("//a[@href='logout.php'][2]")).click();
//		Open the brower and Enter the URL
		d.get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application");
//		Click on User login button
		d.findElement(By.xpath("//a[@href='login.php']")).click();
//		Enter the valid user name
		d.findElement(By.id("exampleInputEmail1")).sendKeys("anuj.lpu1@gmail.com");
//		Enter the valid password
		d.findElement(By.name("password")).sendKeys("Test@123");
//		click on login button
		Thread.sleep(500);
		d.findElement(By.xpath("//button[@type='submit']")).submit();
//		click on Jewelry major tab
//		Click on logout button

	}

}
