package StepDefinitions;

import io.cucumber.java.en.Given;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginSteps {
	
	WebDriver driver;
	
	@Given("launch the web page")
	public void launch_the_web_page() {
		System.out.println("-------------- Given one--------------------");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Desktop\\Desktop\\job\\selenium2021\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/login");
	}

	@When("you enter correct username and password and click login button")
	public void you_enter_correct_username_and_password_and_click_login_button() {
		System.out.println(" ------------------When Two---------------");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		
	}

	@Then("I should login successfully")
	public void i_should_login_successfully() {
		System.out.println(" -------------------- Then three --------------");
		
		driver.findElement(By.xpath("//button[@class='radius']")).click();
		WebElement link = driver.findElement(By.id("flash"));
		String actualStr = link.getText();
		
		/* code to overcome space and * found at the end of actual_string*/
		String modActualString = actualStr.substring(0,(actualStr.length()-2));
		Assert.assertEquals("You logged into a secure area!",modActualString);
		driver.close();
		
	}
	
	@When("you enter wrong username and password and click login button")
	public void you_enter_wrong_username_and_password_and_click_login_button() {
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("wrongadmin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("wrongpasswd");
		driver.findElement(By.xpath("//button[@class='radius']")).click();
	}

	@Then("I should fail to login")
	public void i_should_fail_to_login() {
		WebElement link = driver.findElement(By.id("flash"));
		String actualStr = link.getText();
		
		// code to overcome space and * found at the end of actual_string
		String modActualString = actualStr.substring(0,(actualStr.length()-2));
		Assert.assertEquals("Your username is invalid!",modActualString);
		driver.close();
	}
	
	@Then("I should fail to login with wrong password")
	public void i_should_fail_to_login_with_wrong_password() {
		WebElement link = driver.findElement(By.id("flash"));
		String actualStr = link.getText();
		
		// code to overcome space and * found at the end of actual_string
		String modActualString = actualStr.substring(0,(actualStr.length()-2));
		Assert.assertEquals("Your password is invalid!",modActualString);
		driver.close();
		
	}

	@When("you enter wrong username and correct password and click login button")
	public void you_enter_wrong_username_and_correct_password_and_click_login_button() {
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("wronguser");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@class='radius']")).click();
			
	}

	@When("you enter correct username and wrong password and click login button")
	public void you_enter_correct_username_and_wrong_password_and_click_login_button() {
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("wrongpasswd");
		driver.findElement(By.xpath("//button[@class='radius']")).click();		
		
	}


}
