package seleniumPractise.SampleProgram;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BriscoesTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.briscoes.co.nz/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='icon-wrapper icon-cart']")).click();

	}

}
