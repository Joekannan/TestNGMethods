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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAttributes {
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
	
	
	@Test(description = "This test is to complete registration", priority = -2, enabled = true)
	public void registration() throws InterruptedException {
		
		driver.findElement(By.linkText("REGISTER")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='images/mast_register.gif']")));
		driver.findElement(By.name("firstName")).sendKeys(faker.name().firstName());
		driver.findElement(By.name("lastName")).sendKeys(faker.name().lastName());
		driver.findElement(By.name("phone")).sendKeys(faker.phoneNumber().cellPhone());
		driver.findElement(By.name("userName")).sendKeys(userName+"@gmail.com");
		driver.findElement(By.name("address1")).sendKeys(faker.address().fullAddress());
		driver.findElement(By.name("city")).sendKeys(faker.address().city());
		driver.findElement(By.name("state")).sendKeys(faker.address().state());
		driver.findElement(By.name("postalCode")).sendKeys(faker.address().zipCode());
		
		
		driver.findElement(By.name("email")).sendKeys(userName+"@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.name("confirmPassword")).sendKeys("Password123");
		driver.findElement(By.name("submit")).click();
		wait.until(ExpectedConditions.urlContains("register_sucess"));
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("register_sucess"));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SIGN-OFF")));
		je.executeScript("arguments[0].click();", driver.findElement(By.linkText("SIGN-OFF")));
		driver.navigate().refresh();
		je.executeScript("arguments[0].click();", driver.findElement(By.linkText("SIGN-OFF")));
		
		wait.until(ExpectedConditions.urlContains("index"));
		String url1 = driver.getCurrentUrl();
		Assert.assertTrue(url1.contains("index"));
	}
	
	@Parameters({"Username", "Password"})
	@Test(description = "This test is to login", priority = -1, enabled = true)
	public void verifyLogin(@Optional("jothi") String uname, @Optional("Password123") String password) {
//		je.executeScript("arguments[0].click();", driver.findElement(By.linkText("SIGN-ON")));
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		wait.until(ExpectedConditions.urlContains("login_sucess"));
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("login_sucess"));
		if(driver.findElement(By.linkText("SIGN-OFF")).isDisplayed()) {
			driver.findElement(By.linkText("SIGN-OFF")).click();
//			String url1 = driver.getCurrentUrl();
//			Assert.assertTrue(url1.contains("index"));
		}
	}
	
	@AfterMethod(description = "This test is to tidy up the driver")
	public void tearDown() {
		driver.close();
		driver.quit();
	}	
}
