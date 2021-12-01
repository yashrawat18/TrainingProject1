package Datadriven;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.Login;

public class Test {
	

	
	public static void main(String[] args) throws Exception {			
		FileInputStream fis = new FileInputStream("C:\\Users\\vishal verma\\Downloads");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		String name = sheet.getRow(0).getCell(0).getStringCellValue();
		String pass = sheet.getRow(0).getCell(1).getStringCellValue();
	
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vishal verma\\Downloads\\chromedriver_win32\\chromedriver.exe");
	          ChromeDriver    driver = new ChromeDriver();
	          driver.get("https://www.royalcaribbean.com/");
	          driver.manage().window().maximize();
	          Thread.sleep(15000);
	          Sign_in obj =new Sign_in(driver);
	       obj.Home();
	       obj.login(name,pass);
	      Thread.sleep(1000);
	      obj.close();
		
	}

}
