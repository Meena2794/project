package ecommerce.system;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class UpdateStatusTest {
@Test
	public void UpdateStatusTest() throws Throwable {


		// read test script data from Excel file
	      
	String emailid = eLib.getDataFromExcel("product", 1, 0).toString();
		

//		click on order management dropdown 
		driver.findElement(By.xpath("//div[2]/div/div/div[1]/div/ul[1]/li[1]/a")).click();
//		click on pending order
		//driver.findElement(By.xpath("//ul[@id='togglePages']/li[2]/a")).submit();
		driver.findElement(By.xpath("//a[@href='pending-orders.php']")).click();
//		type and search in today's order table
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("novel",Keys.ENTER)
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		Thread.sleep(1000);
		search.sendKeys("novel");
		Thread.sleep(1000);
		search.click();
//		click on edit icon in action column of today's order table
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//table[@id='DataTables_Table_0']/tbody/tr/td[9]//a)")).click();
		//driver.findElement(By.xpath("//a[@href='updateorder.php?oid=603']")).click();
		driver.findElement(By.xpath("//a[@title='Update order']")).click();
//		select valid status  
//		driver.findElement(By.xpath("//form[@id=\"updateticket\"]/table/tbody/tr[3]/td[2]/span/select")).click();
		//driver.findElement(by)
//		 enter the remarks and click on update button
//		data should also be displayed in pending order's table
	//

	}

}
