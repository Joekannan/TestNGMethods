package seleniumPractise.SampleProgram;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitMethods1 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		pageTimeOut(driver);
//		implicitWaitMethod(driver);
//		setScriptTimeOut(driver);
//		threadSleep(driver);
		explicitWaitMethod(driver);
//		fluentWaitMethod(driver);
		driver.close();
		driver.quit();
	}
	
	public static void pageTimeOut(WebDriver driver) {
		//1. Page Load Timeout
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://app.testproject.io/");
	}

	public static void implicitWaitMethod(WebDriver driver) {
		//1. Implicit wait
		driver.get("https://testproject.io/");
		driver.findElement(By.linkText("Login")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String>allWindows = driver.getWindowHandles();
		for(String windowName : allWindows) {
			driver.switchTo().window(windowName);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("info@novatraining.nz");
		System.out.println("Username is set in the field");
		
	}
	
	public static void setScriptTimeOut(WebDriver driver) {
		//1. Implicit wait
		driver.get("https://testproject.io/");
		driver.findElement(By.linkText("Login")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String>allWindows = driver.getWindowHandles();
		for(String windowName : allWindows) {
			driver.switchTo().window(windowName);
		}
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("info@novatraining.nz");
		System.out.println("Username is set in the field");
		
	}
	
	public static void threadSleep(WebDriver driver) throws InterruptedException {
		//1. Implicit wait
		driver.get("https://testproject.io/");
		driver.findElement(By.linkText("Login")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String>allWindows = driver.getWindowHandles();
		for(String windowName : allWindows) {
			driver.switchTo().window(windowName);
		}
		Thread.sleep(20000);
		System.out.println("I am waiting here");
		driver.findElement(By.id("username")).sendKeys("info@novatraining.nz");
		System.out.println("Username is set in the field");
		
	}
	
	public static void explicitWaitMethod(WebDriver driver) {
		//1. Explicit wait
		driver.get("https://testproject.io/");
		driver.findElement(By.linkText("Login")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String>allWindows = driver.getWindowHandles();
		for(String windowName : allWindows) {
			driver.switchTo().window(windowName);
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		driver.findElement(By.id("username")).sendKeys("info@novatraining.nz");
		System.out.println("Username is set in the field");
		
	}
	
	public static void fluentWaitMethod(WebDriver driver) {
		//1. fluent wait
		driver.get("https://testproject.io/");
		driver.findElement(By.linkText("Login")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String>allWindows = driver.getWindowHandles();
		for(String windowName : allWindows) {
			driver.switchTo().window(windowName);
		}
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(20))
			       .pollingEvery(Duration.ofSeconds(5))
			       .ignoring(NoSuchElementException.class);
		WebElement username = wait.until(new Function<WebDriver, WebElement>() 
		{
		    public WebElement apply(WebDriver driver) {
		    	return driver.findElement(By.id("username"));
		}
		    
		});
		username.sendKeys("info@novatraining.nz");
		System.out.println("Username is set in the field");
		
	}

}
