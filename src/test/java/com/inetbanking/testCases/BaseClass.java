package com.inetbanking.testCases;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.inetbanking.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass 
{
	static ReadConfig readConfig = new ReadConfig(); 
	public static final String BASE_URL = readConfig.getApplicationURL();
	public static final String username = readConfig.getApplicationusername();
	public static final String password = readConfig.getApplicationpassword();
	public static WebDriver driver;
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) 
	{
		logger = LogManager.getLogger(this.getClass());
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("****************  Chrome Browser Launched ***************");
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
			logger.info("****************  Firefox Browser Launched ***************");
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver = new InternetExplorerDriver();
			logger.info("****************  InternetExplorer Browser Launched ***************");
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", readConfig.getEdgePath());
			driver = new EdgeDriver();
			logger.info("****************  Edge Browser Launched ***************");
		}
		driver.get(BASE_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\Screenshots\\"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}
	public String randomstring() 
	{
		SecureRandom random = new SecureRandom();
		return RandomStringUtils.random(5, 0, 0, true, true, null, random);
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}