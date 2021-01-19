package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException 
	{
		//Chrome
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\aaron\\OneDrive\\Documents\\Assessmen_Project\\Assessment\\src\\test\\java\\Resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\aaron\\OneDrive\\Documents\\Assessmen_Project\\chromedriver_win32\\1\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\aaron\\OneDrive\\Documents\\Assessmen_Project\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("Edge"))
		{
			// Defining System Property for the IEDriver 
			System.setProperty("webdriver.edge.driver", "C:\\Users\\aaron\\OneDrive\\Documents\\Assessmen_Project\\edgedriver_win64\\msedgedriver.exe"); 
			driver = new EdgeDriver();
		}
		//Maximize current window 
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}

	
}
