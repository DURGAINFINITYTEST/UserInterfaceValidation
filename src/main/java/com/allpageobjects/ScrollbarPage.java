package com.allpageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScrollbarPage {

	private WebDriver driver;

	public ScrollbarPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// html
	@FindBy(xpath = "//html")
	private WebElement scrollableContent;

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

	public Object isVerticalScrollbarPresent() {
		String script = "return arguments[0].scrollHeight > arguments[0].clientHeight;";
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(script, scrollableContent);
	}

	public Object isHorizontalScrollbarPresent() {
		String script = "return arguments[0].scrollWidth > arguments[0].clientWidth;";
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(script, scrollableContent);
	}

}
