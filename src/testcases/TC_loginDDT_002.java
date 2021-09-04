package testcases;

import java.io.IOException;
import java.utilities.BaseClassReadconfig;
import java.utilities.XLUtilities;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectModal.LoginPage;

public class TC_loginDDT_002 extends BaseClassReadconfig {

	
	
	@Test(dataProvider = "Inputdata")
	public void loginDDT(String username,String pasword)
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		
		lp.setPassword(pasword);
		lp.clickSubmit();
	}
	@DataProvider(name="Inputdata")
	public String[][] getData() throws IOException
	{
		String path=System.getProperty(("user.dir")+"/src/testdata/inputdata.xlsx");
		
		int rownum=XLUtilities.getRowCount(path, "Sheet1");
		int colcount=XLUtilities.getCellCount(path, "Sheet1", 1);
		
		 String inputdata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;){
				
				inputdata[i-1][j]=XLUtilities.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return inputdata;
	}
	
	

	
	
}
