package seleniumPractise.SampleProgram;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchMethods {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		handleAlert(driver);
//		handleNestedFrames(driver);
		
		driver.get("http://skryabin.com/webdriver/html/sample.html");
		
		driver.findElement(By.id("thirdPartyButton")).click();
		
		//Switch Methods for Alert - Accept
		driver.switchTo().alert().accept();
		String result = driver.findElement(By.id("thirdPartyResponseMessage")).getText();
		System.out.println("The result of accepting the alert is - " + result);
		
		driver.findElement(By.id("thirdPartyButton")).click();
		//Switch Methods for Alert - Cancel
		driver.switchTo().alert().dismiss();
		String result1 = driver.findElement(By.id("thirdPartyResponseMessage")).getText();
		System.out.println("The result of dismissing the alert is - " + result1);
		
		//Switch Methods for Frames
		driver.switchTo().frame("additionalInfo");
		System.out.println("Switching to iframe");
		driver.findElement(By.id("contactPersonName")).sendKeys("joekannan");
		driver.findElement(By.id("contactPersonPhone")).sendKeys("0123456789");
		System.out.println("Entered the details inside frame elements");
		driver.switchTo().defaultContent();
		System.out.println("Switching to main page");
		
		//Switch Method for Windows
		//Xpath = XML Path Language
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window  - " + parentWindow);
		driver.findElement(By.xpath(".//button[contains(.,'Related documents (click)')]")).click();
		Set<String>allWindows = driver.getWindowHandles();
		for(String windowHandle : allWindows) {
			driver.switchTo().window(windowHandle);
			System.out.println("No of opened Windows -" +allWindows.size() );
			System.out.println("Windows are - " + windowHandle );
		}
		String newWindowTitle = driver.getTitle();
		System.out.println("New Window title is - " + newWindowTitle);
		
		driver.switchTo().window(parentWindow);
		String parentWindowTitle = driver.getTitle();
		System.out.println("New Window title is - " + parentWindowTitle);
		
		System.out.println(driver.switchTo().activeElement().getTagName());
		
		driver.close();
		driver.quit();

	}
	
	public static void handleAlert(WebDriver driver) {
		driver.get("https://demoqa.com/alerts");
		
		//Simple Alert
		driver.findElement(By.id("alertButton")).click();
		System.out.println("Simple Alert - Get Text is " + driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		System.out.println("Simple Alert is accepted");
		
		//Confirmation Alert - Accept
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().accept();
		System.out.println("Confirmation Alert is accepted");
		
		//Confirmation Alert - Reject
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
		System.out.println("Confirmation Alert is dismissed");
		
		//Prompt Alert
		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys("Hello");
		System.out.println("Text Entered in the prompt alert's textbox");
		driver.switchTo().alert().accept();
		
		}
	
	public static void handleNestedFrames(WebDriver driver) {
		//Frames
		driver.get("https://demoqa.com/frames");
		List<WebElement>iFrames = driver.findElements(By.tagName("iframe"));
		System.out.println("No of iFrames - " + iFrames.size());
		driver.switchTo().frame(driver.findElement(By.id("frame1")));
		System.out.println("Frame 1 - " +driver.findElement(By.id("sampleHeading")).getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("frame2")));
		System.out.println("Frame 2 - " +driver.findElement(By.id("sampleHeading")).getText());
		
		
		
		//Nested Frames
		driver.get("https://demoqa.com/nestedframes");
		List<WebElement>nestedFrames = driver.findElements(By.tagName("iframe"));
		System.out.println("No of Nested Frames - " + nestedFrames.size());
		driver.switchTo().frame("frame1");
		System.out.println("Parent Frame " +driver.findElement(By.tagName("body")).getText());
		driver.switchTo().frame(0);
		System.out.println("Child Frame " +driver.findElement(By.tagName("p")).getText());
		driver.switchTo().parentFrame();
		System.out.println("Parent Frame " +driver.findElement(By.tagName("body")).getText());
		driver.switchTo().defaultContent();
		System.out.println(driver.switchTo().activeElement().getTagName());
		
		}

}
