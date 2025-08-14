package practices.TestNGTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
	@Test(dataProvider ="getData")
	public void GetProductInfoTest(String brand, String pName) throws Throwable {
		WebDriver d=new EdgeDriver();
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		d.get("http://amazon.in");
		d.findElement(By.id("twotabsearchtextbox")).sendKeys(brand,Keys.ENTER);
		 String price = d.findElement(By.xpath("//span[contains(.,'"+pName+"')]/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a[1]/span[1]")).getText();
		 System.out.println(price);
		 d.quit();
		 
	}

	@DataProvider
	public	Object[][]getData() throws Throwable, IOException{
	ExcelUtility eu=new ExcelUtility();
	int rowCount=eu.getRowCount("product");
   	Object[][]objArr=new Object [rowCount][2];
   	for (int i=0;i<rowCount;i++) {
   		objArr[i][0]=eu.getDataFromExcel("product", i+1, 0);
   		objArr[i][1]=eu.getDataFromExcel("product", i+1, 1);
   	}
	
return objArr;
	}
}

