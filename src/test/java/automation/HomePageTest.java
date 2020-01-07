package automation;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.HomePageTest;
import pageobject.HomePage;
import resources.Base;

public class HomePageTest extends Base{
	
	// Adding logs using log4j
	public static Logger log = LogManager.getLogger(HomePageTest.class.getName());
	
	public WebDriver driver;
	public HomePage hp;
	public Actions a;
	
	// Initialize driver object before running test
//	@BeforeTest
//	public void initialize() throws IOException{
//		driver = initializeDriver();
//	}
	
	

	
	// Navigate to main page before test
	@BeforeTest
	public void landingPage() throws InterruptedException, IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		Thread.sleep(3000);
		
		hp = new HomePage(driver);
		if(hp.getPopUpSize() > 0) {
			// If pop-up, click "x" button
			hp.getPopUp().click();
		}
		
		a = new Actions(driver);

	}
	
	// Validate Shop page
	@Test
	public void shop() {
		a.moveToElement(hp.getShop()).click().build().perform();
        AssertJUnit.assertTrue(hp.getValid().isDisplayed());
        log.info("Shop page is displayed");
        // Back to home page
        hp.getLogoLifx().click();
	}
	
	// Validate General Lighting page and sub pages
	@Test
	public void generalLights() throws InterruptedException {
		// 1. Move mouse to "Shop" button to display auto suggestive dropdowns
		a.moveToElement(hp.getShop()).build().perform();
		Thread.sleep(1000);
		// Since "general light" button becomes visible, validate and click it
		String actualGeneral = hp.getGeneral().getText();
		String expectedGeneral = "General Lighting";
        AssertJUnit.assertEquals(actualGeneral, expectedGeneral);
        hp.getGeneral().click();
        AssertJUnit.assertTrue(hp.getValid().isDisplayed());
        log.info("General Lighting page is displayed");
        
        Thread.sleep(1000);
        
        // Move back to "shop" button to check next element - Lightbulbs
        a.moveToElement(hp.getShop()).build().perform();
		a.moveToElement(hp.getGeneral()).build().perform();

        String actualLight = hp.getLightbulbs().getText();
        String expectedLight = "Lightbulbs";
        AssertJUnit.assertEquals(actualLight, expectedLight);
        hp.getLightbulbs().click();
        AssertJUnit.assertTrue(hp.getTitle().isDisplayed());
        log.info("Lightbulbs page is displayed");
        
        Thread.sleep(1000);
        
        // Move back to "shop" button to check next element - Downlights
        a.moveToElement(hp.getShop()).build().perform();
		a.moveToElement(hp.getGeneral()).build().perform();
		
		String actualDownlight = hp.getDownlight().getText();
		String expectedDownlights = "Downlights";
		AssertJUnit.assertEquals(actualDownlight, expectedDownlights);
		hp.getDownlight().click();
		AssertJUnit.assertTrue(hp.getTitle().isDisplayed());
        log.info("Downlights page is displayed");
		
		Thread.sleep(1000);
		
        // Move back to "shop" button to check next element - Outdoor
        a.moveToElement(hp.getShop()).build().perform();
		a.moveToElement(hp.getGeneral()).build().perform();
		
		String actualOutdoor = hp.getOutdoor().getText();
		String expectedOutdoor = "Outdoor";
		AssertJUnit.assertEquals(actualOutdoor, expectedOutdoor);
		hp.getOutdoor().click();
		AssertJUnit.assertTrue(hp.getTitle().isDisplayed());
        log.info("Outdoor page is displayed");
        
		Thread.sleep(1000);
		
        // Move back to "shop" button to check next element - Switch
        a.moveToElement(hp.getShop()).build().perform();
		a.moveToElement(hp.getGeneral()).build().perform();
		
		String actualSwitch = hp.getSwitchLifx().getText();
		String expectedSwitch = "LIFX Switch";
		AssertJUnit.assertEquals(actualSwitch, expectedSwitch);
		hp.getSwitchLifx().click();
		AssertJUnit.assertTrue(hp.getTitle().isDisplayed());
        log.info("Switch page is displayed");
        
		Thread.sleep(1000);
		
	}
	
	// Validate Home Entertainment page and sub pages
	@Test
	public void homeEntertainment() throws InterruptedException {
		// 1. Move mouse to "Shop" button to display auto suggestive dropdowns
		a.moveToElement(hp.getShop()).build().perform();

		String actualEntertain = hp.getHomeEntertain().getText();
		String expectedEntertain = "Home Entertainment";
        AssertJUnit.assertEquals(actualEntertain, expectedEntertain);
        hp.getHomeEntertain().click();
        AssertJUnit.assertTrue(hp.getValid().isDisplayed());
        log.info("Home Entertainment page is displayed");
        
        Thread.sleep(1000);
        
        // Move back to "shop" button to check next element - Gaming
        a.moveToElement(hp.getShop()).build().perform();
		a.moveToElement(hp.getHomeEntertain()).build().perform();
		
		String actualGaming = hp.getGaming().getText();
		String expectedGaming = "Gaming";
		AssertJUnit.assertEquals(actualGaming, expectedGaming);
		hp.getGaming().click();
		AssertJUnit.assertTrue(hp.getTitle().isDisplayed());
        log.info("Gaming page is displayed");
        
        Thread.sleep(1000);
        
        // Move back to "shop" button to check next element - TV Lighting
        a.moveToElement(hp.getShop()).build().perform();
		a.moveToElement(hp.getHomeEntertain()).build().perform();
		
		String actualTVLight = hp.getTVLight().getText();
		String expectedTVLight = "TV Lighting";
		AssertJUnit.assertEquals(actualTVLight, expectedTVLight);
		hp.getTVLight().click();
		AssertJUnit.assertTrue(hp.getTitle().isDisplayed());
        log.info("TV Lighting page is displayed");
        
		Thread.sleep(1000);

	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}

}
