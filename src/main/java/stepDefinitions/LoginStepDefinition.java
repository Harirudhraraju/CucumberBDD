package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition{

	String Path=System.getProperty("user.dir");
	WebDriver driver;

	@Given("^user is already on Login Page$")
	public void user_is_already_on_Login_Page() {

		System.setProperty("webdriver.chrome.driver", Path+"\\Drivers\\chromedriver.exe");

		ChromeOptions options=new ChromeOptions();
		options.addArguments("--incognito");
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com/");
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() {
		String title=driver.getTitle();
		System.out.println("My title is : "+title);
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
	}

	//Regulor expression 
	//1. \"(.*)\" 
	//2.\"([^\"]*)\"

	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_Username_and_password(String username,String password){
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button(){
		driver.findElement(By.cssSelector("input[type='submit']")).click();

	}

	@Then("^user is on home page$")
	public void user_is_on_home_page(){

		String title=driver.getTitle();
		System.out.println("Again My Title is : "+title);
		Assert.assertEquals("CRMPRO", title);
	}


	@Then("^user moves to new contact page$")
	public void user_moves_to_new_contact_page() throws InterruptedException {

		driver.switchTo().frame("mainpanel");
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[text()='Contacts']"))).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='New Contact']")).click();

	}

	@Then("^user enters contact details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void user_enters_contact_details(String firstname, String lastname, String position) {
		driver.findElement(By.cssSelector("#first_name")).sendKeys(firstname);
		driver.findElement(By.cssSelector("#surname")).sendKeys(lastname);
		driver.findElement(By.cssSelector("#company_position")).sendKeys(position);
		driver.findElement(By.xpath("//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")).click();
	}




	@Then ("^close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

}
