package com.ninza.hrm.api.genericutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	public void waitForElementpresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

//	 this method is to wait for 10s for particular element to be click able
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

//	  This method is used to wait for 10s for particular element to be selected

	public void waitForElementToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public void switchToTabonurl(WebDriver driver, String PartialUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(PartialUrl)) {
				break;
			}
		}
	}

	public void switchToTabonTitle(WebDriver driver, String PartialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(PartialTitle)) {
				break;
			}
		}
	}

	public void SwitchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void SwitchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	public void SwitchToFrame(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void SwitchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void SwitchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void SelectfromText(WebElement ele, String text) {
		Select sel = new Select(ele);
		sel.selectByVisibleText(text);
	}

	public void SelectfromIndex(WebElement ele, int index) {
		Select sel = new Select(ele);
		sel.selectByIndex(index);
	}

	public void SelectfromValue(WebElement ele, String Value) {
		Select sel = new Select(ele);
		sel.selectByValue(Value);
	}

	public void mouseMovementonElement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}

	public void doubleclick(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	public void dragAnddrop(WebDriver driver, WebElement ele, WebElement tar) {
		Actions act = new Actions(driver);
		act.dragAndDrop(ele, tar).perform();
	}

	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void scrollToElementAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element);
	}
	
	public void scrollbyjs(int x,int y, WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public void scrollToElementjs(WebElement element, WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",element);
	}
	
}
