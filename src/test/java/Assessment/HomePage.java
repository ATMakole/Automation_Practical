package Assessment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
//import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import Resources.getExcelData;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.ShoppingCardPage;

public class HomePage extends base
{
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\aaron\\OneDrive\\Documents\\Assessmen_Project\\Assessment\\src\\test\\java\\Resources//TestData.xlsx";
	
	@Test
	public void TC1() throws IOException, InterruptedException 
	{
		driver = initializeDriver();
		driver.get("http://automationpractice.com/"); 
		LandingPage l = new LandingPage(driver);	
		driver.close();
	}
	
	@Test
	public void TC2() throws IOException, InterruptedException 
	{
		driver = initializeDriver();
		driver.get("http://automationpractice.com/"); 
		LandingPage homePage = new LandingPage(driver);
		
		String searchCriteria;
		searchCriteria = "Blouse,Printed Dress,Printed Chiffon Dress";
		
		String[] searchArray = searchCriteria.split(",");
		
		for(int i = 0; i < searchArray.length; i++)
		{
			homePage.search().sendKeys(searchArray[i]);
			homePage.searchButton().click();		
			homePage.homeButton().click();
			//Adding wait 
			//Thread.sleep(1000);
		}
		driver.close();
	}

	@Test
	public void TC3() throws IOException, InterruptedException
	{		
		//Call a method that returns Excel test data
		driver = initializeDriver();
		driver.get(getLoginData("Sheet3")[0][0].toString());
		driver.close();
	}
	
	//@Test
	public void TC4() throws IOException, InterruptedException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("..\\Assessment\\src\\test\\java\\Resources\\data.properties");
		prop.load(fis);
		String email = prop.getProperty("email");
		String password = prop.getProperty("email");
		
