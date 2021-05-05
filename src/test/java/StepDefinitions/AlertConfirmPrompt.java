package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AlertConfirmPrompt {
	
	WebDriver driver;
	
	@Given("launch the web page of javascript_alerts")
	public void launch_the_web_page_of_javascript_alerts() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Desktop\\Desktop\\job\\selenium2021\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);	
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");		   
	}

	@When("I click ok on pop up alert box")
	public void i_click_ok_on_pop_up_alert_box() {
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert aObj = driver.switchTo().alert();
		aObj.accept();	
	}

	@Then("I should come back to my main window")
	public void i_should_come_back_to_my_main_window() {
		String expectedStr = "You successfully clicked an alert";
		String resultStr = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(expectedStr,resultStr);
		driver.quit();
	  }
	
	/*********************************************/
	@When("I click ok on pop up confirm window")
	public void i_click_ok_on_pop_up_confirm_window() {
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Alert aObj = driver.switchTo().alert();
		aObj.accept();	  
	}
	
	@Then("I should get result you clicked ok")
	public void i_should_get_result_you_clicked_ok() {
		String expectedStr = "You clicked: Ok";
		String resultStr = driver.findElement(By.id("result")).getText();
		Assert.assertEquals(expectedStr,resultStr);
		driver.quit();
	    
	}

	@When("I click cancel on pop up confirm window")
	public void i_click_cancel_on_pop_up_confirm_window() {
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Alert aObj = driver.switchTo().alert();
		aObj.dismiss();	   
	}

	@Then("I should get result you clicked cancel")
	public void i_should_get_result_you_clicked_cancel() {
		
		String resultStr = driver.findElement(By.id("result")).getText();
		Assert.assertEquals("You clicked: Cancel",resultStr);
		driver.quit();
		
	}
	
	/*********************************************/
	
	@When("I type text on prompt window and click ok")
	public void i_type_text_on_prompt_window_and_click_ok() {
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert aObj = driver.switchTo().alert();
		aObj.sendKeys("OK");
		aObj.accept();
	}

	@Then("I should see your text under You entered: column")
	public void i_should_see_your_text_under_you_entered_column() {
		String resultStr = driver.findElement(By.id("result")).getText();
		//System.out.println("When i am OK           : " + resultStr);
		Assert.assertEquals("You entered: OK",resultStr);
		driver.quit();
	}
	
	@When("I type text on prompt window and click cancel")
	public void i_type_text_on_prompt_window_and_click_cancel() {
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert aObj = driver.switchTo().alert();
		aObj.sendKeys("OK");
		aObj.dismiss();	
	}	

	@Then("I should not see your text under You entered: columnn")
	public void i_should_not_see_your_text_under_you_entered_columnn() {
		String resultStr = driver.findElement(By.id("result")).getText();
		Assert.assertEquals("You entered: null",resultStr);
		driver.quit();
				
	}

	

} //End
