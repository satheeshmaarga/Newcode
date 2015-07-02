package test_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewRequest {
	
	WebDriver driver = new FirefoxDriver ();
	
  @Test
  public NewRequest() throws Throwable
  {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //driver.get("http://kalaichelvan_s:9597333725@10.10.10.181/RSE/ACE.nsf/Home.xsp");
	  driver.get("http://10.10.10.181/RSP/ACE.nsf/Home.xsp");
	  driver.findElement(By.partialLinkText("Home")).click();
	  driver.findElement(By.partialLinkText("New Service Request")).click();
	  Select functionalarea = new Select (driver.findElement(By.id("view:_id1:_id2:txt_ServiceCat")));
	  functionalarea.selectByVisibleText("Procurement");
	  Select Category = new Select (driver.findElement(By.id("view:_id1:_id2:txt_ServiceType")));
	  Category.selectByVisibleText("ExpDeli");
	  Select Request = new Select (driver.findElement(By.id("view:_id1:_id2:txt_RequestType")));
	  Request.selectByVisibleText("Delivery");
	  WebDriverWait Wait = new WebDriverWait (driver,30);
	  Wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("view:_id1:_id9:callback1:_id172:txt_Telephone"))));
	  driver.findElement(By.id("view:_id1:_id9:callback1:button4")).click();
	  // To validate all the mandatory fields	  
	  WebDriverWait Wait2 = new WebDriverWait (driver,40);
	  Wait2.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("view:_id1:_id9:callback1:_id236:txt_ACEDocScreenShot"))));
	  System.out.println("All Mandatory fields are validated");	  
	  driver.findElement(By.id("view:_id1:_id9:callback1:txt_VendorName")).sendKeys("Test");
	  driver.findElement(By.id("view:_id1:_id9:callback1:txt_PONumber")).sendKeys("Test");
	  driver.findElement(By.id("view:_id1:_id9:callback1:txt_DeliveryDate")).sendKeys("12/03/2015");
	  driver.findElement(By.id("view:_id1:_id9:callback1:_id236:txt_ACEDocScreenShot")).click();
	  Runtime.getRuntime().exec("C:\\Documents and Settings\\satheesh_v\\Desktop\\script.exe");
	  WebDriverWait Wait1 = new WebDriverWait (driver,40);
	  Wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("view:_id1:_id9:callback1:_id236:button3"))));
	  driver.findElement(By.id("view:_id1:_id9:callback1:button4")).click();
	  String title = driver.getTitle();
	//To check whether Request have been submitted
	  if(title.equals("Successful"))
	  {
		 System.out.println("Request submitted successfully");
	  }
	 else
	 {
		 System.out.println("Request not submitted");
	 }
	 System.out.println("Request submitted successfully");
	 
	 driver.navigate().back();
	 driver.navigate().refresh();
	 
	  
  }
}
