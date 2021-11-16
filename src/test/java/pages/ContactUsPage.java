package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage{
	WebDriver driver;
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	 public WebElement getPageHeading1() {
		 return driver.findElement(By.cssSelector(".display-4"));		 
	 }
	 public WebElement getPageHeading2() {
		 return driver.findElement(By.cssSelector("span[class='fw-bold']"));
	 }
	 
	 public WebElement getFristName() {
		 return driver.findElement(By.cssSelector("#firstname-b15d4232-7672-429d-81fd-a00020bddf95"));
	 }
	 
	 public WebElement getLastName() {
		 return driver.findElement(By.cssSelector("#lastname-b15d4232-7672-429d-81fd-a00020bddf95"));
	 }
	 
	 public WebElement getEmail() {
		 return driver.findElement(By.cssSelector("#email-b15d4232-7672-429d-81fd-a00020bddf95"));
	 }
	 
	 public WebElement getContactNumber() {
		 return driver.findElement(By.cssSelector("#mobilephone-b15d4232-7672-429d-81fd-a00020bddf95"));
	 }
	 
	 public WebElement getDropDownHowDoyouHearAboutUS() {
		 return driver.findElement(By.cssSelector("#how_did_you_hear_about_us_-b15d4232-7672-429d-81fd-a00020bddf95"));
	 }
	 
	 public WebElement getMessage() {
		 return driver.findElement(By.cssSelector("#message-b15d4232-7672-429d-81fd-a00020bddf95"));
	 }
	 
	 
	 public WebElement getSendMessageButton() {
		 return driver.findElement(By.cssSelector("input[value='Send Message >']"));
	 }
	 
	 public WebElement getMessageSentNote() {
		 return driver.findElement(By.cssSelector("#hbspt-form-1637017678866-9379588882>div>p"));
	 }
	 
	 public List<WebElement> getErrorMessagelist() {
		 return driver.findElements(By.cssSelector("label.hs-error-msg"));
	 }
	 
	 public WebElement getErrorMessage() {
		 return driver.findElement(By.cssSelector("label.hs-error-msg"));
	 }
	 
	 public WebElement getMainErrorMessage() {
		 return driver.findElement(By.cssSelector("label.hs-main-font-element"));
	 }
}

