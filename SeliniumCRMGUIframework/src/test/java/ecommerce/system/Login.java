package ecommerce.system;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Open the brower and Enter the URL
		d.get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application");
//		Click on User login button
		d.findElement(By.xpath("//a[@href='login.php']")).click();
//		d.findElement(By.id("fullname")).sendKeys("saimeena");
//		d.findElement(By.id("email")).sendKeys("saimeena@gmail.com");
//		d.findElement(By.id("contactno")).sendKeys("9876543210");
//		d.findElement(By.id("password")).sendKeys("admin");
//		d.findElement(By.id("confirmpassword")).sendKeys("admin");
//		d.findElement(By.id("submit")).submit();
//	
	
//		Enter the valid user name
		d.findElement(By.id("exampleInputEmail1")).sendKeys("anuj.lpu1@gmail.com");
//		Enter the valid password
		d.findElement(By.name("password")).sendKeys("Test@123");
//		click on login button
		Thread.sleep(500);
		//d.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/form/button")).submit();
		//d.findElement(By.xpath("//button[@type='submit']")).submit();
		d.findElement(By.xpath("//button[@name='login']")).submit();
		//d.findElement(By.linkText("Login")).click();
		//d.findElement(By.name("login")).click();
//		div[2]/div/div[1]/div/div[1]/form/button
}
}





public class UpdateAndDelete {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\configAppdata\\commandata.properties");
		Properties p = new Properties();
        p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String Userame = p.getProperty("username");
		String Password = p.getProperty("password");
		
		//read test script data from Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\testdata\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(1);
		Row row1 = sh.getRow(4);
		String expectedtext=row.getCell(1).toString();
		
		String InsertProd=row.getCell(0).toString();
		String productname = row.getCell(2).toString();
		String productname1 = row1.getCell(0).toString();
		String productcompany = row.getCell(3).toString();
		String productpricebefore = row.getCell(4).toString();
		String productpricebefore1 = row1.getCell(4).toString();
		String productpriceafter = row.getCell(5).toString();
		String ProductDescription = row.getCell(6).toString();
		String ProductShippingCharge= row.getCell(7).toString();
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

		driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(productname);
String actprod = driver.findElement(By.xpath("//td[text()='"+productname+"']")).getText();
driver.findElement(By.xpath("//i[@class='icon-edit']")).click();


Thread.sleep(2000);
WebElement pd = driver.findElement(By.name("productName"));
Thread.sleep(3000);
pd.clear();
Thread.sleep(3000);
pd.sendKeys(productname1);
Thread.sleep(2000);

WebElement productpricee = driver.findElement(By.xpath("//input[@name='productprice']"));

productpricee.clear();
Thread.sleep(2000);
productpricee .sendKeys(productpricebefore1);


WebElement submit = driver.findElement(By.xpath("//button[@class='btn']"));
Actions a=new Actions(driver);
Thread.sleep(2000);
a.moveToElement( submit).perform();
submit.sendKeys(Keys.ENTER);
Thread.sleep(1000);

driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
//input[@aria-controls="DataTables_Table_0"]
driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(productname1);
String actprod1 = driver.findElement(By.xpath("//td[text()='"+productname1+"']")).getText();
if(actprod1.equals(productname1))
{
	System.out.println(productname1+" information verified==PASS");
}else
{
	System.out.println(productname1+" information is not verified==FAIL");
}
//return to managelog to delete
driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
WebElement search1 = driver.findElement(By.xpath("//input[@type='text']"));
search1.sendKeys(productname1); 

Thread.sleep(1000); //tr[td[text()='"+productname+"']]
 WebElement actprod11 = driver.findElement(By.xpath("//tr[td[text()='"+productname1+"']]"));
List<WebElement> deleteprod = actprod11.findElements(By.xpath("//i[@class='icon-remove-sign']"));
Thread.sleep(1000);
	if(!deleteprod.equals(productname1))
	{
		System.out.println(productname1+"information verified==PASS");
	}else
	{
		System.out.println(productname1+"information is not verified==FAIL");
	}
	driver.quit();



	}

}
public class DeleteProduct {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\configAppdata\\commandata.properties");
		Properties p = new Properties();
        p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String Userame = p.getProperty("username");
		String Password = p.getProperty("password");
		
