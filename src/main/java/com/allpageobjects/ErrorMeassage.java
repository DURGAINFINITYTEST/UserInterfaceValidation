package com.allpageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ErrorMeassage {

	@FindBy(xpath = " //p[text()='* Incorrect username or password']")
	private WebElement errorText;

	public String getErrorMessageText() {

		return errorText.getText();

	}

}
