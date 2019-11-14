package autotest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTest2 {
	WebDriver driver;

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\hoangcv\\Desktop\\AUTOTEST\\geckodriver-v0.26.0-win64\\geckodriver.exe");
	  driver=new FirefoxDriver();
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
	  AssertJUnit.assertEquals("This is a required field.",errorEmailMassege); 
	  AssertJUnit.assertEquals("This is a required field.",errorPassWordMassege); 
  }
 
  @Test
  public void TC_2() {
	  driver.findElement(By.xpath("//input[@id='email' and @name=\"login[username]\"]"))
	  .sendKeys("1511551@1516125.5454");
	  driver.findElement(By.xpath("//button[@id=\"send2\"]")).click();
	  String errorFomatEmail = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(); 
	  AssertJUnit.assertEquals("Please enter a valid email address. For example johndoe@domain.com.",errorFomatEmail);
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
	  AssertJUnit.assertEquals("Please enter 6 or more characters without leading or trailing spaces.",errorFomatPass);
	  	  
  }
  
  
  @AfterTest
  public void afterTest() {
  }

}
