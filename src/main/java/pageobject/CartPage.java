package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	
	public WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	
    private By updateCart = By.xpath("//button[@name='update']");
    private By subtotal = By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[2]/p[1]");
    private By quantity = By.xpath("//input[@id='updates_30344862072906:7cac5367f66fb143686045358b0247ce']");
    private By productPrice = By.xpath("//span[@class='cart__price']");
    private By removeProduct = By.xpath("//a[@class='btn btn--tertiary btn--small']");
    
    
    public WebElement getUpdateCart() {
    	return driver.findElement(updateCart);
    }
    
    public WebElement getSubtotal() {
    	return driver.findElement(subtotal);
    }
    
    public WebElement getQuantity() {
    	return driver.findElement(quantity);
    }
    
    public WebElement getProductPrice() {
    	return driver.findElement(productPrice);
    }
    
    public WebElement getRemoveProduct() {
    	return driver.findElement(removeProduct);
    }
}
