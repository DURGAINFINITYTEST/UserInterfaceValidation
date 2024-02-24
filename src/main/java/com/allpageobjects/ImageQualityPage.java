package com.allpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImageQualityPage {
	private WebDriver driver;

	public ImageQualityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement usernameInput;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginButton;

	public void Login(String username, String password) throws InterruptedException {

		usernameInput.sendKeys(username);

		passwordInput.sendKeys(password);

		loginButton.click();

	}
	

	
}