package org.seke.filmania.selenium;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTest {

	private String baseUrl;
	private WebDriver driver;

	// private ScreenshotHelper screenshotHelper;

	@Before
	public void openBrowser() {
//		baseUrl = System.getProperty("webdriver.base.url");
		baseUrl = "http://www.gogole.com";

		driver = new FirefoxDriver();
		driver.get(baseUrl);

		// screenshotHelper = new ScreenshotHelper();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void pageTitleAfterSearchShouldBeginWithDrupal() throws IOException {

		assertEquals("The page title should equal Google at the start of the test.", "Google", driver.getTitle());

		WebElement searchField = driver.findElement(By.name("q"));
		searchField.sendKeys("Drupal!");
		searchField.submit();

		assertTrue("The page title should start with the search string after the search.", (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("drupal!");
			}
		}));
		
	}
	
	
}
