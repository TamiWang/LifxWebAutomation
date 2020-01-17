package automation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.CartPage;
import pageobject.EntertainmentBundlePage;
import pageobject.HomePage;
import resources.Base;

public class EntertainmentBundleTest extends Base{
	
	// Adding logs using log4j
	public static Logger log = LogManager.getLogger(EntertainmentBundleTest.class.getName());
	
	public WebDriver driver;
	private HomePage hp;
	private EntertainmentBundlePage ebp;
	private CartPage cp;
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		
		Thread.sleep(3000);
		
		hp = new HomePage(driver);
		if(hp.getPopUpSize() > 0) {
			// If pop-up, click "x" button
			hp.getPopUp().click();
		}
	}
	
	// Verify Entertainment Bundle Price
	@Test
	public void entertainBundleTest() throws IOException {

		hp = new HomePage(driver);
		ebp = new EntertainmentBundlePage(driver);
		
		// Verify the price on entertainment-bundle page
		hp.getEntertainBundle().click();
		String expectedPrice = prop.getProperty("EnterBundlePrice");
		String actualPrice = ebp.getEnterBundlePrice().getText();
		Assert.assertEquals(actualPrice, expectedPrice);
		log.info("The price of Entertainment Bundle has been verified.");
		
		// Add to cart
		ebp.getAddToCart().click();
		
		// Verify subtotal price
		cp = new CartPage(driver);
		cp.getUpdateCart().click();
		String actualSubtotal = cp.getSubtotal().getText();
		Assert.assertEquals(actualSubtotal, expectedPrice);
		log.info("The subtotal price of cart has been verified.");
		log.info("The expectedSubtotal is " + expectedPrice + ". The actualSubtotal is " + actualSubtotal);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}

}
