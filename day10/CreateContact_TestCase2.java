package assignments.day10;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_TestCase2 extends LoginPart {
	
    @Test(dataProvider = "fetchData")
	public void createContact(String fName, String lName, String fLocalName, String lLocalName, String dept) {
		
		
		driver.findElement(By.linkText("Create Contact")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys(fName);
		driver.findElement(By.id("lastNameField")).sendKeys(lName);
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys(fLocalName);
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys(lLocalName);
		
		driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys(dept);
		driver.findElement(By.id("createContactForm_description")).sendKeys("A pundit is a person who offers to mass media opinion or commentary on a particular subject area (most typically politics, the social sciences, technology or sport).");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("abc@gmail.com");
		
		WebElement province = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select ddProvince = new Select(province);
		ddProvince.selectByVisibleText("New York");
	
		
		driver.findElement(By.className("smallSubmit")).click();
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("A pundit is a person who offers to mass media opinion or commentary on a particular subject area (most typically politics, the social sciences, technology or sport).");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		System.out.println(driver.getTitle()); //OUTPUT: View Contact | opentaps CRM

	}
    
    @DataProvider(name = "fetchData")
    public String [] [] getDataCreate() throws IOException{
    	return ReadExcelData.readCreate();
    	
    }

}
