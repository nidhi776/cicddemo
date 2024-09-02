package seleniumproject.AbstractComponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumproject.pageobjects.CartPage;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*= 'cart']")
	WebElement cartHeader;
	
	

	public void waitForElementToAppear(By findby) {
		
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	
	
	}
	
	
	public void waitForElementToDisappear(WebElement ele) {
		
		//Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.invisibilityOf(ele));
		}
	
	public CartPage goToCartPage() {
		
		 cartHeader.click();
		 CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
}



