package ui.tests;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginClass extends ui.data.LoginData {
	
	@BeforeTest
	public void SetUp() {
		driver.get(TheWebSite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}
	
	
	
	@Test(priority=1)
	public void SuccessfullyLogin() {
		

		WebElement UserNameField=driver.findElement(By.id("user-name"));
		WebElement PasswordField=driver.findElement(By.id("password"));
		WebElement LoginButton=driver.findElement(By.id("login-button"));
		
		UserNameField.sendKeys(UserName[0]);
		PasswordField.sendKeys(Password);
		LoginButton.click();
		
		Assert.assertTrue(driver.getPageSource().contains(ExpectedForSuccess),"Successful login message not found");

	}
	
	
	
	@Test(priority = 2)
	public void Performance_glitch_userLogin() throws InterruptedException {
		driver.navigate().to(TheWebSite);


	    WebElement UserNameField = driver.findElement(By.id("user-name"));
	    WebElement PasswordField = driver.findElement(By.id("password"));
	    WebElement LoginButton = driver.findElement(By.id("login-button"));

	    // start time
	    long startTime = System.currentTimeMillis();

	    UserNameField.sendKeys(UserName[4]);
	    PasswordField.sendKeys(Password);
	    LoginButton.click();
	    
	    // end time
	    long endTime = System.currentTimeMillis();
	    long duration = endTime - startTime;

	    
	    // assertion: must be less than or equal 2 seconds
	    Assert.assertTrue( duration <= 2000,"Performance glitch user login exceeded 2 seconds! Duration = " + duration + " ms");
	   
	    
	}
	
	
	
	@Test(priority=3)
	public void Locked_out_userLogin() {
		driver.navigate().to(TheWebSite);
		
		WebElement UserNameField=driver.findElement(By.id("user-name"));
		WebElement PasswordField=driver.findElement(By.id("password"));
		WebElement LoginButton=driver.findElement(By.id("login-button"));
		
		UserNameField.sendKeys(UserName[2]);
		PasswordField.sendKeys(Password);
		LoginButton.click();
		
		Assert.assertTrue(driver.getPageSource().contains(ExpectedForLocked),"Locked out user error message not displayed");

	}
	
	
	
	
	@Test(priority=4)
	public void Negative_Login() {
		driver.navigate().to(TheWebSite);

		WebElement UserNameField=driver.findElement(By.id("user-name"));
		WebElement PasswordField=driver.findElement(By.id("password"));
		WebElement LoginButton=driver.findElement(By.id("login-button"));
		

		UserNameField.sendKeys(UserName[0]);
		PasswordField.sendKeys(WrongPassword);
		LoginButton.click();
		
		Assert.assertTrue(driver.getPageSource().contains(ExpectedForNegative),"Error message is not found");

		
		
	}
	
	

	

	
	

}
