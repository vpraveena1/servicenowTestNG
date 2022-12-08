package week5day2AssignmentTestNG;
/*Asssignment 2:Create new Proposal (https://dev111725.service-now.com/
"1. Launch ServiceNow application
2. Login with valid credential 
3. Click All and Enter Proposal in filter navigator and press enter 
4. Click- new  and  fill mandatory fields and click 'Submit' 
Button.
5. Verify the successful creation of new Proposal"*/

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class CreateNewProfile extends BaseClassServiceNow {
@Test
	public void Proposal(){
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("My Proposals",Keys.ENTER);
		shadow.findElementByXPath("//span[@class='item-icon']").click();
		WebElement element = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.xpath("//span[@class='label-text']/following::input[40][1]")).sendKeys("Replace color  to pink");
		driver.findElement(By.xpath("(//span[text()='Change Request values'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='select2-chosen'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='s2id_autogen6_search']")).sendKeys("Review Comments");
		driver.findElement(By.xpath("//span[text()='Review comments']")).click();
		driver.findElement(By.xpath("(//textarea[@class='filerTableInput form-control'])[1]")).sendKeys("Good product");
		driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
		//driver.close();
		
	}

}
