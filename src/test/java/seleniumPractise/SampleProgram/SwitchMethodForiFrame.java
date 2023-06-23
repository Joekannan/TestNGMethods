package seleniumPractise.SampleProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchMethodForiFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://skryabin.com/webdriver/html/sample.html");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("additionalInfo");
		driver.findElement(By.id("contactPersonName")).sendKeys("Jothi");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.name("phone")).sendKeys("123456789");
		
		
		driver.close();
		driver.quit();
	}

}
