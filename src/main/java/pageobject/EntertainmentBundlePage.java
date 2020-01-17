package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EntertainmentBundlePage {
	
	public WebDriver driver;
	
	public EntertainmentBundlePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By enterBundlePrice = By.xpath("//span[@id='ProductPrice-4427396153418']");
	private By addToCart = By.xpath("//span[@id='AddToCartText-4427396153418']");
	
	
	public WebElement getEnterBundlePrice() {
		return driver.findElement(enterBundlePrice);
	}
	
	public WebElement getAddToCart() {
		return driver.findElement(addToCart);
	}
	

}
