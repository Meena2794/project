package com.acti_time.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {

	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addNew;
	
	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement newCustomer;
	
	@FindBy(id="customerLightBox_nameField")
	private WebElement nameFieldtbx;
	
	@FindBy(id="customerLightBox_descriptionField")
	private WebElement descriptionFieldtbx;
	
	@FindBy(xpath="//button[@class='x-btn-text']")
	private WebElement  activeCustomerSelectdd;
	
	@FindBy(xpath="//a[text()='Our Company']")
	private WebElement ourCompanyOpt;
	
	@FindBy(xpath="//span[text()='Create Customer']")
	private WebElement createCustomerbtn; 
	
	@FindBy(xpath="//div[@class='navigationLinks']/../div[2]")
	private WebElement actualCustCreatedLoc;
	
	
	public void TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	public WebElement getAddNew() {
		return addNew;
	}


	public WebElement getNewCustomer() {
		return newCustomer;
	}


	public WebElement getNameFieldtbx() {
		return nameFieldtbx;
	}


	public WebElement getDescriptionFieldtbx() {
		return descriptionFieldtbx;
	}


	public WebElement getActiveCustomerSelectdd() {
		return activeCustomerSelectdd;
	}


	public WebElement getOurCompanyOpt() {
		return ourCompanyOpt;
	}


	public WebElement getCreateCustomerbtn() {
		return createCustomerbtn;
	}
	
	public WebElement getActualCustCreatedLoc() {
		return actualCustCreatedLoc;
	}
	
	
}
