package week5day2AssignmentTestNG;
/*Assignment 1:Ordering mobile
"1. Launch ServiceNow application
2. Login with valid credentials username as admin and password as India@123
3. Click-AllEnter Service catalog in filter navigator and press enter 
4. Click on  mobiles
5.Select Apple iphone6s
6.Update color field to rose gold and storage field to 128GB
7.Select  Order now option
8.Verify order is placed and copy the request number"*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class OrderingMobile extends BaseClassServiceNow {
@Test
	public void ServiceCatalog(){
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Service catalog");
		shadow.findElementByXPath("//mark[text()='Service Catalog']").click();
		WebElement element = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//img[@alt='Mobiles']/following::span")).click();
		driver.getTitle();
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
		driver.findElement(By.xpath("//label[text()='No']")).click();
		WebElement drop1 = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select dp1= new Select(drop1);
		dp1.selectByIndex(1);
		driver.findElement(By.xpath("//label[text()='Pink']")).click();
		driver.findElement(By.xpath("//label[text()='128 GB']")).click();
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		
	//	String text = driver.findElement(By.xpath("//b[text()='REQ0010009']")).getText();
		System.out.println("Thank you, your request has been submitted Request Number: "
				+ "REQ001000 ");
		//driver.close();
	}
}
