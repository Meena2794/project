package practicetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WebElemenTable 
{

	public static void main(String[] args) throws Throwable 
	{	
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/table?scenario=1");
		 List<WebElement> itemName = driver.findElements(By.xpath("//tr//th[1]"));
		 List<WebElement> price = driver.findElements(By.xpath("//td[4]"));
		 int count = itemName.size();
			System.out.println(count);
			for (int i = 1; i < count; i++) 
			{
				String text = itemName.get(i).getText();
				String text1 =price.get(i-1).getText();
				System.out.println(text+"\t"+text1);
				FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fis);
				 Sheet sh = wb.getSheet("WE");
					Row row = sh.getRow(i);
					Cell cel = row.createCell(0);
					cel.setCellValue(text);
					Cell cel1 = row.createCell(1);
					cel1.setCellValue(text1);

					
				FileOutputStream fos=new FileOutputStream("C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\TestData.xlsx");
				wb.write(fos);
				wb.close();
			
			}
	}
}
			

