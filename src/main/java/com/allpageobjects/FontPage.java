package com.allpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FontPage {
	
	/*
	 * Rendering Consistency:
	 * Rendering Consistency: Test the font family across different browsers and operating systems to ensure that the fonts render consistently and accurately. This includes checking the appearance of the fonts on popular web browsers like Chrome, Firefox, Safari, and Internet Explorer, as well as on mobile devices.
	 * Readability and Legibility
	 * Font Variations
	 * some links in diff colours
	 * in our user interface we are seen multi
	 * 
	 */
	private WebDriver driver;

	public FontPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement usernameInput;

	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordInput;

	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement loginButton;

	@FindBy(xpath = " //p[text()='* Incorrect username or password']")
	private WebElement errorText;

	public void Login(String username, String password) throws InterruptedException {

		usernameInput.sendKeys(username);

		passwordInput.sendKeys(password);

		loginButton.click();

	}

	public String getFontFamily() {
		return errorText.getCssValue("font-family");
	}

	public String getFontSize() {
		return errorText.getCssValue("font-size");
	}

	public String getFontColor() {
		String color = errorText.getCssValue("color");
		return Color.fromString(color).asHex();

	}

}