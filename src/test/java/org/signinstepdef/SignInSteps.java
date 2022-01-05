package org.signinstepdef;

import java.util.concurrent.TimeUnit;

import org.basecreation.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignInSteps extends BaseClass {
//	WebDriver driver;
	@Given("user should go to Target ecommerce homepage")
	public void user_should_go_to_Target_ecommerce_homepage() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://www.target.com/");
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	   
	}

	@When("user should click signIn button and click on signIn link")
	public void user_should_click_signIn_button_and_click_on_signIn_link() throws InterruptedException {
		WebElement signinBtn = driver.findElement(By.id("account"));
		signinBtn.click();
		Thread.sleep(2000);
		WebElement signIn = driver.findElement(By.xpath("(//a[@data-test='navigation-link'])[1]"));
		signIn.click();
	   
	}
	
	@When("user should enter invalid  email and password")
	public void user_should_enter_invalid_email_and_password() {
		WebElement txtEmail = driver.findElement(By.id("username"));
		txtEmail.sendKeys("fsdfd@gmail.com");
	    WebElement txtPswd = driver.findElement(By.id("password"));
	    txtPswd.sendKeys("12345ABCD");
	}

	@Then("user should click signIn button and get error message")
	public void user_should_click_signIn_button_and_get_error_message() {
		WebElement loginBtn = driver.findElement(By.id("login"));
		loginBtn.click();
//		String errorText = driver.
//		Assert.assertTrue("Check email is valid or invalid", false);
	 
	}

	@When("user should enter valid email and password")
	public void user_should_enter_valid_email_and_password() {
		
		WebElement txtEmail = driver.findElement(By.id("username"));
		txtEmail.sendKeys("raguprofessional06@gmail.com");
	    WebElement txtPswd = driver.findElement(By.id("password"));
	    txtPswd.sendKeys("Game@Ragu6");
	}

	@Then("user should click signIn button and login successful")
	public void user_should_click_signIn_button_and_login_successful() {
		WebElement loginBtn = driver.findElement(By.id("login"));
		loginBtn.click();
	  
	}

}
