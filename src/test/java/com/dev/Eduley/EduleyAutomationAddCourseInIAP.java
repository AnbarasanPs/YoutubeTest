package com.dev.Eduley;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import baseClass.BaseClass;
import pages.EduleyAutomationInstituteRegisterPage;
import pages.IAP_AddCourseVerificationPage;

public class EduleyAutomationAddCourseInIAP extends BaseClass {
	Faker faker = new Faker();
	
	private IAP_AddCourseVerificationPage iap_AddCourseVerificationPage;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		logger.info("Initial setup is in progress");
	}

	@Test(priority = 0,enabled = true)
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
