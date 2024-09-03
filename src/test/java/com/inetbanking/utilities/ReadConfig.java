package com.inetbanking.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class ReadConfig 
{
	Properties prop;
	public ReadConfig() 
	{
		File src = new File("./Configuration/config.properties");
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e) 
		{
			System.out.println("Exception is " +e.getMessage());
		}
	}
	public String getApplicationURL() 
	{
		String url = prop.getProperty("BASE_URL");
		return url;
	}
	public String getApplicationusername() 
	{
		String username = prop.getProperty("username");
		return username;
	}
	public String getApplicationpassword() 
	{
		String password = prop.getProperty("password");
		return password;
	}
	public String getFirefoxPath() 
	{
		String FirefoxPath = prop.getProperty("FirefoxPath");
		return FirefoxPath;
	}
	public String getIEPath() 
	{
		String IEPath = prop.getProperty("IEPath");
		return IEPath;
	}
	public String getOperaPath() 
	{
		String OperaPath = prop.getProperty("OperaPath");
		return OperaPath;
	}
	public String getEdgePath() 
	{
		String EdgePath = prop.getProperty("EdgePath");
		return EdgePath;
	}
}