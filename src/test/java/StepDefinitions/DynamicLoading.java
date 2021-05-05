package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicLoading {
	
	WebDriver driver;
	
	@Given("launch the web page of dynamic loading")
	public void launch_the_web_page_of_dynamic_loading() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Desktop\\Desktop\\job\\selenium2021\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);	
		driver.get("https://the-internet.herokuapp.com/dynamic_loading");
		
	}

	@When("when i click the start button and wait")
	public void when_i_click_the_start_button_and_wait() {
	   
		driver.findElement(By.xpath("//a[starts-with(text(),'Example 2: Element')]")).click();
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		WebDriverWait myWait = new WebDriverWait(driver,20);
	}

	@Then("after loadingbar disappears the text hello world appears")
	public void after_loadingbar_disappears_the_text_hello_world_appears() {
		
		WebDriverWait myWait = new WebDriverWait(driver,20);
		WebElement w = myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
		String resultStr = w.getText();
		System.out.println("Text You captured is :" + w.getText() );
		Assert.assertEquals("Hello World!",resultStr);
		driver.quit();
		
	}

}
