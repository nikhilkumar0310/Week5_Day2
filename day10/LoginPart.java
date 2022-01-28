package assignments.day10;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class LoginPart {
	
	public ChromeDriver driver;
	
  @Parameters({"url", "userID", "pwd"})
  @BeforeMethod(alwaysRun = true)
  public void preCondition(String url, String userID, String pwd) {
	  WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		driver.get(url);
		
		driver.findElement(By.id("username")).sendKeys(userID);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.xpath("//a[normalize-space(text()='CRM/SFA')]")).click();
		
  }

  @AfterMethod(alwaysRun = true)
  public void postCondition() {
	  driver.close();
  }

}
