package practiceContact;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshot {
@Test
public void AmazonTest() throws IOException {
	WebDriver driver= new ChromeDriver();
	driver.get("http://amazon.in");
    TakesScreenshot t = (TakesScreenshot)driver;
    File scr = t.getScreenshotAs(OutputType.FILE);
   File dest = new File("./TakeScreenShot/masi.png");
   FileUtils.copyFile(scr, dest);
   driver.close();

}
}
