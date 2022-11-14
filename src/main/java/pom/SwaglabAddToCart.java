package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SwaglabAddToCart {
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")private WebElement AddToCart;
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement Cart;
	@FindBy(xpath="//button[text()='Remove']")private WebElement Remove;
	@FindBy(xpath="//button[@id='checkout']")private WebElement Checkout;
	@FindBy(xpath="//input[@id='first-name']")private WebElement firstname;
	@FindBy(xpath="//input[@id='last-name']")private WebElement lastname;
	@FindBy(xpath="//input[@id='postal-code']")private WebElement zipcode;
	@FindBy(xpath="//input[@id='continue']")private WebElement Continu;
	@FindBy(xpath="//button[@id='finish']")private WebElement Finish;
	@FindBy(xpath="//h2[text()='THANK YOU FOR YOUR ORDER']")private WebElement thanks;
	@FindBy(xpath="//h2[@class='complete-header']")private WebElement Text;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")private WebElement Menu;
	@FindBy(xpath="//a[@id='logout_sidebar_link']")private WebElement Logout;
	@FindBy(xpath="//a[text()='Twitter']")private WebElement Twitter;
	@FindBy(xpath="//a[text()='Facebook']")private WebElement Facebook;
	@FindBy(xpath="//a[text()='LinkedIn']")private WebElement Linkdlin;
	@FindBy(xpath="//button[@id='continue-shopping']")private WebElement ContinueShipping;
	@FindBy(xpath="//div[text()='1']")private WebElement quantity;
	public SwaglabAddToCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnAddToCart() {
		AddToCart.click();
	}
	public void ClickOnCart() {
		Cart.click();
	}
	public void ClickOnRemove() {
		Remove.click();
	}
	
	public void ClickOnCheckout() {
		Checkout.click();
	}
	public void firstname(String FIRSTNAME) {
		firstname.sendKeys(FIRSTNAME);
	}
	public void lastname(String LASTNAME) {
		lastname.sendKeys(LASTNAME);
	}
	public void zipcode(String CODE) {
		zipcode.sendKeys(CODE);
	}
    public void ClickOnContinue() {
		Continu.click();
	}
    public void ClickOnFinish() {
		Finish.click();
	}
    public void thanksMessage() {
    	boolean actualResult=thanks.isDisplayed();
    	boolean expectedResult=true;
    	Assert.assertEquals(actualResult, expectedResult);
    }
    public void ClickOnText() {
		Text.click();
	}
    public void ClickOnMenu() {
		Menu.click();
	}
    public void ClickOnLogout() {
		Logout.click();
	}
	public void ClickOnTwitter() {
		Twitter.click();
	}
	public void ClickOnFacebook() {
		Facebook.click();
	}
	public void Linkdlin() {
		Linkdlin.click();
	}
	public void ContinueShipping() {
		ContinueShipping.click();
	}
	public void VerifyQuantity() {
	boolean actualResult=quantity.isDisplayed();
	boolean expectedResult=true;
	Assert.assertEquals(actualResult, expectedResult);
	}
	public void VerifyRemove() {
		boolean actualResult=Remove.isDisplayed();
		boolean expectedResult=false;
		Assert.assertEquals(actualResult, expectedResult);
	}
}
