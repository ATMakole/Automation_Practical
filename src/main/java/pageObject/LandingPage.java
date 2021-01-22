package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By signIn = By.xpath("//div[@class='container']//div//nav//div//a");
	By womenMenuSection = By.xpath("//*[@id='block_top_menu']/ul/li[1]/a");
	By dressesMenuSection = By.xpath("//*[@id='block_top_menu']/ul/li[2]/a");
	By tshirtsMenuSection = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a");
	By search = By.xpath("//*[@id='search_query_top']");
	By searchButton = By.xpath("//div[@id='page']//div//header//div[3]//div//div//form//button");
	By homeButton = By.xpath("//div[@class='columns-container']//div//div//a");
	By selectItem = By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");
	By addToCart = By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span");
	By tops = By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/a");
	By dresses = By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/a");
	By dressesMenu = By.xpath("//*[@id='block_top_menu']/ul/li[2]/a");
	By casual = By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a");
	By evening = By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[2]/a");
	By summer = By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a");
		
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement AddToCart() 
	{
		return driver.findElement(addToCart);
	}
	
	public WebElement subCasual() 
	{
		return driver.findElement(casual);
	}
	
	public WebElement subEvening() 
	{
		return driver.findElement(evening);
	}
	
	public WebElement subSummer() 
	{
		return driver.findElement(summer);
	}
	
	public WebElement subTops() 
	{
		return driver.findElement(tops);
	}
	
	public WebElement subDresses() 
	{
		return driver.findElement(dresses);
	}
	
	public WebElement dressessMenuSection() 
	{
		return driver.findElement(womenMenuSection);
	}
	
	public WebElement womenMenuSection() 
	{
		return driver.findElement(womenMenuSection);
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
	
	public WebElement homeButton() 
	{
		return driver.findElement(homeButton);
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
