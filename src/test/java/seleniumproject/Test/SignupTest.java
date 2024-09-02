package seleniumproject.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignupTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.booking.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fd8bdbddd9")));
	    WebElement registerButton = modal.findElement(By.className("dbf48415a7"));
	    registerButton.click();
	    driver.findElement(By.className("js-header-login-link")).click();
		driver.findElement(By.className("LkmBPiMnXBfMgmQ98uiP")).sendKeys("nidhichaudhary@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div/div/div/div/div/div/div/form/div[2]/div[2]/button")).click();	
		//driver.findElement(By.cssSelector("//button[@type="submit"]")).click();
		driver.findElement(By.id("new_password")).sendKeys("Nidhi@12345");
		driver.findElement(By.id("confirmed_password")).sendKeys("Nidhi@12345");
		 driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div[1]/div/div/div/div/div/div/div/form/div/button")).click();
		
		
		
	}

}
