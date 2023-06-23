package seleniumPractise.SampleProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchMethodForAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("alertButton")).click();
		driver.switchTo().alert().accept();
		System.out.println("A simple alert has been accepted");
		
		
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().accept();
		System.out.println("A alert has been accepted");
		
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
		System.out.println("A alert has been dismissed");
		
		
		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys("Hello");
		driver.switchTo().alert().accept();
		System.out.println("Handled the prompt alert");

	}

}
