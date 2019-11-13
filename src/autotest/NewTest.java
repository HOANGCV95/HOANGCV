package autotest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
  @Test
  public void f() {
	  System.out.println("Start test");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\hoangcv\\Desktop\\AUTOTEST\\geckodriver-v0.26.0-win64\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.get("https://github.com/HOANGCV95");
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
