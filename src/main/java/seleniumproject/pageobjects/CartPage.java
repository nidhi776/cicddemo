package seleniumproject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumproject.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
      
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartproducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutele;
	
	
	public boolean verifyProductDisplay(String productName) {
		
		Boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
        return match;
	}
	
	public checkoutPage goToCheckout() {
		
		checkoutele.click();
		return new checkoutPage(driver);
		
	}
	
	
	
	

}
