package com.herokuapp.theinternet;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExceptionsTests {

	private WebDriver driver;

//	In case of different browsers use Parameter annotation and pass browser as param- then in the setUp method 
//	using switch case create the webdriver based on the browser

	@BeforeMethod(alwaysRun = true)
	private void setUp() {

		System.out.println("Starting Login Test.");

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

	}


	@AfterMethod(alwaysRun = true)
	private void tearDown() {
//		Close browser
//		quit is used to shut down the web driver instance or destroy the web driver instance
//		close is used for closing the browser or the page on which it has focus- closes only active tab
		driver.quit();
	}

//	@Test
	public void noSuchElementExceptionTest() {

		/*
		 * Test case 1: NoSuchElementException Open page Click Add button Verify Row 2
		 * input field is displayed Row 2 doesn’t appear immediately. This test will
		 * fail with org.openqa.selenium.NoSuchElementException without proper wait
		 */

		String url = "https://practicetestautomation.com/practice-test-exceptions/";
		driver.get(url);
		System.out.println("Page opened");

		WebElement addButton = driver.findElement(By.id("add_btn"));
		addButton.click();
		System.out.println("Button clicked");

		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
//		Implicit wait
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
//		Explicit wait
//		WebDriverWait(WebDriver driver, long timeOutInSeconds)
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement row2Button =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']")));

		AssertJUnit.assertTrue(row2Button.isDisplayed());
	}
	
	
//	@Test
	public void elementNotInteractableExceptionTest() {

		String url = "https://practicetestautomation.com/practice-test-exceptions/";
		driver.get(url);
		System.out.println("Page opened");
		
		sleep

		WebElement addButton = driver.findElement(By.id("add_btn"));
		addButton.click();
		System.out.println("Button clicked");

		/*
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		
//		Implicit wait
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
//		Explicit wait
//		WebDriverWait(WebDriver driver, long timeOutInSeconds)
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement row2Button =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));

		AssertJUnit.assertTrue(row2Button.isDisplayed());
		
		row2Button.sendKeys("Hamburger");
		
//		WebElement saveButton = driver.findElement(By.name("Save"));
		WebElement saveButton = driver.findElement(By.xpath("//div[@id='row2']/button[@name='Save']"));
		saveButton.click();
		System.out.println("Save Button clicked");
		
		String expectedMsg= "Row 2 was saved";
		WebElement saveConfirmationMsg = driver.findElement(By.id("confirmation"));
		String actualMsg= saveConfirmationMsg.getText();
		Assert.assertTrue(actualMsg.contains(expectedMsg), "Actual message is not the same as expected");
		
	}
	
//	@Test
	public void invalidElementStateExceptionTest() {

		String url = "https://practicetestautomation.com/practice-test-exceptions/";
		driver.get(url);
		System.out.println("Page opened");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement inputField= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row1']/input")));
		WebElement editButton= driver.findElement(By.id("edit_btn"));
		editButton.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(inputField));
		inputField.clear();		//this line creates an exception
		
		inputField.sendKeys("Hamburger");
		
		WebElement saveButton= driver.findElement(By.id("save_btn"));
		saveButton.click();
		
//		Return value of the attribute- in this case return value of attribute 'value'
		Assert.assertEquals(inputField.getAttribute("value"), "Hamburger", "Input text is not same as entered");
		
		String expectedMsg= "Row 1 was saved";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='confirmation']")));
		WebElement confirmationMsg= driver.findElement(By.xpath("//div[@id='confirmation']"));
		String actualMsg= confirmationMsg.getText();
		Assert.assertTrue(actualMsg.contains(expectedMsg), "Confirmation message is not the same as expected");
		
	}
	
//	@Test
	public void staleElementReferenceExceptionTest() {

		String url = "https://practicetestautomation.com/practice-test-exceptions/";
		driver.get(url);
		System.out.println("Page opened");
		
//		WebElement instructionMsg= driver.findElement(By.xpath("//p[@id='instructions']"));
		
		WebElement addButton = driver.findElement(By.id("add_btn"));
		addButton.click();
		System.out.println("Button clicked");
		
//		Since the instructionMsg is removed from the page after clicking add button we cannot check if it is 
//		displayed or not
//		Assert.assertTrue(!instructionMsg.isDisplayed(), "Instructions Message is still visible");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		Assert.assertFalse(instructionMsg.isDisplayed(), "Instructions are still visible");
		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[@id='instructions']"))),"Instructions are still visible");
	}
	
	
	@Test
	public void timeoutExceptionTest() {

		String url = "https://practicetestautomation.com/practice-test-exceptions/";
		driver.get(url);
		System.out.println("Page opened");
		
		WebElement addButton = driver.findElement(By.id("add_btn"));
		addButton.click();
		System.out.println("Button clicked");
		
//		WebDriverWait wait = new WebDriverWait(driver, 3);  Timeout Exception
		WebDriverWait wait = new WebDriverWait(driver, 6);
		WebElement row2Input= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
		
//		Assert.assertFalse(instructionMsg.isDisplayed(), "Instructions are still visible");
		Assert.assertTrue(row2Input.isDisplayed(), "Second input field is not visible");
				
	}
}
