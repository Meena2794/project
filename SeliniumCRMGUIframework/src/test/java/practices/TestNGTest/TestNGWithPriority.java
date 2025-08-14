package practices.TestNGTest;

import org.testng.annotations.Test;

public class TestNGWithPriority {
@Test(priority = 1)
public void createContactTest() {
	System.out.println("Execute createcontact with -->Hdfc");
}
@Test(priority = 3)
public void modifyContactTest() {
	System.out.println("execute Query insert contact in DB==>ICIC");
	System.out.println("Execute modifyContactTest-->ICIC-->ICIC_1");
}
@Test(priority =2)
public void DeleteContactTest() {
	System.out.println("execute Query insert contact in DB==>UPI");
	System.out.println("Execute  Deletecontact-->ICIC");
}
}
