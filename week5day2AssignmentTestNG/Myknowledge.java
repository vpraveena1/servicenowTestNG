package week5day2AssignmentTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

/*Assignment 4:Fill mandatory fields (https://dev111725.service-now.com/)
"1. Launch ServiceNow application
2. Login with valid credentials 
3. Enter Knowledge  in filter navigator and press enter
4. Create new Article 
5.Select knowledge base as IT and category as IT- java and Click Ok
6.Update the other mandatory fields
7.Select the submit option*/
public class Myknowledge extends BaseClassServiceNow {
@Test
	public void Knowledge() {
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge");
		shadow.findElementByXPath("//mark[text()='Knowledge']").click();
	    WebElement element = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.xpath("//span[text()='Knowledge base']/following::input[4]")).sendKeys("IT",Keys.ARROW_DOWN,Keys.ENTER);
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		//driver.findElement(By.xpath("//span[text()='Category']/following::input[4]")).sendKeys("Java",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Short description']/following::input[2]")).sendKeys("Java Knowledge");
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		//driver.close();
	}

}

