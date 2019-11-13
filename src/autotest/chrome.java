package autotest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class chrome {
	WebDriver driver;
  @Test
  public void f() {
	  System.out.println("Start test");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\hoangcv\\Desktop\\AUTOTEST\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://github.com/HOANGCV95");  
  }

  @AfterTest
  public void afterTest() {
  }

}