		//read test script data from Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\testdata\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(1);
		
		String InsertProd=row.getCell(0).toString();
		String productname = row.getCell(2).toString();
		String productcompany = row.getCell(3).toString();
		String productpricebefore = row.getCell(4).toString();
		String productpriceafter = row.getCell(5).toString();
		String ProductDescription = row.getCell(6).toString();
		String ProductShippingCharge= row.getCell(7).toString();
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
		//insert product
				driver.findElement(By.xpath("//a[text()='Insert Product ']")).click();
				Thread.sleep(1000);
				//verify
				WebElement dropdowncat = driver.findElement(By.xpath("(//select[@class='span8 tip'])[1]"));
				Select s=new Select(dropdowncat);
				s.selectByValue("3");
				WebElement dropdownsub = driver.findElement(By.id("subcategory"));
		Select ssub= new Select(dropdownsub);
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
		Select s2= new Select(productavailable);
		s2.selectByValue("In Stock");
		Thread.sleep(2000);


		WebElement choosefile1 = driver.findElement(By.xpath("//input[@id='productimage1']"));

		Thread.sleep(1000);
		File fileupload=new File("C:/Users/DELL/Desktop/k.jfif");
		choosefile1.sendKeys(fileupload.getAbsolutePath());

		WebElement choosefile2 = driver.findElement(By.name("productimage2"));
		File fileupload2=new File("C:/Users/DELL/Desktop/k.jfif");
		choosefile2.sendKeys(fileupload.getAbsolutePath());

//upload
		WebElement choosefile3 = driver.findElement(By.name("productimage3"));
		File fileupload3=new File("C:/Users/DELL/Desktop/k.jfif");
		choosefile3.sendKeys(fileupload.getAbsolutePath());
		//save
		driver.findElement(By.xpath("//button[@class='btn']")).sendKeys(Keys.ENTER);
Thread.sleep(1000);
//go to managelog
		  driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
		  WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		  search.sendKeys(productname);
		  Thread.sleep(1000); 
		  String actprod =driver.findElement(By.xpath("//td[text()='"+productname+"']")).getText();
		  
		  Thread.sleep(1000); if(actprod.trim().equals(productname)) {
		  System.out.println(productname+"information verified==PASS"); }else {
		  System.out.println(productname+"information is not verified==FAIL"); }
		  
		  //return to managelog to delete
		  driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
		  WebElement search1 = driver.findElement(By.xpath("//input[@type='text']"));
		  search1.sendKeys(productname); 
		  
	  Thread.sleep(1000); //tr[td[text()='"+productname+"']]
		   WebElement actprod1 = driver.findElement(By.xpath("//tr[td[text()='"+productname+"']]"));
		  List<WebElement> deleteprod = actprod1.findElements(By.xpath("//i[@class='icon-remove-sign']"));
		  Thread.sleep(1000);
			if(!deleteprod.equals(productname))
			{
				System.out.println(productname+"information verified==PASS");
			}else
			{
				System.out.println(productname+"information is not verified==FAIL");
			}
			driver.quit();
	}

}





//integeration

public class updateProducts {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\configAppdata\\commandata.properties");
		Properties p = new Properties();
        p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String Userame = p.getProperty("username");
		String Password = p.getProperty("password");
		
		//read test script data from Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\testdata\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(1);
		Row row1 = sh.getRow(4);
		String expectedtext=row.getCell(1).toString();
		
		String InsertProd=row.getCell(0).toString();
		String productname = row.getCell(2).toString();
		String productname1 = row1.getCell(0).toString();
		String productcompany = row.getCell(3).toString();
		String productpricebefore = row.getCell(4).toString();
		String productpricebefore1 = row1.getCell(4).toString();
		String productpriceafter = row.getCell(5).toString();
		String ProductDescription = row.getCell(6).toString();
		String ProductShippingCharge= row.getCell(7).toString();
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

		driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(productname);
String actprod = driver.findElement(By.xpath("//td[text()='"+productname+"']")).getText();
driver.findElement(By.xpath("//i[@class='icon-edit']")).click();


Thread.sleep(2000);
WebElement pd = driver.findElement(By.name("productName"));
Thread.sleep(3000);
pd.clear();
Thread.sleep(3000);
pd.sendKeys(productname1);
Thread.sleep(2000);

WebElement productpricee = driver.findElement(By.xpath("//input[@name='productprice']"));

productpricee.clear();
Thread.sleep(2000);
productpricee .sendKeys(productpricebefore1);


WebElement submit = driver.findElement(By.xpath("//button[@class='btn']"));
Actions a=new Actions(driver);
Thread.sleep(2000);
a.moveToElement( submit).perform();
submit.sendKeys(Keys.ENTER);
Thread.sleep(1000);

driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
//input[@aria-controls="DataTables_Table_0"]
driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(productname1);
String actprod1 = driver.findElement(By.xpath("//td[text()='"+productname1+"']")).getText();
if(actprod1.equals(productname1))
{
	System.out.println(productname1+" information verified==PASS");
}else
{
	System.out.println(productname1+" information is not verified==FAIL");
}
driver.quit();


	}

}

public class subcategory {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\configAppdata\\commandata.properties");
		Properties p = new Properties();
        p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String Userame = p.getProperty("username");
		String Password = p.getProperty("password");
		
		//read test script data from Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\testdata\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(4);
		
		String subcat=row.getCell(1).toString();
		
		
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

		driver.findElement(By.xpath("//a[@href='subcategory.php']")).click();
		WebElement dropdownsub = driver.findElement(By.name("category"));
		Select ssub= new Select(dropdownsub);
		Thread.sleep(1000);
		ssub.selectByValue("3");
		driver.findElement(By.xpath("//input[@class='span8 tip']")).sendKeys(subcat);
		driver.findElement(By.xpath("//button[@class='btn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(subcat);
		Thread.sleep(3000);
		String actsub = driver.findElement(By.xpath("//td[text()='"+subcat+"']")).getText();
		Thread.sleep(3000);
		if(actsub.equals(subcat))
		{
			System.out.println(subcat +" information verified==PASS");
		}else
		{
			System.out.println(subcat + "information is not verified==FAIL");
		}
		driver.quit();
		
	}

}

public class InsertProdDetails {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\configAppdata\\commandata.properties");
		Properties p = new Properties();
        p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String Userame = p.getProperty("username");
		String Password = p.getProperty("password");
		
		//read test script data from Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\testdata\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(1);
		Row row1 = sh.getRow(5);
		String InsertProd=row.getCell(0).toString();
		String productname = row.getCell(2).toString();
		String productcompany = row.getCell(3).toString();
		String productpricebefore = row.getCell(4).toString();
		String productpriceafter = row.getCell(5).toString();
		String ProductDescription = row.getCell(6).toString();
		String ProductShippingCharge= row.getCell(7).toString();
		
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
		//insert product
		driver.findElement(By.xpath("//a[text()='Insert Product ']")).click();
		Thread.sleep(1000);
		//verify
		WebElement dropdowncat = driver.findElement(By.xpath("(//select[@class='span8 tip'])[1]"));
		Select s=new Select(dropdowncat);
		s.selectByValue("3");
		WebElement dropdownsub = driver.findElement(By.id("subcategory"));
Select ssub= new Select(dropdownsub);
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
Select s2= new Select(productavailable);
s2.selectByValue("In Stock");
Thread.sleep(2000);


WebElement choosefile1 = driver.findElement(By.xpath("//input[@id='productimage1']"));

Thread.sleep(1000);
File fileupload=new File("C:/Users/DELL/Desktop/k.jfif");
choosefile1.sendKeys(fileupload.getAbsolutePath());

WebElement choosefile2 = driver.findElement(By.name("productimage2"));
File fileupload2=new File("C:/Users/DELL/Desktop/k.jfif");
choosefile2.sendKeys(fileupload.getAbsolutePath());


WebElement choosefile3 = driver.findElement(By.name("productimage3"));
File fileupload3=new File("C:/Users/DELL/Desktop/k.jfif");
choosefile3.sendKeys(fileupload.getAbsolutePath());
driver.findElement(By.xpath("//button[@class='btn']")).sendKeys(Keys.ENTER);

  driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
  WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
  search.sendKeys(productname); Thread.sleep(1000); String actprod =
  driver.findElement(By.xpath("//td[text()='"+productname+"']")).getText();
  
