package com.allpageobjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZoomPage {
	private WebDriver driver;

	public ZoomPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = " //p[text()='* Incorrect username or password']")
	private WebElement errorText;

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

	public Dimension getDefaultSize() {

		return errorText.getSize();
	}

	public Dimension getBeforeZoomin() {
		return errorText.getSize();
	}

	public Dimension getBeforeZoomOut() {
		return errorText.getSize();
	}

}