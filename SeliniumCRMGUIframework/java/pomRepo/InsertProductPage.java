package pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class InsertProductPage {
	WebDriver d;
	public WebDriverUtility wu=new WebDriverUtility();
	public InsertProductPage(WebDriver d) {
		this.d=d;
		PageFactory.initElements(d,this);
	}

}
