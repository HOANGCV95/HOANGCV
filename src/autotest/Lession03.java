package autotest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
import static org.junit.Assert.assertEquals;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lession03{
	WebDriver driver;
	
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\hoangcv\\Desktop\\AUTOTEST\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
	  driver.get("https://automationfc.github.io/basic-form/index.html");
	  
  }
	@Test
	  public void TC_1() {
		//hien thi
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Email:']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Age:']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id=\"under_18\"]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Education:']")).isDisplayed());
		//nhap gia tri
	    driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("Automation Testing");
	    driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("Automation Testing");
	    driver.findElement(By.xpath("//input[@id=\"under_18\"]")).click();
	  }
	@Test
	  public void TC_2() {
		//kiem tra enable
		 Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Email:']")).isEnabled());
		  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isEnabled());
		  Assert.assertTrue(driver.findElement(By.xpath("//label[text()='Education:']")).isEnabled());
		  Assert.assertTrue(driver.findElement(By.xpath("//select[@id='job1']")).isEnabled());
		  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='development']")).isEnabled());
		  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='slider-1']")).isEnabled());
		//kiem tra disable
		  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='password']")).isDisplayed());
		  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='radio-disabled']")).isDisplayed());
		  Assert.assertTrue(driver.findElement(By.xpath("//textarea[@id='bio']")).isDisplayed());
		  Assert.assertTrue(driver.findElement(By.xpath("//select[@id='job2']")).isDisplayed());
		  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='check-disbaled']")).isDisplayed());
		  Assert.assertTrue(driver.findElement(By.xpath("//input[@id='slider-2']")).isDisplayed());
		  //chua in duoc
	  }
	@Test
	  public void TC_3() {
		driver.findElement(By.xpath("//input[@id=\"under_18\"]")).click();
		driver.findElement(By.xpath("//input[@id='development']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='development']")).isSelected());
		driver.findElement(By.xpath("//input[@id='development']")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='development']")).isSelected());
	  }
	  
	  
	  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
