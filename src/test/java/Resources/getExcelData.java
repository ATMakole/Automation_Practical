package Resources;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getExcelData {
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
    public static void main( String[] args )
    {
        //getRowCount();
        //getGetCellData();
    	getRowCount();
    }
    
    public static void getRowCount()
    {
    	String projectPath = System.getProperty("user.dir");
    	
    	System.out.println(projectPath);
    	
    	try 
    	{
			 workbook = new XSSFWorkbook("C:\\Users\\aaron\\OneDrive\\Documents\\Assessmet\\TestData\\TestData.xlsx");
			 sheet = workbook.getSheet("Sheet1");
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println(rowCount);
		} 
    	catch (Exception e) 
    	{
			// TODO: handle exception
    		e.getMessage();
    		e.getCause();
    		e.printStackTrace();
		}
    }
    
    public static void getGetCellData()
    {
    	try 
    	{
			 workbook = new XSSFWorkbook("C:\\Users\\aaron\\OneDrive\\Documents\\Assessmet\\TestData\\TestData.xlsx");
			 sheet = workbook.getSheet("Sheet1");
			 		//System.out.println(sheet.getRow(1).getCell(0).getNumericCellValue());
					System.out.println(sheet.getRow(1).getCell(0).getStringCellValue().toString() + "\t");
		} 
    	catch (Exception e) 
    	{
			// TODO: handle exception
    		e.getMessage();e.getCause();e.printStackTrace();
		}
    }
}
