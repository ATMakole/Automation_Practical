package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
public WebDriver driver;
	
	By email = By.xpath("//div[@class='col-xs-12 col-sm-6']//div//input[@id='email']");
	By password = By.xpath("//div[@class='col-xs-12 col-sm-6']//div//div//input[@id='passwd']");
	By login = By.xpath("//div[@class='col-xs-12 col-sm-6']//div//p//button[@id='SubmitLogin']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmail() 
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword() 
	{
		return driver.findElement(password);
	}
	
	public WebElement getSubmit() 
	{
		return driver.findElement(login);
	}

}
