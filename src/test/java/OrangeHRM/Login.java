package OrangeHRM;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login {
	
	WebDriver driver;

	//@FindBy (id="txtUsername")
	//@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/form[1]/div[2]/input[1]")
	//@FindBy(how = How.XPATH,using = "//input[@id='txtUsername']")
	WebElement username;
	
	//@FindBy(id="txtPassword")
	//@FindBy(how = How.XPATH,using = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[2]/div[2]/form[1]/div[3]/input[1]")
	//@FindBy(how = How.XPATH,using = "//input[@id='txtPassword']")
	WebElement password;
		
	//@FindBy(id="btnLogin")
	WebElement login ;
	
	public void init() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");

		String url = "https://opensource-demo.orangehrmlive.com/";
		driver = new ChromeDriver();

		driver.get(url);
		
		driver.manage().window().maximize();	
	}
	
	 public void setUsername(String username) {
		 this.username = driver.findElement(By.id("txtUsername"));
		 
		this.username.sendKeys(username);

	 }
	 
	 public void setPassword(String password) {
		 this.password = driver.findElement(By.id("txtPassword"));

		this.password.sendKeys(password);

	 }
	 
	 public void login() {
		 this.login= driver.findElement(By.id("btnLogin"));
		 this.login.click();
	 }
	 
	 public void verify() {
		 String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		 String actualUrl = driver.getCurrentUrl(); // te5ouli lien mte3 l page
		 Assert.assertEquals(expectedUrl,actualUrl);
	 }
	 public void finish() {
		 driver.close();
		 driver.quit();
	 }
	 @Test
	 public void test() throws InterruptedException {
		 init();
		 Thread.sleep(2000);
		 setUsername("Admin");
		 Thread.sleep(2000);
		 setPassword("admin123");
		 Thread.sleep(2000);
		 login();
		 Thread.sleep(2000);
		 verify();
		 Thread.sleep(2000);
		 finish();
	 }
	
}
