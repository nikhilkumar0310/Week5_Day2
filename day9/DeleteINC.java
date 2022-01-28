package assignments.day9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteINC extends CommonClass {
	
	@Test
	public void deleteExistingINC() throws InterruptedException {
		
		
		String latestINC = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).getText();
		Thread.sleep(3000);
		WebElement searchField = driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]"));
		Thread.sleep(2000);
		searchField.sendKeys(latestINC);
		searchField.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("sysverb_delete_bottom")).click();
		driver.findElement(By.id("ok_button")).click();
		Thread.sleep(2000);
		
		String textNegative = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td")).getText();
		System.out.println(textNegative);
		if(textNegative.contains("No records to display")) {
			System.out.println("The INC has been Deleted from the records");
		}
		else {
			System.out.println("The Deletion Failed");
		}
		
//		int sizeRow = driver.findElements(By.xpath("//table[@id='incident_table']/tbody/tr")).size();
//		List<String> numbersINC = new ArrayList<String>();
//		
//		for(int i=1; i<=sizeRow; i++) {
//			String allINCnumbers = driver.findElement(By.xpath("//table[@id='incident_table']/tbody/tr/td["+ i +"]")).getText();
//			numbersINC.add(allINCnumbers);
//			System.out.println(numbersINC);
//		}
	}

}
