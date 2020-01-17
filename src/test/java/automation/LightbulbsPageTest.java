package automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.CartPage;
import pageobject.HomePage;
import pageobject.LightbulbsPage;
import resources.Base;

public class LightbulbsPageTest extends Base{
	// Adding logs using log4j
	public static Logger log = LogManager.getLogger(LightbulbsPageTest.class.getName());
	
	public WebDriver driver;
	private HomePage hp;
	private CartPage cp;
	private Actions a;
	
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
	
	@Test
	public void lightbulbsPage() throws InterruptedException {
		// 1. Move mouse to "Shop" button to display auto suggestive dropdowns
		a.moveToElement(hp.getShop()).build().perform();
		Thread.sleep(1000);
        
        // Move to Lightbulbs page
        a.moveToElement(hp.getShop()).build().perform();
		a.moveToElement(hp.getGeneral()).build().perform();
		
		Thread.sleep(1000);
        hp.getLightbulbs().click();
        
        LightbulbsPage lp = new LightbulbsPage(driver);
        
        // Maximize browser and scroll down the page by 1000 pixel vertical
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        
        // Verity mini DD on its page
        lp.getMiniDD().click();
        String actualMiniDDPrice = lp.getMiniDDPrice().getText();
        String expectedMiniDDPrice = prop.getProperty("MiniDDPrice");
        Assert.assertEquals(actualMiniDDPrice, expectedMiniDDPrice);
        log.info("The expectedMiniDD Price is " + expectedMiniDDPrice + ", The actualMiniDD Price is " + actualMiniDDPrice);
        
        // Verify mini DD on cart page
        lp.getAddToCart().click();
        cp = new CartPage(driver);
        cp.getUpdateCart().click();
        String actualProductPrice = cp.getProductPrice().getText();
        
        Assert.assertEquals(actualProductPrice, expectedMiniDDPrice);
        log.info("After update cart, the expectedMiniDD Price is " + expectedMiniDDPrice + ", The actualMiniDD Price is " + actualProductPrice);
        
        // Update quantity to 4
        cp.getQuantity().clear();
        cp.getQuantity().sendKeys(prop.getProperty("quantity4"));
        
        // Update Cart
        cp.getUpdateCart().click();
        String expectedMiniDDPrice4 = prop.getProperty("MiniDDPrice4");
        // The actual price for 4 has been updated, so getText() again
        actualProductPrice = cp.getProductPrice().getText();
        Assert.assertEquals(actualProductPrice, expectedMiniDDPrice4);
        log.info("After update cart, the expectedMiniDD Price for 4 is " + expectedMiniDDPrice4 + ", The actualMiniDD Price for 4 is " + actualProductPrice); 
        
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}
	

}
