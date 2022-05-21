package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	private static WebElement webElement;

	public static void main(String[] args) throws InterruptedException {

		//setup chromedriver
		WebDriverManager.chromedriver().setup();
		
		//To open the browser, create an object for the driver
		ChromeDriver driver=new ChromeDriver();
		
		//load the url
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//maximize the window
		driver.manage().window().maximize();
		
		//To identify WebElement
		WebElement eleUserName = driver.findElement(By.id("username"));
		
		//Enter the username
		eleUserName.sendKeys("DemoSalesManager");
		
		//find the password box and enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//To click on submit button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on the link in the screen
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on the option Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter the company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		
		//Enter the First name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Selenium");
		
		//Enter the Last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Tester1");
		
		//Select the source dropdown
		WebElement ele=driver.findElement(By.id("createLeadForm_dataSourceId"));
		
		//Create an object for select class and link with drop down element
		Select dropdown_Source=new Select(ele);
		
		//Choosing the option select by value
		dropdown_Source.selectByValue("LEAD_CONFERENCE");
	
		//Enter the first name(local)
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Local first name");
		
		//find the department element and enter the input
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Technical team");
		
		//find the description and enter the text in description
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is the test description to create a test lead");
		
		//find the email_id and enter the email._id
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("testleaftester@gmail.com");
		
		//Select the "state" dropdown
		WebElement element1=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		//Create an object for select class and link with drop down element
		Select dropdown_state=new Select(element1);
		
		//Choosing the option select by value
		dropdown_state.selectByVisibleText("New York");
				
		Thread.sleep(5000);
		
		//Click on Create Lead button
		driver.findElement(By.className("smallSubmit")).click();
		
		//Verify the text of the title page
		//Choosing the option select by value
		System.out.println(driver.getTitle());
		 driver.close();
		
	}

}