  Thread.sleep(1000); if(actprod.trim().equals(productname)) {
  System.out.println(productname+"information verified==PASS"); }else {
  System.out.println(productname+"information is not verified==FAIL"); }
  driver.quit();
 
	
	}}

public class category {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\configAppdata\\commandata.properties");
	Properties p = new Properties();
	
    p.load(fis);
	String Browser = p.getProperty("browser");
	String URL = p.getProperty("url");
	String Userame = p.getProperty("username");
	String Password = p.getProperty("password");
	
	//read test script data from Excel file
	FileInputStream fis1=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\testdata\\testscriptdata.xlsx");
	Workbook wb=WorkbookFactory.create(fis1);
	Sheet sh = wb.getSheet("sheet1");
	Row row = sh.getRow(4);
	String cat=row.getCell(2).toString();
	String catdes=row.getCell(3).toString();
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
	
	driver.findElement(By.xpath("//a[@href='category.php']")).click();
	driver.findElement(By.name("category")).sendKeys(cat);
	driver.findElement(By.name("description")).sendKeys(catdes);
	driver.findElement(By.xpath("//button[@name='submit']")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(cat);
	String actcat = driver.findElement(By.xpath("//td[text()='"+cat+"']")).getText();
	Thread.sleep(1000);
	if(actcat.equals(cat))
	{
		System.out.println(cat+"information verified==PASS");
	}else
	{
		System.out.println(cat+"information is not verified==FAIL");
	}
	driver.quit();
}
}


//smoke

public class SubCatDropDownDisplay {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\configAppdata\\commandata.properties");
		Properties p = new Properties();
        p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String Userame = p.getProperty("username");
		String Password = p.getProperty("password");
		
		//read test script data from Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\testdata\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(1);
		String SubCat=row.getCell(0).toString();
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
		
		driver.findElement(By.xpath("//a[@href='subcategory.php']")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='category']"));
Select s= new Select(dropdown);
s.selectByValue("3");
String actsubcat=driver.findElement(By.xpath("//option[@value='3']")).getText();
Thread.sleep(1000);
System.out.println(actsubcat);
Thread.sleep(1000);
if(actsubcat.equals(SubCat))
{
	System.out.println(SubCat+"information verified==PASS");
}else
{
	System.out.println(SubCat+"information is not verified==FAIL");
}
driver.quit();
	}

}

public class ManageProdEditPage {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\configAppdata\\commandata.properties");
		Properties p = new Properties();
        p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String Userame = p.getProperty("username");
		String Password = p.getProperty("password");
		
		//read test script data from Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\testdata\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(1);
		String expectedtext=row.getCell(1).toString();
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

		driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
		driver.findElement(By.xpath("//a[@href='edit-products.php?id=5']")).click();
		String acttext = driver.findElement(By.xpath("//div[@class='module-head']")).getText();
		if(acttext.equals(expectedtext))
		{
			System.out.println(expectedtext+"information verified==PASS");
		}else
		{
			System.out.println(expectedtext+"information is not verified==FAIL");
		}
		driver.quit();
	}

}


ublic class InsertProductSelectOneInDropdown {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\configAppdata\\commandata.properties");
		Properties p = new Properties();
        p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String Userame = p.getProperty("username");
		String Password = p.getProperty("password");
		
		//read test script data from Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\SeleniumECommerceFramework\\testdata\\testscriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sheet1");
		Row row = sh.getRow(1);
		String InsertProd=row.getCell(0).toString();
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
		//insert product
		driver.findElement(By.xpath("//a[text()='Insert Product ']")).click();
		Thread.sleep(1000);
		//verify
		WebElement dropdown = driver.findElement(By.xpath("(//select[@class='span8 tip'])[1]"));
		Select s=new Select(dropdown);
		s.selectByValue("3");
		String actInsertProd=driver.findElement(By.xpath("//option[@value='3']")).getText();
		Thread.sleep(1000);
		System.out.println(actInsertProd);
		Thread.sleep(1000);
		if(actInsertProd.equals(InsertProd))
		{
			System.out.println(InsertProd+"information verified==PASS");
		}else
		{
			System.out.println(InsertProd+"information is not verified==FAIL");
		}
		driver.quit();
	}
	}