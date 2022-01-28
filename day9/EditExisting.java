package assignments.day9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EditExisting extends CommonClass{
	
	@Test
	public void editExistingINC() throws InterruptedException {
	
		
		String latestINC = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).getText();
		Thread.sleep(3000);
		WebElement searchField = driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]"));
		Thread.sleep(2000);
		searchField.sendKeys(latestINC);
		searchField.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).click();
		Thread.sleep(3000);
		WebElement ddSeverity = driver.findElement(By.xpath("//select[@name='incident.urgency']"));
		
		Select ddOption = new Select(ddSeverity);
		ddOption.selectByValue("1");
		String priority = ddSeverity.getText();
		
		WebElement ddState = driver.findElement(By.xpath("//select[@name='incident.state']"));
		Select ddStateOptions = new Select(ddState);
		ddStateOptions.selectByVisibleText("In Progress");
		String state = ddState.getText();
		
		if(priority.contains("1 - High") && state.contains("In Progress")) {
			System.out.println("The fields have been updated correctly.");
		}
		
		driver.findElement(By.id("sysverb_update_bottom")).click();
	}

}
