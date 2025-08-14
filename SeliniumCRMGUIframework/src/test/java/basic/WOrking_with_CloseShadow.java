package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WOrking_with_CloseShadow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://demoapps.qspiders.com/ui/shadow/closed?sublist=1");
		// login attached text
		d.findElement(By.xpath("//h1[text()='Login']")).click();

		Actions act = new Actions(d);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("JAHNVI").perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("SURESH");
		d.quit();

	}

}
