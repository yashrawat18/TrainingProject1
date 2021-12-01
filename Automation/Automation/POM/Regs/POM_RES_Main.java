package Page_Object_Model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
public static void main(String args[]) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver=new ChromeDriver();
	 driver.get("https://www.royalcaribbean.com/");
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	driver.manage().window().maximize();
	
	Register reg=new Register(driver);
	reg.Home();
	
	String FN="Sham";
	String LN="ghatkar";
	String Yr= "1999";
	String email="shamghatkar@gmail.com";
	String pass="Sham@123";
	String ans="EnglishMedium";
	reg.Register(FN, LN, Yr, email, pass, ans);
}
}