		//Driver initialize
		driver = initializeDriver();	
		driver.get("http://automationpractice.com/"); 
		LandingPage homePage = new LandingPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		//Login page
		homePage.getLogin().click();
		loginPage.getEmail().sendKeys(email);
		loginPage.getPassword().sendKeys(password);
		loginPage.getSubmit().click();
		driver.close();
	}

	@Test
	public void TC6_Women() throws IOException, InterruptedException 
	{
		driver = initializeDriver();	
		driver.get("http://automationpractice.com/"); 
		LandingPage l = new LandingPage(driver);
		LoginPage lp = new LoginPage(driver);
		ShoppingCardPage shoppingCard = new ShoppingCardPage(driver);	
		
		for (int i = 0; i <= 1; i++) 
		{
			//Click Menu - Women
			l.WomenMenuCategory().click();
			//Instantiate Action Class        
			Actions actions = new Actions(driver);
			//Retrieve WebElement 'Women' to perform mouse hover 
			WebElement menuOption = l.womenMenuSection();
			//Mouse hover menuOption 'Women' 
			actions.moveToElement(menuOption).perform();
			Thread.sleep(2000);
		
			if (i==0) {
				//Tops
				l.subTops().click();
			} else {
				//Dresses
				l.subDresses().click();
			}
		}		
		
		driver.close();
	}
	
	@Test
	public void TC6_Dresses() throws IOException, InterruptedException 
	{
		driver = initializeDriver();	
		driver.get("http://automationpractice.com/"); 
		LandingPage l = new LandingPage(driver);
		LoginPage lp = new LoginPage(driver);
		
		for (int i = 0; i <= 2; i++) 
		{
			//Click Menu - Dresses
			l.WomenMenuCategory().click();
			//Instantiate Action Class        
			Actions actions1 = new Actions(driver);
			//Retrieve WebElement 'Women' to perform mouse hover 
			WebElement menuOption1 = l.dressessMenuSection();
			//Mouse hover menuOption 'Women' 
			actions1.moveToElement(menuOption1).perform();
			Thread.sleep(2000);
			
			if (i == 0) 
			{
				l.subCasual().click();
			} 
			else if(i == 2) 
			{
				l.subEvening().click();	
			}
			else
			{
				l.subSummer().click();
			}
		}
	}
	
	@Test
	public void TC6_Tshirts() throws IOException, InterruptedException 
	{
		driver = initializeDriver();	
		driver.get("http://automationpractice.com/"); 
		LandingPage l = new LandingPage(driver);
		LoginPage lp = new LoginPage(driver);
		ShoppingCardPage shoppingCard = new ShoppingCardPage(driver);	
		
		//Click Menu - T-shirts
		l.WomenMenuCategory().click();
		//Instantiate Action Class        
		Actions actions3 = new Actions(driver);
		//Retrieve WebElement 'Women' to perform mouse hover 
		WebElement menuOption3 = l.tshirtsMenuCategory();
		//Mouse hover menuOption 'Women' 
		actions3.moveToElement(menuOption3).perform();
		Thread.sleep(2000);
		
		driver.close();
	}
	
	//@Test
	public void TC5() throws IOException, InterruptedException
	{
		driver = initializeDriver();	
		driver.get("http://automationpractice.com/"); 
		LandingPage l = new LandingPage(driver);
		LoginPage lp = new LoginPage(driver);
		ShoppingCardPage shoppingCard = new ShoppingCardPage(driver);	
		
		//Login page
		//l.getLogin().click();
		//lp.getEmail().sendKeys("Aaron.Makole@gmail.com");
		//lp.getPassword().sendKeys("Bells@298");
		//lp.getSubmit().click();
		
		//Click Menu 
		l.WomenMenuCategory().click();
		//Instantiate Action Class        
		Actions actions = new Actions(driver);
		//Retrieve WebElement 'Women' to perform mouse hover 
		WebElement menuOption = l.womenMenuSection();
		//Mouse hover menuOption 'Women' 
		actions.moveToElement(menuOption).perform();	
		//driver.findElement(By.xpath("//div[@class='product-container']//div[2]//div[@class='button-container']//a[@title='Add to cart']")).click();
		Thread.sleep(2000);	
		
		driver.close();
	}
	
	public double calculate(double unitPrice, int quantity)
	{
		return (unitPrice * quantity) + 2;
	}
	
	@DataProvider
	public Object[][] getData() 
	{
		Object[][] data = new Object[2][2];
		//0th row
		data[0][0] = "col 0";
		data[0][1] = "col 1";
		data[0][2] = "col 2";
		
		//1st row
		data[1][0] = "col 0";
		data[1][1] = "col 1";
		data[1][2] = "col 2";
		
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.
		
		return data;
	}
	
	@DataProvider
	public static Object[][] getLoginData(String sheetName) 
	{
		FileInputStream file = null;
		try 
		{
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} 
		catch (FileNotFoundException e) 
		{
			
			//e.printStackTrace();
		}
		
		try 
		{
			book = WorkbookFactory.create(file);
		} 
		catch (InvalidFormatException e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) 
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				//System.out.print(data[i][j] + "\t");
			}
			//System.out.print("\n");
		}
		
		return data;
	}
	
	public void searchArray() throws InterruptedException
	{
		String searchCriteria;
		searchCriteria = "Blouse,Printed Dress,Printed Chiffon Dress";
		
		String[] searchArray = searchCriteria.split(",");
		
		for(int i = 0; i < searchArray.length; i++)
		{
			driver.findElement(By.xpath("//*[@id='search_query_top']")).sendKeys(searchArray[i]);
			driver.findElement(By.xpath("//div[@id='page']//div//header//div[3]//div//div//form//button")).click();		
			driver.findElement(By.xpath("//div[@class='columns-container']//div//div//a")).click();
			
			//Adding wait 
			Thread.sleep(2000);
			System.out.println(searchArray[i] + "\t");
			//Assert.assertEquals(searchArray[i], searchArray[i]);
		}
	}	
}
