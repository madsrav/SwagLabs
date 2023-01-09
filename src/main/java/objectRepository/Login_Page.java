package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {

	@FindBy(id="user-name")
	 private WebElement uname;
	@FindBy(id="password")
	private WebElement pwd;
	@FindBy(id="login-button")
	private WebElement submit;
	
	public Login_Page(WebDriver driver)
	{
	  PageFactory.initElements(driver, this);
	}

	public WebElement getUname() {
		return uname;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	public void Login(String username,String password)
	{
	uname.sendKeys(username);
	pwd.sendKeys(password);
	submit.click();
	}


}
