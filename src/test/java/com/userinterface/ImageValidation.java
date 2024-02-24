package com.userinterface;

import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfDouble;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.allpageobjects.ImageQualityPage;

public class ImageValidation {
	WebDriver driver;

	@Test
	public void getImageValidation() throws Exception {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		ImageQualityPage im = new ImageQualityPage(driver);
		im.Login("Chinnakatak", "9013565452");
		Thread.sleep(3000);

		// Locate the image element
		WebElement imageElement = driver.findElement(By.xpath("//div[@class='overlay-panel overlay-right']"));

		// Capture the screenshot of the image element
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Analyze image clarity using OpenCV

		double imageClarity = analyzeImageClarity(screenshot);
		System.out.println(imageClarity);

		// Perform validation based on the image clarity value

		driver.quit();
	}

	public static double analyzeImageClarity(File imageFile) {
		// Load the screenshot as an OpenCV Mat

		Mat mat = Imgcodecs.imread(imageFile.getAbsolutePath());

		// Convert the image to grayscale
		Mat gray = new Mat(mat.rows(), mat.cols(), CvType.CV_8U, new Scalar(1));
		Imgproc.cvtColor(mat, gray, Imgproc.COLOR_BGR2GRAY);

		// Calculate image sharpness using Laplacian operator
		Mat laplacian = new Mat();
		Imgproc.Laplacian(gray, laplacian, CvType.CV_64F);
		MatOfDouble median = new MatOfDouble();
		MatOfDouble stddev = new MatOfDouble();
		Core.meanStdDev(laplacian, median, stddev);
		double sharpness = Math.pow(stddev.get(0, 0)[0], 2);

		return sharpness;
	}
}
