package com.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {

	public static WebDriver driver = null;
	public static Logger log = Logger.getLogger(TestBase.class);

	public String ReadProperty(String Key) {
		log.info("Reading property from property file");
		Properties prop = new Properties();
		try {
			FileInputStream fis = null;
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("Value found in the property file for the key" + Key);
		return prop.getProperty(Key);
	}
	
	public void LaunchApplication()
	{
		driver.get(ReadProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public WebDriver Initialization() {
		if (ReadProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			LaunchApplication();
			return driver;
		} else if (ReadProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			LaunchApplication();
			return driver;
		} else {
			return null;
		}
	}
	
	public void GetScreenShot(String name)
	{
		TakesScreenshot ss = (TakesScreenshot)driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir")+"/ScreenShots/"+name+".jpg");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
