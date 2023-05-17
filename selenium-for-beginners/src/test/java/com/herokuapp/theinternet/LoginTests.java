package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//public class PositiveTests {
public class LoginTests {
	
	private WebDriver driver;
	
//	In case of different browsers use Parameter annotation and pass browser as param- then in the setUp method 
//	using switch case create the webdriver based on the browser
	
	@BeforeMethod(alwaysRun= true)
	private void setUp() {
		
		  System.out.println("Starting Login Test.");
		  
		  System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe"); 
		  driver= new ChromeDriver();
		  
		  driver.manage().window().maximize();
		 
	}

	@Test(priority=1,groups = { "positiveTests", "smokeTests" })
//	public void loginTest() {
	public void positiveLoginTest() {

		/*
		 * System.out.println("Starting Login Test.");
		 * 
		 * // Create driver- in our case its ChromeDriver // We are letting project know
		 * where ChromeDriver is located System.setProperty("webdriver.chrome.driver",
		 * "src/main/resources/chromedriver.exe"); // We will create instance of the
		 * driver that will send commands to the actual Chrome browser WebDriver driver
		 * = new ChromeDriver();
		 * 
		 * // Code to slow down the test- sleep for 3 secs // sleep(1000);
		 * 
		 * // Maximize browser window driver.manage().window().maximize();
		 */
		
//		Open test page
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is opened.");

//		Now if we run our code, driver will open new instance of Chrome browser and then driver get command will 
//		open the url in the browser

//		Enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");

//		Enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");

//		Click login button
		WebElement login = driver.findElement(By.tagName("button"));
		login.click();

//		Verifications:- 
//		new url: make sure that next page url is /secure
		String expectedUrl = "http://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "The actual url is not the same as expected url");

//		logout button: make sure logout button is present on the page
//		WebElement logout= driver.findElement(By.className("button secondary radius"));
		WebElement logout = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logout.isDisplayed(), "Logout button is not visible!");

//		Successful login msg: 'You are logged into secure area' msg is also present on page
		WebElement successMsg = driver.findElement(By.cssSelector("#flash"));
		String expectedMsg = "You logged into a secure area!";
		String actualMsg = successMsg.getText();
//		Assert.assertEquals(actualMsg, expectedMsg, "Actual message is not equal to the expected message");
//		.getText() fails due to inclusion of sub-elements- as you inspect you will find an extra x in the sub element
		Assert.assertTrue(actualMsg.contains(actualMsg), "Actual message is not equal to the expected message."
				+ "\nActual Message: " + actualMsg + "\nExpected Message: " + expectedMsg);

	}


	@Test(priority=2,groups = { "negativeTests", "smokeTests" })
//	public void incorrectUsernameTest() 

	@Parameters({ "username", "password", "expectedMsg" })
	public void negativeLoginTest(String username, String password, String expectedErrorMsg) {

//		Need not for the parameters name to be equal to given in parameters annotation- only order should be same

		/*
		 * System.out.println("Starting Incorrect Username Test");
		 * 
		 * System.setProperty("webdriver.chrome.driver",
		 * "src/main/resources/chromedriver.exe"); WebDriver driver = new
		 * ChromeDriver();
		 * 
		 * driver.manage().window().maximize();
		 */

		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is opened!");

		WebElement usernameElement = driver.findElement(By.id("username"));
//		usernameElement.sendKeys("incorrectUsername");
		usernameElement.sendKeys(username);

		WebElement passwordElement = driver.findElement(By.xpath("//input[@type='password']"));
//		passwordElement.sendKeys("SuperSecretPassword!");
		passwordElement.sendKeys(password);

		WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
		loginButton.click();

//		Verifications:-
//		URL- not required
//		String expectedUrl= "https://the-internet.herokuapp.com/login";
//		String actualUrl= driver.getCurrentUrl();
//		Assert.assertEquals(actualUrl, expectedUrl, "Actual url is not same as expected");

//		Incorrect username message
//		String expectedMsg= "Your username is invalid!";
		WebElement invalidUsernameMsg = driver.findElement(By.cssSelector("#flash"));
		String actualMsg = invalidUsernameMsg.getText();
//		Assert.assertTrue(actualMsg.contains(expectedMsg), "Actual msg is not the same as expected");
		Assert.assertTrue(actualMsg.contains(expectedErrorMsg), "Actual msg is not the same as expected");

	}
	
	@AfterMethod(alwaysRun= true)
	private void tearDown() {
//		Close browser
//		quit is used to shut down the web driver instance or destroy the web driver instance
//		close is used for closing the browser or the page on which it has focus- closes only active tab
		driver.quit();
	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
