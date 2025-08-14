package basic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshot {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		String name = driver.getTitle();
		TakesScreenshot t = (TakesScreenshot) driver;
		File scr = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./TakeScreenShot/"+name+".png");
		FileHandler.copy(scr, dest);
		driver.findElement(By.id("small-searchterms")).sendKeys("mobiles");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		File scr1 = t.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./TakeScreenShot/"+name+".png");
		FileHandler.copy(scr1, dest1);

		driver.quit ();
	}

}
