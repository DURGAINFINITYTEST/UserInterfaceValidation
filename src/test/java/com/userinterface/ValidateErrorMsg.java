package com.userinterface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allpageobjects.LoginPage;

public class ValidateErrorMsg {

	public class image {

		public image() {
			// TODO Auto-generated constructor stub
		}

	}

	private WebDriver driver;

	@Test(priority = 1)
	public void ErrorValidation() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		LoginPage lp = new LoginPage(driver);
		lp.Login("durga prasad ", "1234578");
		Thread.sleep(5000);
		String text = driver.findElement(By.xpath("//p[@class='error']")).getText();

		Assert.assertEquals(text, "* Incorrect username or password");
		System.out.println("valid error message");

	}
}
