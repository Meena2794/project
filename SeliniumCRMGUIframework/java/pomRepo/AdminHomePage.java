package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class AdminHomePage {
	WebDriver d;
	public WebDriverUtility wu=new WebDriverUtility();
	public AdminHomePage(WebDriver d) {
		this.d=d;
		PageFactory.initElements(d,this);
	}
	
	
}
