package endToEnd;

import org.openqa.selenium.By;
	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Working_With_CustomWaitExample {
		public static void main(String[] args) {
			WebDriver driver = new ChromeDriver();
			driver.get("https://example.com");

			By elementLocator = By.id("myElement");

			// Custom Wait Call
			WebElement element = waitForElement(driver, elementLocator, 10); // wait up to 10 seconds

			if (element != null) {
				element.click();
				System.out.println("Element clicked.");
			} else {
				System.out.println("Element not found in given time.");
			}

			driver.quit();
		}

		// Custom Wait Method
		public static WebElement waitForElement(WebDriver driver, By locator, int timeoutInSeconds) {
			WebElement element = null;
			int timeElapsed = 0;

			while (timeElapsed < timeoutInSeconds) {
				try {
					element = driver.findElement(locator);
					if (element.isDisplayed()) {
						return element;
					}
				} catch (Exception ignored) {
					// Ignore NoSuchElement or StaleElement exceptions
				}

				try {
					Thread.sleep(1000); // Poll every 1 second
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				timeElapsed++;
			}

			return null; // Element not found within timeout
		}
	}


