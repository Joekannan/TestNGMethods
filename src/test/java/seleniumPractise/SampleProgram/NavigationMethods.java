package seleniumPractise.SampleProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.automationexercise.com/");
		System.out.println("Application launched");

		driver.navigate().refresh();
		System.out.println("Application refreshed");
		
		driver.findElement(By.cssSelector("a[href='/login']")).click();
		
		driver.navigate().back();
		System.out.println("I am on home page");
		
		driver.navigate().forward();
		System.out.println("I am on login page");
		
		driver.close();
		
		driver.quit();
	}

}
