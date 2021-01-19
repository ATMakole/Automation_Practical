package Assessment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.ShoppingCardPage;

public class HomePage extends base{

	@Test//(dataProvider="getLoginData")
	public void basePageNavigation() throws IOException, InterruptedException 
	{
		LandingPage l = new LandingPage(driver);
		LoginPage lp = new LoginPage(driver);
		ShoppingCardPage shoppingCard = new ShoppingCardPage(driver);	
		
		driver = initializeDriver();	
		driver.get("http://automationpractice.com/"); 
		
		//Login page
		l.getLogin().click();
		lp.getEmail().sendKeys("Aaron.Makole@gmail.com");
		lp.getPassword().sendKeys("Bells@298");
		lp.getSubmit().click();
		
		//Click Menu 
		l.WomenMenuCategory().click();
		
		
			
		//Instantiate Action Class        
		Actions actions = new Actions(driver);
		//Retrieve WebElement 'Women' to perform mouse hover 
		WebElement menuOption = driver.findElement(By.xpath("//div[@id='center_column']//ul//li[1]//div//div[1]//div//a[1]//img"));
		//Mouse hover menuOption 'Women' 
		actions.moveToElement(menuOption).perform();
				
		
		shoppingCard.
		
				driver.findElement(By.xpath("//div[@class='product-container']//div[2]//div[@class='button-container']//a[@title='Add to cart']")).click();
								
				
	    		driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
				driver.findElement(By.xpath("//*[@id='cart_quantity_up_1_1_0_417153']/span/i")).click();
				driver.findElement(By.xpath("//*[@id='cart_quantity_up_1_1_0_417153']/span/i")).click();
							
				//Adding wait 
				Thread.sleep(9000);
				driver.findElement(By.xpath("//*[@id='product_price_1_1_417153']/span")); //*[@id="total_price"] //*[@id="total_price"]
				int quantity = Integer.parseInt(driver.findElement(By.xpath("//*[@id='product_1_1_0_417153']/td[5]/input[2]")).getText());
				
				//Adding wait 
				Thread.sleep(9000);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				String heading = driver.findElement(By.xpath("//*[@id='product_price_1_1_417153']/span")).getText();
				
				//Adding wait 
				Thread.sleep(9000);
				double d=Double.parseDouble(heading.substring(1, heading.length()));System.out.println(d);
				String total = driver.findElement(By.xpath("//*[@id='total_product_price_1_1_417153']")).getText();
				
				JOptionPane jop = new JOptionPane();
				//JOptionPane.showMessageDialog(Frame, "Eggs are not supposed to be green.");
				
				//if((d*3) == calculate(d, quantity))
				////System.out.println(d);
				// else
					//System.out.println(total);
				
				getLoginData("Sheet1");
				
				searchArray();
				
		/*
		l.WomenMenuOption().click();
		l.dressesMenuOption().click();
		l.tshirtsMenuOption().click();
			
		l.search().sendKeys("Faded Short Sleeve T-shirt");
		l.searchButton().click();
		l.selectItem().click();
		l.addItem().click();*/
		//driver.close();
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
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\aaron\\OneDrive\\Documents\\Assessmet\\TestData\\TestData.xlsx";
	
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
				System.out.print(data[i][j] + "\t");
			}
			System.out.print("\n");
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
			Thread.sleep(9000);
			System.out.println(searchArray[i] + "\t");
			//Assert.assertEquals(searchArray[i], searchArray[i]);
			
		}
	}
	
	public void genericNav(WebDriver driver,Object obj, String url, String subUrl)
	{
		
		//Instantiate Action Class        
        Actions actions = new Actions(driver);
        //Retrieve WebElement 'Women' to perform mouse hover 
    	WebElement menuOption = driver.findElement(By.xpath("//div[@id='center_column']//ul//li[1]//div//div[1]//div//a[1]//img"));
    	//Mouse hover menuOption 'Women' 
    	actions.moveToElement(menuOption).perform();
    	
    	
	}
	
}

/*
public static Ranorex.WebElement getEle(string path, int timeout){
			Element ele = null;
			Host.Local.TryFindSingle(path, timeout, out ele);
			try{WebElement we = new WebElement(ele);return we;}
			catch{
					if(path.Equals("path")) {
						Report.Log(ReportLevel.Info, "Form not found, waiting for form to load.");
					}else{
						Report.Log(ReportLevel.Warn, "Not found: "+path);
					}
			}
*/
