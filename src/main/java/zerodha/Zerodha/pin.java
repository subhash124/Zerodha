package zerodha.Zerodha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pin {
	@FindBy(xpath="//input[@id='pin']")private WebElement pin;
	@FindBy(xpath="//button[@type='submit']") private WebElement submit;
	
	public pin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void setPin(String PIN) {
		pin.sendKeys(PIN);
	}
	public void clickSubmit() {
		submit.click();
	}
	

}
