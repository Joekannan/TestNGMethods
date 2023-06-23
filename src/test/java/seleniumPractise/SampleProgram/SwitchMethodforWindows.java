package seleniumPractise.SampleProgram;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchMethodforWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://skryabin.com/webdriver/html/sample.html");
		driver.manage().window().maximize();
		
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		
		Thread.sleep(10);
		
		driver.findElement(By.xpath(".//button[contains(.,'Related documents (click)')]")).click();
		
		Set<String>allWindows = driver.getWindowHandles();
		System.out.println(allWindows);
		
		for(String window : allWindows) {
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
		}
		
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.name("phone")).sendKeys("123456789");
		driver.close();
		
		driver.quit();

	}

}
