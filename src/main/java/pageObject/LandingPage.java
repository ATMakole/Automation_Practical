package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signIn = By.xpath("//div[@class='container']//div//nav//div//a");
	By womenMenuOption = By.xpath("//div[@id='center_column']//ul//li[1]//div//div[1]//div//a[1]//img");
	By womenMenuSection = By.xpath("//*[@id='block_top_menu']/ul/li[1]/a");
	By dressesMenuSection = By.xpath("//*[@id='block_top_menu']/ul/li[2]/a");
	By tshirtsMenuSection = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a");
	By search = By.xpath("//*[@id='search_query_top'");
	By searchButton = By.xpath("//*[@id='searchbox']/button");//*[@id="center_column"]/ul/li/div/div[1]/div/a[1]/img
	By selectItem = By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");
	By addToCart = By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span");
	//By womenCategory = By.xpath("//div[@class='row']//div[6]//ul//li//a[@title='Women']");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement womenMenuOption() 
	{
		return driver.findElement(womenMenuOption);
	}
	
	public WebElement getLogin() 
	{
		return driver.findElement(signIn);
	}
	
	public WebElement WomenMenuCategory() 
	{
		return driver.findElement(womenMenuSection);
	}
	
	public WebElement dressesMenuCategory() 
	{
		return driver.findElement(dressesMenuSection);
	}
	
	public WebElement tshirtsMenuCategory() 
	{
		return driver.findElement(tshirtsMenuSection);
	}
	
	public WebElement search() 
	{
		return driver.findElement(search);
	}
	
	public WebElement searchButton() 
	{
		return driver.findElement(searchButton);
	}
	
	public WebElement selectItem() 
	{
		return driver.findElement(selectItem);
	}
	
	public WebElement addItem() 
	{
		return driver.findElement(addToCart);
	}
}
