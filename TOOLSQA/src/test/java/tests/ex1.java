package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ex1 {

	public String baseUrl= "https://demoqa.com/";
	String driverPath= "src/test/resources/chromedriver";
	public WebDriver driver;
	
	@BeforeTest
	private void startTesting() {
		System.out.println("This is a Before Test");
	}
	
	@BeforeMethod
	private void startDriver() {
		System.out.println("Browser to be launch!");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver=new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		System.out.println("Browser launched and maximized");

	}
	@Test
	public void sampleTestMethod() throws InterruptedException {
		
		Actions action = new Actions(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		driver.get("https://demoqa.com/");
		
		String fullName= "Leslie Arredondo";
		String email= "leslieromi2@hotmail.com";
		String currentAdress="Ebano 350, Monterrey";
		String permanentAdress="Ebano 350, Monterrey";
		
		WebElement elementsSection = driver.findElement(By.xpath("//h5[text()='Elements']/../../../div"));
		action.moveToElement(elementsSection).click().perform();

		WebElement checkBoxSection = driver.findElement(By.xpath("//span[text()='Check Box']/.."));
		action.moveToElement(checkBoxSection).click().perform();
		
		WebElement homeSection = driver.findElement(By.xpath("//span[@class='rct-checkbox']"));
		action.moveToElement(homeSection).click().perform();

		Thread.sleep(5000);
		
		WebElement radioButtonSection = driver.findElement(By.xpath("//span[text()='Radio Button']/.."));
		action.moveToElement(radioButtonSection).click().perform();
		
		WebElement yesRadioButton = driver.findElement(By.cssSelector("#yesRadio"));
		action.moveToElement(yesRadioButton).click().perform();
		
		Thread.sleep(5000);
		
		driver.quit();
}
	@AfterMethod
	public void terminateBrowser() {
		driver.close();
		System.out.println("Browser closed!");
}
}