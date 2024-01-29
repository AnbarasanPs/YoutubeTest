package pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pom.EduleyAutomationInstituteRegisterPOM;
import utilities.LocalHelper;
import utilities.TestUtil;

public class EduleyAutomationInstituteRegisterPage extends EduleyAutomationInstituteRegisterPOM {
	protected static final Logger logger = LoggerFactory.getLogger(EduleyAutomationInstituteRegisterPage.class);

	private final LocalHelper localHelper = new LocalHelper();
	private final TestUtil testUtil = new TestUtil();

	private final WebDriver driver;

	public EduleyAutomationInstituteRegisterPage(WebDriver driver) {
		this.driver=driver;
	}
	 public boolean CheckEduleyInstituteNameBox() {
		 localHelper.jsExecutorHighlight(instituteNameBox, driver);
		 return driver.findElement(instituteNameBox).isEnabled();
	 }
	 public void enterInstitutename(String institutename ) {
			localHelper.jsExecutorHighlight(instituteNameBox, driver);
			localHelper.sendKeys(instituteNameBox,institutename, driver);
			//localHelper.sendKeys(instituteNameBox,new TestUtil().init_Properties().getProperty("institutename"),driver);
			logger.info("Name passed in the Institutename box");
		}
		public void enterContactname() {
			localHelper.jsExecutorHighlight(contactNameBox, driver);
			localHelper.sendKeys(contactNameBox,new TestUtil().init_Properties().getProperty("contactname"),driver);
			logger.info("Name passed in the contact name box");
		}
		public void enterEmailId(String emailid) {
			localHelper.jsExecutorHighlight(emailBox, driver);
			//localHelper.sendKeys(emailBox,new TestUtil().init_Properties().getProperty("emailid"),driver);
		    localHelper.sendKeys(emailBox,emailid, driver);
			logger.info("Email id passed in the Email box");
		}
		public void enterTagLine() {
			localHelper.jsExecutorHighlight(tagLineBox, driver);
			localHelper.sendKeys(tagLineBox,new TestUtil().init_Properties().getProperty("tagline"),driver);
			logger.info("Entered Tagline ");
		}
		public void enterPhoneNumber(String phonenum) {
			localHelper.jsExecutorHighlight(phoneBox, driver);
			localHelper.sendKeys(phoneBox,phonenum,driver);
			logger.info("Phone number passed in the Phone number box");
		}
		public void enterAddress() {
			localHelper.jsExecutorHighlight(addressBox, driver);
			localHelper.sendKeys(addressBox,new TestUtil().init_Properties().getProperty("address"),driver);
			//localHelper.sendKeys(addressBox,address, driver);
			logger.info("Address passed in the Address box");
			 localHelper.clickElement(faviconIcon,driver);
		}
		public boolean CheckUploadLogoBoxIsEnabled() {
			localHelper.jsExecutorHighlight(logoChooseButton, driver);
			return driver.findElement(logoChooseButton).isEnabled();
		}
		 public void uploadLogoFromLocal() throws AWTException, InterruptedException {
				String file=System.getProperty("user.dir")+"\\Documents\\logo.png";
				localHelper.jsExecutorClick(logoChooseButton,driver);
				localHelper.uploadUsingRobot(file, driver, logoChooseButton);
				 logger.info("logo uploaded");
			}
		 public boolean CheckUploadFooterLogoBoxIsEnabled() {
				localHelper.jsExecutorHighlight(footerLogoChooseButton, driver);
				return driver.findElement(footerLogoChooseButton).isEnabled();
			}
		 
		 public void uploadFooterLogoFromLocal() throws AWTException, InterruptedException {
			// localHelper.scrollIntoView(instituteInformationText, driver);
				String file=System.getProperty("user.dir")+"\\Documents\\logo2.png";
				localHelper.jsExecutorClick(footerLogoChooseButton,driver);
				localHelper.uploadUsingRobot(file, driver, footerLogoChooseButton);
				 logger.info("Footer logo uploaded");
				 localHelper.scrollIntoView(faviconIcon,driver);
				 
			}
		 public boolean CheckUploadFaviconBoxIsEnabled() {
				localHelper.jsExecutorHighlight(faviconIconChooseButton, driver);
				return driver.findElement(faviconIconChooseButton).isEnabled();
				
			}
		 public void uploadFaviconIconFromLocal() throws AWTException, InterruptedException {
			 localHelper.scrollIntoView(primaryColorText,driver);
			 Thread.sleep(3000);
				String file=System.getProperty("user.dir")+"\\Documents\\logo3.jpg";
				try {
					 localHelper.clickElement(faviconIconChooseButton,driver);
				}catch (Exception e) {
					localHelper.jsExecutorClick(faviconIconChooseButton,driver);
				}
				localHelper.uploadUsingRobot(file, driver, faviconIconChooseButton);
				 logger.info("Favicon Icon uploaded");
			}
		 public void selectPrimaryColor() throws AWTException {
			 localHelper.clickElement(primaryColor,driver);
			// localHelper.clearElement(primaryColor,driver);
			 localHelper.clearUsingRobot();
				localHelper.sendKeys(primaryColor,new TestUtil().init_Properties().getProperty("primarycolor"),driver);
				 localHelper.clickElement(primaryColor,driver);
			  //  localHelper.sendKeys(primaryColor,"#45FF35", driver);
				logger.info("Primary color selected");
			}
		 public void selectSecondaryColor() throws AWTException {
			 localHelper.clickElement(secondaryColor,driver);
			// localHelper.clearElement(secondaryColor,driver);
			 localHelper.clearUsingRobot();
				localHelper.sendKeys(secondaryColor,new TestUtil().init_Properties().getProperty("secondarycolor"),driver);
				 localHelper.clickElement(secondaryColor,driver);
				 localHelper.clickElement(faviconIcon,driver);

			 //localHelper.sendKeys(secondaryColor,"#1810FF", driver);
				logger.info("Secondary color selected");
			}
		 
	   	public void clickSubmitButton() {
			try {
				localHelper.jsExecutorHighlight(submitButton, driver);
				localHelper.clickElement(submitButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(submitButton, driver);
			}
			logger.info("Register page submit button is clicked");
		}
	   	public String checkEduleyTitleMessageAfterSuccessfullyRegister() {
			localHelper.jsExecutorHighlight(titleMsg, driver);
			return localHelper.getText(titleMsg, driver);
		}
	
}