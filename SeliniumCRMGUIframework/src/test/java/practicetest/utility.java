package practicetest;

public class utility {
	package SwagLabs.GenericUtility;

	import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;
	import java.time.Duration;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	/**
	 * This method is used to maximize the window screen
	 * @author Bhaskar
	 *
	 */

	public class SeleniumUtility 
	{
		public void maximizeWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
			
		}
		
		/**
		 * This method is used to minimize the window screen
		 * @param driver
		 */
		
		public void minimizeWindow(WebDriver driver)
		{
			driver.manage().window().minimize();
		}
		
		/**
		 * This method is used to wait for 10s for webpage to load
		 * @param driver
		 */
		public void addImplicitlyWait(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		
		
		/**
		 * This method is to wait for 10s for particular element to be visible
		 * @param driver
		 * @param element
		 */
		public void waitForElementToBeVisible(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		
		/**
		 * this method is to wait for 10s for particular element to be click able
		 */
		public void waitForElementToBeClickable(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
		}
		
		/**
		 * This method is used to wait for 10s for particular element to be selected
		 * @param driver
		 * @param element
		 */
		public void waitForElementToBeSelected(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeSelected(element));
			
		}
		
		/**
		 * This method is used to wait for particular frame to be available
		 * @param driver
		 * @param FrameIndex
		 */
		
		public void waitForFrameToBeAvailable(WebDriver driver, int index)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
		}
		
		
		/**
		 * This method will handle the drop down by index
		 * @param element
		 * @param index
		 */
		public void handleDropDown(WebElement element, int index)
		{
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		
		/**
		 * This method will handle the drop down by value
		 * @param element
		 * @param value
		 */
		public void handleDropDown(WebElement element, String value)
		{
			Select sel = new Select(element);
			sel.selectByValue(value);
		}
		
		/**
		 * This method will handle the drop down by visible text
		 * @param visibletext
		 * @param element
		 */
		public void handleDropDown(String visibletext, WebElement element)
		{
			Select sel = new Select(element);
			sel.selectByVisibleText(visibletext);
		}
		
		/**
		 * This method will perform  mouse hovering action
		 * @param driver
		 * @param element
		 */
		public void mouseHoverAction(WebDriver driver, WebElement element)
		{
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		/**
		 * This method will perform right click action
		 * @param driver
		 * @param element
		 */
		public void rightClickAction(WebDriver driver, WebElement element)
		{
			Actions act = new Actions(driver);
			act.contextClick(element).perform();
		}
		
		/**
		 * This method will perform double click action
		 * @param driver
		 * @param element
		 */
		public void doubleClickAction(WebDriver driver, WebElement element)
		{
			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
		}
		
		/**
		 * This method will perform drag and drop action
		 * @param driver
		 * @param element
		 */
		public void dragAndDropAction(WebDriver driver, WebElement srcEle, WebElement targetEle)
		{
			Actions act = new Actions(driver);
			act.dragAndDrop(srcEle, targetEle).perform();
		}
		
		/**
		 * This method will perform scroll action
		 * @param driver
		 * @param element
		 */
		public void scrollToElementAction(WebDriver driver, WebElement element)
		{
			Actions act = new Actions(driver);
			act.scrollToElement(element);
		}
		
		
		/**
		 * This method will handle frame by index
		 * @param driver
		 * @param index
		 */
		public void handleFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		
		
		/**
		 * This method will handle frame by name or Id
		 * @param driver
		 * @param index
		 */
		public void handleFrame(WebDriver driver, String nameorId)
		{
			driver.switchTo().frame(nameorId);
		}

		
		/**
		 * This method will handle frame by element
		 * @param driver
		 * @param index
		 */
		public void handleFrame(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}

	/**
	 * This method will handle frame by switching to parent frame
	 * @param driver
	 */
		public void switchToParentFrame(WebDriver driver)
		{
			driver.switchTo().parentFrame();
		}
		
		
		/**
		 * This method will handle frame by switching to default frame
		 * @param driver
		 */
			public void switchToDefaultFrame(WebDriver driver)
			{
				driver.switchTo().defaultContent();
			}
		
			/**
			 * This method will click on OK button(accept) the alert popup
			 * @param driver
			 */
			public void acceptAlert(WebDriver driver)
			{
				driver.switchTo().alert().accept();
			}
			
			/**
			 * This method will click on cancel the alert popup
			 * @param driver
			 */
			public void cancelAlert(WebDriver driver)
			{
				driver.switchTo().alert().dismiss();
			}
			
			/**
			 * This method will capture the text from alert popup
			 * @param driver
			 */
			public String getAlertText(WebDriver driver)
			{
				String value = driver.switchTo().alert().getText();
				return value;
			}
			
			
			/**
			 * This method will enter the text in the alert popup
			 * @param driver
			 */
			public void enterTextInAlert(WebDriver driver, String text)
			{
				driver.switchTo().alert().sendKeys(text);
			}

			/**
			 * This method is used to capture the screen shot of web page, store in the path and return the path to the caller
			 * @param driver
			 * @param screenshotname
			 * @return
			 * @throws IOException
			 */

			public String captureScreenShot(WebDriver driver, String screenshotname) throws IOException
			{
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dst = new File(".\\ScreenShots\\"+screenshotname+".png");
				FileUtils.copyFile(src, dst);
				
				
				//For extend report
				return dst.getAbsolutePath();
			}
			
	}

}
