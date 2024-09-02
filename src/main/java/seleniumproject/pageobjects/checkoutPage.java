package seleniumproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import seleniumproject.AbstractComponent.AbstractComponent;

public class checkoutPage extends AbstractComponent{

	WebDriver driver; 
	public checkoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder = 'Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(xpath="/html/body/app-root/app-order/section/div/div/div[2]/div/div/div[3]/div[2]/div[2]/div/div[2]/a")
	WebElement submit;
	
	
	By result = By.cssSelector(".ta-item");
	
	public void selectCountry(String countryName) {
		
	  Actions a = new Actions(driver);
      a.sendKeys(country, countryName).build().perform();
      
      waitForElementToAppear(result);
      selectCountry.click();
      JavascriptExecutor js = (JavascriptExecutor) driver; 
      js.executeScript("window.scrollBy(1049, 630)");
	}
	
	
	public confirmationPage submitOrder() throws InterruptedException {
		
		submit.click();
		 Thread.sleep(2000);
		 return new confirmationPage(driver);
	}
	
	

}
