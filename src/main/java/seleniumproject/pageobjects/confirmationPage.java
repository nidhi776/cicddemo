package seleniumproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumproject.AbstractComponent.AbstractComponent;

public class confirmationPage extends AbstractComponent {
 
	WebDriver driver;
	public confirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(css=".hero-primary")
	WebElement confirmMessage;
	
	
	public String getConfirmatiomPage() {
		
		return confirmMessage.getText();
		
	}

}
