package objectRepository;

import java.util.Locale;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

public class Your_Cart {
	
	@FindBy(id="checkout")
	private WebElement checkout;
	@FindBy(id="first-name")
	private WebElement firstname;
	@FindBy(id="last-name")
	private WebElement lastname;
	@FindBy(id="postal-code")
	private WebElement postcode;
	@FindBy(id="continue")
	private WebElement continuecart;
	@FindBy(id="finish")
	private WebElement finish;
	
	
	public Your_Cart(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getContinuecart() {
		return continuecart;
	}
	public WebElement getFinish() {
		return finish;
	}
	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getPostcode() {
		return postcode;
	}
	public int generateRandomNumber(int range)
	{
	Random random= new Random();
	return random.nextInt(range);
	}
    Faker faker = new Faker(new Locale("en-IND"));
    public String generateFirstName()
	{
		return faker.name().firstName();
	}

	public String generatelastname()
	{
		return faker.name().lastName();
	}
	public String generatepincode()
	{
		return faker.number().digits(5);
		
	}
 public void taskpage()
 {
	 checkout.click();
	 firstname.sendKeys(generateFirstName()+generateRandomNumber(99));
	 lastname.sendKeys(generatelastname()+generateRandomNumber(99));
	 postcode.sendKeys(generatepincode());
	 continuecart.click();
	 finish.click();		 
 }
}
