
package com.userinterface;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.allpageobjects.ZoomPage;

public class ZoomInZoomOut {
	/*
	 * zoomin zoom out when we perform the operaetion the elements will not overlap
	 * those are should be visible in same position brackabacks:one leemnts replaced
	 * another elements
	 */

	public WebDriver driver;

	@Test
	public void getValidateZoom() throws Exception {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		ZoomPage zp = new ZoomPage(driver);
		zp.Login("9642193164", "prasad");

		Dimension def = zp.getDefaultSize();
		System.out.println(def);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='75%'");

		Dimension zoomIn = zp.getBeforeZoomin();
		System.out.println(zoomIn); 

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("document.body.style.zoom='150%'");

		Dimension zoomOut = zp.getBeforeZoomOut();
		System.out.println(zoomOut);

	}

}
