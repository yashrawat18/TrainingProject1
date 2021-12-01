

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {

	WebDriver driver;
	By popUp=By.className("email-capture__close");
	By signIn=By.xpath("/html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[3]/div[1]/nav[1]/div[6]/a[1]/span[1]");
	By CreatAcc=By.linkText("Create an account");
	By FirstName=By.id("mat-input-3");
	By LastName=By.id("mat-input-4");
	By MonthClk=By.id("mat-select-value-1");
	By MonthEnter=By.xpath("//*[@id=\"mat-option-7\"]/span");
	By DayClk=By.id("mat-select-value-3");
	By DayEnter=By.xpath("//*[@id=\"mat-option-14\"]/span");
	By Year=By.id("mat-input-5");
	By CountryClk=By.xpath("//*[@id=\"mat-select-value-5\"]/span");
	By CountryEnter=By.xpath("//*[@id=\"mat-option-145\"]/span");
	By Email=By.id("mat-input-2");
	By Pass=By.id("mat-input-6");
	By QueClk=By.xpath("//*[@id=\"mat-select-value-7\"]/span");
	By QueEnter=By.xpath("//*[@id=\"mat-option-293\"]/span");
	By Ans=By.id("mat-input-7");
	By checkBox=By.xpath("//*[@id=\"mat-checkbox-2\"]/label/span[1]");
	By SigninButton=By.xpath("/html/body/app-root/div/app-signup/main/div[1]/div[11]/button");
	public Register(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void Home() throws InterruptedException {
		Thread.sleep(15000);
		driver.findElement(popUp).click();
		Thread.sleep(1000);
		driver.findElement(signIn).click();
		Thread.sleep(10000);
        driver.findElement(CreatAcc).click();
		Thread.sleep(10000);

	}
	public void Register(String FN,String LN, String Yr, String email, String pass, String ans) throws InterruptedException {
		Thread.sleep(1000);

	driver.findElement(FirstName).sendKeys(FN);
		Thread.sleep(1000);
     driver.findElement(LastName).sendKeys(LN);
		Thread.sleep(1000);
       driver.findElement(MonthClk).click();
		Thread.sleep(1000);
      driver.findElement(MonthEnter).click();
		Thread.sleep(1000);
     driver.findElement(DayClk).click();
		Thread.sleep(1000);
     driver.findElement(DayEnter).click();
		Thread.sleep(1000);
     driver.findElement(Year).sendKeys(Yr);
		Thread.sleep(1000);
     driver.findElement(CountryClk).click();
		Thread.sleep(1000);
      driver.findElement(CountryEnter).click();
		Thread.sleep(1000);
     driver.findElement(Email).sendKeys(email);
		Thread.sleep(1000);
     driver.findElement(Pass).sendKeys(pass);
		Thread.sleep(1000);
     driver.findElement(QueClk).click();
		Thread.sleep(1000);
     driver.findElement(QueEnter).click();
		Thread.sleep(1000);
     driver.findElement(Ans).sendKeys(ans);
		Thread.sleep(1000);
     driver.findElement(checkBox).click();
		Thread.sleep(1000);
     driver.findElement(SigninButton).click();
		Thread.sleep(1000);
}
}





___________________________Main__________________

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
	
	String FN="Yogeshwari";
	String LN="Sonavane";
	String Yr= "1999";
	String email="yogeshwarisonavane@gmail.com";
	String pass="yogi_123";
	String ans="Madhyamic";
	reg.Register(FN, LN, Yr, email, pass, ans);
}
}


