package week5day2AssignmentTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassServiceNow {
	WebDriver driver;
	@BeforeClass()
	@Parameters({"url","user_name","user_password","browser"})
	public void login(String url,String username,String password,String Browser) throws InterruptedException {
	if(Browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--diable-notifications");
		driver=new ChromeDriver(op);
		driver.manage().window().maximize();
	}else if(Browser.equals("edge")) {
		WebDriverManager.edgedriver().setup();;
		EdgeOptions op=new EdgeOptions();
		op.addArguments("--diable-notifications");
		driver=new EdgeDriver(op);
		driver.manage().window().maximize();
	}
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.id("user_name")).sendKeys(username);
	driver.findElement(By.id("user_password")).sendKeys(password);
	driver.findElement(By.id("sysverb_login")).click();
	Thread.sleep(3000);
	
}
@AfterTest
public void close(){
	//driver.close();
}
}