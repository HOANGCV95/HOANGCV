package autotest;

import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertArrayEquals;
import static org.testng.AssertJUnit.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Lession07 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\hoangcv\\Desktop\\AUTOTEST\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		  driver=new FirefoxDriver();
		  driver.get("https://www.myntra.com/");
	}
	
	@Test
	public void TC_01() {
		driver.get("https://www.myntra.com/");
		WebElement hover = driver.findElement(By.xpath("//nav[@class='desktop-navbar']//a[text()='Discover']"));
		Actions action = new Actions(driver);
		action.moveToElement(hover).perform();
		action.click();
		WebElement roadster = driver.findElement(By.xpath("//a[text()='Roadster']"));
		action.moveToElement(roadster).click();
	}

@Test
	public void TC_02() {
	 driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
	List<WebElement> elements =driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee']"));
		 Actions action = new Actions(driver);
	}
 @Test
	public void TC_4() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Double click me']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", doubleClick);
		Actions action = new Actions(driver);
		action.doubleClick(doubleClick).perform();
		String verifyMessage = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		assertEquals("Hello Automation Guys!", verifyMessage);
	}

@Test
	public void TC_5() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(rightClick).perform();
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Quit']"))).perform();

	}
@Test
	public void TC_6() {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/angular");
		WebElement drag = driver.findElement(By.xpath("//div[@id='droptarget']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='draggable']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(drag,drop).build().perform();	
}


	
  @AfterClass
  public void afterClass() {
		driver.close();
  }

}
