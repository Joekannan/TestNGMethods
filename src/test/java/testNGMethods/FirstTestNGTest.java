package testNGMethods;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestNGTest {
	
	WebDriver driver;
	
	@Test(priority = -30,description="This test is to set up the browser")
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//maximise the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority = 3, description="This test is to login")
  	public void loginToOrangeHRM() {
		//specify the URL of the webpage
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		String url = driver.getCurrentUrl();
		
		Assert.assertTrue(url.contains("dashboard"));
  	}
	
	@Test(priority = 40 ,description="This test is to clean up the browser")
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
