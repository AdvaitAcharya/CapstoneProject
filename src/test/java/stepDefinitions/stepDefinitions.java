package stepDefinitions;
//import java.time.Duration;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;






public class stepDefinitions {
	
	WebDriver driver;
	String homepage = "https://westfloridaahec.org/";
	WebDriverWait wait;

	@Given("I am on West Florida AHEC Website homepage")
	public void i_am_on_west_florida_ahec_website_homepage() {
	   driver = new ChromeDriver();
	   driver.get(homepage);
	   //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));;
	}
	

	@When("I click on the {string}")
	public void i_click_on_the(String string) {
	    WebElement program = driver.findElement(By.id("menu-item-264"));
	    program.click();
	}
	
	// problem faced here 
	@When("I select {string} program")
	public void i_select_program(String Program) throws InterruptedException {
		
		String programOption = String.format("//ul[@class='sub-menu']//span[text()='%s']",Program);
		WebElement programSelect = driver.findElement(By.xpath(programOption));
		programSelect.click();
		Thread.sleep(5000);

	}
	
//    WebElement program = driver.findElement(By.cssSelector("ul.sub-menu"));
	
	@Then("I should be navigated to the {string} programspage")
	public void i_should_be_navigated_to_the_page1(String programpage) {
	    String currentURL = driver.getCurrentUrl();
	    boolean urlCheck = currentURL.equals(programpage);
	    Assert.assertTrue(urlCheck);
	    
	    
	}
	@Then("I should see the page title as {string}")
	public void i_should_see_the_page_title_as(String ProgramPageTitle) {
	    String actualTitle = driver.getTitle();
	    boolean titleCheck = actualTitle.contains(ProgramPageTitle);
	    Assert.assertTrue(titleCheck);
	}
	@Then("I should see content related to the program")
	public void i_should_see_content_related_to_the_program() {
	    WebElement content = driver.findElement(By.xpath("/html/body"));
	    Assert.assertTrue(content.isDisplayed());
	    
	    
	}


	/*@Given("I am on West Florida AHEC Website homepage")
	public void i_am_on_west_florida_ahec_website_homepage_again() {
	    driver.navigate().to(homepage);
	}*/
	
	@When("I click on {string} menu")
	public void i_click_on2(String string) {
		WebElement program = driver.findElement(By.id("menu-item-264"));
	    program.click();
	}
	@When("I select {string} program page")
	public void i_select_program1(String String) throws InterruptedException {
		WebElement healthyAging = driver.findElement(By.xpath("//*[@id=\"menu-item-534\"]/a/span"));
		healthyAging.click();
		Thread.sleep(5000);
	}
	@When("I am navigated to {string} program page")
	public void i_am_navigated_to_the_page2(String String) {
		String currentURL = driver.getCurrentUrl();
	    boolean urlCheck = currentURL.equals("https://westfloridaahec.org/healthy-aging/");
	    Assert.assertTrue(urlCheck);
	}
	
	@When("I fill in the {string} field with {string} inputdata")
	public void i_fill_in_the_field_with2(String fieldName, String value) throws InterruptedException {
		Thread.sleep(5000);
		WebElement field;
		switch(fieldName) {
		case "First":
			
			field = driver.findElement(By.id("cog-input-auto-0"));			
			break;
		case "Last":
			
			field = driver.findElement(By.id("cog-input-auto-1"));
			
			break;
		case "Phone":
			
			field = driver.findElement(By.id("cog-1"));
			
			break;
		case "Email":
			
			field = driver.findElement(By.id("cog-2"));
			
			break;
		case "Please help us by telling us how/​where you heard about us:":
			
			field = driver.findElement(By.id("cog-7"));
			
			break;
		default: 
			throw new IllegalArgumentException("Field not found: " + fieldName);
		}
		
		field.clear();
		field.sendKeys(value);
		
	    
	}
	
	// learned new way to use x path
	
