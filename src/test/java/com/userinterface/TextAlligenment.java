package com.userinterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allpageobjects.TextAllginPage;

public class TextAlligenment {
	public class LoginTest {
		//image allignment also like same kind of process

		private WebDriver driver;

		@Test(priority = 1)
		public void Alligen() throws Exception {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/locatorspractice/");
			TextAllginPage ta = new TextAllginPage(driver);
			ta.Login("9661916987", "Chinna");
			Thread.sleep(3000);
			String Expected = ta.getAlignment();

			System.out.println(Expected);
			Assert.assertEquals("center", Expected, "Error message alignment is not center");

		}
	}
}