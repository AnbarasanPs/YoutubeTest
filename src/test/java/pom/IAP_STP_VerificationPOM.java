package pom;

import org.openqa.selenium.By;

public class IAP_STP_VerificationPOM {
	public By adminPanelUsernameBox=By.xpath("//input[@name='email']");
	public By adminPanelPasswordBox=By.xpath("//input[@name='password']");
	public By adminPanelLogin=By.xpath("//button[text()='Login']");
	public By configuration=By.xpath("//div[text()='Configuration']");
	public By theme=By.xpath("//div[text()='Theme']");
	public By saveAndPreviewButton=By.xpath("//button[text()='Save & Preview']");
	public By landingPageButton=By.xpath("//button[text()='Landing Page']");
	
	public By bannerTitleInputBox=By.xpath("//input[@placeholder='Banner Title-1']");
	public By addNewImageButton=By.xpath("//div[@class='MuiBox-root css-1yq0r7u']//*[local-name()='svg']");
	public By chooseMediaButton=By.xpath("(//button[text()='Choose Media'])[1]");
	public By imageSelection=By.xpath("//td[text()='Poster Image']");
	public By summaryTitleInputBox=By.xpath("//input[@name='title']");
	public By contentAboveFooterInputBox=By.xpath("//div[contains(@class,'MuiOutlinedInput-root MuiInputBase-root')]//textarea[1]");
	public By statusLive=By.xpath("(//p[text()='The institute is in' and text()='Live' and text()=' mode.'])[2]");
	public By saveChangesYESbutton=By.xpath("//button[text()='YES']");

	public By forgotPassword=By.xpath("//a[text()='Forgot your password?']");
	public By sendRequest=By.xpath("//button[text()='Send Request']");
	public By setNewPassword=By.xpath("//input[@name='password']");
	public By reEnterNewPassword=By.xpath("//input[@name='repassword']");
	public By verifyPasswordButton=By.xpath("//button[text()='Verify']");
	
	public By stpLoginSignupButton=By.xpath("//button[text()='Login / SignUp']");
	public By SignupButton=By.xpath("//a[text()='Sign Up']");
	public By SignupNewUserMailBox=By.xpath("//input[@id='1-email']");
	public By SignupNewUserPasswordBox=By.xpath("//input[@name='password']");
	public By finalSignupButton=By.xpath("//button[@name='submit']");
	public By acceptButton=By.xpath("//button[text()='Accept']");
	public By stpLoginButton=By.xpath("//button[@aria-label='Log In']");
	
	public By stpForgotPassword=By.xpath("//a[@class='auth0-lock-alternative-link']");
	public By stpEmailBox=By.xpath("//input[@id='1-email']");
	public By stpSendEmailButton=By.xpath("//button[@id='1-submit']");
	public By stpPasswordResetConfirmButton=By.xpath("//button[@id='1-submit']");
	public By stpNewPasswordBox=By.xpath("//input[@id='password-reset']");
	public By stpReEnterNewPasswordBox=By.xpath("//input[@id='re-enter-password']");
	public By stpPasswordResetButton=By.xpath("//button[text()='Reset password']");
	public By stpBackToEduleyButton=By.xpath("//a[text()='Back to Eduley']");

	public By stpProfileButton=By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-w5qhhs']");
	public By stpLogoutButton=By.xpath("//li[text()='Logout']");
	
	
	
	
	
	

}