	@When("I select the {string} option {string}")
	public void i_select_the_option(String fieldName, String value) throws InterruptedException {
		
		WebElement field;
		switch(fieldName) {
		
		case "Which program are you interested in? (Check all that apply)":
			field = driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[1]/div[1]/div[1]/div/label[1]/span[1]"));
			if(!field.isSelected()) {
				field.click();
			}
			Thread.sleep(3000);
			break;			
		case "Which county do you live in?":
			field = driver.findElement(By.xpath("/html/body/div[8]/div/main/div/section/div/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[4]/fieldset[2]/div[1]/div[1]/div/label[1]/span[1]/span"));
			if(!field.isSelected()) {
				field.click();
			}
			Thread.sleep(3000);
			break;
		case "Which class format do you prefer?":
			field = driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[5]/fieldset/div[1]/div[1]/div/label[2]"));
			if(!field.isSelected()) {
				field.click();
			}
			Thread.sleep(3000);
			break;
		case "I am best described as:":
			field = driver.findElement(By.id("cog-6"));
			field.click();
			Thread.sleep(3000);
			WebElement option = driver.findElement(By.xpath("/html/body/div[8]/div/main/div/section/div/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[6]/div/div[1]/div[1]/div/div/input"));
			option.click();
			Thread.sleep(3000);
			break;
		case "I would like to be notified by email when classes are available in my area":
			field = driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div/div[8]/div/div[1]/label/span[2]"));
			field.click();
			Thread.sleep(3000);
			break;
			
		default: 
			throw new IllegalArgumentException("Field not found: " + fieldName);
		}
				
	    
	}
	@When("I submit the form")
	public void i_submit_the_form() throws InterruptedException {
		
	    WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
	    submit.click();
	    Thread.sleep(3000);
	}
	@Then("I should see the success message {string}")
	public void i_should_see_the_success_message(String ResponseMessage) {
	   
		WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"post-500\"]/div/div[1]/div/div[1]/div/form/div/div/div[1]/div[1]/div/div[1]"));
		String successResponse = successMessage.getText();
		boolean successCheck = successResponse.contains(ResponseMessage);
		Assert.assertTrue(successCheck);
	}


/*@Given("I am on West Florida AHEC Website homepage")
public void i_am_on_west_florida_ahec_website_homepage() {
    
}*/
	
	
@When("I click on {string} menuoption")
public void i_click_on3(String string) throws InterruptedException {
	
	WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]"));
	myAccount.click();
	Thread.sleep(5000);
    
}


@When("I am redirected to {string} page")
public void i_am_redirected_to_page(String string) {
	String currentURL = driver.getCurrentUrl();
    boolean urlCheck = currentURL.equals("https://westfloridaahec.org/my-account/");
    Assert.assertTrue(urlCheck);
}

@When("I fill in {string} field with {string} inputvalue")
public void i_fill_in_the_field_with3(String fieldName, String value) {
WebElement field; 
    
    switch(fieldName) {
    case "username":
    	field = driver.findElement(By.id("reg_username"));
    	break;
    case "email":
    	field = driver.findElement(By.id("reg_email"));
    	break;
    case "password":
    	field = driver.findElement(By.id("reg_password"));
    	break;
    default: 
		throw new IllegalArgumentException("Field not found: " + fieldName);
    }
    field.clear();
    field.sendKeys(value);
}

@When("I click on Register")
public void i_click_on_register() throws InterruptedException {
	WebElement register = driver.findElement(By.name("register"));
	register.click();
	Thread.sleep(8000);
    
}

@Then("I should be redirected to the {string} myaccountpage")
public void i_should_be_navigated_to_the_page3(String string) {
	String currentURL = driver.getCurrentUrl();
    boolean urlCheck = currentURL.equals("https://westfloridaahec.org/my-account/");
    Assert.assertTrue(urlCheck);
    
}
@Then("I should see the heading {string}")
public void i_should_see_the_heading(String string) throws InterruptedException {
	Thread.sleep(3000);
    WebElement dashboard = driver.findElement(By.xpath("//*[@id=\"post-381\"]/div/div/div[2]/h2"));
    boolean registrationCheck = dashboard.isDisplayed();
    Assert.assertTrue(registrationCheck);
}




/*@Given("I am on West Florida AHEC Website homepage")
public void i_am_on_west_florida_ahec_website_homepage() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}*/
	
