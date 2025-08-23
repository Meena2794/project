package com.acti_time.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.acti_time.generice.BaseClass;
import com.acti_time.pom.HomePage;
import com.acti_time.pom.TaskListPage;
import com.acti_time.generice.FileLib;

@Listeners(com.acti_time.generice.ListenerImplementation.class)
public class CustomerModule extends BaseClass {
	@Test
	public void testCreatecustomer() throws EncryptedDocumentException, IOException {
		Reporter.log("Createcustomer",true);
		FileLib f=new FileLib();
		String cn = f.getExcelData("CreateCustomer", 1, 3);
		HomePage h= new HomePage(driver);
		h.setTasktab();
		TaskListPage t= new TaskListPage();
		t.getAddNew().click();
		t.getNewCustomer().click();
		t.getNameFieldtbx().sendKeys("");
		t.getDescriptionFieldtbx().sendKeys("");
		t.getActiveCustomerSelectdd().click();
		t.getOurCompanyOpt().click();
		t.getCreateCustomerbtn().click();	
		String actualCust = t.getActualCustCreatedLoc().getText();
		Assert.assertEquals(actualCust,cn );
	}
}
