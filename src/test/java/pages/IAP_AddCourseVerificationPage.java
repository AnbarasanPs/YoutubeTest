package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;

import constants.Constants;
import utilities.LocalHelper;
import utilities.TestUtil;
import pom.IAP_AddCourseVerificationPOM;

public class IAP_AddCourseVerificationPage extends IAP_AddCourseVerificationPOM {
	protected static final Logger logger = LoggerFactory.getLogger(IAP_AddCourseVerificationPage.class);

	Faker faker = new Faker();
	private final LocalHelper localHelper = new LocalHelper();

	private final WebDriver driver;
	public IAP_AddCourseVerificationPage(WebDriver driver) {
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
		localHelper.sendKeys(adminPanelUsernameBox,new TestUtil().init_Properties().getProperty("institute_user"),driver);
			//localHelper.sendKeys(adminPanelUsernameBox,Mailinator.userLoginMail,driver);
	//	localHelper.clickElement(adminPanelPasswordBox, driver);
		}catch (StaleElementReferenceException e) {
			localHelper.clickElement(adminPanelUsernameBox, driver);
			localHelper.sendKeys(adminPanelUsernameBox,new TestUtil().init_Properties().getProperty("institute_user"),driver);
			//localHelper.sendKeys(adminPanelUsernameBox,Mailinator.userLoginMail,driver);
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
	public void clickCourseDropdown() {
		try {
			localHelper.jsExecutorHighlight(CoursesDropdown, driver);
			localHelper.clickElement(CoursesDropdown, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(CoursesDropdown, driver);
		}
		logger.info("IAP  Courses Dropdown is clicked");
	}
	public void clickCourseListButton() {
		try {
			localHelper.jsExecutorHighlight(courseList, driver);
			localHelper.clickElement(courseList, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(courseList, driver);
		}
		logger.info("Course List button is clicked");
	}
	public void clickAddCourseButton() {
		try {
			localHelper.jsExecutorHighlight(addCourseButton, driver);
			localHelper.clickElement(addCourseButton, driver);
		}catch (ElementClickInterceptedException m) {
			localHelper.jsExecutorClick(addCourseButton, driver);
		}
		logger.info("Add Course button is clicked");
	}
	public boolean CheckAddCourseBasicInfoCourseNameBox() {
		 localHelper.jsExecutorHighlight(courseNameInputbox, driver);
		 return driver.findElement(courseNameInputbox).isEnabled();
	 }
	 public void enterCourseName() {
			localHelper.jsExecutorHighlight(courseNameInputbox, driver);
			localHelper.sendKeys(courseNameInputbox,new TestUtil().init_Properties().getProperty("coursename")+(faker.number().digits(2)),driver);
			logger.info("Course Name passed in the  Coursename input box");
		}
	 public boolean CheckAddCourseBasicInfoShortDescriptionBox() {
		 localHelper.jsExecutorHighlight(shortDescriptionInputbox, driver);
		 return driver.findElement(shortDescriptionInputbox).isEnabled();
	 }
	 
	 public void enterCourseShortDescription() {
			localHelper.jsExecutorHighlight(shortDescriptionInputbox, driver);
			localHelper.sendKeys(shortDescriptionInputbox,new TestUtil().init_Properties().getProperty("shortDescription"),driver);
			logger.info("Course  short description passed in the SD input box");
		}
	 public boolean CheckAddCourseBasicInfoDescriptionBox() {
		 localHelper.jsExecutorHighlight(courseDescriptionInputbox, driver);
		 return driver.findElement(courseDescriptionInputbox).isEnabled();
	 }
	 public void enterCourseDescription() {
			localHelper.jsExecutorHighlight(courseDescriptionInputbox, driver);
			localHelper.sendKeys(courseDescriptionInputbox,new TestUtil().init_Properties().getProperty("Description"),driver);
			logger.info("Course Description passed in the  Description input box");
		}
	 public boolean CheckAddCourseBasicInfoWhatStudentsLearnBox() {
		 localHelper.jsExecutorHighlight(whatWillLearnTextbox, driver);
		 return driver.findElement(whatWillLearnTextbox).isEnabled();
	 }
	 public void enterWhatStudentsLearnOurCourse() {
			localHelper.jsExecutorHighlight(whatWillLearnTextbox, driver);
			localHelper.sendKeys(whatWillLearnTextbox,new TestUtil().init_Properties().getProperty("StudentsLearnOurCourse"),driver);
			logger.info("Text passed in the WhatStudentsLearnOurCourse input box");
		}
	 public boolean CheckAddCourseBasicInfoPreRequisitesBox() {
		 localHelper.jsExecutorHighlight(preRequisitesTextbox, driver);
		 return driver.findElement(preRequisitesTextbox).isEnabled();
	 }
	 public void enterPreRequisites() {
			localHelper.jsExecutorHighlight(preRequisitesTextbox, driver);
			localHelper.sendKeys(preRequisitesTextbox,new TestUtil().init_Properties().getProperty("Prerequisites"),driver);
			logger.info("Text passed in the PreRequisites input box");
		}
	 public boolean CheckAddCourseBasicInfoCourseLevelDropdown() {
		 localHelper.jsExecutorHighlight(courseLevelDropdown, driver);
		 return driver.findElement(courseLevelDropdown).isEnabled();
	 }
	 public void enterCourseLevelBeginner() {
		 localHelper.jsExecutorHighlight(courseLevelDropdown, driver);
			localHelper.clickElement(courseLevelDropdown, driver);
			localHelper.clickElement(courseLevelBeginner, driver);
			logger.info("Course level Beginner is selected");
		}
	 public void enterCourseLevelIntermediate() {
		 localHelper.jsExecutorHighlight(courseLevelDropdown, driver);
			localHelper.clickElement(courseLevelDropdown, driver);
			localHelper.clickElement(courseLevelIntermediate, driver);
			logger.info("Course level Intermediate is selected");
		}
	 public void enterCourseLevelExpert() {
		 localHelper.jsExecutorHighlight(courseLevelDropdown, driver);
			localHelper.clickElement(courseLevelExpert, driver);
			localHelper.clickElement(courseLevelExpert, driver);
			logger.info("Course level Expert is selected");
		}
	 public boolean CheckAddCourseBasicInfoCourseLanguageDropdown() {
		 localHelper.jsExecutorHighlight(courseLanguageDropdown, driver);
		 return driver.findElement(courseLanguageDropdown).isEnabled();
	 }
	 public void enterCourseLanguage() {
		 localHelper.jsExecutorHighlight(courseLanguageDropdown, driver);
			localHelper.clickElement(courseLanguageDropdown, driver);
			localHelper.clickElement(courseLanguageEnglish, driver);
			logger.info("Course Language level English is selected");
		}
	 public boolean CheckAddCourseBasicInfoCourseDurationInputbox() {
		 localHelper.jsExecutorHighlight(courseDurationInputbox, driver);
		 return driver.findElement(courseDurationInputbox).isEnabled();
	 }
	 public void enterCourseDuration() {
			localHelper.jsExecutorHighlight(courseDurationInputbox, driver);
			localHelper.sendKeys(courseDurationInputbox,new TestUtil().init_Properties().getProperty("Duration"),driver);
			logger.info("Course Duration weeks passed in the input box");
		}
	 public boolean CheckAddCourseBasicInfoInstructorInputbox() {
		 localHelper.jsExecutorHighlight(instructorInputbox, driver);
		 return driver.findElement(instructorInputbox).isEnabled();
	 }
	 public void enterInstrutor() throws InterruptedException {
		 localHelper.jsExecutorHighlight(instructorInputbox, driver);
			localHelper.clickElement(instructorInputbox, driver);
			Thread.sleep(3000);
			localHelper.clickElement(instructorAnbu, driver);
			logger.info("Course Instructor Anbu is selected");
		}
	 public boolean CheckAddCourseBasicInfoAddReviewerInputbox() {
		 localHelper.jsExecutorHighlight(addReviewerInputbox, driver);
		 return driver.findElement(addReviewerInputbox).isEnabled();
	 }
	 public void enterReviewer() {
		 localHelper.jsExecutorHighlight(addReviewerInputbox, driver);
			localHelper.clickElement(addReviewerInputbox, driver);
			localHelper.clickElement(addReviewerAnbu, driver);
			localHelper.clickElement(selectReviewerSaveButton, driver);
			logger.info("Course Reviewer Anbu is selected");
		}
	 public boolean CheckAddCourseBasicInfoCourseCategoryDropdown() {
		 localHelper.jsExecutorHighlight(courseCategoryDropdown, driver);
		 return driver.findElement(courseCategoryDropdown).isEnabled();
	 }
	 public void enterCourseCategoryTechnology() {
		 localHelper.jsExecutorHighlight(courseCategoryDropdown, driver);
			localHelper.clickElement(courseCategoryDropdown, driver);
			localHelper.clickElement(courseCategoryTechnology, driver);
			logger.info("Course category Technology is selected");
		}
	 public void enterCourseCategoryFood() {
		 localHelper.jsExecutorHighlight(courseCategoryDropdown, driver);
			localHelper.clickElement(courseCategoryDropdown, driver);
			localHelper.clickElement(courseCategoryFood, driver);
			logger.info("Course category Technology is selected");
		}
	 public boolean CheckAddCourseBasicInfoPostGraduationWeeksInputbox() {
		 localHelper.jsExecutorHighlight(accessPostGraduationWeeksInputbox, driver);
		 return driver.findElement(accessPostGraduationWeeksInputbox).isEnabled();
	 }
	 public void enterAccessPostGraduationWeeks() {
			localHelper.jsExecutorHighlight(accessPostGraduationWeeksInputbox, driver);
			localHelper.sendKeys(accessPostGraduationWeeksInputbox,new TestUtil().init_Properties().getProperty("PGaccess"),driver);
			logger.info("Course Access post graduation weeks passed in the input box");
		}
	 public void clickCourseCompletionAwardYes() {
			try {
				localHelper.jsExecutorHighlight(courseCompletionYes, driver);
				localHelper.clickElement(courseCompletionYes, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(courseCompletionYes, driver);
			}
			logger.info("Course completion award YES button is clicked");
		}
	 public void clickCourseCompletionAwardNO() {
			try {
				localHelper.jsExecutorHighlight(courseCompletionNo, driver);
				localHelper.clickElement(courseCompletionNo, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(courseCompletionNo, driver);
			}
			logger.info("Course completion award NO button is clicked");
		}
	 public void clickandValidateFreeCourseCheckbox() throws InterruptedException {
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).sendKeys(Keys.SPACE);
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).sendKeys(Keys.SPACE);
			 logger.info("Free Course checkbox is validated");
	 
		  }
	 public boolean CheckAddCourseBasicInfoPriceOfCourseInputbox() {
		 localHelper.jsExecutorHighlight(priceOfCourseInputbox, driver);
		 return driver.findElement(priceOfCourseInputbox).isEnabled();
	 }
	 public void enterPriceOfCourse() {
			localHelper.jsExecutorHighlight(priceOfCourseInputbox, driver);
			localHelper.sendKeys(priceOfCourseInputbox,new TestUtil().init_Properties().getProperty("CoursePrice"),driver);
			logger.info("Price of course passed in the input box");
		}
	 public void clickFirstSectionFreeCheckbox() {
		 driver.findElement(By.xpath("//input[@type='checkbox'][1]")).sendKeys(Keys.SPACE);
		//	localHelper.clickElement(firstSectionFreeCheckbox, driver);
			logger.info("First section free checkbox is clicked");
		}
	 public void clickCourseRunsInCohortsYes() {
			try {
				localHelper.jsExecutorHighlight(courseRunsCohertsYes, driver);
				localHelper.clickElement(courseRunsCohertsYes, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(courseRunsCohertsYes, driver);
			}
			logger.info("Course runs in Cohorts YES button is clicked");
		}
	 public void clickCourseRunsInCohortsDelete() {
			try {
				localHelper.jsExecutorHighlight(courseDeleteCohertsButton, driver);
				localHelper.clickElement(courseDeleteCohertsButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(courseDeleteCohertsButton, driver);
			}
			logger.info("Delete cohorts button is clicked");
		}
	 
	 public void clickCourseRunsInCohortsNo() {
			try {
				localHelper.jsExecutorHighlight(courseRunsCohertsNo, driver);
				localHelper.clickElement(courseRunsCohertsNo, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(courseRunsCohertsNo, driver);
			}
			logger.info("Course runs in Cohorts NO button is clicked");
		}
	 public void clickBasicInfoPageNextButton() {
			try {
				localHelper.jsExecutorHighlight(pageNextButton, driver);
				localHelper.clickElement(pageNextButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(pageNextButton, driver);
			}
			logger.info("Basic information page Next button is clicked");
		}
	 public void clickCurriculamAddSectionButton() {
		 localHelper.jsExecutorHighlight(curriculamAddSection, driver);
			localHelper.clickElement(curriculamAddSection, driver);
		}
	 public void enterCurriculamAddSectionInputbox() {
		 localHelper.jsExecutorHighlight(curriculamAddSectionInputbox, driver);
		 localHelper.sendKeys(curriculamAddSectionInputbox,new TestUtil().init_Properties().getProperty("NewSectionTitle"),driver);
			//localHelper.clickElement(curriculamAddSectionTickIcon, driver);
			logger.info("Add section title is passed in inputbox");
		}
	 public boolean CheckAddCourseCurriculamAddSectionInputbox() {
		 localHelper.jsExecutorHighlight(curriculamAddSectionInputbox, driver);
		 return driver.findElement(curriculamAddSectionInputbox).isEnabled();
	 }
	 public void clickCurriculamAddSectionTickIcon() {
			localHelper.clickElement(curriculamAddSectionTickIcon, driver);
			logger.info("Add section Tick Icon clicked");
		}
	 public void clickCurriculamAddContentButton() {
		 localHelper.jsExecutorHighlight(curriculamAddContent, driver);
			localHelper.clickElement(curriculamAddContent, driver);
			logger.info("Add Content button is clicked");
		}
	 public void clickContentTypeLessonRadioButton() {
		 driver.findElement(By.xpath("(//input[@name='lessonType'])[1]")).sendKeys(Keys.SPACE);
			logger.info("Content Type Lesson is clicked");
		}
	
	 public boolean CheckAddCourseLessonNamebox() {
		 localHelper.jsExecutorHighlight(lessonName, driver);
		 return driver.findElement(lessonName).isEnabled();
	 }
	 public void enterLessonName() {
			localHelper.sendKeys(lessonName,new TestUtil().init_Properties().getProperty("LessonName"),driver);
			logger.info("Lesson Name passed in the input box");
		}
	 public void uploadLessonAttachmentFile() throws InterruptedException {
		 localHelper.jsExecutorHighlight(lessonAttachmentButton, driver);
			localHelper.clickElement(lessonAttachmentButton, driver);
			Thread.sleep(3000);
			localHelper.clickElement(lessonAttachmentPosterImage, driver);
			logger.info("Lesson attachment file is selected");
		}
	 public boolean CheckAddCourseLessonDescriptionBox() {
		 localHelper.jsExecutorHighlight(lessonDescription, driver);
		 return driver.findElement(lessonDescription).isEnabled();
	 }
	 public void enterLessonDescription() {
			localHelper.sendKeys(lessonDescription,new TestUtil().init_Properties().getProperty("LessonDescription"),driver);
			logger.info("Lesson Description passed in the  Description input box");
		}
	 public boolean CheckAddCourseStartDateCalanderInputbox() {
		 localHelper.jsExecutorHighlight(startDateCalanderInputbox, driver);
		 return driver.findElement(startDateCalanderInputbox).isEnabled();
	 }
	 public void enterCourseStartDate() throws InterruptedException {
			//localHelper.clickElement(startDateCalanderIcon,driver);
			//localHelper.clickElement(startDate,driver);
			//localHelper.clickElement(startTimeInHours,driver);
			//localHelper.clickElement(startTimeInMinutes,driver);
			try {
				localHelper.clickElement(startDateCalanderIcon, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(startDateCalanderIcon, driver);
			}
			Thread.sleep(2000);
			try {
				localHelper.clickElement(startDate, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(startDate, driver);
			}
			Thread.sleep(2000);
			try {
				localHelper.clickElement(startTimeInHours, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(startTimeInHours, driver);
			}
			Thread.sleep(2000);
			/*try {
				localHelper.clickElement(startTimeInMinutes, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(startTimeInMinutes, driver);
			}*/
			localHelper.clickElement(startDateCalanderIcon, driver);
			logger.info("Entered course starting date ");
		}
	 public void clickSkipContentCheckbox() {
		 driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).sendKeys(Keys.SPACE);
			logger.info("Skip content checkbox is clicked");
		}
	 public void clickSaveContentButton() {
			try {
				localHelper.jsExecutorHighlight(saveContentButton, driver);
				localHelper.clickElement(saveContentButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(saveContentButton, driver);
			}
			logger.info("Add content save button is clicked");
		}
	 public void clickContentTypeQuizRadioButton() {
		 driver.findElement(By.xpath("(//input[@name='lessonType'])[2]")).sendKeys(Keys.SPACE);
			logger.info("Content Type Quiz is clicked");
		}
	 public boolean CheckAddCourseQuizTitlebox() {
		 localHelper.jsExecutorHighlight(quizTitleBox, driver);
		 return driver.findElement(quizTitleBox).isEnabled();
	 }
	 public void enterQuizTitle() {
			localHelper.sendKeys(quizTitleBox,new TestUtil().init_Properties().getProperty("QuizTitle"),driver);
			logger.info("Quiz Title passed in the input box");
		}
	 public boolean CheckAddCourseQuizDescriptionbox() {
		 localHelper.jsExecutorHighlight(quizDescriptionBox, driver);
		 return driver.findElement(quizDescriptionBox).isEnabled();
	 }
	 public void enterQuizDescription() {
			localHelper.sendKeys(quizDescriptionBox,new TestUtil().init_Properties().getProperty("QuizDescription"),driver);
			logger.info("Quiz Description passed in the input box");
		}
	 public boolean CheckAddCourseQuizTimeAllowedbox() {
		 localHelper.jsExecutorHighlight(quizTimeAllowedBox, driver);
		 return driver.findElement(quizTimeAllowedBox).isEnabled();
	 }
	 public void enterQuizTimeAllowed() {
			localHelper.sendKeys(quizTimeAllowedBox,new TestUtil().init_Properties().getProperty("QuizTimeAllowed"),driver);
			logger.info("Quiz  Allowed Time passed in the input box");
		}
	 public void clickNoOfAttemptsCheckbox() {
		 driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).sendKeys(Keys.SPACE);
			logger.info("No of Attempts checkbox is clicked");
		}
	 public void enterQuizNoOfAttempts() {
			localHelper.sendKeys(noOfAttemptsInputbox,new TestUtil().init_Properties().getProperty("QuizNoOfAttempts"),driver);
			logger.info("Number of attempts quiz value passed in the input box");
		}
	 public void clickQuizHaveMCQquestionsCheckbox() {
		 driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).sendKeys(Keys.SPACE);
			logger.info("No of Attempts checkbox is clicked");
		}
	 public boolean CheckQuizDisplayQuestionsInputbox() {
		 localHelper.jsExecutorHighlight(displayQuestionsInputbox, driver);
		 return driver.findElement(displayQuestionsInputbox).isEnabled();
	 }
	 public void enterQuizDisplayQuestions() {
			localHelper.sendKeys(displayQuestionsInputbox,new TestUtil().init_Properties().getProperty("DisplayQuestions"),driver);
			logger.info("Quiz display questions passed in the input box");
		}
	 public boolean CheckQuizMarksPerMCQInputbox() {
		 localHelper.jsExecutorHighlight(marksPerMCQInputbox, driver);
		 return driver.findElement(marksPerMCQInputbox).isEnabled();
	 }
	 public void enterQuizMarkPerMCQ() {
			localHelper.sendKeys(marksPerMCQInputbox,new TestUtil().init_Properties().getProperty("MarkPerMCQ"),driver);
			logger.info("Quiz Mark per MCQ passed in the input box");
		}
	 public boolean CheckQuizTotalMarksInputbox() {
		 localHelper.jsExecutorHighlight(totalMarksInputbox, driver);
		 return driver.findElement(totalMarksInputbox).isEnabled();
	 }
	 public void enterQuizTotalMarks() {
			localHelper.sendKeys(totalMarksInputbox,new TestUtil().init_Properties().getProperty("QuizTotalMarks"),driver);
			logger.info("Quiz Total Mark passed in the input box");
		}
	 public boolean CheckQuizPassinglMarksInputbox() {
		 localHelper.jsExecutorHighlight(passingMarksInputbox, driver);
		 return driver.findElement(passingMarksInputbox).isEnabled();
	 }
	 public void enterQuizPassingMarks() {
			localHelper.sendKeys(passingMarksInputbox,new TestUtil().init_Properties().getProperty("QuizPassingMarks"),driver);
			logger.info("Quiz Total Mark passed in the input box");
		}
	 public boolean CheckQuizStartDateCalanderInputbox() {
		 localHelper.jsExecutorHighlight(startDateCalanderInputbox, driver);
		 return driver.findElement(startDateCalanderInputbox).isEnabled();
	 }
	 public void enterQuizStartDate() throws InterruptedException {
			//localHelper.clickElement(startDateCalanderIcon,driver);
			//localHelper.clickElement(startDate,driver);
			//localHelper.clickElement(startTimeInHours,driver);
			//localHelper.clickElement(startTimeInMinutes,driver);
			try {
				localHelper.clickElement(startDateCalanderIcon, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(startDateCalanderIcon, driver);
			}
			Thread.sleep(2000);
			try {
				localHelper.clickElement(startDate, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(startDate, driver);
			}
			Thread.sleep(2000);
			try {
				localHelper.clickElement(startTimeInHours, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(startTimeInHours, driver);
			}
			Thread.sleep(2000);
			/*try {
				localHelper.clickElement(startTimeInMinutes, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(startTimeInMinutes, driver);
			}*/
			localHelper.clickElement(startDateCalanderIcon, driver);
			logger.info("Entered course starting date ");
		}
	 public void clickQuizSkipContentCheckbox() {
		 driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).sendKeys(Keys.SPACE);
			logger.info("Skip content checkbox is clicked");
		}
	 public boolean CheckQuizMCQButton() {
		 localHelper.jsExecutorHighlight(mcqButton, driver);
		 return driver.findElement(mcqButton).isEnabled();
	 }
	 public void clickQuizMCQButton() {
			try {
				localHelper.jsExecutorHighlight(mcqButton, driver);
				localHelper.clickElement(mcqButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(mcqButton, driver);
			}
			logger.info("Quiz details page MCQ button is clicked");
		}
	 public boolean CheckQuizAddQuestionButton() {
		 localHelper.jsExecutorHighlight(addQuetionButton, driver);
		 return driver.findElement(addQuetionButton).isEnabled();
	 }
	 public void clickQuizAddQuestionButton() {
			try {
				localHelper.jsExecutorHighlight(addQuetionButton, driver);
				localHelper.clickElement(addQuetionButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(addQuetionButton, driver);
			}
			logger.info("Quiz details page Add Quetion button is clicked");
		}
	 public boolean CheckQuizQuestionInputbox() {
		 localHelper.jsExecutorHighlight(QuestionInputbox, driver);
		 return driver.findElement(QuestionInputbox).isEnabled();
	 }
	 public void enterQuizQuestion1() {
			localHelper.sendKeys(QuestionInputbox,new TestUtil().init_Properties().getProperty("QuizQuestion1"),driver);
			logger.info("Quiz Question passed in the input box");
		}
	 public void uploadQuizMediaImage() throws InterruptedException {
		 localHelper.jsExecutorHighlight(chooseMediaButton, driver);
			localHelper.clickElement(chooseMediaButton, driver);
			Thread.sleep(3000);
			localHelper.clickElement(mediaPosterImage, driver);
			logger.info("Quiz Media image is uploaded");
		}
	 public boolean CheckQuizAddOptionButton() {
		 localHelper.jsExecutorHighlight(addOptionButton, driver);
		 return driver.findElement(addOptionButton).isEnabled();
	 }
	 public void clickQuizAddOptionButton() {
			try {
				localHelper.jsExecutorHighlight(addOptionButton, driver);
				localHelper.clickElement(addOptionButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(addOptionButton, driver);
			}
			logger.info("Quiz  Add Option button is clicked");
		}
	 public void enterQuizQuestion1Option1() {
			localHelper.sendKeys(enterOption1,new TestUtil().init_Properties().getProperty("QuizQuestion1Option1"),driver);
			logger.info("Quiz Question1 Option1 passed in the input box");
		}
	 public void clickQuizCorrectAnswerOption1Button() {
			try {
				localHelper.clickElement(Option1AnswerTickButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(Option1AnswerTickButton, driver);
			}
			logger.info("Quiz  correct answer Option1 button is clicked");
		}
	 public void enterQuizQuestion1Option2() {
			localHelper.sendKeys(enterOption2,new TestUtil().init_Properties().getProperty("QuizQuestion1Option2"),driver);
			logger.info("Quiz Question1 Option2 passed in the input box");
		}
	 public void enterQuizQuestion1Option3() {
			localHelper.sendKeys(enterOption3,new TestUtil().init_Properties().getProperty("QuizQuestion1Option3"),driver);
			logger.info("Quiz Question1 Option3 passed in the input box");
		}
	 public void enterQuizQuestion1Option4() {
			localHelper.sendKeys(enterOption4,new TestUtil().init_Properties().getProperty("QuizQuestion1Option4"),driver);
			logger.info("Quiz Question1 Option4 passed in the input box");
		}
	 public void clickQuizPageSubmitButton() {
			try {
				localHelper.jsExecutorHighlight(addQuestionSubmitButton, driver);
				localHelper.clickElement(addQuestionSubmitButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(addQuestionSubmitButton, driver);
			}
			logger.info("Quiz details page Submit button is clicked");
		}
	 public void clickQuizSaveContentButton() {
			try {
				localHelper.jsExecutorHighlight(quizSaveContentButton, driver);
				localHelper.clickElement(quizSaveContentButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(quizSaveContentButton, driver);
			}
			logger.info("Quiz Save content button is clicked");
		}
	 
	 public void clickContentTypeAssignmentRadioButton() {
		 driver.findElement(By.xpath("(//input[@name='lessonType'])[3]")).sendKeys(Keys.SPACE);
			logger.info("Content Type Assignment is clicked");
		}
	 
	 public boolean CheckAddCourseAssignmentNamebox() {
		 localHelper.jsExecutorHighlight(assignmentNameBox, driver);
		 return driver.findElement(assignmentNameBox).isEnabled();
	 }
	 public void enterAssignmentName() {
			localHelper.sendKeys(assignmentNameBox,new TestUtil().init_Properties().getProperty("AssignmentName"),driver);
			logger.info("Assignment name passed in the input box");
		}
	 public boolean CheckAddCourseAssignmentDescriptionbox() {
		 localHelper.jsExecutorHighlight(assignmentDescriptionBox, driver);
		 return driver.findElement(assignmentDescriptionBox).isEnabled();
	 }
	 public void enterAssignmentDescription() {
			localHelper.sendKeys(assignmentDescriptionBox,new TestUtil().init_Properties().getProperty("AssignmentDescription"),driver);
			logger.info("Assignment description passed in the input box");
		}
	 public void uploadMediaAssignmentfile() throws InterruptedException {
		 localHelper.jsExecutorHighlight(assignmentFileChooseMediaButton, driver);
			localHelper.clickElement(assignmentFileChooseMediaButton, driver);
			Thread.sleep(3000);
			localHelper.clickElement(assignmentFileChooseMediaPoserImage, driver);
			logger.info("Assignment file is uploaded");
		}
	
	 public boolean CheckAddCourseAssignmentTimeAllotmentInputbox() {
		 localHelper.jsExecutorHighlight(assignmentTimeAllotment, driver);
		 return driver.findElement(assignmentTimeAllotment).isEnabled();
	 }
	 public void enterAssignmentTimeAllotment() {
			localHelper.sendKeys(assignmentTimeAllotment,new TestUtil().init_Properties().getProperty("AssignmentTimeAllotment"),driver);
			logger.info("Assignment Time allotment passed in the input box");
		}
	 public void enterAssignmentStartDate() throws InterruptedException {
			try {
				localHelper.clickElement(startDateCalanderIcon, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(startDateCalanderIcon, driver);
			}
			Thread.sleep(2000);
			try {
				localHelper.clickElement(startDate, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(startDate, driver);
			}
			Thread.sleep(2000);
			try {
				localHelper.clickElement(startTimeInHours, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(startTimeInHours, driver);
			}
			Thread.sleep(2000);
			/*try {
				localHelper.clickElement(startTimeInMinutes, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(startTimeInMinutes, driver);
			}*/
			localHelper.clickElement(startDateCalanderIcon, driver);
			logger.info("Entered course starting date ");
		}
	 public void clickCanSkipContentCheckbox() {
		 driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).sendKeys(Keys.SPACE);
			logger.info("Skip content checkbox is clicked");
		}
	 public void clickIsGatedContentCheckbox() {
		 driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).sendKeys(Keys.SPACE);
			logger.info("Is Gated checkbox is clicked");
		}
	 public void clickSubmissionTypeSubjectiveRadioButton() {
		 driver.findElement(By.xpath("(//input[@name='submission_type'])[2]")).sendKeys(Keys.SPACE);
			logger.info(" Subjective radiobutton is clicked");
		}
	 public void clickSubmissionTypeFileUploadRadioButton() {
		 driver.findElement(By.xpath("(//input[@name='submission_type'])[1]")).sendKeys(Keys.SPACE);
			logger.info(" FileUpload radiobutton is clicked");
		}
	 public boolean CheckAddCourseAssignmentTotalMarksInputbox() {
		 localHelper.jsExecutorHighlight(assignmentTotalMarks, driver);
		 return driver.findElement(assignmentTotalMarks).isEnabled();
	 }
	 public void enterAssignmentTotalMarks() {
			localHelper.sendKeys(assignmentTotalMarks,new TestUtil().init_Properties().getProperty("AssignmentTotalMarks"),driver);
			logger.info("Assignment total marks passed in the input box");
		}
	 public boolean CheckAssignmentSaveContentButton() {
		 localHelper.jsExecutorHighlight(assignmentSaveContent, driver);
		 return driver.findElement(assignmentSaveContent).isEnabled();
	 }
	 public void clickAssignmentSaveContentButton() {
			try {
				localHelper.jsExecutorHighlight(assignmentSaveContent, driver);
				localHelper.clickElement(assignmentSaveContent, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(assignmentSaveContent, driver);
			}
			logger.info("Assignment save content button is clicked");
		}
	 
	 public void clickFirstSectionOfCourseFreeCheckbox() throws InterruptedException {
		
		 driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).sendKeys(Keys.SPACE);
			logger.info("First section free course checkbox is clicked");
		}
	 
	 public void clickCurriculamPageNextButton() {
			try {
				localHelper.jsExecutorHighlight(pageNextButton, driver);
				localHelper.clickElement(pageNextButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(pageNextButton, driver);
			}
			logger.info("Curriculam page Next button is clicked");
		}
	 public void clickConfigurationPageNextButton() throws InterruptedException {
			try {
				localHelper.jsExecutorHighlight(pageNextButton, driver);
				localHelper.clickElement(pageNextButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(pageNextButton, driver);
			}
			logger.info("Configuration page Next button is clicked");
			Thread.sleep(2000);
		}
	 public void uploadMediaPosterImage() throws InterruptedException {
		 localHelper.jsExecutorHighlight(mediaCoverImageChooseButton, driver);
			localHelper.clickElement(mediaCoverImageChooseButton, driver);
			Thread.sleep(3000);
			localHelper.clickElement(mediaPosterImage, driver);
			logger.info("Media Poster image is uploaded");
		}
	 public void uploadMediaIntroductionVideo() throws InterruptedException {
		 localHelper.jsExecutorHighlight(mediaCoverVideoChooseButton, driver);
			localHelper.clickElement(mediaCoverVideoChooseButton, driver);
			Thread.sleep(3000);
			localHelper.clickElement(mediaIntroductionVideo, driver);
			logger.info("Media Introduction video is uploaded");
		}
	 public void clickMediaPageNextButton() {
			try {
				localHelper.jsExecutorHighlight(pageNextButton, driver);
				localHelper.clickElement(pageNextButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(pageNextButton, driver);
			}
			logger.info("Media page Next button is clicked");
		}
	 public void clickPublishstatusLive() {
			try {
				localHelper.jsExecutorHighlight(publishStatusLive, driver);
				localHelper.clickElement(publishStatusLive, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(publishStatusLive, driver);
			}
			logger.info("Publish status Live button is clicked");
		}
	 public void clickPublishstatusDraft() {
			try {
				localHelper.jsExecutorHighlight(publishStatusDraft, driver);
				localHelper.clickElement(publishStatusDraft, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(publishStatusDraft, driver);
			}
			logger.info("Publish status Draft button is clicked");
		}
	 public void clickPublishstatusArchive() {
			try {
				localHelper.jsExecutorHighlight(publishStatusArchive, driver);
				localHelper.clickElement(publishStatusArchive, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(publishStatusArchive, driver);
			}
			logger.info("Publish status Archive button is clicked");
		}
	 public void clickTranscriptedCourseYesButton() {
			try {
				localHelper.jsExecutorHighlight(transcriptedCourseYesbutton, driver);
				localHelper.clickElement(transcriptedCourseYesbutton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(transcriptedCourseYesbutton, driver);
			}
			logger.info("Transcripted course Yes button is clicked");
		}
	 public void clickTranscriptedCourseNoButton() {
			try {
				localHelper.jsExecutorHighlight(transcriptedCourseNobutton, driver);
				localHelper.clickElement(transcriptedCourseNobutton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(transcriptedCourseNobutton, driver);
			}
			logger.info("Transcripted course No button is clicked");
		}
	 public void clickPublishPageSaveButton() {
			try {
				localHelper.jsExecutorHighlight(publishPageSaveButton, driver);
				localHelper.clickElement(publishPageSaveButton, driver);
			}catch (ElementClickInterceptedException m) {
				localHelper.jsExecutorClick(publishPageSaveButton, driver);
			}
			logger.info("Publish page Save button is clicked");
		}
	 
}
