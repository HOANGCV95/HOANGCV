package autotest;

import static org.testng.AssertJUnit.assertArrayEquals;
import static org.testng.AssertJUnit.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lession06 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\hoangcv\\Desktop\\AUTOTEST\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
	  driver.get("http://live.demoguru99.com/");
	}
	@Test
	public void TC_01() {
		WebElement myAcc = driver.findElement(
				By.xpath("//a[text()='Orders and Returns']/parent::li/preceding-sibling::li[@class='first']/a"));
		myAcc.click();
		System.out.print(driver.getCurrentUrl());
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://live.demoguru99.com/index.php/customer/account/login/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement createAcc = driver.findElement(By.xpath("//span[text()='Create an Account']"));
		js.executeScript("arguments[0].click();", createAcc);
	}

@Test
	public void TC_02() throws InterruptedException {
		driver.get("https://demos.telerik.com/kendo-ui/styling/checkboxes");
		WebElement dual = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']"));
		if (dual.isDisplayed() && !dual.isSelected()) {
			dual.click();
			Thread.sleep(7000);
		} else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", dual);
			Thread.sleep(7000);
		}
		Assert.assertTrue(dual.isSelected());
	}
@Test
    public void TC_03() throws InterruptedException  {
	driver.get("https://demos.telerik.com/kendo-ui/styling/radios");
	WebElement dual = driver.findElement(By.xpath("//label[text()='2.0 Petrol, 147kW']"));
	if (dual.isDisplayed() && !dual.isSelected()) {
		dual.click();
		Thread.sleep(7000);
	} else {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", dual);
		Thread.sleep(7000);
	}
}
@Test
public void TC_04()  {
	driver.get("https://automationfc.github.io/basic-form/index.html");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement createAcc = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
	createAcc.click();
	Alert mesageTo= driver.switchTo().alert();
	mesageTo.accept();
	WebElement message = driver.findElement(By.xpath("//p[text()='You clicked an alert successfully ']"));
	js.executeScript("arguments[0].scrollIntoView(true);", message);
	Assert.assertEquals(message.getText(), "You clicked an alert successfully ");
}

@Test
public void TC_05() throws InterruptedException  {
	driver.get("https://automationfc.github.io/basic-form/index.html");
	WebElement createAcc = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
	createAcc.click();
	Alert mesageTo= driver.switchTo().alert();
	mesageTo.dismiss();
	WebElement message = driver.findElement(By.xpath("//p[text()='You clicked: Cancel']"));
	Assert.assertEquals(message.getText(), "You clicked: Cancel");
}




	@AfterClass
	public void afterClass() {
		driver.close();
	}

}