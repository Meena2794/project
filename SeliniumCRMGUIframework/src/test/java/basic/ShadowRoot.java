package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowRoot {
	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		d.get("https://demoapps.qspiders.com/ui?scenario=1");
//		Thread.sleep(2000);
//		d.findElement((By.xpath("//section[contains(text(),'Shadow')][1]"))).click();
//		Thread.sleep(2000);
//		d.findElement((By.xpath("(//section[contains(text(),'Shadow')])[2]"))).click();
		d.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
		Thread.sleep(3000);
		//shadow host -> identify shadow host
		   SearchContext shadow_host = d.findElement(By.xpath("//form /div[1]")).getShadowRoot();
		shadow_host.findElement(By.cssSelector("input[type='text']")).sendKeys("MADHURA");
		//Thread.sleep(2000);
	//shadow host for password
SearchContext shadow_host_PW = d.findElement(By.xpath("//form /div[2]")).getShadowRoot();
shadow_host_PW.findElement(By.cssSelector("input[type='text']")).sendKeys("Meenakshi");
	}
}
