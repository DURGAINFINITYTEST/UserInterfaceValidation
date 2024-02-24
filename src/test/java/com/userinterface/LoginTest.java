package com.userinterface;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.allpageobjects.LoginPage;

public class LoginTest {

	private WebDriver driver;
	private LoginPage loginPage;

	@Test(priority = 1)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		loginPage = new LoginPage(driver);
		loginPage.Login("katakatladurgaprasad@gmail.com", "rahulshettyacademy");

	}

	@Test(priority = 2)
	public void Validation() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		WebElement user = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		Dimension size = user.getSize();
		int width = size.getWidth();
		int height = size.getHeight();
		System.out.println(width + "and" + height);

		WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		Point position = user.getLocation();
		// input[@placeholder='Password']"
		int x = position.getX();
		int y = position.getY();
		System.out.println(x + "and" + y);

	}

}