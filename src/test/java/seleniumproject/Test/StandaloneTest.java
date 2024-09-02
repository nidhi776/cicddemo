package seleniumproject.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import seleniumproject.pageobjects.LandingPage;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName = "ADIDAS ORIGINAL";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		LandingPage landingpage = new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("nidhi.chaudhary@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Nidhi@123");
		driver.findElement(By.id("login")).click();
		
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".offset-md-0")));
		
        List<WebElement> products = driver.findElements(By.cssSelector(".offset-md-0"));
        WebElement prod= products.stream().filter(product-> 
        product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
       
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
       

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
       
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
       
        driver.findElement(By.cssSelector("[routerlink*= 'cart']")).click();
        
        List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
        Boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);
        driver.findElement(By.cssSelector(".totalRow button")).click();
        
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder = 'Select Country']")), "India").build().perform();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        
        
       JavascriptExecutor js = (JavascriptExecutor) driver; 
       js.executeScript("window.scrollBy(1049, 630)"); 
       Thread.sleep(2000);
        
        WebElement cl = driver.findElement(By.xpath("/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a"));
        Thread.sleep(2000);
        cl.click();
        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
       
        
       
       
       
       
       
}


}
