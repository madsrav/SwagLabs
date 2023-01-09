package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement addShirt;
	@FindBy(id="react-burger-menu-btn")
	private WebElement clickBurgerMenu;
	@FindBy(id="logout_sidebar_link")
	private WebElement logout;
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement clickCart;

	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddShirt() {
		return addShirt;
	}

	public WebElement getClickBurgerMenu() {
		return clickBurgerMenu;
	}

	public WebElement getClickCart() {
		return clickCart;
	}
	public WebElement getLogout() {
		return logout;
	}

	public void home()
	{
		addShirt.click();
		clickCart.click();  
	}
	public void logout()
	{	
		clickBurgerMenu.click();
		logout.click();
	}	
}
