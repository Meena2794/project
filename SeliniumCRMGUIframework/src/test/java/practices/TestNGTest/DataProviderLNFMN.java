package practices.TestNGTest;


public class DataProviderLNFMN {

	@Test(dataProvider="getData")
	public void CreateContact(String FirstName,String LastName) {
      System.out.println("FirstName:"+FirstName+"\t"+"LastName: "+LastName);
	}



@DataProvider
public Object[][] getData() {
	Object[][] objArr=new Object[3][2];
			objArr[0][0]="Deepak";
			objArr[0][1]="HR";
			objArr[1][0]="Madhura";
			objArr[1][1]="Meenakshi";
			objArr[2][0]="Suresh";
			objArr[2][1]="Kumar";
return objArr;
}
}	