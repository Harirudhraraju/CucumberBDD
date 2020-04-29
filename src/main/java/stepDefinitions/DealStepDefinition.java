package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DealStepDefinition {

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


	@Then("^user enters username and password$")
	public void user_enters_Username_and_password(DataTable credentials){

		List<List<String>> data=credentials.raw();
		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
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

	@Then("^user moves to new deal page$")
	public void user_moves_to_new_deal_page() throws InterruptedException {
		driver.switchTo().frame("mainpanel");
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[text()='Deals']"))).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='New Deal']")).click();
	}

	@Then("^user enters deal details$")
	public void user_enters_deal_details(DataTable dealdata)  {
		List<List<String>> dealValues=dealdata.raw();
		driver.findElement(By.cssSelector(" input[id='title']")).sendKeys(dealValues.get(0).get(0));
		driver.findElement(By.cssSelector(" input[id='amount']")).sendKeys(dealValues.get(0).get(1));
		driver.findElement(By.cssSelector(" input[id='probability']")).sendKeys(dealValues.get(0).get(2));
		driver.findElement(By.cssSelector(" input[id='commission']")).sendKeys(dealValues.get(0).get(3));
		driver.findElement(By.xpath("//*[@id=\"prospectForm\"]/table/tbody/tr[1]/td/input[1]")).click();

	}



	@Then ("^close the browser$")
	public void close_the_browser() {
		driver.quit();
	}
}
