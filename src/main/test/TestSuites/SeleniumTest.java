package TestSuites;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

	@Test
	@Ignore
	public void myFirstTest() {

		// ChromeOptions options = new ChromeOptions();
		//
		// String dir = "C:\\Users\\Raulg\\AppData\\Local\\Google\\Chrome\\User Data\\Default\r\n"; // replace with your Google profile path
		//
		// options.addArguments("user-data-dir=" + dir);
		//
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe"); // on Windows use backslashes "\"

		WebDriver driver = new ChromeDriver(/* options */);

		driver.get("http://www.scoalainformala.ro");

		driver.quit();
	}

	@Test
	@Ignore
	public void mySecondTest() {

		WebDriver driver = startDriver();

		agreeGoogleCookies(driver);

		driver.quit();
	}

	/**
	 * 1. Open the browser (Firefox) <br>
	 * 2. Navigate to www.google.com <br>
	 * 3. Accept cookies <br>
	 * 4. Search for keyword "koala" <br>
	 * 5. Grab the total number of results and print it <br>
	 * 6. Grab the results on the first page and print them <br>
	 * {@link #startDriver()}
	 */
	@Test
	// @Ignore
	public void printAllSearchResults() {

		WebDriver driver = startDriver();

		agreeGoogleCookies(driver);

		WebElement searchBox = driver.findElement(By.name("q"));

		searchBox.sendKeys("koala", Keys.RETURN);

		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("result-stats")));

		System.out.println("Total number of results is: " + myDynamicElement.getText() + "\r\n");

		List<WebElement> resultTitleElements = driver.findElements(By.cssSelector("h3"));

		System.out.println("There are " + resultTitleElements.size() + " results on this page \r\n");

		for (WebElement we : resultTitleElements) {

			System.out.println(we.getText());

			WebElement resultTitle = we.findElement(By.xpath(".."));

			String resultHyperLink = resultTitle.getAttribute("href");

			System.out.println(resultHyperLink + "\r\n");

			Assert.assertTrue("href is not existent for this element: " + we.getText(), resultHyperLink != null);
		}

	}

	/**
	 * @return
	 */
	private static WebDriver startDriver() {
		System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.google.com");
		return driver;
	}

	/**
	 * Clicks on the "Agree" button on annoying "Accept cookies" dialog on Google web page
	 * 
	 * @param driver
	 *        the {@link WebDriver}
	 */
	public void agreeGoogleCookies(WebDriver driver) {

		WebElement agree = driver.findElement(By.id("L2AGLb"));

		agree.click();
	}
}
