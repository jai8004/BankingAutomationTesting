package bankingproj.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bakingproj.utilities.XLUtils;
import bankingproj.pageObjects.LoginPage;
import junit.framework.Assert;

public class TC_LoginTestDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname,String password) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		lp.setPassword(password);
		lp.clickSubmit();
		
		if (isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {

			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		
		try {
			driver.switchTo().alert();
			return true;
			}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
	 String path = System.getProperty("user.dir")+"\\src\\test\\java\\bankingproj\\testData\\LoginData.xlsx";
	
	 int rownum=XLUtils.getRowCount(path,"Sheet1");
	 int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
	 String loginData[][]=new String[rownum][colcount];
	 
	 for (int i=1;i<=rownum;i++)
	 {
		 for (int j=0;j<colcount;j++)
		 {
			 loginData[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
		 }
	 }
	return loginData;
	 
	
	
	}

}
