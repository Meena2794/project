package basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class nested_Shadow {
	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("https://demoapps.qspiders.com/ui/shadow/nested?sublist=2");
		 SearchContext shadow_host = d.findElement(By.xpath("//form /div[1]")).getShadowRoot();
////		 shadow_host.findElement(By.cssSelector("input[text(),'Email']")).sendKeys("JAHNVI@gmail.com");
////		Thread.sleep(1000);
		d.findElement(By.xpath("//h1[text()='Login']"));
		Actions act = new Actions(d);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		act.sendKeys("JAHNVI@gmail.com").perform();
//		//*[@id="email"]
//		/html/body/div[1]/div/div[2]/section/main/section/article/aside/div/aside/div/aside/section[2]/form/div[1]//label
	
	

//public class NestedShadowRoot {
//    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://demoapps.qspiders.com/ui/shadow/nested?sublist=2");
//
//        // Accessing the first shadow root
//        SearchContext shadow_host = driver.findElement(By.xpath("//form /div[1]")).getShadowRoot();
//	 shadow_host.findElement(By.cssSelector("input[text(),'Email']")).sendKeys("JAHNVI@gmail.com");
////        WebElement shadowHost1 = driver.findElement(By.cssSelector("#shadow-host-1"));
////        WebElement shadowRoot1 = (WebElement) ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowHost1);
////
//        // Accessing the second shadow root
//        WebElement shadowHost2 = shadowRoot1.findElement(By.cssSelector("#shadow-host-2"));
//        WebElement shadowRoot2 = (WebElement) ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadowHost2);
//
//        // Interacting with elements inside the nested shadow root
//        WebElement inputField = shadowRoot2.findElement(By.cssSelector("input"));
//        inputField.sendKeys("Hello, World!");
//
//        driver.quit();
    

}

}
