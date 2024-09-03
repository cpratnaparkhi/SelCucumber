package com.inetbanking.testCases;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLSUtility;
import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider= "LoginData")
	public void loginDDT(String username, String password) throws IOException, InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			captureScreen(driver,"loginDDT");
			Assert.assertTrue(false);
			logger.info("Login FAIL");
		}
		else
		{
			captureScreen(driver,"loginDDT");
			Assert.assertTrue(true);
			logger.info("Login PASS");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //Successfull logout
		}
	}
	public boolean isAlertPresent() 
	{
		try 
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) 
		{
			return false;	
		}
	}
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path =  System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rownum = XLSUtility.getRowCount(path,"Data");
		int cocount=XLSUtility.getCellCount(path,"Data",1);
		String logindata [][]=new String[rownum][cocount];
		for (int i=1;i<=rownum;i++)
			for(int j=0;j<cocount;j++)
			{
				logindata[i-1][j]=XLSUtility.getCellData(path, "Data", i, j);
			}
		return logindata;
	}
}