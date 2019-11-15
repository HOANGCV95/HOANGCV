package autotest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest3 {
	WebDriver driver;

	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\hoangcv\\Desktop\\AUTOTEST\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
	  driver.get("http://live.demoguru99.com/");
	  
  }
  @Test
  public void TC_1() {
	  //click vao account
	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  //click vao login
	  driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
	  //Kiem tra hien thi
	  String errorEmailMassege = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(); 
	  System.out.println("loi mail"+ errorEmailMassege );
	  String errorPassWordMassege = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(); 
	  System.out.println("loi pass"+ errorPassWordMassege);
	  assertEquals("This is a required field.",errorEmailMassege); 
	  assertEquals("This is a required field.",errorPassWordMassege); 
  }
 
  @Test
  public void TC_2() {
	  driver.findElement(By.xpath("//input[@id='email' and @name=\"login[username]\"]"))
	  .sendKeys("1511551@1516125.5454");
	  driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
	  String errorFomatEmail = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(); 
	 assertEquals("Please enter a valid email address. For example johndoe@domain.com.",errorFomatEmail);
  }
  @Test
  public void TC_3() {
	  driver.findElement(By.xpath("//input[@id='email' and @name=\"login[username]\"]"))
	  .clear();
	  driver.findElement(By.xpath("//input[@id='email' and @name=\"login[username]\"]"))
	  .sendKeys("automation@gmail.com");
	  driver.findElement(By.xpath("//input[ @name=\"login[password]\"]"))
	  .sendKeys("123");
	  driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
	  String errorFomatPass = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(); 
	  assertEquals("Please enter 6 or more characters without leading or trailing spaces.",errorFomatPass);
	  	  
  }
  @Test
  public void TC_4() {
	  driver.findElement(By.xpath("//input[ @name=\"login[password]\"]"))
	  .clear();
	  driver.findElement(By.xpath("//input[ @name=\"login[password]\"]"))
	  .sendKeys("123123123");
	  driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
	  String errorInvalidPass = driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText(); 
	  assertEquals("Invalid login or password.",errorInvalidPass);
	  	  
  }
  @Test
  public void TC_5() {
	  driver.findElement(By.xpath("//input[@id='email' and @name=\"login[username]\"]")).clear();
	  driver.findElement(By.xpath("//input[@id='email' and @name=\"login[username]\"]")).sendKeys("Hoangcv@vnpay.vn");
	  driver.findElement(By.xpath("//input[ @name=\"login[password]\"]")).clear();
	  driver.findElement(By.xpath("//input[ @name=\"login[password]\"]")).sendKeys("123456789");
	  driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
	  String VerifyInfomation= driver.findElement(By.xpath("//div[@class=\"box-content\"] /p[contains(text(),'Chu Hoàng')]")).getText();
	  System.out.print(VerifyInfomation);
	  //so sanh ket qua
	  assertEquals("Chu Hoàng",VerifyInfomation);
	  	  // van fail hic hic
  }

	@Test
	public void TC_6() {
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[contains(text(),'Account')]")).click();
		driver.findElement(By.xpath("//div[@id='header-account']//a[@title='Log Out']")).click();
		driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//div[@class='buttons-set']//span[contains(text(),'Create an Account')]")).click();
	    driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Chu");
		driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("Van");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Hoang");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("Hoangcv" + randomNumber() + "@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='is_subscribed']")).click();
		driver.findElement(By.xpath("//button[@type='submit'and @title='Register']")).click();
		String verifyMessage = driver.findElement(By.xpath("//li/span[contains(string(),'Thank you for registering with Main Website Store.')]")).getText();
		assertEquals("Thank you for registering with Main Website Store.", verifyMessage);
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[contains(text(),'Account')]")).click();
		driver.findElement(By.xpath("//div[@id='header-account']//a[@title='Log Out']")).click();
		System.out.println(verifyMessage);
	}

	public static int randomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(999999);
		return randomNumber;

	}
  
  @AfterTest
  public void afterTest() {
	 driver.quit();
  }

}
