package Major_Slave;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Naukri_Resumetest {
	
	@Test
	public void Resume_Upload() throws AWTException {
		WebDriver driver = new ChromeDriver();
		 Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.naukri.com/");
		WebElement Login = driver.findElement(By.id("login_Layer"));
		Login.click();
		WebElement UN = driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"));
		UN.sendKeys("amarnath.s.b123@gmail.com");
		WebElement PWD = driver.findElement(By.xpath("//input[@placeholder='Enter your password']"));
		PWD.sendKeys("amartheboss");
		WebElement Login_btn = driver.findElement(By.xpath("//button[@class='btn-primary loginButton']"));
		Login_btn.click();
		act.moveByOffset(100, 200).click().perform();   
		WebElement ViewProfile = driver.findElement(By.xpath("//a[text()='View']"));
		ViewProfile.click();
		WebElement Updateresume = driver.findElement(By.xpath("//input[@id ='attachCV']"));
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", Updateresume);
	
		Updateresume.sendKeys("C:\\Users\\Amarnath\\eclipse-workspace\\Slave\\Resume\\Amarnath_QA_3+ YOE.pdf");
		//WebElement Toast = driver.findElement(By.xpath("//p[text()='Resume has been successfully uploaded.']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Resume has been successfully uploaded.']")));
		 WebElement msg = driver.findElement(By.xpath("//div[@class='msgBox success ']//p"));
		 System.out.println(msg.getText());
		 if(msg.getText().equals("Success")) {
			 System.out.println("----------Resume has been Uploaded-----------");
			 driver.quit();
		 }
		//Updateresume.click();
		
//		 StringSelection ss	= new StringSelection("C:\\Users\\Amarnath\\eclipse-workspace\\Slave\\Resume\\Amarnath_QA_3+ YOE.pdf");
//		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		 Robot rb = new Robot();
//		 rb.delay(2000);
//		 rb.keyPress(KeyEvent.VK_CONTROL);
//		 rb.keyPress(KeyEvent.VK_V);
//		 
//		 rb.keyRelease(KeyEvent.VK_CONTROL);
//		 rb.keyRelease(KeyEvent.VK_V);
//		 
//		 rb.keyPress(KeyEvent.VK_ENTER);   
//		 rb.keyRelease(KeyEvent.VK_ENTER);
		
		 
		 driver.quit();
	}

}