@When("I click on {string} account")
public void i_click_on4(String string) throws InterruptedException {
	
	WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]"));
	myAccount.click();
	Thread.sleep(5000);
    
}
@When("I am navigated to {string} page")
public void i_am_navigated_to_the_page4(String string) {
	String currentURL = driver.getCurrentUrl();
    boolean urlCheck = currentURL.equals("https://westfloridaahec.org/my-account/");
    Assert.assertTrue(urlCheck);
}
@When("I fill in {string} field with {string}")
public void i_fill_in_the_field_with4(String fieldName, String value) {
WebElement field; 
    
    switch(fieldName) {
    case "login_username":
    	field = driver.findElement(By.id("username"));
    	break;
    case "login_password":
    	field = driver.findElement(By.id("password"));
    	break;
    default: 
		throw new IllegalArgumentException("Field not found: " + fieldName);
    }
    field.clear();
    field.sendKeys(value);
}
@When("I click on Log In")
public void i_click_on_log_in() throws InterruptedException {
    WebElement login = driver.findElement(By.name("login"));
    login.click();
    Thread.sleep(5000);
}
@Then("I should be navigated to the {string} page")
public void i_should_be_navigated_to_the_page(String string) {
	String currentURL = driver.getCurrentUrl();
    boolean urlCheck = currentURL.equals("https://westfloridaahec.org/my-account/");
    Assert.assertTrue(urlCheck);
}
@Then("I should see {string} on the page")
public void i_should_see_on_the_page4(String value) {
    WebElement loginHelloText = driver.findElement(By.xpath("//*[@id=\"post-381\"]/div/div/div[1]/div[1]/span[1]"));
    String helloText = loginHelloText.getText();
    boolean loginCheck = helloText.contains(value);
    Assert.assertTrue(loginCheck);
}


	/*@Given("I am on West Florida AHEC Website homepage")
	public void i_am_on_west_florida_ahec_website_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/
	
	

	/*@Given("I am on West Florida AHEC Website homepage")
	public void i_am_on_west_florida_ahec_website_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}*/
	
	@When("I click on {string} page")
	public void i_click_on_page(String string) throws InterruptedException {
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]"));
		myAccount.click();
		Thread.sleep(5000);
	}
	@When("I am navigated to the {string} page")
	public void i_am_navigated_to_the_page(String string) throws InterruptedException {
		String currentURL = driver.getCurrentUrl();
	    boolean urlCheck = currentURL.equals("https://westfloridaahec.org/my-account/");
	    Assert.assertTrue(urlCheck);
	}
	@When("I click on {string}")
	public void i_click_on(String string) throws InterruptedException {
		WebElement lostYourPassword = driver.findElement(By.linkText("Lost your password?"));
		lostYourPassword.click();
		Thread.sleep(5000);
	}
	@When("I am navigated to the {string} reset page")
	public void i_am_navigated_to_the_reset_page(String string) {
	    String currentURL = driver.getCurrentUrl();
	    boolean urlCheck = currentURL.equals("https://westfloridaahec.org/my-account/lost-password/");
	    Assert.assertTrue(urlCheck);
	}
	@When("I fill in the {string} field with {string}")
	public void i_fill_in_the_field_with(String fieldName, String value) {
		  WebElement field = driver.findElement(By.id("user_login"));
		  field.sendKeys(value);
	}
	
	@When("I click on Reset password")
	public void i_click_on_reset_password() {
		WebElement resetButton = driver.findElement(By.xpath("//*[@id=\"post-381\"]/div/div/form/p[3]/button"));
		resetButton.click();
	}
	@Then("I should see {string} message on the page")
	public void i_should_see_on_the_page(String value) {
		WebElement mailSentMsg = driver.findElement(By.xpath("//*[@id=\"post-381\"]/div/div/div/div"));
		String sentText = mailSentMsg.getText();
		boolean passwordRecovery = sentText.contains(value);
		Assert.assertTrue(passwordRecovery);
	}


	@After
	public void tearDown() {
		
		if(driver != null ) {
			driver.quit();
		}
		
	}

}


