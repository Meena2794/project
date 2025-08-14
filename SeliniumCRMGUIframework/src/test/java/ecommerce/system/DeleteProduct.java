package ecommerce.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
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
import org.openqa.selenium.devtools.v130.indexeddb.model.Key;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DeleteProduct {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String Userame = p.getProperty("username");
		String Password = p.getProperty("password");

		// read test script data from Excel file
		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(1);

		String InsertProd = row.getCell(0).toString();
		String productname = row.getCell(2).toString();
		String productcompany = row.getCell(3).toString();
		String productpricebefore = row.getCell(4).toString();
		String productpriceafter = row.getCell(5).toString();
		String ProductDescription = row.getCell(6).toString();
		String ProductShippingCharge = row.getCell(7).toString();
		wb.close();

		WebDriver driver = null;

		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(URL);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='admin']")).click();
		driver.findElement(By.id("inputEmail")).sendKeys(Userame);
		driver.findElement(By.id("inputPassword")).sendKeys(Password);
		Thread.sleep(1000);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);
		// insert product
		driver.findElement(By.xpath("//a[text()='Insert Product ']")).click();
		Thread.sleep(1000);
		// verify
		WebElement dropdowncat = driver.findElement(By.xpath("(//select[@class='span8 tip'])[1]"));
		Select s = new Select(dropdowncat);
		s.selectByValue("3");
		WebElement dropdownsub = driver.findElement(By.id("subcategory"));
		Select ssub = new Select(dropdownsub);
		Thread.sleep(1000);
		ssub.selectByValue("8");
		Thread.sleep(2000);
		WebElement pd = driver.findElement(By.name("productName"));
		pd.sendKeys(productname);
		System.out.println(pd.getText());
		driver.findElement(By.name("productCompany")).sendKeys(productcompany);
		driver.findElement(By.name("productpricebd")).sendKeys(productpricebefore);
		driver.findElement(By.name("productprice")).sendKeys(productpriceafter);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=' nicEdit-main']")).sendKeys(ProductDescription);
		driver.findElement(By.name("productShippingcharge")).sendKeys(ProductShippingCharge);
		Thread.sleep(1000);
		WebElement productavailable = driver.findElement(By.id("productAvailability"));
		Select s2 = new Select(productavailable);
		s2.selectByValue("In Stock");
		Thread.sleep(2000);

		WebElement choosefile1 = driver.findElement(By.xpath("//input[@id='productimage1']"));

		Thread.sleep(1000);
		File fileupload = new File("C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\img\\harry.png");
		choosefile1.sendKeys(fileupload.getAbsolutePath());

		WebElement choosefile2 = driver.findElement(By.name("productimage2"));
		File fileupload2 = new File("C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\img\\k.jpeg");
		choosefile2.sendKeys(fileupload.getAbsolutePath());

//upload
		WebElement choosefile3 = driver.findElement(By.name("productimage3"));
		File fileupload3 = new File("C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\img\\k1.jpeg");
		choosefile3.sendKeys(fileupload.getAbsolutePath());
		// save
		driver.findElement(By.xpath("//button[@class='btn']")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
//go to managelog
		driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys(productname);
		Thread.sleep(1000);
		String actprod = driver.findElement(By.xpath("//td[text()='" + productname + "']")).getText();

		Thread.sleep(1000);
		if (actprod.trim().equals(productname)) {
			System.out.println(productname + "information verified==PASS");
		} else {
			System.out.println(productname + "information is not verified==FAIL");
		}

		// return to managelog to delete
		driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
		WebElement search1 = driver.findElement(By.xpath("//input[@type='text']"));
		search1.sendKeys(productname);

		Thread.sleep(1000); // tr[td[text()='"+productname+"']]
		WebElement actprod1 = driver.findElement(By.xpath("//tr[td[text()='" + productname + "']]"));
		List<WebElement> deleteprod = actprod1.findElements(By.xpath("//i[@class='icon-remove-sign']"));
		Thread.sleep(1000);
		if (!deleteprod.equals(productname)) {
			System.out.println(productname + "information verified==PASS");
		} else {
			System.out.println(productname + "information is not verified==FAIL");
		}
		driver.quit();

	}

}
