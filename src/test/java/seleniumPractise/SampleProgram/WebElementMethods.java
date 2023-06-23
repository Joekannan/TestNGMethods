package seleniumPractise.SampleProgram;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://skryabin.com/webdriver/html/sample.html");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("name")).click();
		
		driver.findElement(By.id("firstName")).sendKeys("Nagajothi");
		
		driver.findElement(By.id("middleName")).click();
		driver.findElement(By.id("middleName")).sendKeys("N/A");
		
		
		driver.findElement(By.id("lastName")).click();
		driver.findElement(By.id("lastName")).sendKeys("Kaliappan");
		
		driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();
		
		
		WebElement country = driver.findElement(By.name("countryOfOrigin"));
		Select dropdown = new Select(country);
		dropdown.selectByVisibleText("Japan");
		
		dropdown.selectByIndex(1);
		
		
		driver.findElement(By.id("address")).sendKeys("abc street, new zealand");
		
		List<WebElement> gender = driver.findElements(By.name("gender"));
		gender.get(0).click(); // male
		gender.get(1).click(); // female
		
		WebElement carMake = driver.findElement(By.name("carMake"));
		
		Select car = new Select(carMake);
		car.selectByVisibleText("BMW");
		
		
		driver.close();
		driver.quit();

	}

}
