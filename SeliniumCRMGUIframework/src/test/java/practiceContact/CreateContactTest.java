package practiceContact;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String Browser = p.getProperty("browser");
		String Url = p.getProperty("url");
		String UN = p.getProperty("username");
		String PW = p.getProperty("password");
		
			Random random=new Random();
			int randomint=random.nextInt(1000);
		
			FileInputStream fis1 = new FileInputStream(
					"C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\testscript.xlsx");
			Workbook wb = WorkbookFactory.create(fis1);
			Sheet sh = wb.getSheet("contact");
			Row row = sh.getRow(1);
			String lastName = row.getCell(2).toString() + randomint;
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
			d.findElement(By.name("user_name")).sendKeys(UN);
			System.out.println(UN);
			d.findElement(By.name("user_password")).sendKeys(PW);
			System.out.println(PW);
			d.findElement(By.id("submitButton")).click();
			d.findElement(By.linkText("Contacts")).click();
			d.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
			d.findElement(By.name("lastname")).sendKeys(lastName);
			d.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
			Thread.sleep(3000);
			String contact = d.findElement(By.xpath("//span[contains(text(),'Contact Information')]")).getText();
			System.out.println(contact);
			// verify lastname & info
			String actlastname = d.findElement(By.id("dtlview_Last Name")).getText();
			if (actlastname.equals(lastName)) {
				System.out.println(lastName + "header verified==pass");

			} else {
				System.out.println(lastName + "header is not verified==fail");
			}
	
		Actions a= new Actions(d); 
		a.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	  d.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click(); 
		 d.quit();
}

}
