package seleniumPractise.SampleProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.automationexercise.com/");
		System.out.println("Application launched");
		
		String title = driver.getTitle();
		System.out.println("Browser title is - " + title);
		
		driver.findElement(By.cssSelector("a[href='/login']")).click();
		
		String url = driver.getCurrentUrl();
		System.out.println("The Current URL is - " + url);
		
		driver.close();
		
		driver.quit();
		

	}

}
