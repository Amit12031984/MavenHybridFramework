package com.Tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Base.TestBase;
import com.Pages.LoginPage;

public class LoginTest extends TestBase {

	WebDriver driver = null;
	LoginPage lp = null;
	@BeforeSuite
	public void SetUp() {
		driver = Initialization();
		lp = new LoginPage(driver);
	}
	@Test
	public void Login()
	{
		lp.ValidLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@Test
	public void Test02()
	{
		Assert.assertTrue(false);
	}
}
