package practices.TestNGTest;

import org.testng.annotations.Test;

public class TestNGWithDependon {
	@Test
	public void createContactTest() {
		System.out.println("Execute createcontact with -->Hdfc");
	}
	@Test(dependsOnMethods ="createContactTest" )
	public void modifyContactTest() {
		System.out.println("execute Query insert contact in DB==>ICIC");
		System.out.println("Execute modifyContactTest-->ICIC-->ICIC_1");
	}
	@Test(dependsOnMethods ="modifyContactTest" )
	public void DeleteContactTest() {
		System.out.println("execute Query insert contact in DB==>UPI");
		System.out.println("Execute  Deletecontact-->ICIC");
	}
}
