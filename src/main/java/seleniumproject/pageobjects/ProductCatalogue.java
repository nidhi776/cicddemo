package seleniumproject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import seleniumproject.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	
	public ProductCatalogue(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	// List<WebElement> products = driver.findElements(By.cssSelector(".offset-md-0"));
	
	//@FindBy(id=".offset-md-0")
	//List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".offset-md-0");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	
	//public List<WebElement> getProductList() {
		

		// waitForElementToAppear(productsBy);
		// return products;

	//}
	
	public WebElement getProductByName(String productName){
		
		waitForElementToAppear(productsBy);
		 List<WebElement> products = driver.findElements(By.cssSelector(".offset-md-0"));
		WebElement prod= products.stream().filter(product-> 
        product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	     return prod;
		
	}
	
	public void addProductToCart(String productName) {
		
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		 waitForElementToAppear(toastMessage); 
		 waitForElementToDisappear(spinner);
		
	}
	
	

}