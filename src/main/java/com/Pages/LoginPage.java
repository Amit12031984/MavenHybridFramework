package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(id = "email")
	private WebElement uName;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(xpath = "//button")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void ValidLogin()
	{
		uName.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		loginBtn.click();
	}
}
