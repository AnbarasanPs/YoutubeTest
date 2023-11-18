package pages;

import java.util.Set;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import constants.Constants;
import pom.IAP_STP_VerificationPOM;
import utilities.LocalHelper;

public class IAP_STP_VerificationPage extends IAP_STP_VerificationPOM {
	
	protected static final Logger logger = LoggerFactory.getLogger(IAP_STP_VerificationPage.class);

	private final LocalHelper localHelper = new LocalHelper();

	private final WebDriver driver;
	public IAP_STP_VerificationPage(WebDriver driver) {
		this.driver=driver;
	}
	public void launchInstituteAdminPanel(WebDriver driver) {
		driver.get(Constants.institute_url);
	}
	public void launchStudentPortel(String stp_url,WebDriver driver) {
		driver.get(stp_url);
	}
	public void enterAdminPanelUserName() throws InterruptedException {
		localHelper.jsExecutorHighlight(adminPanelUsernameBox, driver);
		try {
			localHelper.clickElement(adminPanelUsernameBox, driver);
			Thread.sleep(3000);
		localHelper.sendKeys(adminPanelUsernameBox,Mailinator.userLoginMail,driver);
	//	localHelper.clickElement(adminPanelPasswordBox, driver);
		}catch (StaleElementReferenceException e) {
			localHelper.clickElement(adminPanelUsernameBox, driver);
			localHelper.sendKeys(adminPanelUsernameBox,Mailinator.userLoginMail,driver);
		//	localHelper.clickElement(adminPanelPasswordBox, driver);
		}
		Thread.sleep(3000);
		logger.info("UserName passed in the Admin panel Username box");
	}
	public void enterAdminPanelPassword() {
		localHelper.jsExecutorHighlight(adminPanelPasswordBox, driver);
		localHelper.sendKeys(adminPanelPasswordBox,Constants.commonpassword,driver);
		logger.info("Password passed in the Admin panel Password box");
	}
	public void clickLoginButton() {
		try {
			localHelper.jsExecutorHighlight(adminPanelLogin, driver);
			localHelper.clickElement(adminPanelLogin, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(adminPanelLogin, driver);
		}
		logger.info("Admin panel login button is clicked");
	}
	public void clickConfigurationDropdown() {
		try {
			localHelper.jsExecutorHighlight(configuration, driver);
			localHelper.clickElement(configuration, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(configuration, driver);
		}
		logger.info("IAP  configuration button is clicked");
	}
	public void clickTheme() {
		try {
			localHelper.jsExecutorHighlight(theme, driver);
			localHelper.clickElement(theme, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(theme, driver);
		}
		localHelper.scrollIntoView(saveAndPreviewButton,driver);
		logger.info("IAP Theme is clicked");
	}
	public void clickLandingPageButton() {
		try {
			localHelper.jsExecutorHighlight(landingPageButton, driver);
			localHelper.clickElement(landingPageButton, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(landingPageButton, driver);
		}
		logger.info("IAP landingPage is clicked");
	}
	public void enterBannerTitle(String bannerTitle) {
		localHelper.jsExecutorHighlight(bannerTitleInputBox, driver);
		localHelper.sendKeys(bannerTitleInputBox,bannerTitle,driver);
		logger.info("Banner title passed in the landing page banner title inputbox");
	}
	public void clickAddNewImageButton() {
		try {
			localHelper.clickElement(addNewImageButton, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(addNewImageButton, driver);
		}
		logger.info("IAP landingPage Add new image button is clicked");
	}
	public void clickChooseMediaButton() {
		try {
			localHelper.clickElement(chooseMediaButton, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(chooseMediaButton, driver);
		}
		logger.info("IAP landingPage choose Media Button button is clicked");
	}
	public void selectImage() {
		try {
			localHelper.clickElement(imageSelection, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(imageSelection, driver);
		}
		logger.info("IAP landingPage Media Image is selected");
	}
	public void enterSummaryTitle(String summaryTitle) {
		localHelper.jsExecutorHighlight(summaryTitleInputBox, driver);
		localHelper.sendKeys(summaryTitleInputBox,summaryTitle,driver);
		logger.info("summary title passed in the landing page summary title inputbox");
	}
	public void enterContentAboveFooter(String footerContent) {
		localHelper.jsExecutorHighlight(contentAboveFooterInputBox, driver);
		localHelper.sendKeys(contentAboveFooterInputBox,footerContent,driver);
		logger.info("Footer above content passed in the landing page footer content inputbox");
	}
	
  	public String checkEduleyIAPLandingPageStatus() {
			localHelper.jsExecutorHighlight(statusLive, driver);
			return localHelper.getText(statusLive, driver);
		}
  	public void clickIAPLandingPageSaveAndPreviewButton() {
		try {
			localHelper.clickElement(saveAndPreviewButton, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(saveAndPreviewButton, driver);
		}
		logger.info("IAP landingPage Save And Preview Button is clicked");
	}
  	public void clickIAPLandingPageSaveChangesYesButton() {
		try {
			localHelper.clickElement(saveChangesYESbutton, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(saveChangesYESbutton, driver);
		}
		logger.info("IAP landingPage SaveChanges YESbutton is clicked");
	}
		
	public void clickForgotPassword() {
		try {
			localHelper.jsExecutorHighlight(forgotPassword, driver);
			localHelper.clickElement(forgotPassword, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(forgotPassword, driver);
		}
		logger.info("Admin panel forgot password  is clicked");
	}
	public void clickSendRequestButton() {
		try {
			localHelper.jsExecutorHighlight(sendRequest, driver);
			localHelper.clickElement(sendRequest, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(sendRequest, driver);
		}
		logger.info("forgot password send request is clicked");
	}
	public void enterSetNewPassword() {
		localHelper.jsExecutorHighlight(setNewPassword, driver);
		localHelper.sendKeys(setNewPassword,Constants.commonpassword,driver);
		logger.info("Password passed in the Admin panel new Password box");
	}
	public void enterReEnterNewPassword() {
		localHelper.jsExecutorHighlight(reEnterNewPassword, driver);
		localHelper.sendKeys(reEnterNewPassword,Constants.commonpassword,driver);
		logger.info("Password passed in the Admin panel re-enter  Password box");
	}
	public void clickPasswordVerifyButton() {
		try {
			localHelper.jsExecutorHighlight(verifyPasswordButton, driver);
			localHelper.clickElement(verifyPasswordButton, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(verifyPasswordButton, driver);
		}
		logger.info("New password verify button is clicked");
	}
	public void clickSTPLoginSignupButton() {
		try {
			localHelper.jsExecutorHighlight(stpLoginSignupButton, driver);
			localHelper.clickElement(stpLoginSignupButton, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(stpLoginSignupButton, driver);
		}
		logger.info("STP Login/Signup button is clicked");
	}
	public void clickSTPSignupButton() {
		try {
			localHelper.jsExecutorHighlight(SignupButton, driver);
			localHelper.clickElement(SignupButton, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(SignupButton, driver);
		}
		logger.info("STP Signup button is clicked");
	}
	public void enterNewSTPUserEmail(String stpuseremail ) {
		localHelper.jsExecutorHighlight(SignupNewUserMailBox, driver);
		localHelper.sendKeys(SignupNewUserMailBox,stpuseremail,driver);
		logger.info("STP User mail passed in the user email inputbox");
	}
	public void enterNewSTPUserPasssword(String stpuserpassword ) {
		localHelper.jsExecutorHighlight(SignupNewUserPasswordBox, driver);
		localHelper.sendKeys(SignupNewUserPasswordBox,stpuserpassword,driver);
		logger.info("STP User password passed in the user password inputbox");
	}
	public void clickSTPFinalSignupButton() {
		try {
			localHelper.jsExecutorHighlight(finalSignupButton, driver);
			localHelper.clickElement(finalSignupButton, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(finalSignupButton, driver);
		}
		logger.info("STP final signup button is clicked");
	}
	public void clickAcceptButton() {
		try {
			localHelper.jsExecutorHighlight(acceptButton, driver);
			localHelper.clickElement(acceptButton, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(acceptButton, driver);
		}
		logger.info("STP final accept button is clicked");
	}
	public void clickFinalLoginButton() {
		try {
			localHelper.jsExecutorHighlight(stpLoginButton, driver);
			localHelper.clickElement(stpLoginButton, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(stpLoginButton, driver);
		}
		logger.info("STP final Login button is clicked");
	}
public void switchToNewWindow(WebDriver driver) {
		
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			if(!string.contains(windowHandle)) {
				driver.switchTo().window(string);
	
			}
		}
		logger.info("Switched to new window");
	}
public void switchToNewWindowByUsingTitle(WebDriver driver) {

	String windowHandle = driver.getWindowHandle();
	Set<String> windowHandles = driver.getWindowHandles();
	for (String string : windowHandles) {
		driver.switchTo().window(string);

		 String pageTitle = driver.getTitle();
		 System.out.println(pageTitle);
		if(pageTitle.contains("Sign In with Auth0")) {
       break;
		}
	}
	logger.info("Switched to new window");
}
public void clickSTPProfileButton() {
	try {
		localHelper.jsExecutorHighlight(stpProfileButton, driver);
		localHelper.clickElement(stpProfileButton, driver);
	}catch (ElementClickInterceptedException m) {
		localHelper.jsExecutorClick(stpProfileButton, driver);
	}
	logger.info("STP profile button is clicked");
}
public void clickSTPLogoutButton() {
	try {
		localHelper.jsExecutorHighlight(stpLogoutButton, driver);
		localHelper.clickElement(stpLogoutButton, driver);
	}catch (ElementClickInterceptedException m) {
		localHelper.jsExecutorClick(stpLogoutButton, driver);
	}
	logger.info("STP Logout button is clicked");
}

public void enterSTPUserEmail(String stpuseremail ) {
	localHelper.jsExecutorHighlight(stpEmailBox, driver);
	localHelper.sendKeys(stpEmailBox,stpuseremail,driver);
	logger.info("STP User mail passed in the user email inputbox");
}
public void clickSTPForgotPasswordButton() {
	try {
		localHelper.jsExecutorHighlight(stpForgotPassword, driver);
		localHelper.clickElement(stpForgotPassword, driver);
	}catch (ElementClickInterceptedException m) {
		localHelper.jsExecutorClick(stpForgotPassword, driver);
	}
	logger.info("STP Forgot Password button is clicked");
}
public void clickSTPSendEmailButton() {
	try {
		localHelper.jsExecutorHighlight(stpSendEmailButton, driver);
		localHelper.clickElement(stpSendEmailButton, driver);
	}catch (ElementClickInterceptedException m) {
		localHelper.jsExecutorClick(stpSendEmailButton, driver);
	}
	logger.info("STP Send Email button is clicked");
}
public void clickSTPPasswordResetConfirmButton() {
	try {
		localHelper.jsExecutorHighlight(stpPasswordResetConfirmButton, driver);
		localHelper.clickElement(stpPasswordResetConfirmButton, driver);
	}catch (ElementClickInterceptedException m) {
		localHelper.jsExecutorClick(stpPasswordResetConfirmButton, driver);
	}
	logger.info("STP Password Reset Confirm button is clicked");
}
public void enterSTPNewPassword(String stpnewpassword ) {
	localHelper.jsExecutorHighlight(stpNewPasswordBox, driver);
	localHelper.sendKeys(stpNewPasswordBox,stpnewpassword,driver);
	logger.info("STP user Password passed in the  inputbox");
}
public void reEnterSTPNewPassword(String stpnewpassword ) {
	localHelper.jsExecutorHighlight(stpReEnterNewPasswordBox, driver);
	localHelper.sendKeys(stpReEnterNewPasswordBox,stpnewpassword,driver);
	logger.info("STP user Password reentered in the  inputbox");
}
public void clickSTPPasswordResetButton() {
	try {
		localHelper.jsExecutorHighlight(stpPasswordResetButton, driver);
		localHelper.clickElement(stpPasswordResetButton, driver);
	}catch (ElementClickInterceptedException m) {
		localHelper.jsExecutorClick(stpPasswordResetButton, driver);
	}
	logger.info("STP Password Reset button is clicked");
}
public void clickSTPBackToEduleyButton() {
	try {
		localHelper.jsExecutorHighlight(stpBackToEduleyButton, driver);
		localHelper.clickElement(stpBackToEduleyButton, driver);
	}catch (ElementClickInterceptedException m) {
		localHelper.jsExecutorClick(stpBackToEduleyButton, driver);
	}
	logger.info("STP BackToEduley Button is clicked");
}


}
