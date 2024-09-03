package com.inetbanking.testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		logger.info("****************  User Logged IN ***************");
		Thread.sleep(3000);
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		addcust.custName("Chandra");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		addcust.custaddress("INDIA");
		addcust.custcity("MUM");
		addcust.custstate("MH");
		addcust.custpinno("400097");
		addcust.custtelephoneno("989898989");
		addcust.custemailid(randomstring()+"@gmail.com");
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		logger.info("Data Entered");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		System.out.println(res);
		if (res==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}
