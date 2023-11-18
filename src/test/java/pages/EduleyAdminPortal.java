package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import constants.Constants;
import pom.EduleyAdminPortalPOM;
import utilities.LocalHelper;
import utilities.TestUtil;

public class EduleyAdminPortal extends EduleyAdminPortalPOM {
	protected static final Logger logger = LoggerFactory.getLogger(EduleyAdminPortal.class);

	private final LocalHelper localHelper = new LocalHelper();

	private final WebDriver driver;
	public EduleyAdminPortal(WebDriver driver) {
		this.driver=driver;
	}
	public void launchEduleyAdminPortal(WebDriver driver) {
		driver.get(Constants.admin_url);
	}
	 public void enterAdminUserName() {
			localHelper.jsExecutorHighlight(userNameBox, driver);
			localHelper.sendKeys(userNameBox,new TestUtil().init_Properties().getProperty("adminUsername"),driver);
			logger.info("UserName passed in the Admin Username box");
		}
	 public void enterAdminPassword() {
			localHelper.jsExecutorHighlight(passwordBox, driver);
			localHelper.sendKeys(passwordBox,new TestUtil().init_Properties().getProperty("adminPassword"),driver);
			logger.info("Password passed in the Admin Password box");
		}
		public void clickLoginButton() {
			try {
				localHelper.jsExecutorHighlight(loginButton, driver);
				localHelper.clickElement(loginButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(loginButton, driver);
			}
			logger.info("Admin page login button is clicked");
		}
		public void clickInstitutes() {
			try {
				localHelper.jsExecutorHighlight(institutesLink, driver);
				localHelper.clickElement(institutesLink, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(institutesLink, driver);
			}
			logger.info("Institutes is clicked");
		}
		public void clickCreatedInstitute(String instituteName) {
			By xpath=By.xpath ("//a[text()='"+instituteName+"']");
			try {
				localHelper.jsExecutorHighlight(xpath, driver);
				localHelper.clickElement(xpath, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(xpath, driver);
			}
			logger.info("Created Institute is clicked");
		}
		public void enterPaymentMethodDetails() {
			 String value= localHelper.getText(paymentValue,driver);	
			 System.out.println(value);
			localHelper.selectDropdownByVisibleText(paymentMethodDropdown, value, driver);
			//localHelper.clickElement(paymentMethodDropdown, driver);
			//localHelper.clickElement(paymentValue, driver);
			logger.info("Payment method is selected");
		}
		public void enterLanguageDetails() {
			 String value= localHelper.getText(languageValue,driver);	
			localHelper.selectDropdownByVisibleText(languageDropdown, value, driver);
			//localHelper.clickElement(languageDropdown, driver);
			//localHelper.clickElement(languageValue, driver);
			logger.info("Language is selected");
		}
		public void enterCurrencyDetails() {
			 String value= localHelper.getText(currencyValue,driver);	
			localHelper.selectDropdownByVisibleText(currencyDropdown, value, driver);
			//localHelper.clickElement(currencyDropdown, driver);
			//localHelper.clickElement(currencyValue, driver);
			logger.info("Currency is selected");
		}
		public void clickIsActiveCheckBox() {
			try {
				localHelper.clickElement(isActive, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(isActive, driver);
			}
			logger.info("isActive checkbox is clicked");
		}
		public void clickIsApprovedCheckBox() {
			try {
				localHelper.clickElement(isApproved, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(isApproved, driver);
			}
			logger.info("isApproved checkbox is clicked");
		}
		public void clickSaveButton() {
			try {
				localHelper.jsExecutorHighlight(saveButton, driver);
				localHelper.clickElement(saveButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(saveButton, driver);
			}
			logger.info("save button is clicked");
		}
		public String checkInstituteActiveSuccessMessage() {
			localHelper.jsExecutorHighlight(InsActiveSuccessMsg, driver);
			return localHelper.getText(InsActiveSuccessMsg, driver);
		}
}
