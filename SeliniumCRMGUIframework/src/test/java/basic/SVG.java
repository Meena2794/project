package basic;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class SVG {
public static void main(String[] args) {
	WebDriver d=new EdgeDriver();
	d.manage().window().maximize();
	d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	d.findElement(By.xpath("//*[local-name()='svg'][1]")).click();

	
	

//	//*[local-name()='svg'] for svg tag
//	//*[local-name()='svg']/*[name()='g']/*[name()='path']for svg child nodes
}
}
