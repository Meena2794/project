package Practicedatdriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateOrgReadDataFromXmlTest 
{
	@Test
	public void Createorgtest(XmlTest test) throws Throwable 
	{
		String BROWSER = test.getParameter("browser");
		String Url = test.getParameter("url");
		String UN = test.getParameter("username");
		String PW = test.getParameter("password");
	

	Random random = new Random();
	int randomint = random.nextInt(1000);

	FileInputStream fis =new FileInputStream("./src/test/resources/testscript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("org");
	Row row =sh.getRow(2);
	String orgname = row.getCell(2).toString() + randomint;
	
	WebDriver d =null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		d = new ChromeDriver();
	}else if(BROWSER.equals("firefox"))
	{
		d = new FirefoxDriver();
	}else if(BROWSER.equals("edge"))
	{
		d = new EdgeDriver();
	}else
	{
		d = new ChromeDriver();
	}
	d.manage().window().maximize();d.get(Url);d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	d.findElement(By.name("user_name")).sendKeys(UN);
	System.out.println(UN);
	d.findElement(By.name("user_password")).sendKeys(PW);
	System.out.println(PW);
	d.findElement(By.id("submitButton")).click();
	d.findElement(By.linkText("Organizations")).click();
	d.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
	d.findElement(By.name("accountname")).sendKeys(orgname);
	d.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	Thread.sleep(3000);
	String org = d.findElement(By.xpath("//span[contains(text(),' Organization Information')]")).getText();
	System.out.println(org);
	Actions a = new Actions(d);
	a.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	d.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
	d.quit();

}
}


