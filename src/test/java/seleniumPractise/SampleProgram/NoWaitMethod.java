package seleniumPractise.SampleProgram;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoWaitMethod {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://testproject.io/");
		
		driver.findElement(By.linkText("Login")).click();
		
		Set<String>allWindows = driver.getWindowHandles();
		
		for(String window:allWindows) {
			driver.switchTo().window(window);
		}
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		
		driver.findElement(By.id("username")).sendKeys("jothi2k9@gmail.com");
		
		

		driver.close();
		driver.quit();
	}
	
	

}
