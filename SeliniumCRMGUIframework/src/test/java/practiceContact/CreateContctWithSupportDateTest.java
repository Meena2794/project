package practiceContact;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class CreateContctWithSupportDateTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String Browser = p.getProperty("browser");
		String Url = p.getProperty("url");
		String UN = p.getProperty("username");
		String PW = p.getProperty("password");

		Random random = new Random();
		int randomint = random.nextInt(1000);

		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(4);
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
		Date dateObj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sim.format(dateObj);
		//System.out.println(startDate);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String endDate = sim.format(cal.getTime());
		//System.out.println(endDate);
		d.findElement(By.name("support_start_date")).clear();
		d.findElement(By.name("support_start_date")).sendKeys(startDate);
		d.findElement(By.name("support_end_date")).clear();
		d.findElement(By.name("support_end_date")).sendKeys(endDate);
		d.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(3000);
		String contact = d.findElement(By.xpath("//span[contains(text(),'Contact Information')]")).getText();
		System.out.println(contact);
		// verify startDate  & endDate info
		String actstartDate = d.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actstartDate .equals(startDate )) {
			System.out.println(startDate  + "header verified==pass");

		} else {
			System.out.println(startDate  + "header is not verified==fail");
		}
		String actendDate = d.findElement(By.id("dtlview_Support End Date")).getText();
		if (actendDate .equals(endDate )) {
			System.out.println(endDate  + "header verified==pass");

		} else {
			System.out.println(endDate  + "header is not verified==fail");
		}

		Actions a = new Actions(d);
		a.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		d.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		d.quit();
	}

}
