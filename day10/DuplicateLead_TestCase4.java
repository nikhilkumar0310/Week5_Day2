package assignments.day10;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class DuplicateLead_TestCase4 extends LoginPart {
	
	@Test(dependsOnMethods = "assignments.day10.CreateContact_TestCase2.createContact")
	public void dupeLead() throws InterruptedException {
		
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		
		String nameLead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']")).getText();
		System.out.println(nameLead);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a")).click();
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		if(driver.getTitle().contains("Duplicate Lead")) {
			System.out.println("We have the expected Title for Duplicate Lead.");
		}
		else {
			System.out.println("We haven't got the correct Title.");
		}
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		Thread.sleep(8000);
		String duplicateName = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[2]")).getText();
		System.out.println(duplicateName);
		
		if(nameLead.equalsIgnoreCase(duplicateName)) {
			System.out.println("The Duplicate Lead is found.");
		}
		else {
			System.out.println("Not Found");
		}

	}

}
