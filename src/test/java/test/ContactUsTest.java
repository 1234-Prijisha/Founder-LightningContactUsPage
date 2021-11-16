package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest extends BaseTest {

	WebDriver driver;

	public ContactUsTest(WebDriver driver) {
		this.driver = driver;
	}

	ContactUsPage pageObj = new ContactUsPage(driver);

	/**verify ContactUS page is opened successfully */
	@Test
	public void verifyContactUSPageOpenORNot() {
		String expectedPageHeading = "Contact US";
		String actulaPageHeading = pageObj.getPageHeading1().getText().concat(pageObj.getPageHeading2().getText()); //pageObj.getPageHeading1().getText()[normalize-space()]')[0].strip()
		Assert.assertEquals(actulaPageHeading, expectedPageHeading, "Error validating ContactUS page heading");
		System.out.println("ContactUS page is opened successfully");
	}

	/**verify all the validation message on  ContactUS page */
	@Test
	public void verifyAllValidationMgs() {
		pageObj.getSendMessageButton().click();
		List<WebElement> lst = pageObj.getErrorMessagelist();
		for(int i=0; i>lst.size();i++) {
			Assert.assertEquals(lst.get(i).getText(), "Please complete this required field.", "Error validating ContactUS  page error messages");
		}
		Assert.assertEquals(pageObj.getMainErrorMessage().getText(), "Please complete all required fields.", "Error validating ContactUS page Main error messages");
		System.out.println("ContactUSPage Heading validation messages verrified successfully");
	}

	/**verify ContactUS page email format should be xyz@abc.com*/
	public boolean verifyEmailFormat(String emailID){
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		//Matching the given email with regular expression
		boolean result = emailID.matches(regex);
		return result;
	}


	/**verify ContactUS page mobile number entered should be in range 0 to 9*/
	public boolean verifyMobileNumberRange(String mobNumber) {
		if (mobNumber.matches("\\d{10}"))  
			return true;  
		//validates phone numbers having digits, -, . or spaces  
		else if (mobNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))  
			return true;  
		else if (mobNumber.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))   
			return true;  
		//validates phone numbers having digits and area code in braces  
		else if (mobNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))  
			return true;  
		else if (mobNumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))  
			return true;  
		else if (mobNumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))  
			return true;  
		//return false if any of the input matches is not found  
		else  
			return false;  
	}


	/**verify ContactUS page send message functionality*/
	@Test
	public void verifySendMessageFun() {
		String mobileNumber = "9123456789";
		String emailId="test@gmail.com";
		pageObj.getFristName().sendKeys("Tester");
		pageObj.getLastName().sendKeys("Automation");

		pageObj.getMessage().sendKeys("automation test execution message");
		Select dropdown = new Select(pageObj.getDropDownHowDoyouHearAboutUS());
		dropdown.selectByIndex(7);
		while(!verifyEmailFormat(emailId)) {
			Assert.assertEquals(pageObj.getErrorMessage(), "Email must be formatted correctly.", "Error occured while validating email format error message");
		}			
		pageObj.getEmail().sendKeys(emailId);
		while(!verifyMobileNumberRange(mobileNumber)) {
			Assert.assertEquals(pageObj.getErrorMessage(), "Must contain only numbers, +()-. and x.", "Error occured while validating mobile number format error message");
		}	
		pageObj.getContactNumber().sendKeys(mobileNumber);
		pageObj.getSendMessageButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(pageObj.getMessageSentNote(), "Thank you for your message. We'll get back to you as soon as possible.", "Error occured while sending message");
		System.out.println("ContactUS page message sent successfully");
	}



}
