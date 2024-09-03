package com.inetbanking.testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;
public class TC_Login_001 extends BaseClass
{
	@Test
	public void loginTest() throws InterruptedException, IOException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
			Assert.assertTrue(true, "PASS");
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false, "FAIL");
		}
	}
}
