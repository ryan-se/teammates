package teammates.test.cases.ui.browsertests;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import teammates.common.datatransfer.DataBundle;
import teammates.common.datatransfer.StudentAttributes;
import teammates.common.util.Const;
import teammates.common.util.Url;
import teammates.common.util.StringHelper;
import teammates.common.util.FieldValidator;
import teammates.test.driver.BackDoor;
import teammates.test.pageobjects.Browser;
import teammates.test.pageobjects.BrowserPool;
import teammates.test.pageobjects.InstructorCourseDetailsPage;
import teammates.test.pageobjects.InstructorCourseStudentDetailsEditPage;

/**
 * Covers the 'edit student details' functionality for instructors.
 * SUT: {@link InstructorCourseStudentDetailsEditPage}.
 */
public class InstructorCourseStudentDetailsEditPageUiTest extends BaseUiTestCase {
    private static Browser browser;
    private static InstructorCourseStudentDetailsEditPage editPage;
    private static DataBundle testData;
    

    @BeforeClass
    public static void classSetup() throws Exception {
        printTestClassHeader();
        testData = loadDataBundle("/InstructorCourseStudentDetailsEditPageUiTest.json");
        restoreTestDataOnServer(testData);
        browser = BrowserPool.getBrowser();
    }
    
    
    @Test
    public void testAll() throws Exception{
        testContent();
        testInputValidation();
//        no links to check
        testEditAction();
    }
    
    public void testContent() throws Exception{
        
        String instructorId = testData.instructors.get("CCSDEditUiT.instr").googleId;
        String courseId = testData.courses.get("CCSDEditUiT.CS2104").id;
        
        ______TS("content: unregistered student");
        
        Url editPageUrl = createUrl(Const.ActionURIs.INSTRUCTOR_COURSE_STUDENT_DETAILS_EDIT)
        .withUserId(instructorId)
        .withCourseId(courseId)
        .withStudentEmail(testData.students.get("unregisteredStudent").email);
        
        editPage = loginAdminToPage(browser, editPageUrl, InstructorCourseStudentDetailsEditPage.class);
        editPage.verifyHtml("/InstructorCourseStudentEditUnregisteredPage.html");
        
        ______TS("content: registered student");
        
        editPageUrl = createUrl(Const.ActionURIs.INSTRUCTOR_COURSE_STUDENT_DETAILS_EDIT)
            .withUserId(instructorId)
            .withCourseId(courseId)
            .withStudentEmail(testData.students.get("registeredStudent").email);
        
        editPage = loginAdminToPage(browser, editPageUrl, InstructorCourseStudentDetailsEditPage.class);
        editPage.verifyHtml("/InstructorCourseStudentEditPage.html");
    }
    
    public void testInputValidation() {
        
        ______TS("input validation");
        
        editPage.submitUnsuccessfully(null, "", null, null)
            .verifyStatus(Const.StatusMessages.FIELDS_EMPTY);
        
        String invalidStudentName = StringHelper.generateStringOfLength(FieldValidator.COURSE_STUDENTNAME_MAX_LENGTH + 1);
        String newTeamName = "New teamname";
        editPage.submitUnsuccessfully(invalidStudentName, newTeamName, null, null)
            .verifyStatus(Const.StatusMessages.COURSE_STUDENTNAME_INVALID);
        
        String newStudentName = "New guy";
        String invalidTeamName = StringHelper.generateStringOfLength(FieldValidator.COURSE_TEAMNAME_MAX_LENGTH + 1);
        editPage.submitUnsuccessfully(newStudentName, invalidTeamName, null, null)
            .verifyStatus(Const.StatusMessages.COURSE_TEAMNAME_INVALID);
        
        String invalidEmail = "invalidemail";
        editPage.submitUnsuccessfully(newStudentName, newTeamName, invalidEmail, null)
            .verifyStatus(Const.StatusMessages.COURSE_EMAIL_INVALID);
    }


    public void testEditAction() throws Exception{
        
        ______TS("Error case, invalid email parameter (email already taken by others)");

        StudentAttributes anotherStudent = testData.students.get("unregisteredStudent");
        
        
        editPage  = editPage.submitUnsuccessfully("New name2", "New team2", anotherStudent.email, "New comments2");
        editPage.verifyStatus(Const.StatusMessages.STUDENT_EMAIL_CONFLIT+anotherStudent.name+"/"+anotherStudent.email); //??
        editPage.verifyIsCorrectPage("CCSDEditUiT.jose.tmms@gmail.com");
            
        // Verify data
        StudentAttributes student  = BackDoor.getStudent(testData.courses.get("CCSDEditUiT.CS2104").id, "CCSDEditUiT.jose.tmms@gmail.com");
        assertEquals("José Gómez",student.name);
        assertEquals("Team 1",student.team);
        assertEquals(testData.students.get("registeredStudent").googleId,student.googleId);
        assertEquals("CCSDEditUiT.jose.tmms@gmail.com",student.email);
        assertEquals("This student's name is José Gómez",student.comments);
        
        
        ______TS("edit action");
        
        InstructorCourseDetailsPage detailsPage = editPage.submitSuccessfully("New name", "New team", "newemail@gmail.com", "New comments");
        detailsPage.verifyStatus(Const.StatusMessages.STUDENT_EDITED);
        detailsPage.verifyIsCorrectPage(testData.courses.get("CCSDEditUiT.CS2104").id);
            
        // Verify data
        student  = BackDoor.getStudent(testData.courses.get("CCSDEditUiT.CS2104").id, "newemail@gmail.com");
        assertEquals("New name",student.name);
        assertEquals("New team",student.team);
        assertEquals(testData.students.get("registeredStudent").googleId,student.googleId);
        assertEquals("newemail@gmail.com",student.email);
        assertEquals("New comments",student.comments);
    }


    @AfterClass
    public static void classTearDown() throws Exception {
        BrowserPool.release(browser);
    }
}
