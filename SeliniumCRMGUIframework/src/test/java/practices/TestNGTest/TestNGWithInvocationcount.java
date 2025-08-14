package practices.TestNGTest;

import org.testng.annotations.Test;

public class TestNGWithInvocationcount {
	@Test(invocationCount = 10)
	public void createContactTest() {
		System.out.println("Execute createordertest==>123");
	}
	@Test(enabled = false )
	public void modifyContactTest() {
		System.out.println("Execute billingAndOrder===>123");
	}
}
