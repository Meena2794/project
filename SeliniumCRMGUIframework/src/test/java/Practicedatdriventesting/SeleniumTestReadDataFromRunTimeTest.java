package Practicedatdriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRunTimeTest {
	@Test
	public void seleniumTest() throws EncryptedDocumentException, IOException, InterruptedException {
		// read common data from cmd
		String Browser = System.getProperty("Browser");
		String Url = System.getProperty("url");
		String UserName = System.getProperty("username");
		String PassWord = System.getProperty("password");

		Random random = new Random();
		int randomint = random.nextInt(1000);

		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(2);
		String orgname = row.getCell(2).toString() + randomint;
		wb.close();

		WebDriver d = null;
		if (Browser.equals("chrome")) {
			d = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			d = new FirefoxDriver();
		} else if (Browser.equals("edge")) {
			d = new EdgeDriver();
		} else {
			d = new ChromeDriver();
		}
		d.manage().window().maximize();
		d.get(Url);
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.findElement(By.name("user_name")).sendKeys(UserName);
		System.out.println(UserName);
		d.findElement(By.name("user_password")).sendKeys(PassWord);
		System.out.println(PassWord);
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
