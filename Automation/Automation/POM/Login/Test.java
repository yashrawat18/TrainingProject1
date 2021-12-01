package POM;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vishal verma\\Downloads\\chromedriver_win32\\chromedriver.exe");
	          ChromeDriver    driver = new ChromeDriver();
	          driver.get("https://www.royalcaribbean.com/");
	          driver.manage().window().maximize();
	          Thread.sleep(15000);
	       Login obj =new Login(driver);
	       obj.Home();
	      
	       String name="vishal39715@gmail.com";
	       String pass ="Vishal@1234";
	       obj.login(name, pass);
	      Thread.sleep(1000);
	      obj.close();
	          
	          
	}

}
