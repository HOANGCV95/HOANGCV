package autotest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lession05{
	WebDriver driver;
	
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\hoangcv\\Desktop\\AUTOTEST\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
	  driver.get("https://automationfc.github.io/basic-form/index.html");
	  
  }
	  @Test
		public void TC_1() {
			By job = By.xpath("//select[@id='job1']");
			WebElement job01 = driver.findElement(job);
			Select select = new Select(job01);
			Assert.assertFalse(select.isMultiple());
			select.selectByVisibleText("Automation Tester");
			select.selectByValue("manual");
			select.selectByIndex(4);
			int no2 = select.getOptions().size();
			Assert.assertEquals(no2, 5);
	  }
	  
		
  @AfterTest
  public void afterClass() {
	  driver.quit();
  }

}
