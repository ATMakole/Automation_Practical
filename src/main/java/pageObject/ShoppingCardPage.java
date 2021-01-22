package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCardPage 
{
	public WebDriver driver;
	
	public ShoppingCardPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	By selectItem = By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img");
	By increment = By.xpath("//*[@id='quantity_wanted_p']/a[2]/span/i");
	By addToCart = By.xpath("//*[@id='add_to_cart']/button/span");
	By proceed = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span");
	By getTotalPrice = By.xpath("//*[@id='total_price']");
	By getUnitPrice = By.xpath("//*[@id='cart_summary']/tbody/tr/td[4]/span/span[@class='price special-price']");

	public WebElement getUnitPrice() 
	{
		return driver.findElement(getUnitPrice);
	}
	
	public WebElement getTotalPrice() 
	{
		return driver.findElement(getTotalPrice);
	}
	
	public WebElement proceed() 
	{
		return driver.findElement(proceed);
	}	
	
	public WebElement addToCart() 
	{
		return driver.findElement(addToCart);
	}	
	
	public WebElement selectItem() 
	{
		return driver.findElement(selectItem);
	}	
	
	public WebElement increment() 
	{
		return driver.findElement(increment);
	}
}
