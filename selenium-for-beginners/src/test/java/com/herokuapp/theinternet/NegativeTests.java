package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeTests {
	
	/*
	 * // @Test(priority=1,groups = { "negativeTests", "smokeTests" }) // public
	 * void incorrectUsernameTest()
	 * 
	 * @Parameters({ "username", "password", "expectedMsg" })
	 * 
	 * @Test public void negativeLoginTest(String username, String password, String
	 * expectedErrorMsg){
	 * 
	 * // Need not for the parameters name to be equal to given in parameters
	 * annotation- only order should be same
	 * 
	 * System.out.println("Starting Incorrect Username Test");
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * "src/main/resources/chromedriver.exe"); WebDriver driver= new ChromeDriver();
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * String url= "https://the-internet.herokuapp.com/login"; driver.get(url);
	 * System.out.println("Page is opened!");
	 * 
	 * WebElement usernameElement= driver.findElement(By.id("username")); //
	 * usernameElement.sendKeys("incorrectUsername");
	 * usernameElement.sendKeys(username);
	 * 
	 * WebElement passwordElement=
	 * driver.findElement(By.xpath("//input[@type='password']")); //
	 * passwordElement.sendKeys("SuperSecretPassword!");
	 * passwordElement.sendKeys(password);
	 * 
	 * WebElement loginButton=
	 * driver.findElement(By.xpath("//button[@class='radius']"));
	 * loginButton.click();
	 * 
	 * // Verifications:- // URL- not required // String expectedUrl=
	 * "https://the-internet.herokuapp.com/login"; // String actualUrl=
	 * driver.getCurrentUrl(); // Assert.assertEquals(actualUrl, expectedUrl,
	 * "Actual url is not same as expected");
	 * 
	 * // Incorrect username message // String expectedMsg=
	 * "Your username is invalid!"; WebElement invalidUsernameMsg=
	 * driver.findElement(By.cssSelector("#flash")); String actualMsg=
	 * invalidUsernameMsg.getText(); //
	 * Assert.assertTrue(actualMsg.contains(expectedMsg),
	 * "Actual msg is not the same as expected");
	 * Assert.assertTrue(actualMsg.contains(expectedErrorMsg),
	 * "Actual msg is not the same as expected");
	 * 
	 * driver.quit(); }
	 */
	
	/*
	 * @Test(priority=2, groups = {"negativeTests"}) public void
	 * incorrectPassword(){
	 * 
	 * System.out.println("Starting Incorrect Password Test");
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * "src/main/resources/chromedriver.exe"); WebDriver driver= new ChromeDriver();
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * String url= "https://the-internet.herokuapp.com/login"; driver.get(url);
	 * System.out.println("Page is opened");
	 * 
	 * WebElement username= driver.findElement(By.id("username"));
	 * username.sendKeys("tomsmith");
	 * 
	 * WebElement password=
	 * driver.findElement(By.xpath("//input[@type='password']"));
	 * password.sendKeys("incorrectPassword");
	 * 
	 * WebElement loginButton=
	 * driver.findElement(By.xpath("//button[@class='radius']"));
	 * loginButton.click();
	 * 
	 * // Verifications:- String expectedMsg= "Your password is invalid!";
	 * WebElement incorrectPasswordMsg= driver.findElement(By.id("flash")); String
	 * actualMsg= incorrectPasswordMsg.getText();
	 * Assert.assertTrue(actualMsg.contains(expectedMsg),
	 * "Actual Msg is not the same as expected");
	 * 
	 * driver.quit(); }
	 */
}
