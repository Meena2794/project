package practices.pom.repository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Autohealing {

	@FindAll({ @FindBy(name = "username"), @FindBy(id = "inputEmail") })
	private WebElement userEdt;

	@FindBy(name = "password")
	private WebElement passwordEdt;

	@FindBy(name = "submit")
	private WebElement loginbtn;

	public WebElement getUserEdt() {
		return userEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	@Test
	public void sampleTest() {
		WebDriver d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/admin/");
		d.manage().window().maximize();
		Autohealing ah = PageFactory.initElements(d, Autohealing.class);
		ah.userEdt.sendKeys("admin");
		ah.passwordEdt.sendKeys("Test@123");
		ah.loginbtn.click();

	}
}