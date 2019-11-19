package autotest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import static org.junit.Assert.assertEquals;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lession04{
	WebDriver driver;
	By userId = By.xpath("//input[@name='uid']");
	By passId = By.xpath("//input[@name='password']");
	By buttonLogin = By.xpath("//input[@name='btnLogin']");
	

	By newName = By.xpath("//input[@name='name']");
	By address = By.xpath("//textarea");
	By city = By.xpath("//input[@name='city']");
	By state = By.xpath("//input[@name='state']");
	By pin = By.xpath("//input[@name='pinno']");
	By mobile = By.xpath("//input[@name='telephoneno']");
	By mail = By.xpath("//input[@name='emailid']");
	By passNew = By.xpath("//input[@name='password']");
	By submit = By.xpath("//input[@type='submit']");
	
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\hoangcv\\Desktop\\AUTOTEST\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
	  driver.get("http://demo.guru99.com/v4/");
	  
  }

 @Test
	public void TC_1() {
		  driver.findElement(userId).sendKeys("mngr233535");
		  driver.findElement(passId).sendKeys("UsapubE");  
		  driver.findElement(buttonLogin).click();
		  driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		  driver.findElement(newName).sendKeys("hoangcv");
		  driver.findElement(address).sendKeys("22 lang ha");
		  driver.findElement(city).sendKeys("ha noi");
		  driver.findElement(state).sendKeys("Vietnam");
		  driver.findElement(pin).sendKeys("123456");
		  driver.findElement(mobile).sendKeys("0356757421");
		  driver.findElement(mail).sendKeys("hoangcv@vnpay.vn");
		  driver.findElement(passNew).sendKeys("123456");
		  //driver.findElement(submit).click();
	  }
@Test
      public void TC_2() {
	  driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
	  driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("mngr233535");
	  driver.findElement(submit).click();	 
	  driver.findElement(newName).clear();
	  driver.findElement(newName).sendKeys("hoangcv");
	  driver.findElement(address).clear();
	  driver.findElement(address).sendKeys("22 lang ha");
	  driver.findElement(city).clear();
	  driver.findElement(city).sendKeys("ha noi");
	  driver.findElement(state).clear();
	  driver.findElement(state).sendKeys("vietnam");
	  driver.findElement(pin).clear();
	  driver.findElement(pin).sendKeys("123456");
	  driver.findElement(mobile).clear();
	  driver.findElement(mobile).sendKeys("0356757421");
	  driver.findElement(mail).clear();
	  driver.findElement(mail).sendKeys("hoangcv@vnpay.vn");
	  driver.findElement(passNew).sendKeys("123456");
	  //driver.findElement(submit).click();
}
	  
	  
	  
  @AfterTest
	  public void afterTest() {
			 driver.quit();
  }

}
