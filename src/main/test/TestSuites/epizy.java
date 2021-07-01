package TestSuites;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class epizy {

	private static WebDriver driver;

	@BeforeClass
	public static void beforeTest() {

		WebDriverManager.chromedriver()
				.setup();

		driver = new ChromeDriver();

		driver.get("http://siit.epizy.com/index.php?route=account/login");

	}

	@Test
	public void loginWithInvalidCredentials() {

		WebElement txtEmailAddress = driver.findElement(By.xpath("//input[@name='email']"));

		txtEmailAddress.sendKeys("test@yahoo.com");

		WebElement txtPassword = driver.findElement(By.cssSelector("input[type='password']"));

		txtPassword.sendKeys("1234567");

		WebElement btnLogIn = driver.findElement(By.xpath("//input[@value='Login']"));

		btnLogIn.click();

		WebElement lblValidationError = driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible']"));

		System.out.println(lblValidationError.getText() + "\r\n");

		String actualErrorMsg = lblValidationError.getText();

		String expectedMsg = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";

		Assert.assertEquals("The error message is incorrect", expectedMsg, actualErrorMsg);

	}

	@AfterClass
	public static void quit() {
		driver.quit();
	}

}
