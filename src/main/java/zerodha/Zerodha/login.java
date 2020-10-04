package zerodha.Zerodha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	@FindBy(xpath="//input[@id='userid']")private WebElement id;
	@FindBy(xpath="//input[@id='password']")private WebElement pas;
	@FindBy(xpath="//button[@type='submit']")private WebElement click;
	
	public login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void setid(String ID) {
		id.sendKeys(ID);
	}
	public void setPAs(String PAS) {
		pas.sendKeys(PAS);
	}
	public void clickLogin() {
		click.click();
	}

}
