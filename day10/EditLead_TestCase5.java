package assignments.day10;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditLead_TestCase5 extends LoginPart {

	@Test(dependsOnMethods = "assignments.day10.DuplicateLead_TestCase4.dupeLead")
	public void editLead() throws InterruptedException {
		
	
		String orgName = "Steam Electronics";
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Amudhini");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click();
		Thread.sleep(3000);
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("We are on the Correct Page");
		}
		else {
			System.out.println("Not the expected Page");
		}
		driver.findElement(By.linkText("Edit")).click();
		
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(orgName);
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(3000);
		
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(companyName.contains(orgName)) {
			System.out.println("The Company Name Has been updated");
		}
		else {
			System.out.println("The Name didn't get updated.");
		}

	}

}
