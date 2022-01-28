package assignments.day9;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class CommonClass {
 
	public ChromeDriver driver;
	
  @Parameters({"url", "userName", "passWord"})	
  @BeforeMethod(alwaysRun = true)
  public void preCondition(String url, String userName, String passWord) throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get(url);
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.id("user_name")).sendKeys(userName);
		driver.findElement(By.id("user_password")).sendKeys(passWord);
		driver.findElement(By.id("sysverb_login")).click();
		WebElement filter = driver.findElement(By.id("filter"));
		filter.sendKeys("Incidents");
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("(//div[text()='Incidents'])[1]"))).click().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gsft_main"));
		
  }

  @AfterMethod(alwaysRun = true)
  public void postCondition() {
	  driver.close();
  }

}
