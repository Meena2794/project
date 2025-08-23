package com.acti_time.generice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.acti_time.generice.FileLib;
import com.acti_time.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser() {
	Reporter.log("openBrowser",true);	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://localhost/login.do");
	}
	@BeforeMethod
public void Login() throws IOException {
		Reporter.log("login",true);	
		FileLib f=new FileLib();
		String url = f.getPropertyData("url");
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setlogin(un, pw);	
		}	
	//driver.findElement(By.id("username")).sendKeys("admin");;
	//driver.findElement(By.name("pwd")).sendKeys("manager");
	//driver.findElement(By.xpath("//div[text()='Login ']")).click();
	@AfterMethod
public void Logout() {
	Reporter.log("login",true);	
	driver.findElement(By.id("logoutLink")).click();
	
}
	@AfterTest
public void closeBrowser() {
	Reporter.log("closeBrowser",true);	
	driver.quit();
}

}
