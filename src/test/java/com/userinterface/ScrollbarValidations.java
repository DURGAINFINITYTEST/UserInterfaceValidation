package com.userinterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.allpageobjects.ScrollbarPage;

public class ScrollbarValidations {

	private WebDriver driver;
	private ScrollbarPage sp;

	@Test(priority = 1)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		sp = new ScrollbarPage(driver);
		sp.Login("Chinna", "Chinna123");
		Thread.sleep(4000);

	}

	@Test(priority = 2)
	public void testVerticalScrollbar() {
		boolean isVerticalScrollbarPresent = (Boolean) sp.isVerticalScrollbarPresent();
		System.out.println(isVerticalScrollbarPresent);
	}

	@Test(priority = 3)
	public void testHorizontalScrollbar() {
		boolean isHorizontalScrollbarPresent = (Boolean) sp.isHorizontalScrollbarPresent();

		System.out.println(isHorizontalScrollbarPresent);
	}

}