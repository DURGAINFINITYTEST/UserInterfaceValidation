package com.userinterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.allpageobjects.FontPage;

public class ValidateFont {
	public WebDriver driver;

	@Test
	public void getValidateTheFont() throws Exception {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		FontPage fp = new FontPage(driver);
		fp.Login("durga prasad k", "Chinna5237");
		Thread.sleep(3000);
		String fontFamily = fp.getFontFamily();
		System.out.println(fontFamily);
		String fontColor = fp.getFontColor();
		System.out.println(fontColor);
		String fontSize = fp.getFontSize();
		System.out.println(fontSize);

	}

}
