package practicetest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ProductAndPrice {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("iphone 15", Keys.ENTER);
//		List<WebElement> productName = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
		List<WebElement> productName = driver.findElements(By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[2]"));
		List<WebElement> productPrice = driver.findElements(By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[2]/div[1]/div[1]/div[1]"));
//		List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
		int count = productName.size();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			String text = productName.get(i).getText();
		String text1 =productPrice.get(i).getText();;
		System.out.println(text+"---->"+text1);

		}
	}
}
///html/body/div/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[2]
//*[@id="container"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[2]
