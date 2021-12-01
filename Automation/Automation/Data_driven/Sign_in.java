import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sign_in {
	 WebDriver driver;
	 public Sign_in(WebDriver driver) {
	 	super();
	 	this.driver = driver;
	 }
	 By username =By.id("mat-input-0");
	 By check_box =By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-login-hybris[1]/div[1]/main[1]/form[1]/div[1]/shared-hybris-input-checkbox[1]/div[1]/mat-checkbox[1]/label[1]/span[1]");
	 By password =By.id("Password");
	 By popup =By.className("email-capture__close");
	 By signin =By.id("rciHeaderSignIn");
	 By button =By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-login-hybris[1]/div[1]/main[1]/form[1]/div[2]/shared-hybris-button[1]/button[1]");
	 public void login(String name,String pass ) throws Exception {
	 	
	 	Thread.sleep(1000);
	 	driver.findElement(username).sendKeys(name);;
	 	Thread.sleep(1000);
	 	
	 	driver.findElement(password).sendKeys(pass);;
	 	Thread.sleep(1000);
	 	driver.findElement(check_box).click();
	 	
	 	driver.findElement(button).click();
	 }

	 public void Home() throws InterruptedException {
	 driver.findElement(popup).click();
	 Thread.sleep(10000);
	 driver.findElement(signin).click();
	 Thread.sleep(10000);
	 }
	 public void close() {
	 	driver.quit();
	 }
}
