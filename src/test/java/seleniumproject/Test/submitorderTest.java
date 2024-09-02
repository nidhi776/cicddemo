package seleniumproject.Test;
import java.io.IOException;
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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import seleniumproject.TestComponents.BaseTest;
import seleniumproject.pageobjects.CartPage;
import seleniumproject.pageobjects.LandingPage;
import seleniumproject.pageobjects.ProductCatalogue;
import seleniumproject.pageobjects.checkoutPage;
import seleniumproject.pageobjects.confirmationPage;

public class submitorderTest extends BaseTest{
	
	@Test
	
	public void submitOrder() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String productName = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();
		//LandingPage landingpage = launchApplication();
		ProductCatalogue productCatalogue=landingpage.LoginApplication("nidhi.chaudhary@gmail.com", "Nidhi@123");
		productCatalogue.getProductByName(productName);
		productCatalogue.addProductToCart(productName);
		CartPage cartpage = productCatalogue.goToCartPage();
		Boolean match = cartpage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        cartpage.goToCheckout();
        checkoutPage checkoutcart = new checkoutPage(driver);
        checkoutcart.selectCountry("India");
       Thread.sleep(2000);
       confirmationPage confirmationpage = checkoutcart.submitOrder();
       String confirmMessage = confirmationpage.getConfirmatiomPage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();
             
}

}
