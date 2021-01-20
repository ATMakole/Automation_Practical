package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCardPage 
{
	public WebDriver driver;
	
	By addToCart = By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span");
	
	public ShoppingCardPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
}
