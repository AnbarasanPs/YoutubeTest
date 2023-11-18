package com.dev.Eduley;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import constants.Constants;
import pages.EduleyAdminPortal;
import pages.EduleyAutomationInstituteRegisterPage;
import pages.IAP_AddCourseVerificationPage;
import pages.IAP_STP_VerificationPage;
import pages.Mailinator;
import pages.YopMail;

public class EduleyAutomationInstituteRegister extends BaseClass {
	Faker faker = new Faker();
	public static String instituteName;
	public static String emailid;
	public static String emailidSTP;
	public static String currentIAP_Url;
	
	private EduleyAutomationInstituteRegisterPage eduleyAutomationInstituteReg;
	private EduleyAdminPortal eduleyAdminPortal;
	private YopMail yopMail;
	private IAP_STP_VerificationPage iap_StpVerification;
	private Mailinator mailinator;
	private IAP_AddCourseVerificationPage iap_AddCourseVerificationPage;
	

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		logger.info("Initial setup is in progress");
	}

	@Test(priority = 0,enabled = true)
	public void eduleyInstituteRegister() throws AWTException, InterruptedException{
		logger.info("Fill the details in register page and submit");
		eduleyAutomationInstituteReg=new EduleyAutomationInstituteRegisterPage(driver);
		eduleyAutomationInstituteReg.CheckEduleyInstituteNameBox();
		instituteName=faker.name().firstName()+"Academy";
		eduleyAutomationInstituteReg.enterInstitutename(instituteName);
		eduleyAutomationInstituteReg.enterContactname();
		emailid=faker.name().firstName()+".eduley876@mailinator.com";
		eduleyAutomationInstituteReg.enterEmailId(emailid);
		eduleyAutomationInstituteReg.enterTagLine();
		eduleyAutomationInstituteReg.enterPhoneNumber(faker.number().digits(10));
		eduleyAutomationInstituteReg.enterAddress();
		logger.info("Checking Upload Logo box is enabled or not");
		Assert.assertTrue(eduleyAutomationInstituteReg.CheckUploadLogoBoxIsEnabled(), "LaterActivateButton is Enabled");
		logger.info("Upload Logo box is enabled");
		eduleyAutomationInstituteReg.uploadLogoFromLocal();
		logger.info("Checking Upload Footer Logo box is enabled or not");
		Assert.assertTrue(eduleyAutomationInstituteReg.CheckUploadFooterLogoBoxIsEnabled(), "LaterActivateButton is Enabled");
		logger.info("Upload Footer Logo box is enabled");
		eduleyAutomationInstituteReg.uploadFooterLogoFromLocal();
		logger.info("Checking Upload Favicon  box is enabled or not");
		Assert.assertTrue(eduleyAutomationInstituteReg.CheckUploadFaviconBoxIsEnabled(), "LaterActivateButton is Enabled");
		logger.info("Upload Favicon Logo box is enabled");
		eduleyAutomationInstituteReg.uploadFaviconIconFromLocal();
		eduleyAutomationInstituteReg.selectPrimaryColor();
		eduleyAutomationInstituteReg.selectSecondaryColor();
		
		eduleyAutomationInstituteReg.clickSubmitButton();
		eduleyAutomationInstituteReg.checkEduleyTitleMessageAfterSuccessfullyRegister();
		logger.info("Checking Title message received on after successfully register ");
		Assert.assertEquals(eduleyAutomationInstituteReg.checkEduleyTitleMessageAfterSuccessfullyRegister(), "We have received your request. You will get login credentials once your institute is approved.","Verifying Registration successfully");
		logger.info("Title message received on after successfully register");
		
		logger.info("Login the Eduley Admin portal and active the Institute ");
    	eduleyAdminPortal=new EduleyAdminPortal(driver);
    	eduleyAdminPortal.launchEduleyAdminPortal(driver);
    	eduleyAdminPortal.enterAdminUserName();
    	eduleyAdminPortal.enterAdminPassword();
    	eduleyAdminPortal.clickLoginButton();
    	eduleyAdminPortal.clickInstitutes();
    	eduleyAdminPortal.clickCreatedInstitute(instituteName);
    	eduleyAdminPortal.enterPaymentMethodDetails();
    	eduleyAdminPortal.enterLanguageDetails();
    	eduleyAdminPortal.enterCurrencyDetails();
    	eduleyAdminPortal.clickIsActiveCheckBox();
    	eduleyAdminPortal.clickIsApprovedCheckBox();
    	eduleyAdminPortal.clickSaveButton();
    	logger.info("Checking Institute Active success message received or not ");
		Assert.assertEquals(eduleyAdminPortal.checkInstituteActiveSuccessMessage(), "The institute “"+instituteName+"” was changed successfully.","Verifying Institute Activation successfully");
		logger.info("Institute Active success message received");
	}
	
	@Test(priority = 1,enabled = true,dependsOnMethods = "eduleyInstituteRegister")
	public void eduleyIAPForgotPasswordVerification() throws AWTException, InterruptedException{
		logger.info("Verification of IAP while clicking forgetPassword");
		mailinator=new Mailinator(driver);
		mailinator.launchMailinatorMail(driver);
		mailinator.enterEmail(emailid);
		mailinator.clickEduleyApprovedMail();
		mailinator.switchToFrame1(driver);
		mailinator.getMailAndPassword();
		iap_StpVerification=new IAP_STP_VerificationPage(driver);
		iap_StpVerification.launchInstituteAdminPanel(driver);
		iap_StpVerification.enterAdminPanelUserName();
		iap_StpVerification.clickForgotPassword();
		iap_StpVerification.enterAdminPanelUserName();
		iap_StpVerification.clickSendRequestButton();
		mailinator=new Mailinator(driver);
		mailinator.launchMailinatorMail(driver);
		mailinator.enterEmail(emailid);
		mailinator.clickResetPasswordMail();
		mailinator.switchToFrame1(driver);
		mailinator.clickResetPasswordButton();
		mailinator.switchToNewAdminPortalWindow(driver);
		 iap_StpVerification.enterSetNewPassword();
		 iap_StpVerification.enterReEnterNewPassword();
		 iap_StpVerification.clickPasswordVerifyButton();
	
		
	}
    	@Test(priority = 2,enabled = true,dependsOnMethods = "eduleyIAPForgotPasswordVerification")
    	public void eduleyIAPLoginVerification() throws AWTException, InterruptedException{
    		logger.info("Verification of IAP while clicking forgetPassword");
    		mailinator=new Mailinator(driver);
    		mailinator.launchMailinatorMail(driver);
    		mailinator.enterEmail(emailid);
    		mailinator.clickEduleyApprovedMail();
    		mailinator.switchToFrame1(driver);
    		mailinator.getMailAndPassword();
    		iap_StpVerification=new IAP_STP_VerificationPage(driver);
    		iap_StpVerification.launchInstituteAdminPanel(driver);
    		iap_StpVerification.enterAdminPanelUserName();
    		iap_StpVerification.enterAdminPanelPassword();
    		iap_StpVerification.clickLoginButton();
    		iap_StpVerification.clickConfigurationDropdown();
    		iap_StpVerification.clickTheme();
    		iap_StpVerification.clickLandingPageButton();
    		iap_StpVerification.clickAddNewImageButton();
    		String bannerTitle=faker.lorem().word();
    		iap_StpVerification.enterBannerTitle(bannerTitle);
    		iap_StpVerification.clickChooseMediaButton();
    		iap_StpVerification.selectImage();
    		String summaryTitle=faker.name().title();
    		iap_StpVerification.enterSummaryTitle(summaryTitle);
    		String footerContent=faker.lorem().sentence();
    		iap_StpVerification.enterContentAboveFooter(footerContent);
    		iap_StpVerification.checkEduleyIAPLandingPageStatus();
    		iap_StpVerification.clickIAPLandingPageSaveAndPreviewButton();
    		iap_StpVerification.clickIAPLandingPageSaveChangesYesButton();
    		Thread.sleep(5000);
    		iap_StpVerification.switchToNewWindow(driver);
    		 currentIAP_Url = driver.getCurrentUrl();
    		 System.out.println(currentIAP_Url);
    	
    			
    	}

    	@Test(priority = 3,enabled = true,dependsOnMethods = "eduleyIAPLoginVerification")
    	public void eduleySTP_SignupAndLoginVerification() throws AWTException, InterruptedException{
    		logger.info("Verification of STP Signup and Login");
    		iap_StpVerification=new IAP_STP_VerificationPage(driver);
    		iap_StpVerification.launchStudentPortel(currentIAP_Url, driver);
    		iap_StpVerification.clickSTPLoginSignupButton();
    		Thread.sleep(3000);
    		iap_StpVerification.switchToNewWindowByUsingTitle(driver);
    		iap_StpVerification.clickSTPSignupButton();
    		emailidSTP=faker.name().firstName()+".eduley543@mailinator.com";
    		iap_StpVerification.enterNewSTPUserEmail(emailidSTP);
    		iap_StpVerification.enterNewSTPUserPasssword(Constants.commonpassword);
    		iap_StpVerification.clickSTPFinalSignupButton();
    		iap_StpVerification.clickAcceptButton();
    		
    		iap_StpVerification.switchToNewWindow(driver);
    		iap_StpVerification.clickSTPProfileButton();
    		iap_StpVerification.clickSTPLogoutButton();
    	      	
}

    	@Test(priority = 4,enabled = true,dependsOnMethods = "eduleySTP_SignupAndLoginVerification")
    	public void eduleySTP_ForgotPasswordVerification() throws AWTException, InterruptedException{
    		logger.info("Verification of STP Signup and Login");
    		iap_StpVerification=new IAP_STP_VerificationPage(driver);
    		iap_StpVerification.launchStudentPortel(currentIAP_Url, driver);
    		
    		iap_StpVerification.clickSTPLoginSignupButton();
    		iap_StpVerification.switchToNewWindowByUsingTitle(driver);
    		iap_StpVerification.enterSTPUserEmail(emailidSTP);
    		iap_StpVerification.clickSTPForgotPasswordButton();
    		iap_StpVerification.clickSTPSendEmailButton();
    		iap_StpVerification.switchToNewWindow(driver);
    		mailinator=new Mailinator(driver);
    		mailinator.launchMailinatorMail(driver);
    		mailinator.enterEmail(emailidSTP);
    		mailinator.clickResetPasswordMail();
    		mailinator.switchToFrame1(driver);
    		mailinator.clickResetPasswordConfirmButton();
    		iap_StpVerification.switchToNewWindow(driver);
    		iap_StpVerification.enterSTPNewPassword(Constants.commonpassword);
    		iap_StpVerification.reEnterSTPNewPassword(Constants.commonpassword);
    		iap_StpVerification.clickSTPPasswordResetButton();
    		iap_StpVerification.clickSTPBackToEduleyButton();
    		
    	}
    	@Test(priority = 5,enabled = true,dependsOnMethods = "eduleySTP_SignupAndLoginVerification")
    	public void eduleyIAPAddCourse() throws AWTException, InterruptedException{
    		logger.info("Add course in institute admin page ");
    		iap_AddCourseVerificationPage=new IAP_AddCourseVerificationPage(driver);
    		iap_AddCourseVerificationPage.launchInstituteAdminPanel(driver);
    		iap_AddCourseVerificationPage.enterAdminPanelUserName();
    		iap_AddCourseVerificationPage.enterAdminPanelPassword();
    		iap_AddCourseVerificationPage.clickLoginButton();
    		iap_AddCourseVerificationPage.clickCourseDropdown();
    		iap_AddCourseVerificationPage.clickCourseListButton();
    		iap_AddCourseVerificationPage.clickAddCourseButton();
    		logger.info("Checking Course name box is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseBasicInfoCourseNameBox(), "Course name box is displayed");
    		logger.info("Course name box is present");
    		iap_AddCourseVerificationPage.enterCourseName();
    		logger.info("Checking Course Short Description box is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseBasicInfoShortDescriptionBox(), "Course Short Description box is displayed");
    		logger.info("Course Short Description box is present");
    		iap_AddCourseVerificationPage.enterCourseShortDescription();
    		logger.info("Checking Course Description box is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseBasicInfoDescriptionBox(), "Course Description box is displayed");
    		logger.info("Course Description box is present");
    		iap_AddCourseVerificationPage.enterCourseDescription();
    		logger.info("Checking Course Students Learn box is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseBasicInfoWhatStudentsLearnBox(), "Course Students Learn box is displayed");
    		logger.info("Course Students Learn box is present");
    		iap_AddCourseVerificationPage.enterWhatStudentsLearnOurCourse();
    		logger.info("Checking Course PreRequisites box is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseBasicInfoPreRequisitesBox(), "Course PreRequisites box is displayed");
    		logger.info("Course PreRequisites box is present");
    		iap_AddCourseVerificationPage.enterPreRequisites();
    		logger.info("Checking Course Level Dropdown is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseBasicInfoCourseLevelDropdown(), "Course Level Dropdown box is displayed");
    		logger.info("Course Level Dropdown box is present");
    		iap_AddCourseVerificationPage.enterCourseLevelBeginner();
    		logger.info("Checking Course Language Dropdown is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseBasicInfoCourseLanguageDropdown(), "Course Language Dropdown is displayed");
    		logger.info("Course Language Dropdown is present");
    		iap_AddCourseVerificationPage.enterCourseLanguage();
    		logger.info("Checking Course Duration Box is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseBasicInfoCourseDurationInputbox(), "Course Duration Box is displayed");
    		logger.info("Course Duration Box is present");
    		iap_AddCourseVerificationPage.enterCourseDuration();
    		logger.info("Checking Course Instructor Box is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseBasicInfoInstructorInputbox(), "Course Instructor Box is displayed");
    		logger.info("Course Instructor Box is present");
    		iap_AddCourseVerificationPage.enterInstrutor();
    		logger.info("Checking Course Reviewer Box is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseBasicInfoAddReviewerInputbox(), "Course Reviewer Box is displayed");
    		logger.info("Course Reviewer Box is present");
    		iap_AddCourseVerificationPage.enterReviewer();
    		logger.info("Checking Course Category Dropdown is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseBasicInfoCourseCategoryDropdown(), "Course Category Dropdown is displayed");
    		logger.info("Course Category Dropdown is present");
    		iap_AddCourseVerificationPage.enterCourseCategoryTechnology();
    		logger.info("Checking Course Graduation weeks inputbox is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseBasicInfoPostGraduationWeeksInputbox(), "Course Graduation weeks inputbox is displayed");
    		logger.info("Course Graduation weeks inputbox is present");
    		iap_AddCourseVerificationPage.enterAccessPostGraduationWeeks();
    		iap_AddCourseVerificationPage.clickCourseCompletionAwardYes();
    		iap_AddCourseVerificationPage.clickandValidateFreeCourseCheckbox();
    		logger.info("Checking Price Of Course inputbox is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseBasicInfoPriceOfCourseInputbox(), "Course Price Of Course inputbox is displayed");
    		logger.info("Price Of Course inputbox is present");
    		iap_AddCourseVerificationPage.enterPriceOfCourse();
    		iap_AddCourseVerificationPage.clickFirstSectionFreeCheckbox();
    		iap_AddCourseVerificationPage.clickCourseRunsInCohortsYes();
    		iap_AddCourseVerificationPage.clickCourseRunsInCohortsNo();
    		iap_AddCourseVerificationPage.clickCourseRunsInCohortsDelete();
    		iap_AddCourseVerificationPage.clickBasicInfoPageNextButton();
    		
    		//Curriculam page
    		iap_AddCourseVerificationPage.clickCurriculamAddSectionButton();
    		iap_AddCourseVerificationPage.enterCurriculamAddSectionInputbox();
    		logger.info("Checking Add Section inputbox is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseCurriculamAddSectionInputbox(), "Add Section inputbox is displayed");
    		logger.info("Add Section inputbox is present");
    		iap_AddCourseVerificationPage.clickCurriculamAddSectionTickIcon();
    		//Lesson 
    		iap_AddCourseVerificationPage.clickCurriculamAddContentButton();
    		iap_AddCourseVerificationPage.clickContentTypeLessonRadioButton();
    		logger.info("Checking Add Course Lesson Name box is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseLessonNamebox(), "Add Course Lesson Name box is displayed");
    		logger.info("Add Course Lesson Name box is present");
    		iap_AddCourseVerificationPage.enterLessonName();
    		iap_AddCourseVerificationPage.uploadLessonAttachmentFile();
    		logger.info("Checking Add Course Lesson Description box is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseLessonDescriptionBox(), "Add Course Lesson Description box is displayed");
    		logger.info("Add Course Lesson Description box is present");
    		iap_AddCourseVerificationPage.enterLessonDescription();
    		logger.info("Checking Add Course Start Date Calander box is present or not");
    		Assert.assertTrue(iap_AddCourseVerificationPage.CheckAddCourseStartDateCalanderInputbox(), "Add Course Start Date Calander box is displayed");
    		logger.info("Add Course Start Date Calander box is present");
    		iap_AddCourseVerificationPage.enterCourseStartDate();
    		iap_AddCourseVerificationPage.clickSkipContentCheckbox();
    		iap_AddCourseVerificationPage.clickSaveContentButton();
    		//Quiz
    		iap_AddCourseVerificationPage.clickCurriculamAddContentButton();
    		iap_AddCourseVerificationPage.clickContentTypeQuizRadioButton();
    		iap_AddCourseVerificationPage.CheckAddCourseQuizTitlebox();
    		iap_AddCourseVerificationPage.enterQuizTitle();
    		iap_AddCourseVerificationPage.CheckAddCourseQuizDescriptionbox();
    		iap_AddCourseVerificationPage.enterQuizDescription();
    		iap_AddCourseVerificationPage.CheckAddCourseQuizTimeAllowedbox();
    		iap_AddCourseVerificationPage.enterQuizTimeAllowed();
    		iap_AddCourseVerificationPage.clickNoOfAttemptsCheckbox();
    		iap_AddCourseVerificationPage.enterQuizNoOfAttempts();
    		//iap_AddCourseVerificationPage.clickQuizHaveMCQquestionsCheckbox();
    		iap_AddCourseVerificationPage.CheckQuizDisplayQuestionsInputbox();
    		iap_AddCourseVerificationPage.enterQuizDisplayQuestions();
    		iap_AddCourseVerificationPage.CheckQuizMarksPerMCQInputbox();
    		iap_AddCourseVerificationPage.enterQuizMarkPerMCQ();
    		iap_AddCourseVerificationPage.CheckQuizTotalMarksInputbox();
    		iap_AddCourseVerificationPage.enterQuizTotalMarks();
    		iap_AddCourseVerificationPage.CheckQuizPassinglMarksInputbox();
    		iap_AddCourseVerificationPage.enterQuizPassingMarks();
    		iap_AddCourseVerificationPage.CheckQuizStartDateCalanderInputbox();
    		iap_AddCourseVerificationPage.enterQuizStartDate();
    		iap_AddCourseVerificationPage.clickQuizSkipContentCheckbox();
    		iap_AddCourseVerificationPage.CheckQuizMCQButton();
    		iap_AddCourseVerificationPage.CheckQuizAddQuestionButton();
    		iap_AddCourseVerificationPage.clickQuizAddQuestionButton();
    		iap_AddCourseVerificationPage.CheckQuizQuestionInputbox();
    		iap_AddCourseVerificationPage.enterQuizQuestion1();
    		iap_AddCourseVerificationPage.uploadQuizMediaImage();
    		iap_AddCourseVerificationPage.CheckQuizAddOptionButton();
    		iap_AddCourseVerificationPage.clickQuizAddOptionButton();
    		iap_AddCourseVerificationPage.enterQuizQuestion1Option1();
    		iap_AddCourseVerificationPage.clickQuizCorrectAnswerOption1Button();
    		iap_AddCourseVerificationPage.clickQuizAddOptionButton();
    		iap_AddCourseVerificationPage.enterQuizQuestion1Option2();
    		iap_AddCourseVerificationPage.clickQuizAddOptionButton();
    		iap_AddCourseVerificationPage.enterQuizQuestion1Option3();
    		iap_AddCourseVerificationPage.clickQuizAddOptionButton();
    		iap_AddCourseVerificationPage.enterQuizQuestion1Option4();
    		iap_AddCourseVerificationPage.clickQuizPageSubmitButton();
    		iap_AddCourseVerificationPage.clickQuizSaveContentButton();
    		//Assignment
    		iap_AddCourseVerificationPage.clickCurriculamAddContentButton();
    		iap_AddCourseVerificationPage.clickContentTypeAssignmentRadioButton();
    		iap_AddCourseVerificationPage.CheckAddCourseAssignmentNamebox();
    		iap_AddCourseVerificationPage.enterAssignmentName();
    		iap_AddCourseVerificationPage.CheckAddCourseAssignmentDescriptionbox();
    		iap_AddCourseVerificationPage.enterAssignmentDescription();
    		iap_AddCourseVerificationPage.uploadMediaAssignmentfile();
    		iap_AddCourseVerificationPage.CheckAddCourseAssignmentTimeAllotmentInputbox();
    		iap_AddCourseVerificationPage.enterAssignmentTimeAllotment();
    		iap_AddCourseVerificationPage.enterAssignmentStartDate();
    		iap_AddCourseVerificationPage.clickCanSkipContentCheckbox();
    		iap_AddCourseVerificationPage.clickIsGatedContentCheckbox();
    		iap_AddCourseVerificationPage.clickSubmissionTypeSubjectiveRadioButton();
    		iap_AddCourseVerificationPage.clickSubmissionTypeFileUploadRadioButton();
    		iap_AddCourseVerificationPage.CheckAddCourseAssignmentTotalMarksInputbox();
    		iap_AddCourseVerificationPage.enterAssignmentTotalMarks();
    		iap_AddCourseVerificationPage.CheckAssignmentSaveContentButton();
    		iap_AddCourseVerificationPage.clickAssignmentSaveContentButton();
    		
    		
    		iap_AddCourseVerificationPage.clickCurriculamPageNextButton();
    		//Configuration page
    		iap_AddCourseVerificationPage.clickConfigurationPageNextButton();
    		//Media page
    		iap_AddCourseVerificationPage.uploadMediaPosterImage();
    		iap_AddCourseVerificationPage.uploadMediaIntroductionVideo();
    		iap_AddCourseVerificationPage.clickMediaPageNextButton();
    		//Publish page
    		iap_AddCourseVerificationPage.clickPublishstatusLive();
    		iap_AddCourseVerificationPage.clickPublishstatusArchive();
    		iap_AddCourseVerificationPage.clickPublishstatusDraft();
    		iap_AddCourseVerificationPage.clickTranscriptedCourseYesButton();
    		iap_AddCourseVerificationPage.clickTranscriptedCourseNoButton();
    		iap_AddCourseVerificationPage.clickPublishPageSaveButton();
    	
    		
    	}

}
