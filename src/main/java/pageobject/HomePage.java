package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By logoLIFX = By.xpath("//img[@class='small--hide']");
	private By shop = By.xpath("//a[@class='site-nav__link site-nav__link--has-dropdown'][contains(text(),'Shop')]");
    private By headerValid = By.xpath("//h2[@class='section-header__title']");
	private By popup = By.xpath("//div[@class='privy-dismiss-content']");
    private By generallight = By.xpath("//a[@class='site-nav__dropdown-link site-nav__dropdown-link--second-level  site-nav__dropdown-link--has-children']");
    private By lightbulbs = By.linkText("Lightbulbs");
    private By downlights = By.linkText("Downlights");
    private By outdoor = By.linkText("Outdoor");
    private By switchlifx = By.linkText("LIFX Switch");
    private By homeEntertain = By.xpath("//a[contains(@class,'site-nav__dropdown-link--has-children')][contains(text(),'Home Entertainment')]");
    private By gaming = By.linkText("Gaming");
    private By tvLighting = By.linkText("TV Lighting");
    private By titleDisplay = By.xpath("//h2[@class='h1 hero__title']");
    
	public WebElement getLogoLifx() {
		return driver.findElement(logoLIFX);
	}
	
	public WebElement getShop() {
		return driver.findElement(shop);
	}
	
	public WebElement getValid() {
		return driver.findElement(headerValid);
	}
	
	public int getPopUpSize() {
		return driver.findElements(popup).size();
	}
	
	public WebElement getPopUp() {
		return driver.findElement(popup);
	}
	
	public WebElement getGeneral() {
		return driver.findElement(generallight);
		
	}
	
	public WebElement getLightbulbs() {
		return driver.findElement(lightbulbs);
		
	}
	
	public WebElement getDownlight() {
		return driver.findElement(downlights);
		
	}
	
	public WebElement getOutdoor() {
		return driver.findElement(outdoor);
		
	}
	
	public WebElement getSwitchLifx() {
		return driver.findElement(switchlifx);
		
	}
	
	public WebElement getHomeEntertain() {
		return driver.findElement(homeEntertain);
	}
	
	public WebElement getGaming() {
		return driver.findElement(gaming);
	}
	
	public WebElement getTVLight() {
		return driver.findElement(tvLighting);
	}
	
	public WebElement getTitle() {
		return driver.findElement(titleDisplay);
		
	}


	
}
