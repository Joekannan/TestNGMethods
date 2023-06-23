package testNGMethods;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTestOutsideClass {
	public WebDriver driver;
	public WebDriverWait wait;
	public Faker faker;
	public String userName;
	public JavascriptExecutor je;
	
	@BeforeMethod(description="This test is to set up the browser")
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		faker = new Faker();
		userName = faker.name().fullName();
		je = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/newtours/");
	}
	
	@Test(description = "This test is to login", priority = -1, dataProvider="loginData", dataProviderClass=DataproviderMethod.class)
	public void verifyLogin(String uname, String password) {
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		wait.until(ExpectedConditions.urlContains("login_sucess"));
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("login_sucess"));
		if(driver.findElement(By.linkText("SIGN-OFF")).isDisplayed()) {
			driver.findElement(By.linkText("SIGN-OFF")).click();
		}
	}
	
	@AfterMethod(description = "This test is to tidy up the driver")
	public void tearDown() {
		driver.close();
		driver.quit();
	}	
}
