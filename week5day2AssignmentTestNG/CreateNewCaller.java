package week5day2AssignmentTestNG;
/*Assignment 3:Create New Caller (https://dev111725.service-now.com/
"1. Launch ServiceNow application
2. Login with valid credential
3. Click-All and Enter Callers in filter navigator and press enter 
4. Create new Caller by filling all the fields and click 'Submit'.
5. Search and verify the newly created Caller"*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class CreateNewCaller extends BaseClassServiceNow {
	@Test
	public void Caller() {
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers");
		shadow.findElementByXPath("//mark[text()='Callers']").click();
	    WebElement element = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//span[text()='First name']/following::input[2]")).sendKeys("Praveena");
		driver.findElement(By.xpath("//span[text()='Email']/following::input[2]")).sendKeys("abcd@123.com");
		driver.findElement(By.xpath("//span[text()='Last name']/following::input[2]")).sendKeys("Hari");
		driver.findElement(By.xpath("//span[text()='Business phone']/following::input[2]")).sendKeys("1234567890");
		driver.findElement(By.xpath("//span[text()='Title']/following::input[4]")).sendKeys("Caller List");
		driver.findElement(By.xpath("//span[text()='Mobile phone']/following::input[2]")).sendKeys("0987654321");
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		//driver.close();
}
}
