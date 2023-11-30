package pom;

import org.openqa.selenium.By;

public class IAP_AddCourseVerificationPOM {
	public By adminPanelUsernameBox=By.xpath("//input[@name='email']");
	public By adminPanelPasswordBox=By.xpath("//input[@name='password']");
	public By adminPanelLogin=By.xpath("//button[text()='Login']");
	public By CoursesDropdown=By.xpath("//div[text()='Courses']");
	public By courseList=By.xpath("//div[text()='Course List']");
	public By cohorts=By.xpath("//div[text()='Cohorts']");
	public By addCourseButton=By.xpath("//a[text()='Add Course']");
	public By courseNameInputbox=By.xpath("//input[@name='name']");
	public By shortDescriptionInputbox=By.xpath("//input[@name='short_description']");
	public By courseDescriptionInputbox=By.xpath("//div[@data-placeholder='Write something awesome...'] //p[1]");
	public By whatWillLearnTextbox=By.xpath("//textarea[@name='what_will_student_learn']");
	public By preRequisitesTextbox=By.xpath("//textarea[@name='prerequisite_for_course']");
	public By courseLevelDropdown=By.xpath("//select[@name='course_level']");
	public By courseLevelBeginner=By.xpath("//select[@name='course_level']/option[text()='Beginner']");
	public By courseLevelIntermediate=By.xpath("//select[@name='course_level']/option[text()='Intermediate']");
	public By courseLevelExpert=By.xpath("//select[@name='course_level']/option[text()='Expert']");
	public By courseLanguageDropdown=By.xpath("//select[@name='course_language']");
	public By courseLanguageEnglish=By.xpath("//select[@name='course_language']/option[text()='en']");
	public By courseDurationInputbox=By.xpath("//input[@name='duration_in_weeks']");
	public By instructorInputbox=By.xpath("(//label[text()='Course Language']/following::input)[2]");
	public By instructorAnbu=By.xpath("//h6[text()='Anbu Instrc']");
	public By addReviewerInputbox=By.xpath("(//label[text()='Course Language']/following::input)[3]");
	public By addReviewerAnbu=By.xpath("//h6[text()='Anbu Ap']");
	public By addNewReviewerFirstName=By.xpath("//input[@name='first_name']");
	public By addNewReviewerLastName=By.xpath("//input[@name='last_name']");
	public By addNewReviewerEmail=By.xpath("//input[@name='email']");
	public By addNewReviewerPassword=By.xpath("//input[@name='password']");
	public By addNewReviewerRoleDropdown=By.xpath("//div[@id='demo-multiple-chip']");
	public By addNewReviewerRoleInstituteAdmin=By.xpath("(//input[@type='checkbox'])[2]");
	public By addNewReviewerRoleInstructor=By.xpath("(//input[@type='checkbox'])[3]");
	public By addNewReviewerRoleAccounts=By.xpath("(//input[@type='checkbox'])[4]");
	public By addNewReviewerRoleReviewer=By.xpath("(//input[@type='checkbox'])[5]");
	public By addNewReviewerRoleCounsellor=By.xpath("(//input[@type='checkbox'])[6]");
	public By addNewReviewerCreateUserButton=By.xpath("(//button[text()='Create User'])");
	public By selectReviewer=By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]");
	public By selectReviewerSaveButton=By.xpath("//button[text()='Save']");
	public By courseCategoryDropdown=By.xpath("//select[@name='category']");
	public By courseCategoryTechnology=By.xpath("//select[@name='category']/option[text()='Technology']");
	public By courseCategoryFood=By.xpath("//select[@name='category']/option[text()='Food']");
	public By accessPostGraduationWeeksInputbox=By.xpath("//input[@type='number']");
	public By courseCompletionYes=By.xpath("(//button[text()='Yes'])[1]");
	public By courseCompletionNo=By.xpath("(//button[text()='No'])[1]");
	public By priceOfCourseInputbox=By.xpath("//input[@name='price']");
	public By freeCourseCheckbox=By.xpath("//div[@class='css-1beik88']//*[local-name()='svg']");
	public By firstSectionFreeCheckbox=By.xpath("//input[@type='checkbox'][1]");
	public By courseRunsCohertsYes=By.xpath("(//button[text()='Yes'])[2]");
	public By courseRunsCohertsNo=By.xpath("(//button[text()='No'])[2]");
	public By courseDeleteCohertsButton=By.xpath("//button[text()='Delete Cohort']");
	
	public By pageNextButton=By.xpath("//button[text()='Next']");
	public By curriculamAddSection=By.xpath("//button[text()='Add Section']");
	public By curriculamAddSectionInputbox=By.xpath("//input[@placeholder='New Section']");
	public By curriculamAddSectionTickIcon=By.xpath("//div[@class='MuiInputAdornment-root MuiInputAdornment-positionEnd css-5zxort']//*[local-name()='svg']");
	public By curriculamAddContent=By.xpath("//button[text()='Add Content']");
	public By curriculamContentTypeLesson=By.xpath("(//input[@name='lessonType'])[1]");
	public By curriculamContentTypeQuiz=By.xpath("(//input[@name='lessonType'])[2]");
	public By curriculamContentTypeAssignment=By.xpath("(//input[@name='lessonType'])[3]");
	public By lessonName=By.xpath("//input[@name='name']");
	public By lessonAttachmentButton=By.xpath("//button[text()='Choose Media']");
	public By lessonAttachmentPosterImage=By.xpath("//td[text()='Poster Image']");
	public By lessonDescription=By.xpath("//textarea[@name='description']");
	public By lessonResourceAddIcon=By.xpath("//div[@class='css-9jay18']//*[local-name()='svg']");
	public By addNewResourceButton=By.xpath("//button[text()='Add New Resource']");
	public By nameOfResourceTextbox=By.xpath("//input[@id='mui-91']");
	public By resourceChooseMediaButton=By.xpath("//button[text()='Choose Media']");
	public By resourceChooseMediaImagefile=By.xpath("//td[text()='Poster Image']");
	public By resourceSubmitButton=By.xpath("//button[text()='Submit']");
	public By resourceSaveButton=By.xpath("//button[text()='Save']");
	public By startDateCalanderInputbox=By.xpath("//input[@placeholder='mm/dd/yyyy hh:mm (a|p)m']");
	public By startDateCalanderIcon=By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-12xczkh']//*[local-name()='svg']");
	public By startDate=By.xpath("//button[text()='5']");
	public By startTimeInHours=By.xpath("//span[text()='9']");
	public By startTimeInMinutes=By.xpath("//span[text()='30']");
	public By skipContentCheckbox=By.xpath("(//input[@type='checkbox'])[2]");
	public By saveContentButton=By.xpath("//button[text()='Save Content']");
	
	public By quizTitleBox=By.xpath("//input[@placeholder='Enter Title']");
	public By quizDescriptionBox=By.xpath("//textarea[@name='description']");
	public By quizTimeAllowedBox=By.xpath("//input[@placeholder='please enter time in minutes']");
	public By noOfAttemptsCheckbox=By.xpath("(//input[@type='checkbox'])[2]");
	public By noOfAttemptsInputbox=By.xpath("(//input[@type='number'])[2]");
	public By mcqQuestionsCheckbox=By.xpath("(//input[@type='checkbox'])[3]");
	public By displayQuestionsInputbox=By.xpath("//textarea[@placeholder='Enter Display Questions']");
	public By marksPerMCQInputbox=By.xpath("//input[@placeholder='Enter Marks for MCQ']");
	public By totalMarksInputbox=By.xpath("//input[@placeholder='Enter Marks']");
	public By passingMarksInputbox=By.xpath("//input[@placeholder='Enter Passing Marks']");
	public By weightageGroupGradeInputbox=By.xpath("//input[@value='Quiz']");
	public By canSkipContentCheckbox=By.xpath("(//input[@type='checkbox'])[4]");
	public By isGatedCheckbox=By.xpath("(//input[@type='checkbox'])[5]");
	public By mcqButton=By.xpath("//button[text()='MCQ']");
	public By subjectiveButton=By.xpath("//button[text()='Subjective']");
	public By addQuetionButton=By.xpath("//button[text()='Add Question']");
	public By QuestionInputbox=By.xpath("//textarea[@placeholder='Question']");
	public By chooseMediaButton=By.xpath("//button[text()='Choose Media']");
	public By addOptionButton=By.xpath("//button[text()='Add Option']");
	public By enterOption1=By.xpath("(//textarea[@placeholder='enter option'])[1]");
	public By Option1AnswerTickButton=By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-yzt5i1']//*[local-name()='svg'])[1]");
	public By enterOption2=By.xpath("(//textarea[@placeholder='enter option'])[2]");
	public By Option2AnswerTickButton=By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-yzt5i1']//*[local-name()='svg'])[2]");
	public By enterOption3=By.xpath("(//textarea[@placeholder='enter option'])[3]");
	public By Option3AnswerTickButton=By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-yzt5i1']//*[local-name()='svg'])[3]");
	public By enterOption4=By.xpath("(//textarea[@placeholder='enter option'])[4]");
	public By Option4AnswerTickButton=By.xpath("(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeSmall css-yzt5i1']//*[local-name()='svg'])[4]");
	public By addQuestionSubmitButton=By.xpath("//button[text()='Submit']");
	public By quizSaveContentButton=By.xpath("//button[text()='Save Content']");
	
	public By assignmentNameBox=By.xpath("//input[@placeholder='Assignment name']");
	public By assignmentDescriptionBox=By.xpath("//textarea[@placeholder='Description']");
	public By assignmentFileChooseMediaButton=By.xpath("//button[text()='Choose Media']");
	public By assignmentFileChooseMediaPoserImage=By.xpath("//td[text()='Poster Image']");
	public By assignmentTimeAllotment=By.xpath("//input[@placeholder='hh:mm:ss']");
	public By assignmentCanSkip=By.xpath("(//input[@type='checkbox'])[2]");
	public By assignmentIsGated=By.xpath("(//input[@type='checkbox'])[3]");
	public By assignmentSubmissionTypeFileUpload=By.xpath("(//input[@name='submission_type'])[1]");
	public By assignmentSubmissionTypeSubjective=By.xpath("(//input[@name='submission_type'])[2]");
	public By assignmentTotalMarks=By.xpath("//input[@name='total_marks']");
	public By assignmentSaveContent=By.xpath("//button[text()='Save Content']");
	public By firstSectionOfCourseFreeCheckbox=By.xpath("(//input[@type='checkbox'])[1]");
	
	
	public By mediaCoverImageChooseButton=By.xpath("(//button[text()='Choose Media'])[1]");
	public By mediaCoverVideoChooseButton=By.xpath("(//button[text()='Choose Media'])[1]");
	public By mediaPosterImage=By.xpath("//td[text()='Poster Image']");
	public By mediaIntroductionVideo=By.xpath("//td[text()='Youtube video']");
	public By publishStatusLive=By.xpath("//button[text()='Live']");
	public By publishStatusDraft=By.xpath("//button[text()='Draft']");
	public By publishStatusArchive=By.xpath("//button[text()='Archive']");
	public By transcriptedCourseYesbutton=By.xpath("//button[text()='Yes']");
	public By transcriptedCourseNobutton=By.xpath("//button[text()='No']");
	public By publishPageSaveButton=By.xpath("//button[text()='Save']");
	
	public By coursesButton=By.xpath("//a[text()='Courses']");
	public By coursesName=By.xpath("//h6[text()='Core Java_08']");
	public By SubscribeNowButton=By.xpath("(//button[text()='Subscribe Now'])[1]");
	public By loginButton=By.xpath("(//span[text()='Log In'])[2]");
	
	
	
	
	
	
	

}
