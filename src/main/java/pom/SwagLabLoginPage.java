package pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Parametrization;

public class SwagLabLoginPage {
@FindBy(xpath="//input[@id='user-name']")private WebElement username;
@FindBy(xpath="//input[@id='password']")private WebElement pass;
@FindBy(xpath="//input[@id='login-button']")private WebElement login;
 
public  SwagLabLoginPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void EnterUsername(int row,int cell) throws EncryptedDocumentException, IOException {
	username.sendKeys(Parametrization.getaxle(row,cell, "Credentials"));
}
public void EnterPass(int row,int cell) throws EncryptedDocumentException, IOException {
	pass.sendKeys(Parametrization.getaxle(row,cell, "Credentials"));
}
public void ClickOnLogin() {
	login.click();
}
}
