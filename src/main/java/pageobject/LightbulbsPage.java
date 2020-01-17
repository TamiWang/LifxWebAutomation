package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LightbulbsPage {
	
	public WebDriver driver;
	
	public LightbulbsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By miniDD = By.xpath("//div[@class='grid grid--uniform aos-init aos-animate']//div[1]//div[1]//a[1]//div[1]//div[1]//img[1]");
	private By miniDDPrice = By.xpath("//span[@id='ProductPrice-4156182167626']");
	private By addToCart = By.xpath("//span[@id='AddToCartText-4156182167626']");
	
	
	public WebElement getMiniDD() {
		return driver.findElement(miniDD);
	}
	
	public WebElement getMiniDDPrice() {
		return driver.findElement(miniDDPrice);
	}
	
	public WebElement getAddToCart() {
		return driver.findElement(addToCart);
	}

}
