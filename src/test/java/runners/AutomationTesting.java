package runners;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.extent.AutomationExtentManager;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AutomationTesting {

	WebDriver driver;
	String ParentURL = "https://westfloridaahec.org/";
	WebDriverWait wait;
	ExtentReports extent;
    ExtentTest test;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
	}else if(browser.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	}else if(browser.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}else {
		throw new IllegalArgumentException("Unsupported browser: " + browser);
	}
		extent = AutomationExtentManager.getInstance(); // Initialize ExtentReports
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(ParentURL);
	}
	
	@Test(priority = 1)
	  public void verificationOfTitle(){
		test = extent.createTest("Title Verification");
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		// Assert.assertEquals(title, "Home - West Florida Area Health Education Center, Inc");
		boolean titleCheck = title.contains("Home - West Florida Area Health Education Center, Inc");
		Assert.assertTrue(titleCheck);
		test.pass("Test passed successfully.");
	  }
	
	@Test(priority = 2)
	public void verificationOfHome() {
		test = extent.createTest("Navigation bar Homepage Verification");
		WebElement home = driver.findElement(By.xpath("//*[@id=\"menu-item-207\"]/a/span"));
		boolean homeVerification = home.isDisplayed();
		Assert.assertTrue(homeVerification);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 3)
	public void verificationOfAbout() {
		test = extent.createTest("Navigation bar About Verification");
		WebElement about = driver.findElement(By.id("menu-item-616"));
		boolean aboutVerification = about.isDisplayed();
		Assert.assertTrue(aboutVerification);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 4)
	public void verificationOfPrograms() {
		test = extent.createTest("Navigation bar Programs Verification");
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		boolean programsVerification = programs.isDisplayed();
		Assert.assertTrue(programsVerification);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 5)
	public void verificationOfServices() {
		test = extent.createTest("Navigation bar Services Verification");
		WebElement services = driver.findElement(By.id("menu-item-331"));
		boolean servicesVerification = services.isDisplayed();
		Assert.assertTrue(servicesVerification);
		test.pass("Test passed successfully.");
	}
	@Test(priority = 6)
	public void verificationOfCPR() {
		test = extent.createTest("Navigation bar CPR Verification");
		WebElement cpr = driver.findElement(By.id("menu-item-467"));
		boolean cprVerification = cpr.isDisplayed();
		Assert.assertTrue(cprVerification);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 7)
	public void verificationOfContactUs() {
		test = extent.createTest("Navigation bar ContactUs Verification");
		WebElement contactUs = driver.findElement(By.id("menu-item-209"));
		boolean contactUsVerification = contactUs.isDisplayed();
		Assert.assertTrue(contactUsVerification);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 8)
	public void verificationOfNews() {
		test = extent.createTest("Navigation bar News Verification");
		WebElement news = driver.findElement(By.id("menu-item-1097"));
		boolean newsVerification = news.isDisplayed();
		Assert.assertTrue(newsVerification);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 9)
	public void verificationOfMyAccount() {
		test = extent.createTest("Navigation bar MyAccount Verification");
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]"));
		boolean myAccountVerification = myAccount.isDisplayed();
		Assert.assertTrue(myAccountVerification);
		test.pass("Test passed successfully.");
	}
	
	
	// verifying health programs
	@Test(priority = 10)
	public void verificationOfQuitTobaccoProgram() {
		test = extent.createTest("Tobacco Program Verification");
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement tobacco = driver.findElement(By.xpath("//*[@id=\"menu-item-344\"]/a/span"));
		boolean tobaccoVerification = tobacco.isDisplayed();
		Assert.assertTrue(tobaccoVerification);
		test.pass("Test passed successfully.");
		
	}
	
	
	@Test(priority = 11)
	public void verificationOfAHECScholars() {
		test = extent.createTest("AHECScholar Program Verification");
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement scholars = driver.findElement(By.xpath("//*[@id=\"menu-item-280\"]/a/span"));
		boolean AHECScholarVerification = scholars.isDisplayed();
		Assert.assertTrue(AHECScholarVerification);
		test.pass("Test passed successfully.");
	}
	
	
	@Test(priority = 12)
	public void verificationOfHealthyAgingPrograms() {
		test = extent.createTest("Healthy Aging Program Verification");
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement healthyAging = driver.findElement(By.xpath("//*[@id=\"menu-item-534\"]/a/span"));
		boolean healthyAgingVerification = healthyAging.isDisplayed();
		Assert.assertTrue(healthyAgingVerification);
		test.pass("Test passed successfully.");
	}
	
	
	@Test(priority = 13)
	public void verificationOfCoveringFlorida() {
		test = extent.createTest("Covering Florida Program Verification");
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement coveringFlorida = driver.findElement(By.xpath("//*[@id=\"menu-item-1572\"]/a/span"));
		boolean coveringFloridaVerification = coveringFlorida.isDisplayed();
		Assert.assertTrue(coveringFloridaVerification);
		test.pass("Test passed successfully.");
	}
	
	// functionality of the search bar
	
	@Test(priority = 14)
	public void testingFunctionalityOfSearchBar() {
		test = extent.createTest("Functionality of Search Bar Verification");
		String currentURL = driver.getCurrentUrl();
		WebElement search = driver.findElement(By.cssSelector("input[type='search']"));
		search.sendKeys("Tobacco");
		WebElement submit = driver.findElement(By.cssSelector("input[type='submit']"));
		submit.click();
		String searchedURL = driver.getCurrentUrl();
		driver.navigate().back();
		boolean searchFunctionVerification = currentURL.equals(searchedURL);
		Assert.assertFalse(searchFunctionVerification);
		test.pass("Test passed successfully.");
	}
	
	// functionality of links to various health programs and services.
	
	@Test(priority = 15)
	public void testingFunctionalityOfTobaccoProgramLink() {
		test = extent.createTest("Functionality of Tobacco Program Verification");
		String currentURL = driver.getCurrentUrl();
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement tobacco = driver.findElement(By.xpath("//*[@id=\"menu-item-344\"]/a/span"));
		tobacco.click();
		String newLinkURL = driver.getCurrentUrl();
		driver.navigate().back();
		boolean tobaccoProgramLinkFunctionalityVerification = currentURL.equals(newLinkURL);
		Assert.assertFalse(tobaccoProgramLinkFunctionalityVerification);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 16)
	public void testingFunctionalityOfAHECScholarsProgramLink() {
		test = extent.createTest("Functionality of AHECScholars Program Verification");
		String currentURL = driver.getCurrentUrl();
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement AHECScholar = driver.findElement(By.xpath("//*[@id=\"menu-item-280\"]/a/span"));
		AHECScholar.click();
		String newLinkURL = driver.getCurrentUrl();
		driver.navigate().back();
		boolean AHECScholarsProgramLinkFunctionalityVerification = currentURL.equals(newLinkURL);
		Assert.assertFalse(AHECScholarsProgramLinkFunctionalityVerification);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 17)
	public void testingFunctionaityOfHealthyAgingProgramLink() {
		test = extent.createTest("Functionality of Healthy Aging Program Verification");
		String currentURL = driver.getCurrentUrl();
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement healthyAging = driver.findElement(By.xpath("//*[@id=\"menu-item-534\"]/a/span"));
		healthyAging.click();
		String newLinkURL = driver.getCurrentUrl();
		driver.navigate().back();
		boolean healthyAgingProgramLinkFuncitonalityVerification = currentURL.equals(newLinkURL);
		Assert.assertFalse(healthyAgingProgramLinkFuncitonalityVerification);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 18)
	public void testingFunctionalityOfCoveringFloridaProgramLink() {
		test = extent.createTest("Functionality of Covering Florida Program Verification");
		String currentURL = driver.getCurrentUrl();
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement coveringFlorida = driver.findElement(By.xpath("//*[@id=\"menu-item-1572\"]/a/span"));
		coveringFlorida.click();
		String newLinkURL = driver.getCurrentUrl();
		driver.navigate().back();
		boolean coveringFloridaProgramLinkFunctionalityVerifcation = currentURL.equals(newLinkURL);
		Assert.assertFalse(coveringFloridaProgramLinkFunctionalityVerifcation);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 19)
	public void testingFuncitonalityOfCommunityBasedEducationServices() {
		test = extent.createTest("Functionality of Community Based Education Services Verification");
		WebElement services = driver.findElement(By.id("menu-item-331"));
		services.click();
		WebElement communityBasedEducation = driver.findElement(By.xpath("//*[@id=\"menu-item-440\"]/a/span"));
		communityBasedEducation.click();
		String communityBasedEducationTitle = driver.getTitle();
		driver.navigate().back();
		boolean communityBasedEducationTitleCheck = communityBasedEducationTitle.contains("Community Based Student Education");
		Assert.assertTrue(communityBasedEducationTitleCheck);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 20)
	public void testingFunctionalityOfContinuingEducationServices() {
		test = extent.createTest("Functionality of Continuing Education Services Verification");
		WebElement services = driver.findElement(By.id("menu-item-331"));
		services.click();
		WebElement continuingEducationServices = driver.findElement(By.xpath("//*[@id=\"menu-item-330\"]/a/span"));
		continuingEducationServices.click();
		String continuingEducationServicesTitle = driver.getTitle();
		driver.navigate().back();
		boolean continuingEducationServicesTitleCheck = continuingEducationServicesTitle.contains("Continuing Education Services");
		Assert.assertTrue(continuingEducationServicesTitleCheck);
		test.pass("Test passed successfully.");
	}
	
	// 2. Health Programs and Services
	
	@Test(priority = 21)
	public void testingTobaccoProgramContentAndResourceQuitTobacco() throws InterruptedException {
		test = extent.createTest("Tobacco Program Quit Tobacco Program content and resource verification");
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement tobacco = driver.findElement(By.xpath("//*[@id=\"menu-item-344\"]/a/span"));
		tobacco.click();
		WebElement quitTobacco = driver.findElement(By.xpath("//*[@id=\"post-340\"]/div/div/div/div/div/div[1]/div[1]/div/div[1]/a/div/img"));
		wait.until(ExpectedConditions.elementToBeClickable(quitTobacco));
		quitTobacco.click();
		String quitTobaccoTitle = driver.getTitle();
		driver.navigate().to(ParentURL);
		Thread.sleep(2000);
		boolean quitTobaccoTitleCheck = quitTobaccoTitle.contains("Quit Tobacco - West Florida Area Health Education Center, Inc");
		Assert.assertTrue(quitTobaccoTitleCheck);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 22)
	public void testingTobaccoProgramContentAndResourceSystemChange() throws InterruptedException {
		test = extent.createTest("Tobacco Program System Change Program content and resource verification");
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement tobacco = driver.findElement(By.xpath("//*[@id=\"menu-item-344\"]/a/span"));
		tobacco.click();
		WebElement systemsChange = driver.findElement(By.xpath("//*[@id=\"post-340\"]/div/div/div/div/div/div[1]/div[2]/div/div[1]/a/div/img"));
		wait.until(ExpectedConditions.elementToBeClickable(systemsChange));
		systemsChange.click();
		String systemsChangeTitle = driver.getTitle();
		driver.navigate().to(ParentURL);
		Thread.sleep(2000);
		boolean systemsChangeTitleCheck = systemsChangeTitle.contains("Systems Change - West Florida Area Health Education Center, Inc");
		Assert.assertTrue(systemsChangeTitleCheck);
		test.pass("Test passed successfully.");
	}
	
	/*@Test(priority = 23)
	public void testingTobaccoProgramContentAndResourceTraining() throws InterruptedException {
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement tobacco = driver.findElement(By.xpath("//*[@id=\"menu-item-344\"]/a/span"));
		tobacco.click();
		WebElement training = driver.findElement(By.xpath("//*[@id=\"post-340\"]/div/div/div/div/div/div[1]/div[3]/div/div[1]/a/h2"));
		training.click();
		String trainingTitle = driver.getTitle();
		driver.navigate().to(ParentURL);
		Thread.sleep(2000);
		boolean trainingTitleCheck = trainingTitle.contains("Training - West Florida Area Health Education Center, Inc");
		Assert.assertTrue(trainingTitleCheck);
	}*/
	
	@Test(priority = 23) 
	public void testingAHECScholarsProgramContentAndResources() {
		test = extent.createTest("AHEC Scholars Program content and resource verification");
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement AHECScholars = driver.findElement(By.xpath("//*[@id=\"menu-item-280\"]/a/span"));
		AHECScholars.click();
		WebElement scholarsProgramComponents = driver.findElement(By.cssSelector("h2.content-box-heading"));
		String scholarsProgramContent = scholarsProgramComponents.getText();
		boolean scholarsProgramContentCheck = scholarsProgramContent.equals("PROGRAM COMPONENTS");
		Assert.assertTrue(scholarsProgramContentCheck);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 24)
	public void testingHealthyAgingProgramContentAndResources() {
		test = extent.createTest("Healthy Aging Program content and resource verification");
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement healthyAging = driver.findElement(By.xpath("//*[@id=\"menu-item-534\"]/a/span"));
		healthyAging.click();
		WebElement healthyAgingClassForm = driver.findElement(By.linkText("CLICK HERE TO REGISTER NOW"));
		wait.until(ExpectedConditions.elementToBeClickable(healthyAgingClassForm));
		healthyAgingClassForm.click();
		String healthyAgingClassFormTitle = driver.getTitle();
		driver.navigate().to(ParentURL);
		boolean healthyAgingCassFormTitleCheck = healthyAgingClassFormTitle.contains("Sign Up for Healthy Aging Classes | Cognito Forms");
		Assert.assertTrue(healthyAgingCassFormTitleCheck);
		test.pass("Test passed successfully.");
	}
	
	@Test(priority = 25)
	public void testingCoveringFloridaProgramContentAndResources() throws InterruptedException {
		test = extent.createTest("Covering Florida Program content and resource verification");
		String parentWindow = driver.getWindowHandle();
		WebElement programs = driver.findElement(By.id("menu-item-264"));
		programs.click();
		WebElement coveringFlorida = driver.findElement(By.xpath("//*[@id=\"menu-item-1572\"]/a/span"));
		coveringFlorida.click();
		WebElement floridaProgramResource = driver.findElement(By.xpath("//*[@id=\"post-1479\"]/div/div[7]/div/div[2]/div/ul/li[1]/div/p/a[1]"));
		floridaProgramResource.click();
		for (String childWindow : driver.getWindowHandles()) {
			if(!childWindow.equals(parentWindow)) {
				driver.switchTo().window(childWindow);
				Thread.sleep(2000);
				}
			}		
		String childTitle = driver.getTitle();
		boolean floridaProgramResouceLineTitle = childTitle.contains("Medicaid & CHIP coverage | HealthCare.gov");
		Assert.assertTrue(floridaProgramResouceLineTitle);
		
		for(String childWindow : driver.getWindowHandles()) {
			if(!childWindow.equals(parentWindow)) {
				driver.switchTo().window(parentWindow);
				Thread.sleep(5000);
				break;
			}
		}
		Thread.sleep(3000);
		driver.navigate().to(ParentURL);
		Thread.sleep(3000);
		test.pass("Test passed successfully.");
	}
	
	// Contact Us Page: 
	
	@Test(priority = 26)
	public void contactUsPage() {
		test = extent.createTest("Contact Us Page Functionality verification");
		WebElement contactUs = driver.findElement(By.id("menu-item-209"));
		contactUs.click();
		String contactUsPageTitle = driver.getTitle();
		driver.navigate().back();
		boolean contactUsPageTitleCheck = contactUsPageTitle.contains("CONTACT US - West Florida Area Health Education Center, Inc");
		Assert.assertTrue(contactUsPageTitleCheck);
		test.pass("Test passed successfully.");
	}
	
	// User Registration and Login: 
	
	@Test(priority = 27)
	public void userRegistration() throws InterruptedException {
		test = extent.createTest("User Registraion Login with Username and Password");
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-main-menu\"]/li[8]/a/span[1]"));
		myAccount.click();
		Thread.sleep(3000);
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("AdvaitAcharya");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Advait@123");
		WebElement login = driver.findElement(By.name("login"));
		login.click();
		Thread.sleep(5000);
		WebElement errorMessage = driver.findElement(By.xpath("/html/body/div[8]/div/main/div/section/div/div/div/div[1]/div/div"));
		String errorMessageText = errorMessage.getText();
		driver.navigate().back();
		boolean errorMessageTextCheck = errorMessageText.contains("Error: The password you entered for the username AdvaitAcharya is incorrect. Lost your password?");
		Assert.assertTrue(errorMessageTextCheck);
		test.pass("Test passed successfully.");
	}
	
	@AfterClass
	public void closeDriver() {
		if(driver != null) {
			driver.quit();
			extent.flush(); // Save the Extent Report
		}
	}
	
}
