package bankingproj.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import bankingproj.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException  {

		driver.get(baseURL);
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username Entered");

		lp.setPassword(password);
		logger.info("Password is Entered");
		
		lp.clickSubmit();
		logger.info("Login button Clicked");
		
		
		if (driver.getTitle().equals("Guru Bank Manager Homepage")) {
			// title verified 
			Assert.assertTrue(true);
			logger.info("Title Verified");

		} else {
		captureScreen(driver,"loginTest");
			// title not verified 
			Assert.assertTrue(true);

			logger.info("Title Not Verified");
		}
	}
}
