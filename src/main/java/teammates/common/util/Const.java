package teammates.common.util;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import teammates.common.datatransfer.FeedbackParticipantType;

/**
 * Stores constants that are widely used across classes.
 * this class contains several nested classes, each containing a specific
 * category of constants.
 */
public final class Const {

    /*
     * This section holds constants that are defined as constants primarily
     * because they are repeated in many places.
     */
    @Deprecated
    public static final String HTML_BR_TAG = "<br>";

    public static final String USER_NOBODY_TEXT = "-";
    public static final String USER_UNKNOWN_TEXT = "Unknown user";
    public static final String TEAM_OF_EMAIL_OWNER = "'s Team";
    public static final String JOIN_LINK = "[Join Link]";

    public static final String NONE_OF_THE_ABOVE = "None of the above";
    public static final String DELETION_DATE_NOT_APPLICABLE = "Not Applicable";

    public static final String INSTRUCTOR_FEEDBACK_SESSION_VISIBLE_TIME_CUSTOM = "custom";
    public static final String INSTRUCTOR_FEEDBACK_SESSION_VISIBLE_TIME_ATOPEN = "atopen";

    public static final String INSTRUCTOR_FEEDBACK_RESULTS_VISIBLE_TIME_CUSTOM = "custom";
    public static final String INSTRUCTOR_FEEDBACK_RESULTS_VISIBLE_TIME_ATVISIBLE = "atvisible";
    public static final String INSTRUCTOR_FEEDBACK_RESULTS_VISIBLE_TIME_LATER = "later";
    public static final String INSTRUCTOR_FEEDBACK_RESULTS_MISSING_RESPONSE = "No Response";

    public static final String STUDENT_COURSE_STATUS_YET_TO_JOIN = "Yet to join";
    public static final String STUDENT_COURSE_STATUS_JOINED = "Joined";
    public static final String STUDENT_PROFILE_FIELD_NOT_FILLED = "Not Specified";

    public static final String USER_NAME_FOR_SELF = "Myself";
    public static final String USER_TEAM_FOR_INSTRUCTOR = "Instructors";
    public static final String NO_SPECIFIC_RECIPIENT = "No specific recipient";
    public static final String NO_SPECIFIC_SECTION = "No specific section";

    public static final String DISPLAYED_NAME_FOR_SELF_IN_COMMENTS = "You";
    public static final String DISPLAYED_NAME_FOR_ANONYMOUS_PARTICIPANT = "Anonymous";

    public static final String ACTION_RESULT_FAILURE = "Servlet Action Failure";

    public static final int SIZE_LIMIT_PER_ENROLLMENT = 150;
    public static final int INSTRUCTOR_VIEW_RESPONSE_LIMIT = 8000;

    public static final String DEFAULT_SECTION = "None";

    public static final ZoneId DEFAULT_TIME_ZONE = ZoneId.of("UTC");

    /*
     * These constants are used as variable values to mean that the variable
     * is in a 'special' state.
     */
    public static final int INT_UNINITIALIZED = -9999;
    public static final double DOUBLE_UNINITIALIZED = -9999.0;

    public static final int MAX_POSSIBLE_RECIPIENTS = -100;

    public static final int POINTS_EQUAL_SHARE = 100;
    public static final int POINTS_NOT_SURE = -101;
    public static final int POINTS_NOT_SUBMITTED = -999;

    public static final int VISIBILITY_TABLE_GIVER = 0;
    public static final int VISIBILITY_TABLE_RECIPIENT = 1;

    public static final String GENERAL_QUESTION = "%GENERAL%";
    public static final String USER_IS_TEAM = "%TEAM%";
    public static final String USER_IS_NOBODY = "%NOBODY%";
    public static final String USER_IS_MISSING = "%MISSING%";

    public static final Instant TIME_REPRESENTS_FOLLOW_OPENING;
    public static final Instant TIME_REPRESENTS_FOLLOW_VISIBLE;
    public static final Instant TIME_REPRESENTS_LATER;
    public static final Instant TIME_REPRESENTS_NOW;
    public static final Instant TIME_REPRESENTS_DEFAULT_TIMESTAMP;

    static {
        TIME_REPRESENTS_FOLLOW_OPENING = TimeHelper.parseInstant("1970-12-31 12:00 AM +0000");
        TIME_REPRESENTS_FOLLOW_VISIBLE = TimeHelper.parseInstant("1970-06-22 12:00 AM +0000");
        TIME_REPRESENTS_LATER = TimeHelper.parseInstant("1970-01-01 12:00 AM +0000");
        TIME_REPRESENTS_NOW = TimeHelper.parseInstant("1970-02-14 12:00 AM +0000");
        TIME_REPRESENTS_DEFAULT_TIMESTAMP = TimeHelper.parseInstant("2011-01-01 12:00 AM +0000");
    }

    /*
     * Other Constants
     */

    private Const() {
        // Utility class containing constants
    }

    public static class SystemParams {

        public static final String ENCODING = "UTF8";
        public static final int NUMBER_OF_HOURS_BEFORE_CLOSING_ALERT = 24;

        /** This is the limit after which TEAMMATES will send error message.
         * Must be within the range of int */
        public static final int MAX_PROFILE_PIC_SIZE = 5000000;

        /** This is the limit given to Blobstore API, beyond which an ugly error page is shown. */
        public static final long MAX_FILE_LIMIT_FOR_BLOBSTOREAPI = 11000000;

        /** e.g. "2014-04-01 11:59 PM UTC" */
        public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd h:mm a Z";

        /** Number to trim the Google ID when displaying to the user. */
        public static final int USER_ID_MAX_DISPLAY_LENGTH = 23;

        /* Field sizes and error messages for invalid fields can be found
         * in the FieldValidator class.
         */

        public static final ZoneId ADMIN_TIME_ZONE = ZoneId.of("Asia/Singapore");

        public static final String DEFAULT_PROFILE_PICTURE_PATH = "/images/profile_picture_default.png";

        @Deprecated
        public static final List<String> PAGES_REQUIRING_ORIGIN_VALIDATION = Collections.unmodifiableList(
                Arrays.asList(
                        ActionURIs.CREATE_IMAGE_UPLOAD_URL,
                        ActionURIs.IMAGE_UPLOAD,
                        ActionURIs.INSTRUCTOR_COURSE_REMIND,
                        ActionURIs.INSTRUCTOR_COURSE_STUDENT_DELETE,
                        ActionURIs.INSTRUCTOR_FEEDBACK_PUBLISH,
                        ActionURIs.INSTRUCTOR_FEEDBACK_REMIND_PARTICULAR_STUDENTS,
                        ActionURIs.INSTRUCTOR_FEEDBACK_RESPONSE_COMMENT_ADD,
                        ActionURIs.INSTRUCTOR_FEEDBACK_RESPONSE_COMMENT_DELETE,
                        ActionURIs.INSTRUCTOR_FEEDBACK_RESPONSE_COMMENT_EDIT,
                        ActionURIs.INSTRUCTOR_FEEDBACK_UNPUBLISH,
                        ActionURIs.STUDENT_PROFILE_CREATEUPLOADFORMURL,
                        ActionURIs.STUDENT_PROFILE_PICTURE_EDIT,
                        ActionURIs.STUDENT_PROFILE_PICTURE_UPLOAD));

    }

    /* Text displayed to the user when the mouse hover over certain elements in
     * the UI.
     */
    @Deprecated
    public static class Tooltips {

        public static final String COURSE_ENROLL = "Enroll student into the course";
        public static final String COURSE_DETAILS = "View, edit and send invitation emails to the students in the course";
        public static final String COURSE_EDIT = "Edit Course information and instructor list";
        public static final String COURSE_MOVE_TO_RECYCLE_BIN =
                "Delete the course and its corresponding students and sessions";
        public static final String COURSE_DELETE =
                "Permanently delete the course and its corresponding students and sessions";
        public static final String COURSE_DELETE_ALL =
                "Permanently delete all courses and their corresponding students and sessions";
        public static final String COURSE_RESTORE =
                "Restore the deleted course and its corresponding students and sessions";
        public static final String COURSE_RESTORE_ALL =
                "Restore all deleted courses and their corresponding students and sessions";
        public static final String COURSE_ARCHIVE =
                "Archive the course so that it will not be shown in the home page any more "
                + "(you can still access it from the 'Courses' tab)";
        public static final String COURSE_ADD_FEEDBACKSESSION = "Add a feedback session for the course";
        public static final String CLAIMED =
                "Claimed Contribution: This is the student's own estimation of his/her contributions";
        public static final String PERCEIVED =
                "Perceived Contribution: This is the average of what other team members think this student contributed";

        public static final String COURSE_INFO_EDIT = "Edit course name";
        public static final String COURSE_INSTRUCTOR_EDIT = "Edit instructor details";
        public static final String COURSE_INSTRUCTOR_CANCEL_EDIT = "Cancel editing instructor details";
        public static final String COURSE_INSTRUCTOR_CANCEL_ADD = "Cancel adding an instructor";
        public static final String COURSE_INSTRUCTOR_DELETE = "Delete the instructor from the course";
        public static final String COURSE_INSTRUCTOR_REMIND = "Send invitation email to the instructor";

        public static final String COURSE_STUDENT_DETAILS = "View the details of the student";
        public static final String COURSE_STUDENT_EDIT =
                "Use this to edit the details of this student. <br>To edit multiple students"
                + " in one go, you can use the enroll page: <br>"
                + "Simply enroll students using the updated data and existing data will be updated accordingly";
        public static final String COURSE_STUDENT_REMIND =
                "Email an invitation to the student requesting him/her to join the course using his/her "
                + "Google Account. Note: Students can use TEAMMATES without ‘joining’, "
                + "but a joined student can access extra features e.g. set up a user profile";
        public static final String COURSE_STUDENT_DELETE =
                "Delete the student and the corresponding submissions from the course";

        public static final String COURSE_REMIND =
                "Email an invitation to all students yet to join requesting them to join the course "
                + "using their Google Accounts. Note: Students can use TEAMMATES without ‘joining’, "
                + "but a joined student can access extra features e.g. set up a user profile";

        public static final String EVALUEE_DESCRIPTION = "The party being evaluated or given feedback to";
        public static final String INSTRUCTOR_DISPLAYED_TO_STUDENT =
                "If this is unselected, the instructor will be completely invisible to students."
                + " E.g. to give access to a colleague for ‘auditing’ your course";

        public static final String INSTRUCTOR_DISPLAYED_AS =
                "Specify the role of this instructor in this course as shown to the students";

        public static final String STUDENT_COURSE_DETAILS = "View and edit information regarding your team";

        public static final String STUDENT_FEEDBACK_SESSION_STATUS_AWAITING =
                "The session is not open for submission at this time. It is expected to open later.";
        public static final String STUDENT_FEEDBACK_SESSION_STATUS_PENDING =
                "The feedback session is yet to be completed by you.";
        public static final String STUDENT_FEEDBACK_SESSION_STATUS_SUBMITTED =
                "You have submitted your feedback for this session.";
        public static final String STUDENT_FEEDBACK_SESSION_STATUS_CLOSED =
                "<br>The session is now closed for submissions.";
        public static final String STUDENT_FEEDBACK_SESSION_STATUS_PUBLISHED =
                "The responses for the session have been published and can now be viewed.";
        public static final String STUDENT_FEEDBACK_SESSION_STATUS_NOT_PUBLISHED =
                "The responses for the session have not yet been published and cannot be viewed.";

        public static final String FEEDBACK_CONTRIBUTION_DIFF = "Perceived Contribution - Claimed Contribution";
        public static final String FEEDBACK_CONTRIBUTION_POINTS_RECEIVED =
                "The list of points that this student received from others";

        public static final String FEEDBACK_CONTRIBUTION_NOT_AVAILABLE =
                "Not Available: There is no data for this or the data is not enough";
        public static final String FEEDBACK_CONTRIBUTION_NOT_SURE = "Not sure about the contribution";

        public static final String FEEDBACK_SESSION_COURSE =
                "Please select the course for which the feedback session is to be created.";
        public static final String FEEDBACK_SESSION_INPUT_NAME =
                "Enter the name of the feedback session e.g. Feedback Session 1.";
        public static final String FEEDBACK_SESSION_STARTDATE =
                "Please select the date and time for which users can start submitting responses for the feedback session.";
        public static final String FEEDBACK_SESSION_ENDDATE =
                "Please select the date and time after which the feedback session "
                + "will no longer accept submissions from users.";
        public static final String FEEDBACK_SESSION_VISIBLEDATE =
                "Select this option to enter in a custom date and time for which "
                + "the feedback session will become visible.<br>"
                + "Note that you can make a session visible before it is open for submissions "
                + "so that users can preview the questions.";
        public static final String FEEDBACK_SESSION_PUBLISHDATE =
                "Select this option to enter in a custom date and time for which</br>"
                + "the responses for this feedback session will become visible.";
        public static final String FEEDBACK_SESSION_SESSIONVISIBLELABEL =
                "Please select when you want the questions for the feedback session to be visible to "
                + "users who need to participate. "
                + "Note that users cannot submit their responses until the submissions opening time set below.";
        public static final String FEEDBACK_SESSION_SESSIONVISIBLEATOPEN =
                "Select this option to have the feedback session become visible "
                + "when it is open for submissions (as selected above).";
        public static final String FEEDBACK_SESSION_RESULTSVISIBLELABEL =
                "Please select when the responses for the feedback session will be visible to the designated recipients."
                + "<br>You can select the response visibility for each type of user and question later.";
        public static final String FEEDBACK_SESSION_RESULTSVISIBLECUSTOM =
                "Select this option to use a custom time for when the responses of the feedback session<br>"
                + "will be visible to the designated recipients.";
        public static final String FEEDBACK_SESSION_RESULTSVISIBLEATVISIBLE =
                "Select this option to have the feedback responses be immediately visible<br>"
                + "when the session becomes visible to users.";
        public static final String FEEDBACK_SESSION_RESULTSVISIBLELATER =
                "Select this option if you intend to manually publish the responses for this session later on.";
        public static final String FEEDBACK_SESSION_SENDOPENEMAIL =
                "Select this option to automatically send an email to students to notify them "
                + "when the session is open for submission.";
        public static final String FEEDBACK_SESSION_SENDCLOSINGEMAIL =
                "Select this option to automatically send an email to students to remind them to submit "
                + "24 hours before the end of the session.";
        public static final String FEEDBACK_SESSION_SENDPUBLISHEDEMAIL =
                "Select this option to automatically send an email to students to notify them "
                + "when the session results is published.";
        public static final String FEEDBACK_SESSION_INSTRUCTIONS =
                "Enter instructions for this feedback session. e.g. Avoid comments which are too critical.<br> "
                + "It will be displayed at the top of the page when users respond to the session.";
        public static final String FEEDBACK_SESSION_STATUS_VISIBLE = ", is visible";
        public static final String FEEDBACK_SESSION_STATUS_AWAITING = ", and is waiting to open";
        public static final String FEEDBACK_SESSION_STATUS_OPEN = ", and is open for submissions";
        public static final String FEEDBACK_SESSION_STATUS_CLOSED = ", and has ended";
        public static final String FEEDBACK_SESSION_STATUS_PUBLISHED = "The responses for this session are visible.";
        public static final String FEEDBACK_SESSION_STATUS_NOT_PUBLISHED = "The responses for this session are not visible.";
        public static final String FEEDBACK_SESSION_INPUT_TIMEZONE =
                "To change this, edit the course settings. <br><br>"
                + "TEAMMATES automatically adjusts to match the current time offset in your area, "
                + "including clock changes due to daylight saving time.";

        public static final String FEEDBACK_SESSION_INPUT_GRACEPERIOD =
                "Please select the amount of time that the system will continue accepting <br>"
                + "submissions after the specified deadline.";

        public static final String FEEDBACK_SESSION_RESPONSE_RATE = "Number of students submitted / Class size";
        public static final String FEEDBACK_SESSION_RESULTS = "View the submitted responses for this feedback session";
        public static final String FEEDBACK_SESSION_EDIT = "Edit feedback session details";
        public static final String FEEDBACK_SESSION_COPY = "Copy feedback session details";
        public static final String FEEDBACK_SESSION_REMIND =
                "Send e-mails to remind students and instructors who have not submitted their feedbacks to do so";
        public static final String FEEDBACK_SESSION_MOVE_TO_RECYCLE_BIN = "Delete the feedback session";
        public static final String FEEDBACK_SESSION_DELETE = "Permanently delete the feedback session";
        public static final String FEEDBACK_SESSION_DELETE_ALL = "Permanently delete all feedback sessions";
        public static final String FEEDBACK_SESSION_RESTORE = "Restore the feedback session";
        public static final String FEEDBACK_SESSION_RESTORE_ALL = "Restore all feedback sessions";
        public static final String FEEDBACK_SESSION_SUBMIT = "Start submitting feedback";
        public static final String FEEDBACK_SESSION_PUBLISH = "Make session responses available for viewing";
        public static final String FEEDBACK_SESSION_UNPUBLISH = "Make responses no longer visible";
        public static final String FEEDBACK_SESSION_AWAITING = "This session is not yet opened";
        public static final String FEEDBACK_SESSION_EDIT_SUBMITTED_RESPONSE = "Edit submitted feedback";
        public static final String FEEDBACK_SESSION_VIEW_SUBMITTED_RESPONSE = "View submitted feedback";
        public static final String FEEDBACK_SESSION_RECIPIENT = "Who the feedback is about";
        public static final String FEEDBACK_SESSION_GIVER = "Who will give feedback";

        public static final String FEEDBACK_SESSION_EDIT_SAVE =
                "You can save your responses at any time and come back later to continue.";

        public static final String FEEDBACK_SESSION_MODERATE_FEEDBACK = "Edit the responses given by this student";

        public static final String FEEDBACK_PREVIEW_ASSTUDENT =
                "View how this session would look like to a student who is submitting feedback.<br>"
                + "Preview is unavailable if the course has yet to have any student enrolled.";
        public static final String FEEDBACK_PREVIEW_ASINSTRUCTOR =
                "View how this session would look like to an instructor who is submitting feedback.<br>"
                + "Only instructors with submit privileges are included in the list.";

        public static final String FEEDBACK_QUESTION_INPUT_INSTRUCTIONS =
                "Please enter the question for users to give feedback about. "
                + "e.g. What is the biggest weakness of the presented product?";
        public static final String FEEDBACK_QUESTION_DUPLICATE =
                "Make a copy of the existing question and add to the current feedback session.";
        public static final String FEEDBACK_QUESTION_EDIT =
                "Edit the existing question. Do remember to save the changes before moving on to editing another question.";
        public static final String FEEDBACK_QUESTION_DISCARDCHANGES =
                "Discard any unsaved edits and revert back to original question.";
        public static final String FEEDBACK_QUESTION_CANCEL_NEW =
                "Cancel adding new question. No new question will be added to the feedback session.";
        public static final String FEEDBACK_QUESTION_INPUT_DESCRIPTION =
                "Please enter the description of the question.";
        public static final String FEEDBACK_QUESTION_CONSTSUMPOINTS_OPTION =
                "Respondents will have to distribute the total points specified here among the options, "
                + "e.g. if you specify 100 points here and there are 3 options, "
                + "respondents will have to distribute 100 points among 3 options.";
        public static final String FEEDBACK_QUESTION_CONSTSUMPOINTS_RECIPIENT =
                "Respondents will have to distribute the total points specified here among the recipients, "
                + "e.g. if you specify 100 points here and there are 3 recipients, "
                + "respondents will have to distribute 100 points among 3 recipients.";
        public static final String FEEDBACK_QUESTION_CONSTSUMPOINTSFOREACHOPTION =
                "The number of points to distribute will vary based on the number of options, "
                + "e.g. if you specify 100 points here and there are 3 options, "
                + "the total number of points to distribute among 3 options will be 300 (i.e. 100 x 3).";
        public static final String FEEDBACK_QUESTION_CONSTSUMPOINTSFOREACHRECIPIENT =
                "The number of points to distribute will vary based on the number of recipients, "
                + "e.g. if you specify 100 points here and there are 3 recipients, "
                + "the total number of points to distribute among 3 recipients will be 300 (i.e. 100 x 3).";
        public static final String FEEDBACK_QUESTION_NUMSCALE_MAX = "Maximum acceptable response value";
        public static final String FEEDBACK_QUESTION_NUMSCALE_STEP = "Value to be increased/decreased each step";
        public static final String FEEDBACK_QUESTION_NUMSCALE_MIN = "Minimum acceptable response value";
        public static final String FEEDBACK_QUESTION_MSQ_ASSIGN_WEIGHTS =
                "Assign weights to the choices for calculating statistics.";
        public static final String FEEDBACK_QUESTION_RUBRIC_ASSIGN_WEIGHTS =
                "Assign weights to the columns for calculating statistics.";
        public static final String FEEDBACK_QUESTION_MCQ_ASSIGN_WEIGHTS =
                "Assign weights to the choices for calculating statistics.";

        public static final String STUDENT_PROFILE_PICTURE = "Upload a profile picture (.jpg or .png, max size 5 MB)";
        public static final String STUDENT_PROFILE_SHORTNAME = "This is the name you prefer to be called by";
        public static final String STUDENT_PROFILE_EMAIL = "This is a long term contact email";
        public static final String STUDENT_PROFILE_INSTITUTION = "This is the institution that you represent";
        public static final String STUDENT_PROFILE_NATIONALITY = "This is your nationality";
        public static final String STUDENT_PROFILE_MOREINFO = "You may specify miscellaneous info about yourself "
                + "e.g. links to home page, online CV, portfolio etc.";

        public static final String VISIBILITY_OPTIONS_RECIPIENT = "Control what feedback recipient(s) can view";
        public static final String VISIBILITY_OPTIONS_GIVER_TEAM_MEMBERS =
                "Control what team members of feedback giver can view";
        public static final String VISIBILITY_OPTIONS_RECIPIENT_TEAM_MEMBERS =
                "Control what team members of feedback recipients can view";
        public static final String VISIBILITY_OPTIONS_OTHER_STUDENTS = "Control what other students can view";
        public static final String VISIBILITY_OPTIONS_INSTRUCTORS = "Control what instructors can view";

        public static final String COMMENT_ADD = "Add comment";
        public static final String COMMENT_EDIT = "Edit this comment";
        public static final String COMMENT_DELETE = "Delete this comment";
        public static final String COMMENT_ADD_FOR_FEEDBACK_PARTICIPANT =
                "Add comment to explain your feedback response. It is optional.";
        public static final String COMMENT_DISCARD_CHANGES = "Discard changes to comment";

        public static final String SEARCH_STUDENT = "Search for student's information, e.g. name, email";

        public static final String ACTION_NOT_ALLOWED = "You do not have the permissions to access this feature";
    }

    public static class FeedbackQuestion {

        public static final Map<String, String> COMMON_VISIBILITY_OPTIONS;

        static {
            Map<String, String> visibilityOptionInit = new LinkedHashMap<>();

            visibilityOptionInit.put("ANONYMOUS_TO_RECIPIENT_AND_INSTRUCTORS",
                                     "Shown anonymously to recipient and instructors");
            visibilityOptionInit.put("ANONYMOUS_TO_RECIPIENT_VISIBLE_TO_INSTRUCTORS",
                                     "Shown anonymously to recipient, visible to instructors");
            visibilityOptionInit.put("ANONYMOUS_TO_RECIPIENT_AND_TEAM_VISIBLE_TO_INSTRUCTORS",
                                     "Shown anonymously to recipient and team members, visible to instructors");
            visibilityOptionInit.put("VISIBLE_TO_INSTRUCTORS_ONLY", "Visible to instructors only");
            visibilityOptionInit.put("VISIBLE_TO_RECIPIENT_AND_INSTRUCTORS", "Visible to recipient and instructors");

            COMMON_VISIBILITY_OPTIONS = Collections.unmodifiableMap(visibilityOptionInit);
        }

        public static final Map<FeedbackParticipantType, List<FeedbackParticipantType>>
                COMMON_FEEDBACK_PATHS;

        static {
            Map<FeedbackParticipantType, List<FeedbackParticipantType>> initializer = new LinkedHashMap<>();

            initializer.put(FeedbackParticipantType.SELF,
                    new ArrayList<>(
                            Arrays.asList(FeedbackParticipantType.NONE,
                                    FeedbackParticipantType.SELF,
                                    FeedbackParticipantType.INSTRUCTORS)));

            initializer.put(FeedbackParticipantType.STUDENTS,
                    new ArrayList<>(
                            Arrays.asList(FeedbackParticipantType.NONE,
                                    FeedbackParticipantType.SELF,
                                    FeedbackParticipantType.INSTRUCTORS,
                                    FeedbackParticipantType.OWN_TEAM_MEMBERS,
                                    FeedbackParticipantType.OWN_TEAM_MEMBERS_INCLUDING_SELF)));

            initializer.put(FeedbackParticipantType.INSTRUCTORS,
                    new ArrayList<>(
                            Arrays.asList(FeedbackParticipantType.NONE,
                                    FeedbackParticipantType.SELF,
                                    FeedbackParticipantType.INSTRUCTORS)));

            COMMON_FEEDBACK_PATHS = Collections.unmodifiableMap(initializer);
        }

        // Mcq
        public static final int MCQ_MIN_NUM_OF_CHOICES = 2;
        public static final String MCQ_ERROR_NOT_ENOUGH_CHOICES =
                "Too little choices for " + Const.FeedbackQuestionTypeNames.MCQ + ". Minimum number of options is: ";
        public static final String MCQ_ERROR_INVALID_OPTION =
                " is not a valid option for the " + Const.FeedbackQuestionTypeNames.MCQ + ".";
        public static final String MCQ_ERROR_INVALID_WEIGHT =
                "The weights for the choices of a " + Const.FeedbackQuestionTypeNames.MCQ
                + " must be valid non-negative numbers with precision up to 2 decimal places.";

        // Msq
        public static final int MSQ_MIN_NUM_OF_CHOICES = 2;
        public static final String MSQ_ERROR_NOT_ENOUGH_CHOICES =
                "Too little choices for " + Const.FeedbackQuestionTypeNames.MSQ + ". Minimum number of options is: ";
        public static final String MSQ_ERROR_INVALID_OPTION =
                " is not a valid option for the " + Const.FeedbackQuestionTypeNames.MSQ + ".";
        public static final String MSQ_ERROR_MAX_SELECTABLE_EXCEEDED_TOTAL =
                "Maximum selectable choices exceeds the total number of options for " + Const.FeedbackQuestionTypeNames.MSQ;
        public static final String MSQ_ERROR_MIN_SELECTABLE_EXCEEDED_MAX_SELECTABLE =
                "Minimum selectable choices exceeds maximum selectable choices for "
                + Const.FeedbackQuestionTypeNames.MSQ;
        public static final String MSQ_ERROR_MIN_FOR_MAX_SELECTABLE_CHOICES =
                "Maximum selectable choices for " + Const.FeedbackQuestionTypeNames.MSQ + " must be at least 2.";
        public static final String MSQ_ERROR_MIN_FOR_MIN_SELECTABLE_CHOICES =
                "Minimum selectable choices for " + Const.FeedbackQuestionTypeNames.MSQ + " must be at least 1.";
        public static final String MSQ_ERROR_INVALID_WEIGHT =
                "The weights for the choices of a " + Const.FeedbackQuestionTypeNames.MSQ
                + " must be valid numbers with precision up to 2 decimal places.";

        // Numscale
        public static final String NUMSCALE_ERROR_MIN_MAX =
                "Minimum value must be < maximum value for " + Const.FeedbackQuestionTypeNames.NUMSCALE + ".";
        public static final String NUMSCALE_ERROR_STEP =
                "Step value must be > 0 for " + Const.FeedbackQuestionTypeNames.NUMSCALE + ".";
        public static final String NUMSCALE_ERROR_OUT_OF_RANGE =
                " is out of the range for " + Const.FeedbackQuestionTypeNames.NUMSCALE + ".";

        // Contribution
        public static final String CONTRIB_ERROR_INVALID_OPTION =
                "Invalid option for the " + Const.FeedbackQuestionTypeNames.CONTRIB + ".";
        public static final String CONTRIB_ERROR_INVALID_FEEDBACK_PATH =
                Const.FeedbackQuestionTypeNames.CONTRIB + " must have "
                + FeedbackParticipantType.STUDENTS.toDisplayGiverName()
                + " and " + FeedbackParticipantType.OWN_TEAM_MEMBERS_INCLUDING_SELF.toDisplayRecipientName()
                + " as the feedback giver and recipient respectively."
                + " These values will be used instead.";
        public static final String CONTRIB_ERROR_INVALID_VISIBILITY_OPTIONS =
                Const.FeedbackQuestionTypeNames.CONTRIB + " must use one of the common visibility options. The \""
                + Const.FeedbackQuestion.COMMON_VISIBILITY_OPTIONS
                                        .get("ANONYMOUS_TO_RECIPIENT_AND_TEAM_VISIBLE_TO_INSTRUCTORS")
                + "\" option will be used instead.";

        // Constant sum
        public static final int CONST_SUM_MIN_NUM_OF_OPTIONS = 2;
        public static final int CONST_SUM_MIN_NUM_OF_POINTS = 1;
        public static final String CONST_SUM_ERROR_NOT_ENOUGH_OPTIONS =
                "Too little options for " + Const.FeedbackQuestionTypeNames.CONSTSUM_OPTION
                + ". Minimum number of options is: ";
        public static final String CONST_SUM_ERROR_DUPLICATE_OPTIONS = "Duplicate options are not allowed.";
        public static final String CONST_SUM_ERROR_NOT_ENOUGH_POINTS =
                "Too little points for " + Const.FeedbackQuestionTypeNames.CONSTSUM_RECIPIENT
                + ". Minimum number of points is: ";
        public static final String CONST_SUM_ERROR_MISMATCH =
                "Please distribute all the points for distribution questions. "
                + "To skip a distribution question, leave the boxes blank.";
        public static final String CONST_SUM_ERROR_NEGATIVE = "Points given must be 0 or more.";
        public static final String CONST_SUM_ERROR_UNIQUE = "Every option must be given a different number of points.";
        public static final String CONST_SUM_ERROR_SOME_UNIQUE =
                "At least some options must be given a different number of points.";

        // Rubric
        public static final int RUBRIC_MIN_NUM_OF_CHOICES = 2;
        public static final String RUBRIC_ERROR_NOT_ENOUGH_CHOICES =
                "Too little choices for " + Const.FeedbackQuestionTypeNames.RUBRIC + ". Minimum number of options is: ";
        public static final int RUBRIC_MIN_NUM_OF_SUB_QUESTIONS = 1;
        public static final String RUBRIC_ERROR_NOT_ENOUGH_SUB_QUESTIONS =
                "Too little sub-questions for " + Const.FeedbackQuestionTypeNames.RUBRIC + ". "
                + "Minimum number of sub-questions is: ";
        public static final String RUBRIC_ERROR_DESC_INVALID_SIZE =
                "Invalid number of descriptions for " + Const.FeedbackQuestionTypeNames.RUBRIC;
        public static final String RUBRIC_ERROR_EMPTY_SUB_QUESTION =
                "Sub-questions for " + Const.FeedbackQuestionTypeNames.RUBRIC + " cannot be empty.";
        public static final String RUBRIC_ERROR_INVALID_WEIGHT =
                "The weights for the choices of each Sub-question of a "
                + Const.FeedbackQuestionTypeNames.RUBRIC
                + " must be valid numbers with precision up to 2 decimal places.";
    }

    public static class FeedbackQuestionTypeNames {
        public static final String TEXT = "Essay question";
        public static final String MCQ = "Multiple-choice (single answer) question";
        public static final String MSQ = "Multiple-choice (multiple answers) question";
        public static final String NUMSCALE = "Numerical-scale question";
        public static final String CONSTSUM_OPTION = "Distribute points (among options) question";
        public static final String CONSTSUM_RECIPIENT = "Distribute points (among recipients) question";
        public static final String RANK_OPTION = "Rank (options) question";
        public static final String RANK_RECIPIENT = "Rank (recipients) question";
        public static final String CONTRIB = "Team contribution question";
        public static final String RUBRIC = "Rubric question";
    }

    public static class FeedbackSessionResults {
        public static final String QUESTION_SORT_TYPE = "question";
        public static final String GRQ_SORT_TYPE = "giver-recipient-question";
        public static final String RGQ_SORT_TYPE = "recipient-giver-question";
        public static final String GQR_SORT_TYPE = "giver-question-recipient";
        public static final String RQG_SORT_TYPE = "recipient-question-giver";
    }

    public static class InstructorPermissionRoleNames {
        public static final String INSTRUCTOR_PERMISSION_ROLE_COOWNER = "Co-owner";
        public static final String INSTRUCTOR_PERMISSION_ROLE_MANAGER = "Manager";
        public static final String INSTRUCTOR_PERMISSION_ROLE_OBSERVER = "Observer";
        public static final String INSTRUCTOR_PERMISSION_ROLE_TUTOR = "Tutor";
        public static final String INSTRUCTOR_PERMISSION_ROLE_CUSTOM = "Custom";
    }

    public static class ParamsNames {

        public static final String IS_IN_RECYCLE_BIN = "isinrecyclebin";

        public static final String IS_USING_AJAX = "isusingAjax";
        public static final String IS_STUDENT_REJOINING = "isstudentrejoining";
        public static final String IS_INSTRUCTOR_REJOINING = "isinstructorrejoining";

        public static final String BLOB_KEY = "blob-key";
        public static final String SESSION_TOKEN = "token";

        public static final String COPIED_FEEDBACK_SESSION_NAME = "copiedfsname";
        public static final String COPIED_COURSE_ID = "copiedcourseid";
        public static final String COPIED_COURSES_ID = "copiedcoursesid";

        public static final String CSV_TO_HTML_TABLE_NEEDED = "csvtohtmltable";

        public static final String COURSE_ID = "courseid";
        public static final String COURSE_NAME = "coursename";
        public static final String COURSE_INDEX = "courseidx";
        public static final String COURSE_TIME_ZONE = "coursetimezone";
        public static final String COURSE_EDIT_MAIN_INDEX = "courseeditmainindex";
        public static final String INSTRUCTOR_ID = "instructorid";
        public static final String INSTRUCTOR_EMAIL = "instructoremail";
        public static final String INSTRUCTOR_INSTITUTION = "instructorinstitution";
        public static final String INSTRUCTOR_NAME = "instructorname";
        public static final String STUDENTS_ENROLLMENT_INFO = "enrollstudents";

        public static final String INSTRUCTOR_IS_DISPLAYED_TO_STUDENT = "instructorisdisplayed";
        public static final String INSTRUCTOR_DISPLAY_NAME = "instructordisplayname";
        public static final String INSTRUCTOR_ROLE_NAME = "instructorrole";
        public static final String INSTRUCTOR_SECTION = "section";
        public static final String INSTRUCTOR_SECTION_GROUP = "sectiongroup";

        public static final String INSTRUCTOR_PERMISSION_MODIFY_COURSE = "canmodifycourse";
        public static final String INSTRUCTOR_PERMISSION_MODIFY_INSTRUCTOR = "canmodifyinstructor";
        public static final String INSTRUCTOR_PERMISSION_MODIFY_SESSION = "canmodifysession";
        public static final String INSTRUCTOR_PERMISSION_MODIFY_STUDENT = "canmodifystudent";

        public static final String INSTRUCTOR_PERMISSION_VIEW_STUDENT_IN_SECTIONS = "canviewstudentinsection";
        public static final String INSTRUCTOR_PERMISSION_VIEW_SESSION_IN_SECTIONS = "canviewsessioninsection";
        public static final String INSTRUCTOR_PERMISSION_SUBMIT_SESSION_IN_SECTIONS = "cansubmitsessioninsection";
        public static final String INSTRUCTOR_PERMISSION_MODIFY_SESSION_COMMENT_IN_SECTIONS =
                "canmodifysessioncommentinsection";

        public static final String INSTRUCTOR_REMIND_STUDENT_IS_FROM = "pagenameremindstudentisfrom";

        public static final String COURSE_SORTING_CRITERIA = "sortby";
        public static final String COURSE_TO_LOAD = "coursetoload";

        public static final String COURSE_ARCHIVE_STATUS = "archive";

        public static final String IMAGE_TO_UPLOAD = "imagetoupload";

        public static final String ADMIN_SEARCH_KEY = "searchkey";

        public static final String LOCAL_DATE_TIME = "localdatetime";
        public static final String TIME_ZONE = "timezone";

        public static final String FEEDBACK_SESSION_NAME = "fsname";
        public static final String FEEDBACK_SESSION_INDEX = "fsindex";
        public static final String FEEDBACK_SESSION_STARTDATE = "startdate";
        public static final String FEEDBACK_SESSION_STARTTIME = "starttime";
        public static final String FEEDBACK_SESSION_STARTHOUR = "starthour";
        public static final String FEEDBACK_SESSION_STARTMINUTE = "startminute";
        public static final String FEEDBACK_SESSION_ENDDATE = "enddate";
        public static final String FEEDBACK_SESSION_ENDTIME = "endtime";
        public static final String FEEDBACK_SESSION_ENDHOUR = "endhour";
        public static final String FEEDBACK_SESSION_ENDMINUTE = "endminute";
        public static final String FEEDBACK_SESSION_VISIBLEDATE = "visibledate";
        public static final String FEEDBACK_SESSION_VISIBLETIME = "visibletime";
        public static final String FEEDBACK_SESSION_PUBLISHDATE = "publishdate";
        public static final String FEEDBACK_SESSION_PUBLISHTIME = "publishtime";
        public static final String FEEDBACK_SESSION_TIMEZONE = "timezone";
        public static final String FEEDBACK_SESSION_GRACEPERIOD = "graceperiod";
        public static final String SESSION_TEMPLATE_TYPE = "sessionTemplateType";
        public static final String FEEDBACK_SESSION_SESSIONVISIBLEBUTTON = "sessionVisibleFromButton";
        public static final String FEEDBACK_SESSION_RESULTSVISIBLEBUTTON = "resultsVisibleFromButton";
        public static final String FEEDBACK_SESSION_SENDREMINDEREMAIL = "sendreminderemail";
        public static final String FEEDBACK_SESSION_INSTRUCTIONS = "instructions";
        public static final String FEEDBACK_SESSION_MODERATED_PERSON = "moderatedperson";
        public static final String FEEDBACK_SESSION_MODERATED_QUESTION_ID = "moderatedquestionid";
        @Deprecated
        public static final String FEEDBACK_SESSION_ENABLE_EDIT = "editsessiondetails";

        public static final String FEEDBACK_QUESTION_ID = "questionid";
        public static final String FEEDBACK_QUESTION_NUMBER = "questionnum";
        public static final String FEEDBACK_QUESTION_NUMBER_STATIC = "questionnum-static";
        public static final String FEEDBACK_QUESTION_TEMPLATE_NUMBER = "templatequestionnum";
        public static final String FEEDBACK_QUESTION_TEXT = "questiontext";
        public static final String FEEDBACK_QUESTION_TEXT_RECOMMENDEDLENGTH = "recommendedlength";
        public static final String FEEDBACK_QUESTION_DESCRIPTION = "questiondescription";
        public static final String FEEDBACK_QUESTION_TYPE = "questiontype";
        public static final String FEEDBACK_QUESTION_NUMBEROFCHOICECREATED = "noofchoicecreated";
        public static final String FEEDBACK_QUESTION_MCQCHOICE = "mcqOption";
        public static final String FEEDBACK_QUESTION_MCQOTHEROPTION = "mcqOtherOption";
        public static final String FEEDBACK_QUESTION_MCQOTHEROPTIONFLAG = "mcqOtherOptionFlag";
        public static final String FEEDBACK_QUESTION_MCQ_ISOTHEROPTIONANSWER = "mcqIsOtherOptionAnswer";
        public static final String FEEDBACK_QUESTION_MCQ_HAS_WEIGHTS_ASSIGNED = "mcqHasAssignedWeights";
        public static final String FEEDBACK_QUESTION_MCQ_WEIGHT = "mcqWeight";
        public static final String FEEDBACK_QUESTION_MCQ_OTHER_WEIGHT = "mcqOtherWeight";
        public static final String FEEDBACK_QUESTION_MSQCHOICE = "msqOption";
        public static final String FEEDBACK_QUESTION_MSQOTHEROPTION = "msqOtherOption";
        public static final String FEEDBACK_QUESTION_MSQOTHEROPTIONFLAG = "msqOtherOptionFlag";
        public static final String FEEDBACK_QUESTION_MSQ_ISOTHEROPTIONANSWER = "msqIsOtherOptionAnswer";
        public static final String FEEDBACK_QUESTION_MSQ_MAX_SELECTABLE_CHOICES = "msqMaxSelectableChoices";
        public static final String FEEDBACK_QUESTION_MSQ_MIN_SELECTABLE_CHOICES = "msqMinSelectableChoices";
        public static final String FEEDBACK_QUESTION_MSQ_ENABLE_MAX_SELECTABLE_CHOICES = "msqEnableMaxSelectableChoices";
        public static final String FEEDBACK_QUESTION_MSQ_ENABLE_MIN_SELECTABLE_CHOICES = "msqEnableMinSelectableChoices";
        public static final String FEEDBACK_QUESTION_MSQ_HAS_WEIGHTS_ASSIGNED = "msqHasAssignedWeights";
        public static final String FEEDBACK_QUESTION_MSQ_WEIGHT = "msqWeight";
        public static final String FEEDBACK_QUESTION_MSQ_OTHER_WEIGHT = "msqOtherWeight";
        public static final String FEEDBACK_QUESTION_CONSTSUMOPTION = "constSumOption";
        public static final String FEEDBACK_QUESTION_CONSTSUMTORECIPIENTS = "constSumToRecipients";
        public static final String FEEDBACK_QUESTION_CONSTSUMNUMOPTION = "constSumNumOption";
        // TODO: rename FEEDBACK_QUESTION_CONSTSUMPOINTSPEROPTION to a more accurate name
        public static final String FEEDBACK_QUESTION_CONSTSUMPOINTSPEROPTION = "constSumPointsPerOption";
        public static final String FEEDBACK_QUESTION_CONSTSUMPOINTS = "constSumPoints";
        public static final String FEEDBACK_QUESTION_CONSTSUMPOINTSFOREACHOPTION = "constSumPointsForEachOption";
        public static final String FEEDBACK_QUESTION_CONSTSUMPOINTSFOREACHRECIPIENT = "constSumPointsForEachRecipient";
        public static final String FEEDBACK_QUESTION_CONSTSUMDISTRIBUTEUNEVENLY = "constSumUnevenDistribution";
        public static final String FEEDBACK_QUESTION_CONSTSUMDISTRIBUTEPOINTSOPTIONS = "constSumDistributePointsOptions";
        public static final String FEEDBACK_QUESTION_CONSTSUMALLUNEVENDISTRIBUTION = "All options";
        public static final String FEEDBACK_QUESTION_CONSTSUMSOMEUNEVENDISTRIBUTION = "At least some options";
        public static final String FEEDBACK_QUESTION_CONSTSUMNOUNEVENDISTRIBUTION = "None";
        public static final String FEEDBACK_QUESTION_CONTRIBISNOTSUREALLOWED = "isNotSureAllowedCheck";
        public static final String FEEDBACK_QUESTION_MCQ_GENERATED_OPTIONS = "mcqGeneratedOptions";
        public static final String FEEDBACK_QUESTION_MSQ_GENERATED_OPTIONS = "msqGeneratedOptions";
        public static final String FEEDBACK_QUESTION_GIVERTYPE = "givertype";
        public static final String FEEDBACK_QUESTION_RECIPIENTTYPE = "recipienttype";
        public static final String FEEDBACK_QUESTION_NUMBEROFENTITIES = "numofrecipients";
        public static final String FEEDBACK_QUESTION_NUMBEROFENTITIESTYPE = "numofrecipientstype";
        public static final String FEEDBACK_QUESTION_EDITTEXT = "questionedittext";
        public static final String FEEDBACK_QUESTION_DISCARDCHANGES = "questiondiscardchanges";
        public static final String FEEDBACK_QUESTION_EDITTYPE = "questionedittype";
        public static final String FEEDBACK_QUESTION_SAVECHANGESTEXT = "questionsavechangestext";
        public static final String FEEDBACK_QUESTION_SHOWRESPONSESTO = "showresponsesto";
        public static final String FEEDBACK_QUESTION_SHOWGIVERTO = "showgiverto";
        public static final String FEEDBACK_QUESTION_SHOWRECIPIENTTO = "showrecipientto";
        public static final String FEEDBACK_QUESTION_RESPONSETOTAL = "questionresponsetotal";
        public static final String FEEDBACK_QUESTION_NUMSCALE_MIN = "numscalemin";
        public static final String FEEDBACK_QUESTION_NUMSCALE_MAX = "numscalemax";
        public static final String FEEDBACK_QUESTION_NUMSCALE_STEP = "numscalestep";
        public static final String FEEDBACK_QUESTION_RUBRIC_EDIT_TABLE = "rubricEditTable";
        public static final String FEEDBACK_QUESTION_RUBRIC_SUBQUESTION = "rubricSubQn";
        public static final String FEEDBACK_QUESTION_RUBRIC_CHOICE = "rubricChoice";
        public static final String FEEDBACK_QUESTION_RUBRIC_DESCRIPTION = "rubricDesc";
        public static final String FEEDBACK_QUESTION_RUBRIC_WEIGHTS_ASSIGNED = "rubricAssignWeights";
        public static final String FEEDBACK_QUESTION_RUBRIC_WEIGHT = "rubricWeight";
        public static final String FEEDBACK_QUESTION_RUBRIC_NUM_ROWS = "rubricNumRows";
        public static final String FEEDBACK_QUESTION_RUBRIC_NUM_COLS = "rubricNumCols";
        public static final String FEEDBACK_QUESTION_RUBRIC_MOVE_COL_LEFT = "rubric-move-col-left";
        public static final String FEEDBACK_QUESTION_RUBRIC_MOVE_COL_RIGHT = "rubric-move-col-right";
        public static final String FEEDBACK_QUESTION_RANKOPTION = "rankOption";
        public static final String FEEDBACK_QUESTION_RANKTORECIPIENTS = "rankToRecipients";
        public static final String FEEDBACK_QUESTION_RANKNUMOPTIONS = "rankNumOptions";
        public static final String FEEDBACK_QUESTION_RANKISDUPLICATESALLOWED = "rankAreDuplicatesAllowed";
        public static final String FEEDBACK_QUESTION_RANK_IS_MIN_OPTIONS_TO_BE_RANKED_ENABLED =
                "minOptionsToBeRankedEnabled";
        public static final String FEEDBACK_QUESTION_RANK_IS_MAX_OPTIONS_TO_BE_RANKED_ENABLED =
                "maxOptionsToBeRankedEnabled";
        public static final String FEEDBACK_QUESTION_RANK_MIN_OPTIONS_TO_BE_RANKED = "minOptionsToBeRanked";
        public static final String FEEDBACK_QUESTION_RANK_MAX_OPTIONS_TO_BE_RANKED = "maxOptionsToBeRanked";
        public static final String FEEDBACK_QUESTION_RANK_IS_MIN_RECIPIENTS_TO_BE_RANKED_ENABLED =
                "minRecipientsToBeRankedEnabled";
        public static final String FEEDBACK_QUESTION_RANK_IS_MAX_RECIPIENTS_TO_BE_RANKED_ENABLED =
                "maxRecipientsToBeRankedEnabled";
        public static final String FEEDBACK_QUESTION_RANK_MIN_RECIPIENTS_TO_BE_RANKED = "minRecipientsToBeRanked";
        public static final String FEEDBACK_QUESTION_RANK_MAX_RECIPIENTS_TO_BE_RANKED = "maxRecipientsToBeRanked";

        public static final String FEEDBACK_RESPONSE_ID = "responseid";
        public static final String FEEDBACK_RESPONSE_RECIPIENT = "responserecipient";
        public static final String FEEDBACK_RESPONSE_TEXT = "responsetext";

        public static final String FEEDBACK_RESPONSE_COMMENT_ID = "responsecommentid";
        public static final String FEEDBACK_RESPONSE_COMMENT_TEXT = "responsecommenttext";
        public static final String FEEDBACK_RESPONSE_COMMENT_ADD_TEXT = "responsecommentaddtext";

        public static final String FEEDBACK_RESULTS_UPLOADDOWNLOADBUTTON = "fruploaddownloadbtn";
        public static final String FEEDBACK_RESULTS_SORTTYPE = "frsorttype";
        public static final String FEEDBACK_RESULTS_GROUPBYTEAM = "frgroupbyteam";
        public static final String FEEDBACK_RESULTS_GROUPBYSECTION = "frgroupbysection";
        public static final String FEEDBACK_RESULTS_GROUPBYSECTIONDETAIL = "frgroupbysectiondetail";
        public static final String FEEDBACK_RESULTS_SHOWSTATS = "frshowstats";
        public static final String FEEDBACK_RESULTS_INDICATE_MISSING_RESPONSES = "frindicatemissingresponses";
        public static final String FEEDBACK_RESULTS_NEED_AJAX = "frneedajax";
        public static final String FEEDBACK_RESULTS_MAIN_INDEX = "frmainindex";

        public static final String PREVIEWAS = "previewas";

        public static final String STUDENT_ID = "googleid";
        public static final String INVITER_ID = "invitergoogleid";

        public static final String REGKEY = "key";
        public static final String STUDENT_EMAIL = "studentemail";
        public static final String NEW_STUDENT_EMAIL = "newstudentemail";

        public static final String STUDENT_SHORT_NAME = "studentshortname";
        public static final String STUDENT_PROFILE_EMAIL = "studentprofileemail";
        public static final String STUDENT_PROFILE_INSTITUTION = "studentprofileinstitute";
        public static final String STUDENT_NATIONALITY = "studentnationality";
        public static final String STUDENT_GENDER = "studentgender";
        public static final String STUDENT_PROFILE_MOREINFO = "studentprofilemoreinfo";
        public static final String STUDENT_PROFILE_PHOTO = "studentprofilephoto";
        public static final String STUDENT_PROFILE_PHOTOEDIT = "editphoto";

        public static final String STUDENT_NAME = "studentname";
        public static final String RESPONSE_COMMENTS_SHOWCOMMENTSTO = "showresponsecommentsto";
        public static final String RESPONSE_COMMENTS_SHOWGIVERTO = "showresponsegiverto";
        public static final String SECTION_NAME = "sectionname";
        public static final String SECTION_NAME_DETAIL = "sectionnamedetail";

        public static final String TEAM_NAME = "teamname";
        public static final String COMMENTS = "comments";
        public static final String TEAMMATES = "teammates";

        public static final String STATUS_MESSAGES_LIST = "statusMessagesToUser";
        public static final String ERROR = "error";
        public static final String NEXT_URL = "next";
        public static final String USER_ID = "user";
        public static final String HINT = "hint";
        public static final String FEEDBACK_SESSION_NOT_VISIBLE = "feedbacksessionnotvisible";

        //Email parameters
        public static final String EMAIL_RECEIVER = "user";
        public static final String EMAIL_COURSE = "course";
        public static final String EMAIL_FEEDBACK = "feedback";
        public static final String EMAIL_TYPE = "type";
        public static final String SESSION_SUMMARY_EMAIL_SEND_CHECK = "sessionsummarysendemail";
        public static final String OPEN_OR_PUBLISHED_EMAIL_SEND_CHECK = "openorpublishedemailsent";

        public static final String EMAIL_CONTENT = "content";
        public static final String EMAIL_SENDER = "sender";
        public static final String EMAIL_SENDERNAME = "sendername";
        public static final String EMAIL_SUBJECT = "subject";
        public static final String EMAIL_REPLY_TO_ADDRESS = "reply";

        public static final String COMMENT_EDITTYPE = "commentedittype";
        public static final String COMMENT_ID = "commentid";
        public static final String COMMENT_TEXT = "commenttext";

        public static final String SEND_SUBMISSION_EMAIL = "sendsubmissionemail";

        //Submission parameters for Task Queue
        public static final String SUBMISSION_COURSE = "course";
        public static final String SUBMISSION_FEEDBACK = "feedback";
        public static final String SUBMISSION_REMIND_USERLIST = "usersToRemind";
        public static final String SUBMISSION_RESEND_PUBLISHED_EMAIL_USER_LIST = "usersToResendEmail";

        public static final String ENROLLMENT_DETAILS = "enrollmentdetails";

        public static final String SEARCH_KEY = "searchkey";
        public static final String DISPLAY_ARCHIVE = "displayarchive";

        public static final String RESPONDENT_EMAIL = "respondentemail";
        public static final String RESPONDENT_IS_INSTRUCTOR = "respondentisinstructor";
        public static final String RESPONDENT_IS_TO_BE_REMOVED = "respondentistoberemoved";

        //Parameters for checking persistence of data during Eventual Consistency
        public static final String CHECK_PERSISTENCE_COURSE = "persistencecourse";

        public static final String PROFILE_PICTURE_LEFTX = "cropboxleftx";
        public static final String PROFILE_PICTURE_TOPY = "cropboxtopy";
        public static final String PROFILE_PICTURE_RIGHTX = "cropboxrightx";
        public static final String PROFILE_PICTURE_BOTTOMY = "cropboxbottomy";
        public static final String PROFILE_PICTURE_HEIGHT = "pictureheight";
        public static final String PROFILE_PICTURE_WIDTH = "picturewidth";
        public static final String PROFILE_PICTURE_ROTATE = "picturerotate";

        public static final String SEARCH_STUDENTS = "searchstudents";
        public static final String SEARCH_FEEDBACK_SESSION_DATA = "searchfeedbacksessiondata";

        public static final String ERROR_FEEDBACK_EMAIL_SUBJECT = "errorfeedbackemailsubject";
        public static final String ERROR_FEEDBACK_REQUEST_ID = "errorfeedbackrequestid";
        public static final String ENTITY_TYPE = "entitytype";

        public static final String INTENT = "intent";
    }

    public static class SearchIndex {
        public static final String FEEDBACK_RESPONSE_COMMENT = "feedbackresponsecomment";
        public static final String STUDENT = "student";
        public static final String INSTRUCTOR = "instructor";
    }

    public static class SearchDocumentField {
        public static final String FEEDBACK_RESPONSE_COMMENT_GIVER_NAME = "frCommentGiverName";
        public static final String FEEDBACK_RESPONSE_GIVER_NAME = "feedbackResponseGiverName";
        public static final String FEEDBACK_RESPONSE_RECEIVER_NAME = "feedbackResponseReceiverName";
        public static final String SEARCHABLE_TEXT = "searchableText";
        public static final String COURSE_ID = "courseId";
    }

    public static class EntityType {

        public static final String STUDENT = "student";
        public static final String INSTRUCTOR = "instructor";
        public static final String ADMIN = "admin";

    }

    public static class CsrfConfig {

        public static final String TOKEN_HEADER_NAME = "X-CSRF-TOKEN";
        public static final String TOKEN_COOKIE_NAME = "CSRF-TOKEN";

    }

    public static class LegacyURIs {

        public static final String INSTRUCTOR_COURSE_JOIN = "/page/instructorCourseJoin";
        public static final String STUDENT_COURSE_JOIN = "/page/studentCourseJoin";
        public static final String STUDENT_COURSE_JOIN_NEW = "/page/studentCourseJoinAuthentication";
        public static final String STUDENT_FEEDBACK_SUBMISSION_EDIT_PAGE = "/page/studentFeedbackSubmissionEditPage";
        public static final String STUDENT_FEEDBACK_RESULTS_PAGE = "/page/studentFeedbackResultsPage";
        public static final String INSTRUCTOR_FEEDBACK_SUBMISSION_EDIT_PAGE = "/page/instructorFeedbackSubmissionEditPage";
        public static final String INSTRUCTOR_FEEDBACK_RESULTS_PAGE = "/page/instructorFeedbackResultsPage";

    }

    public static class WebPageURIs {

        private static final String URI_PREFIX = "/web";

        private static final String STUDENT_PAGE = URI_PREFIX + "/" + EntityType.STUDENT;
        private static final String INSTRUCTOR_PAGE = URI_PREFIX + "/" + EntityType.INSTRUCTOR;
        private static final String ADMIN_PAGE = URI_PREFIX + "/" + EntityType.ADMIN;
        private static final String FRONT_PAGE = URI_PREFIX + "/front";
        public static final String JOIN_PAGE = URI_PREFIX + "/join";

        public static final String ADMIN_HOME_PAGE = ADMIN_PAGE + "/home";
        public static final String ADMIN_ACCOUNTS_PAGE = ADMIN_PAGE + "/accounts";
        public static final String ADMIN_SEARCH_PAGE = ADMIN_PAGE + "/search";
        public static final String ADMIN_SESSIONS_PAGE = ADMIN_PAGE + "/sessions";
        public static final String ADMIN_TIMEZONE_PAGE = ADMIN_PAGE + "/timezone";

        public static final String INSTRUCTOR_HOME_PAGE = INSTRUCTOR_PAGE + "/home";
        public static final String INSTRUCTOR_SEARCH_PAGE = INSTRUCTOR_PAGE + "/search";
        public static final String INSTRUCTOR_SESSIONS_PAGE = INSTRUCTOR_PAGE + "/sessions";
        public static final String INSTRUCTOR_SESSION_SUBMISSION_PAGE = INSTRUCTOR_PAGE + "/sessions/submission";
        public static final String INSTRUCTOR_SESSION_EDIT_PAGE = INSTRUCTOR_PAGE + "/sessions/edit";
        public static final String INSTRUCTOR_COURSES_PAGE = INSTRUCTOR_PAGE + "/courses";
        public static final String INSTRUCTOR_COURSE_DETAILS_PAGE = INSTRUCTOR_PAGE + "/courses/details";
        public static final String INSTRUCTOR_COURSE_EDIT_PAGE = INSTRUCTOR_PAGE + "/courses/edit";
        public static final String INSTRUCTOR_COURSE_ENROLL_PAGE = INSTRUCTOR_PAGE + "/courses/enroll";
        public static final String INSTRUCTOR_COURSE_STUDENT_DETAILS_PAGE = INSTRUCTOR_PAGE + "/courses/student/details";
        public static final String INSTRUCTOR_COURSE_STUDENT_DETAILS_EDIT_PAGE = INSTRUCTOR_PAGE + "/courses/student/edit";
        public static final String INSTRUCTOR_STUDENT_LIST_PAGE = INSTRUCTOR_PAGE + "/students";
        public static final String INSTRUCTOR_STUDENT_RECORDS_PAGE = INSTRUCTOR_PAGE + "/students/records";

        public static final String STUDENT_HOME_PAGE = STUDENT_PAGE + "/home";
        public static final String STUDENT_COURSE_DETAILS_PAGE = STUDENT_PAGE + "/course";
        public static final String STUDENT_PROFILE_PAGE = STUDENT_PAGE + "/profile";

        public static final String SESSION_SUBMISSION_PAGE = URI_PREFIX + "/sessions/submission";
        public static final String INSTRUCTOR_HELP_PAGE = FRONT_PAGE + "/help/instructor";

    }

    public static class ResourceURIs {

        public static final String URI_PREFIX = "/webapi";

        public static final String EXCEPTION = "/exception";
        public static final String ERROR_REPORT = "/errorreport";
        public static final String AUTH = "/auth";
        public static final String ACCOUNTS = "/accounts";
        public static final String ACCOUNTS_SEARCH = "/accounts/search";
        public static final String ACCOUNTS_RESET = "/accounts/reset";
        public static final String ACCOUNTS_DOWNGRADE = "/accounts/downgrade";
        public static final String COURSE = "/course";
        public static final String COURSES = "/courses";
        public static final String INSTRUCTORS = "/instructors";
        public static final String INSTRUCTOR = "/instructor";
        public static final String INSTRUCTOR_PRIVILEGE = "/instructor/privilege";
        public static final String STUDENTS = "/students";
        public static final String STUDENT = "/student";
        public static final String SESSIONS_ADMIN = "/sessions/admin";
        public static final String SESSIONS_STATS = "/sessions/stats";
        public static final String SESSION = "/session";
        public static final String SESSION_PUBLISH = "/session/publish";
        public static final String SESSION_REMIND_SUBMISSION = "/session/remind/submission";
        public static final String SESSION_REMIND_RESULT = "/session/remind/result";
        public static final String SESSIONS = "/sessions";
        public static final String BIN_SESSION = "/bin/session";
        public static final String QUESTIONS = "/questions";
        public static final String QUESTION = "/question";
        public static final String QUESTION_RECIPIENTS = "/question/recipients";
        public static final String RESPONSE = "/response";
        public static final String RESPONSES = "/responses";
        public static final String SUBMISSION_CONFIRMATION = "/submission/confirmation";
        public static final String JOIN = "/join";
        public static final String TIMEZONE = "/timezone";
        public static final String LOCAL_DATE_TIME = "/localdatetime";
        public static final String NATIONALITIES = "/nationalities";

        public static final String INSTRUCTOR_HOME = "/instrutor/home";
        public static final String INSTRUCTOR_COURSES = "/instructor/courses";
        public static final String INSTRUCTOR_COURSES_RESTORE = "/instructor/courses/restore";
        public static final String INSTRUCTOR_COURSES_PERMANENTLY_DELETE = "/instructor/courses/permanentlyDelete";
        public static final String INSTRUCTOR_COURSES_PERMANENTLY_DELETE_ALL = "/instructor/courses/permanentlyDeleteAll";
        public static final String INSTRUCTOR_COURSES_RESTORE_ALL = "/instructor/courses/restoreAll";
        public static final String COURSE_STATS = "/course/stats";
        public static final String INSTRUCTOR_COURSE_DETAILS = "/courses/details";
        public static final String INSTRUCTOR_COURSE_DETAILS_DELETE_ALL_STUDENTS = "/courses/details/deleteAllStudents";
        public static final String INSTRUCTOR_COURSE_DETAILS_ALL_STUDENTS_CSV = "/courses/details/allStudentsCsv";
        public static final String INSTRUCTOR_COURSE_DETAILS_REMIND = "/courses/details/remind";
        public static final String INSTRUCTOR_COURSE_EDIT_PAGE = "/courses/edit";

        public static final String COURSE_STUDENT_DETAILS = "/courses/students/details";
        public static final String STUDENT_COURSE = "/student/course";
        public static final String STUDENT_PROFILE_PICTURE = "/students/profilePic";
        public static final String STUDENT_PROFILE = "/student/profile";
        public static final String STUDENT_COURSES = "/student/courses";
        public static final String STUDENTS_AND_FEEDBACK_SESSION_DATA_SEARCH = "/studentsAndSessionData/search";

        public static final String COURSE_STUDENT_DETAILS_EDIT = "/courses/students/details/edit";
        public static final String STUDENT_EDIT_DETAILS = "/students/editDetails";
        public static final String COURSE_EDIT_DETAILS = "/instructors/course/details";
        public static final String COURSE_EDIT_DETAILS_SAVE = "/instructors/course/details/save";
        public static final String COURSE_DELETE = "/instructors/course/delete";
        public static final String COURSE_EDIT_INSTRUCTOR_DETAILS = "/instructors/course/details/editInstructor";
        public static final String COURSE_ADD_INSTRUCTOR = "/instructors/course/details/addInstructor";
        public static final String COURSE_DELETE_INSTRUCTOR = "/instructors/course/details/deleteInstructor";
        public static final String COURSE_SEND_REMINDER_EMAILS = "/instructors/course/details/sendReminders";
        public static final String COURSE_ENROLL_SAVE = "/course/enrollSave";
        public static final String COURSE_ENROLL_PAGE_DATA = "/course/enroll/pageData";
        public static final String STUDENT_RECORDS = "/students/records";
        public static final String COURSE_ENROLL_STUDENTS = "/course/enroll/students";
    }

    @Deprecated
    public static class ActionURIs {

        /* _PAGE/Page in the Action URI name means 'show page' */

        public static final String LOGOUT = "/logout";

        public static final String INSTRUCTOR_COURSE_STUDENT_DELETE = "/page/instructorCourseStudentDelete";
        public static final String INSTRUCTOR_COURSE_REMIND = "/page/instructorCourseRemind";
        public static final String INSTRUCTOR_STUDENT_LIST_PAGE = "/page/instructorStudentListPage";
        public static final String INSTRUCTOR_STUDENT_LIST_AJAX_PAGE = "/page/instructorStudentListAjaxPage";
        public static final String INSTRUCTOR_STUDENT_RECORDS_AJAX_PAGE = "/page/instructorStudentRecordsAjaxPage";

        public static final String INSTRUCTOR_FEEDBACK_REMIND_PARTICULAR_STUDENTS_PAGE =
                "/page/instructorFeedbackRemindParticularStudentsPage";
        public static final String INSTRUCTOR_FEEDBACK_REMIND_PARTICULAR_STUDENTS =
                "/page/instructorFeedbackRemindParticularStudents";
        public static final String INSTRUCTOR_FEEDBACK_PUBLISH = "/page/instructorFeedbackPublish";
        public static final String INSTRUCTOR_FEEDBACK_UNPUBLISH = "/page/instructorFeedbackUnpublish";
        public static final String INSTRUCTOR_FEEDBACK_RESULTS_PAGE = "/page/instructorFeedbackResultsPage";
        public static final String INSTRUCTOR_FEEDBACK_RESULTS_DOWNLOAD = "/page/instructorFeedbackResultsDownload";

        public static final String INSTRUCTOR_FEEDBACK_RESPONSE_COMMENT_ADD = "/page/instructorFeedbackResponseCommentAdd";
        public static final String INSTRUCTOR_FEEDBACK_RESPONSE_COMMENT_EDIT = "/page/instructorFeedbackResponseCommentEdit";
        public static final String INSTRUCTOR_FEEDBACK_RESPONSE_COMMENT_DELETE =
                "/page/instructorFeedbackResponseCommentDelete";

        public static final String FEEDBACK_PARTICIPANT_FEEDBACK_RESPONSE_COMMENT_DELETE =
                "/page/feedbackParticipantFeedbackResponseCommentDelete";

        public static final String CREATE_IMAGE_UPLOAD_URL = "/page/createImageUploadUrl";
        public static final String IMAGE_UPLOAD = "/page/imageUpload";

        public static final String STUDENT_FEEDBACK_RESULTS_PAGE = "/page/studentFeedbackResultsPage";
        public static final String STUDENT_PROFILE_PICTURE = "/page/studentProfilePic";
        public static final String STUDENT_PROFILE_PICTURE_UPLOAD = "/page/studentProfilePictureUpload";
        public static final String STUDENT_PROFILE_PICTURE_EDIT = "/page/studentProfilePictureEdit";
        public static final String STUDENT_PROFILE_CREATEUPLOADFORMURL = "/page/studentProfileCreateFormUrl";

        public static final String PUBLIC_IMAGE_SERVE = "/public/publicImageServe";

    }

    public static class CronJobURIs {
        public static final String AUTOMATED_EXCEPTION_TEST = "/auto/exception";
        public static final String AUTOMATED_LOG_COMPILATION = "/auto/compileLogs";
        public static final String AUTOMATED_DATASTORE_BACKUP = "/auto/datastoreBackup";
        public static final String AUTOMATED_FEEDBACK_OPENING_REMINDERS = "/auto/feedbackSessionOpeningReminders";
        public static final String AUTOMATED_FEEDBACK_CLOSED_REMINDERS = "/auto/feedbackSessionClosedReminders";
        public static final String AUTOMATED_FEEDBACK_CLOSING_REMINDERS = "/auto/feedbackSessionClosingReminders";
        public static final String AUTOMATED_FEEDBACK_PUBLISHED_REMINDERS = "/auto/feedbackSessionPublishedReminders";
    }

    /**
     * Configurations for task queue.
     */
    public static class TaskQueue {

        public static final String FEEDBACK_RESPONSE_ADJUSTMENT_QUEUE_NAME = "feedback-response-adjustment-queue";
        public static final String FEEDBACK_RESPONSE_ADJUSTMENT_WORKER_URL = "/worker/feedbackResponseAdjustment";

        public static final String FEEDBACK_SESSION_PUBLISHED_EMAIL_QUEUE_NAME =
                "feedback-session-published-email-queue";
        public static final String FEEDBACK_SESSION_PUBLISHED_EMAIL_WORKER_URL =
                "/worker/feedbackSessionPublishedEmail";

        public static final String FEEDBACK_SESSION_RESEND_PUBLISHED_EMAIL_QUEUE_NAME =
                "feedback-session-resend-published-email-queue";
        public static final String FEEDBACK_SESSION_RESEND_PUBLISHED_EMAIL_WORKER_URL =
                "/worker/feedbackSessionResendPublishedEmail";

        public static final String FEEDBACK_SESSION_REMIND_EMAIL_QUEUE_NAME = "feedback-session-remind-email-queue";
        public static final String FEEDBACK_SESSION_REMIND_EMAIL_WORKER_URL = "/worker/feedbackSessionRemindEmail";

        public static final String FEEDBACK_SESSION_REMIND_PARTICULAR_USERS_EMAIL_QUEUE_NAME =
                "feedback-session-remind-particular-users-email-queue";
        public static final String FEEDBACK_SESSION_REMIND_PARTICULAR_USERS_EMAIL_WORKER_URL =
                "/worker/feedbackSessionRemindParticularUsersEmail";

        public static final String FEEDBACK_SESSION_UNPUBLISHED_EMAIL_QUEUE_NAME =
                "feedback-session-unpublished-email-queue";
        public static final String FEEDBACK_SESSION_UNPUBLISHED_EMAIL_WORKER_URL =
                "/worker/feedbackSessionUnpublishedEmail";

        public static final String FEEDBACK_SESSION_UPDATE_RESPONDENT_QUEUE_NAME =
                "feedback-session-update-respondent-queue";
        public static final String FEEDBACK_SESSION_UPDATE_RESPONDENT_WORKER_URL =
                "/worker/feedbackSessionUpdateRespondent";

        public static final String INSTRUCTOR_COURSE_JOIN_EMAIL_QUEUE_NAME = "instructor-course-join-email-queue";
        public static final String INSTRUCTOR_COURSE_JOIN_EMAIL_WORKER_URL = "/worker/instructorCourseJoinEmail";

        public static final String SEND_EMAIL_QUEUE_NAME = "send-email-queue";
        public static final String SEND_EMAIL_WORKER_URL = "/worker/sendEmail";

        public static final String STUDENT_COURSE_JOIN_EMAIL_QUEUE_NAME = "student-course-join-email-queue";
        public static final String STUDENT_COURSE_JOIN_EMAIL_WORKER_URL = "/worker/studentCourseJoinEmail";

    }

    @Deprecated
    public static class ViewURIs {

        /* We omit adding the 'page' prefix to views because all of them are "pages" */

        public static final String INSTRUCTOR_FEEDBACK_RESPONSE_COMMENTS_ADD =
                "/jsp/instructorFeedbackResponseCommentsAdd.jsp";
        public static final String INSTRUCTOR_FEEDBACK_AJAX_REMIND_PARTICULAR_STUDENTS_MODAL =
                "/jsp/instructorFeedbackAjaxRemindParticularStudentsModal.jsp";
        public static final String INSTRUCTOR_FEEDBACK_RESULTS_TOP = "/jsp/instructorFeedbackResultsTop.jsp";
        public static final String INSTRUCTOR_FEEDBACK_RESULTS_BOTTOM = "/jsp/instructorFeedbackResultsBottom.jsp";
        public static final String INSTRUCTOR_FEEDBACK_RESULTS_BY_GIVER_RECIPIENT_QUESTION =
                "/jsp/instructorFeedbackResultsByGiverRecipientQuestion.jsp";
        public static final String INSTRUCTOR_FEEDBACK_RESULTS_BY_RECIPIENT_GIVER_QUESTION =
                "/jsp/instructorFeedbackResultsByRecipientGiverQuestion.jsp";
        public static final String INSTRUCTOR_FEEDBACK_RESULTS_BY_GIVER_QUESTION_RECIPIENT =
                "/jsp/instructorFeedbackResultsByGiverQuestionRecipient.jsp";
        public static final String INSTRUCTOR_FEEDBACK_RESULTS_BY_RECIPIENT_QUESTION_GIVER =
                "/jsp/instructorFeedbackResultsByRecipientQuestionGiver.jsp";
        public static final String INSTRUCTOR_FEEDBACK_RESULTS_BY_QUESTION = "/jsp/instructorFeedbackResultsByQuestion.jsp";
        public static final String INSTRUCTOR_SEARCH = "/jsp/instructorSearch.jsp";
        public static final String INSTRUCTOR_STUDENT_LIST = "/jsp/instructorStudentList.jsp";
        public static final String INSTRUCTOR_STUDENT_LIST_AJAX = "/jsp/instructorStudentListAjax.jsp";
        public static final String INSTRUCTOR_STUDENT_RECORDS_AJAX = "/jsp/instructorStudentRecordsAjax.jsp";

        public static final String STUDENT_FEEDBACK_RESULTS = "/jsp/studentFeedbackResults.jsp";

        public static final String MASHUP = "/test/mashup.jsp";
        public static final String TABLE_SORT = "/test/tableSort.jsp";
    }

    /* These are status messages that may be shown to the user */
    @Deprecated
    public static class StatusMessages {

        public static final String IMAGE_TOO_LARGE = "The uploaded image was too large. ";
        public static final String FILE_NOT_A_PICTURE = "The file that you have uploaded is not a picture. ";
        public static final String NO_IMAGE_GIVEN = "Please specify a image to be uploaded.";
        public static final String DUPLICATE_EMAIL_INFO = "Same email address as the student in line";

        public static final String COURSE_ADDED =
                "The course has been added. Click <a href=\"${courseEnrollLink}\">here</a> to add students to the course "
                + "or click <a href=\"${courseEditLink}\">here</a> to add other instructors.<br>"
                + "If you don't see the course in the list below, please refresh the page after a few moments.";
        public static final String COURSE_EXISTS =
                "A course by the same ID already exists in the system, possibly created by another user. "
                + "Please choose a different course ID";
        public static final String COURSE_EDITED = "The course has been edited.";
        public static final String COURSE_ARCHIVED =
                "The course %s has been archived. It will not appear in the home page any more.";
        // TODO: Let undo process to be in the Course page for now.
        // Should implement to be able to undo the archiving from the home page later.
        public static final String COURSE_ARCHIVED_FROM_HOMEPAGE =
                COURSE_ARCHIVED + " You can access archived courses from the 'Courses' tab.<br>"
                + "Go there to undo the archiving and bring the course back to the home page.";
        public static final String COURSE_UNARCHIVED = "The course %s has been unarchived.";
        public static final String COURSE_MOVED_TO_RECYCLE_BIN_FROM_HOMEPAGE =
                "The course %s has been deleted. You can restore it from the 'Courses' tab.";
        public static final String COURSE_MOVED_TO_RECYCLE_BIN =
                "The course %s has been deleted. You can restore it from the deleted courses table below.";
        public static final String COURSE_RESTORED = "The course %s has been restored.";
        public static final String COURSE_ALL_RESTORED = "All courses have been restored.";
        public static final String COURSE_DELETED =
                "The course %s has been permanently deleted.";
        public static final String COURSE_ALL_DELETED = "All courses have been permanently deleted.";
        public static final String COURSE_EMPTY =
                "You do not seem to have any courses. Use the form above to create a course.";
        public static final String COURSE_EMPTY_IN_INSTRUCTOR_FEEDBACKS =
                "You have not created any courses yet, or you have no active courses. Go <a href=\""
                + WebPageURIs.INSTRUCTOR_COURSES_PAGE + "${user}\">here</a> to create or unarchive a course.";
        public static final String COURSE_REMINDER_SENT_TO = "An email has been sent to ";
        public static final String COURSE_REMINDERS_SENT = "Emails have been sent to unregistered students.";

        public static final String COURSE_ENROLL_POSSIBLE_DATA_LOSS = "There are existing feedback responses "
                + "for this course. Modifying records of enrolled students will result in some existing "
                + "responses from those modified students to be deleted. You may wish to download the data "
                + "before you make the changes.";
        public static final String COURSE_ENROLL_STUDENTS_ERROR = "Errors on %d student(s):";
        public static final String COURSE_ENROLL_STUDENTS_ADDED = "%d student(s) added:";
        public static final String COURSE_ENROLL_STUDENTS_MODIFIED = "%d student(s) modified:";
        public static final String COURSE_ENROLL_STUDENTS_UNMODIFIED = "%d student(s) updated with no changes:";
        public static final String COURSE_ENROLL_STUDENTS_NOT_IN_LIST = "%d student(s) remain unmodified:";
        public static final String COURSE_ENROLL_STUDENTS_UNKNOWN = "%d student(s) with unknown enrolment status:";

        public static final String TEAM_INVALID_SECTION_EDIT =
                "The team \"%s\" is in multiple sections. "
                + "The team ID should be unique across the entire course "
                + "and a team cannot be spread across multiple sections.<br>";
        public static final String SECTION_QUOTA_EXCEED =
                "You are trying enroll more than 100 students in section \"%s\". "
                + "To avoid performance problems, please do not enroll more than 100 students in a single section.<br>";
        public static final String QUOTA_PER_ENROLLMENT_EXCEED =
                "You are trying to enroll more than 100 students. "
                + "To avoid performance problems, please enroll no more than 100 students at a time.";

        public static final String COURSE_INSTRUCTOR_ADDED = "The instructor %s has been added successfully. "
                + "An email containing how to 'join' this course will be sent to %s in a few minutes.";
        public static final String COURSE_INSTRUCTOR_EXISTS =
                "An instructor with the same email address already exists in the course.";
        public static final String COURSE_INSTRUCTOR_EDITED = "The changes to the instructor %s has been updated.";
        public static final String COURSE_INSTRUCTOR_DELETED = "The instructor has been deleted from the course.";
        public static final String COURSE_INSTRUCTOR_DELETE_NOT_ALLOWED =
                "The instructor you are trying to delete is the last instructor in the course. "
                + "Deleting the last instructor from the course is not allowed.";

        public static final String STUDENT_GOOGLEID_RESET = "The student's google id has been reset";
        public static final String STUDENT_GOOGLEID_RESET_FAIL =
                "An error occurred when trying to reset student's google id";

        public static final String STUDENT_EVENTUAL_CONSISTENCY =
                "If the student was created during the last few minutes, "
                + "try again in a few more minutes as the student may still be being saved.";

        public static final String STUDENT_EDITED = "The student has been edited successfully.";
        public static final String STUDENT_EDITED_AND_EMAIL_SENT = STUDENT_EDITED
                + " A summary of the course has been sent to the new email.";
        public static final String STUDENT_NOT_FOUND_FOR_EDIT =
                "The student you tried to edit does not exist. " + STUDENT_EVENTUAL_CONSISTENCY;
        public static final String STUDENT_DELETED = "The student has been removed from the course";
        public static final String STUDENTS_DELETED = "All the students have been removed from the course";
        public static final String STUDENT_PROFILE_EDITED = "Your profile has been edited successfully";
        public static final String STUDENT_PROFILE_PICTURE_SAVED = "Your profile picture has been saved successfully";
        public static final String STUDENT_PROFILE_PIC_TOO_LARGE = "The uploaded profile picture was too large. "
                + "Please try again with a smaller picture.";
        public static final String STUDENT_PROFILE_PIC_SERVICE_DOWN = "We were unable to upload your picture at this time. "
                + "Please try again after some time";
        public static final String STUDENT_EMAIL_TAKEN_MESSAGE =
                "Trying to update to an email that is already used by: %s/%s";

        public static final String FEEDBACK_SESSION_ADDED =
                "The feedback session has been added. "
                + "Click the \"Add New Question\" button below to begin adding questions for the feedback session.";
        public static final String FEEDBACK_SESSION_ADD_DB_INCONSISTENCY =
                "If you do not see existing feedback sessions in the list below, "
                + "please refresh the page after a few moments";
        public static final String FEEDBACK_SESSION_COPIED =
                "The feedback session has been copied. Please modify settings/questions as necessary.";
        public static final String FEEDBACK_SESSION_COPY_NONESELECTED =
                "You have not selected any course to copy the feedback session to";
        public static final String FEEDBACK_SESSION_COPY_ALREADYEXISTS =
                "A feedback session with the name \"%s\" already exists in the following course(s): %s.";
        public static final String FEEDBACK_SESSION_EDITED = "The feedback session has been updated.";
        public static final String FEEDBACK_SESSION_END_TIME_EARLIER_THAN_START_TIME =
                "The end time for this feedback session cannot be earlier than the start time.";
        public static final String FEEDBACK_SESSION_MOVED_TO_RECYCLE_BIN_FROM_HOMEPAGE =
                "The feedback session has been deleted. You can restore it from the 'Sessions' tab.";
        public static final String FEEDBACK_SESSION_MOVED_TO_RECYCLE_BIN =
                "The feedback session has been deleted. You can restore it from the deleted sessions table below.";
        public static final String FEEDBACK_SESSION_RESTORED = "The feedback session has been restored.";
        public static final String FEEDBACK_SESSION_ALL_RESTORED = "All sessions have been restored.";
        public static final String FEEDBACK_SESSION_DELETED = "The feedback session has been permanently deleted.";
        public static final String FEEDBACK_SESSION_ALL_DELETED = "All sessions have been permanently deleted.";
        public static final String FEEDBACK_SESSION_DELETED_NO_ACCESS =
                "The feedback session has been permanently deleted and is no longer accessible.";
        public static final String FEEDBACK_SESSION_DOWNLOAD_FILE_SIZE_EXCEEDED = "This session has more responses than "
                + "that can be downloaded in one go. Please download responses for one question at a time instead. "
                + "To download responses for a specific question, click on the corresponding question number.";
        public static final String FEEDBACK_SESSION_PUBLISHED =
                "The feedback session has been published. "
                + "Please allow up to 1 hour for all the notification emails to be sent out.";
        public static final String FEEDBACK_SESSION_RESEND_EMAIL_NOT_PUBLISHED =
                "The feedback session is not published. "
                + "You cannot resend published notification emails for a session that is not published.";
        public static final String FEEDBACK_SESSION_RESEND_EMAIL_EMPTY_RECIPIENT =
                "You have not selected any student to email.";
        public static final String FEEDBACK_SESSION_RESEND_EMAIL_SENT =
                "Session published notification emails have been resent to those students and instructors. "
                + "Please allow up to 1 hour for all the notification emails to be sent out.";
        public static final String FEEDBACK_SESSION_UNPUBLISHED = "The feedback session has been unpublished.";
        public static final String FEEDBACK_SESSION_REMINDERSSENT =
                "Reminder e-mails have been sent out to those students and instructors. "
                + "Please allow up to 1 hour for all the notification emails to be sent out.";
        public static final String FEEDBACK_SESSION_REMINDERSSESSIONNOTOPEN =
                "The feedback session is not open for submissions. "
                + "You cannot send reminders for a session that is not open.";
        public static final String FEEDBACK_SESSION_REMINDERSEMPTYRECIPIENT = "You have not selected any student to remind.";
        public static final String FEEDBACK_SESSION_EXISTS =
                "A feedback session by this name already exists under this course";
        public static final String FEEDBACK_SESSION_EMPTY =
                "You have not created any sessions yet. Use the form above to create a session.";

        public static final String FEEDBACK_QUESTION_ADDED = "The question has been added to this feedback session.";
        public static final String FEEDBACK_QUESTION_ADDED_MULTIPLE =
                "The questions have been added to this feedback session.";
        public static final String FEEDBACK_QUESTION_DUPLICATED = "The question has been duplicated below.";
        public static final String FEEDBACK_QUESTION_EDITED = "The changes to the question have been updated.";
        public static final String FEEDBACK_QUESTION_DELETED = "The question has been deleted.";
        public static final String FEEDBACK_QUESTION_EMPTY =
                "You have not created any questions for this feedback session yet. "
                + "Click the button below to add a feedback question.";
        public static final String FEEDBACK_QUESTION_NUMBEROFENTITIESINVALID =
                "Please enter the maximum number of recipients each respondents should give feedback to.";
        public static final String FEEDBACK_QUESTION_TEXTINVALID =
                "Please enter a valid question. The question text cannot be empty.";

        public static final String FEEDBACK_RESPONSES_SAVED = "All responses submitted successfully!";
        public static final String FEEDBACK_RESPONSES_MISSING_RECIPIENT =
                "You did not specify a recipient for your response in question %s.";
        public static final String FEEDBACK_RESPONSES_WRONG_QUESTION_TYPE =
                "Incorrect question type for response in question %s.";
        public static final String FEEDBACK_RESPONSES_INVALID_ID = "You are modifying an invalid response in question %s";
        public static final String FEEDBACK_RESPONSES_MSQ_MIN_CHECK = "Minimum selectable choices for question %d is %d.";
        public static final String FEEDBACK_RESPONSES_MSQ_MAX_CHECK = "Maximum selectable choices for question %d is %d.";

        public static final String FEEDBACK_RESPONSE_COMMENT_EMPTY = "Comment cannot be empty";
        public static final String FEEDBACK_RESPONSE_INVALID_RECIPIENT =
                "Trying to update recipient to an invalid recipient for question %d.";
        public static final String FEEDBACK_RESPONSE_DUPLICATE_RECIPIENT =
                "Trying to update response for a recipient who already has a response for question %d.";

        public static final String FEEDBACK_SUBMISSIONS_NOT_OPEN =
                "<strong>The feedback session is currently not open for submissions.</strong> "
                + "You can view the questions and any submitted responses for this feedback session "
                + "but cannot submit new responses.";
        public static final String FEEDBACK_SUBMISSIONS_CAN_SUBMIT_PARTIAL_ANSWER =
                "Note that you can use the Submit button to save responses already entered, "
                + "and continue to answer remaining questions after that. "
                + "You may also edit your submission any number of times before the closing time of this session.";
        public static final String FEEDBACK_UNANSWERED_QUESTIONS = "Note that some questions are yet to be answered. "
                + "They are: ";

        public static final String FEEDBACK_RESULTS_SOMETHINGNEW =
                "You have received feedback from others. Please see below.";
        public static final String FEEDBACK_RESULTS_NOTHINGNEW =
                "You have not received any new feedback but you may review your own submissions below.";
        public static final String FEEDBACK_RESULTS_SECTIONVIEWWARNING =
                "This session seems to have a large number of responses. "
                + "It is recommended to view the results one question/section at a time. "
                + "To view responses for a particular question, click on the question below. "
                + "To view response for a particular section, click the 'Edit View' button above and choose a section.";
        public static final String FEEDBACK_RESULTS_QUESTIONVIEWWARNING =
                "This session seems to have a large number of responses. "
                + "It is recommended to view the results for one question at a time. "
                + "To view responses for a particular question, click on the question below.";
        public static final String ENROLL_LINE_EMPTY = "Please input at least one student detail.";
        public static final String ENROLL_LINES_PROBLEM_DETAIL_PREFIX = "&bull;";
        public static final String ENROLL_LINES_PROBLEM =
                "<p><span class=\"bold\">Problem in line : <span class=\"invalidLine\">%s</span></span>"
                + "<br><span class=\"problemDetail\">" + ENROLL_LINES_PROBLEM_DETAIL_PREFIX + " %s</span></p>";

        public static final String EVENTUAL_CONSISTENCY_MESSAGE_STUDENT =
                "You have successfully joined the course %1$s. "
                + "<br>Updating of the course data on our servers is currently in progress "
                + "and will be completed in a few minutes. "
                + "<br>Please refresh this page in a few minutes to see the course %1$s in the list below.";

        public static final String NULL_POST_PARAMETER_MESSAGE =
                "You have been redirected to this page due to a possible expiry of the previous login."
                + "<br>If you have previously typed some data and wish to retrieve it, "
                + "you may use the 'Back' button of your Browser to navigate to the "
                + "previous page containing the data you typed in.";

        public static final String INSTRUCTOR_STATUS_DELETED = "The Instructor status has been deleted";
        public static final String INSTRUCTOR_ACCOUNT_DELETED = "The Account has been deleted";
        public static final String INSTRUCTOR_REMOVED_FROM_COURSE = "The Instructor has been removed from the Course";

        public static final String INSTRUCTOR_COURSE_EMPTY =
                "There are no students in this course. Click <a href=\"%s\">here</a> to enroll students.";
        public static final String INSTRUCTOR_PERSISTENCE_ISSUE =
                "Account creation is still in progress. Please reload the page"
                + " after sometime.";
        public static final String INSTRUCTOR_NO_MODIFY_PERMISSION_FOR_ACTIVE_COURSES_SESSIONS =
                "No permission to modify any sessions in un-archived courses";
        public static final String INSTRUCTOR_NO_ACTIVE_COURSES = "No un-archived courses";
        public static final String INSTRUCTOR_NO_COURSE_AND_STUDENTS =
                "There are no course or students information to be displayed";
        public static final String INSTRUCTOR_SEARCH_NO_RESULTS = "No results found.";
        public static final String INSTRUCTOR_SEARCH_TIPS =
                "Search Tips:<br>"
                + "<ul>"
                    + "<li>Put more keywords to search for more precise results.</li>"
                    + "<li>Put quotation marks around words <b>\"[any word]\"</b>"
                            + " to search for an exact phrase in an exact order.</li>"
                + "</ul>";

        public static final String HINT_FOR_NEW_INSTRUCTOR = "New to TEAMMATES? You may wish to have a look at our "
                + "<a href=\"/gettingStarted.jsp\" target=\"_blank\">Getting Started Guide</a>.<br>A video tour"
                + " is also available in our <a href=\"/\" target=\"_blank\">home page</a>.";

        public static final String NEW_INSTRUCTOR_TEXT_MESSAGE = "New to TEAMMATES? You may wish to have a look at our "
                + "Getting Started Guide.\n"
                + "A video tour is also available in our home page.";

        public static final String HINT_FOR_NO_SESSIONS_STUDENT =
                "Currently, there are no open feedback sessions in the course %s. "
                + "When a session is open for submission you will be notified.";

        // Messages that are templates only
        /** Template String. Parameters: Student's name, Course ID */
        public static final String STUDENT_COURSE_JOIN_SUCCESSFUL = "You have been successfully added to the course %s.";

        /** Template String. Parameters:  Course ID */
        public static final String NON_EXISTENT_STUDENT_ATTEMPTING_TO_JOIN_COURSE =
                "Unable to join course %s as you are currently not in the student list of that course. "
                + "Please contact your course instructor for assistance.";
        public static final String STUDENT_PROFILE_NOT_A_PICTURE = "The file that you have uploaded is not a picture. "
                + "Please upload a picture (usually it ends with .jpg or .png)";
        public static final String STUDENT_PROFILE_NO_PICTURE_GIVEN = "Please specify a file to be uploaded.";
        public static final String STUDENT_NOT_FOUND_FOR_RECORDS =
                "The student you tried to view records for does not exist. " + STUDENT_EVENTUAL_CONSISTENCY;
        public static final String STUDENT_PROFILE_PICTURE_EDIT_FAILED =
                "The photo that was edited did not belong to the user. "
                + "Please upload another picture to begin editing";

        public static final String UNREGISTERED_STUDENT_MESSAGE = "You may submit feedback for sessions "
                + "that are currently open and view results without logging in. To access other features "
                + "you need <a href='%s' class='link'>to login using a Google account</a> (recommended).";
        public static final String UNREGISTERED_STUDENT = "You are submitting feedback as "
                + "<span class='text-danger text-bold text-large'>%s</span>. "
                + UNREGISTERED_STUDENT_MESSAGE;
        public static final String UNREGISTERED_STUDENT_RESULTS = "You are viewing feedback results as "
                + "<span class='text-danger text-bold text-large'>%s</span>. "
                + UNREGISTERED_STUDENT_MESSAGE;
        public static final String ADMIN_LOG_INSTRUCTOR_COURSE_ENROLL_PAGE_LOAD =
                "instructorCourseEnroll Page Load" + Const.HTML_BR_TAG
                + "Enrollment for Course <span class=\"bold\">[%s]</span>";

        public static final String AMBIGUOUS_LOCAL_DATE_TIME_GAP =
                "The %s, %s, falls within the gap period when clocks spring forward at the start of DST. "
                        + "It was resolved to %s.";

        public static final String AMBIGUOUS_LOCAL_DATE_TIME_OVERLAP =
                "The %s, %s, falls within the overlap period when clocks fall back at the end of DST. "
                        + "It can refer to %s or %s. It was resolved to %s.";
    }

    /* These indicate status of an operation, but they are not shown to the user */
    public static class StatusCodes {

        // Backdoor responses
        public static final String BACKDOOR_STATUS_SUCCESS = "[BACKDOOR_STATUS_SUCCESS]";
        public static final String BACKDOOR_STATUS_FAILURE = "[BACKDOOR_STATUS_FAILURE]";

        // General Error codes
        public static final String NULL_PARAMETER = "ERRORCODE_NULL_PARAMETER";

        // Error message used across DB level
        public static final String DBLEVEL_NULL_INPUT = "Supplied parameter was null";

        // POST parameter null message
        public static final String NULL_POST_PARAMETER = "The %s POST parameter is null%n";

        // HTTP parameter null message
        public static final String NULL_HTTP_PARAMETER = "The [%s] HTTP parameter is null.";
    }

    /**
     * These are constants that may be used in {@link ActivityLogEntry}.
     */
    public static class ActivityLog {
        public static final String TEAMMATESLOG = "TEAMMATESLOG";

        public static final String UNKNOWN = "Unknown";

        public static final String ROLE_ADMIN = "Admin";
        public static final String ROLE_INSTRUCTOR = "Instructor";
        public static final String ROLE_STUDENT = "Student";
        public static final String ROLE_AUTO = "Auto";
        public static final String ROLE_UNREGISTERED = "Unregistered";
        public static final String ROLE_MASQUERADE_POSTFIX = "(M)";

        public static final String PREFIX_STUDENT_PAGE = "student";
        public static final String PREFIX_INSTRUCTOR_PAGE = "instructor";
        public static final String PREFIX_AUTO_PAGE = "/auto";

        public static final String AUTH_NOT_LOGIN = "Unknown";

        public static final String FIELD_SEPARATOR = "|||";
        public static final String FIELD_CONNECTOR = "%";

        public static final String TIME_FORMAT_LOGID = "yyyyMMddHHmmssSS";

        public static final String TESTING_DATA_EMAIL_POSTFIX = ".tmt";

        public static final String MESSAGE_ERROR_ACTION_NAME = "Error when getting ActionName for requestUrl : %1$s";
        public static final String MESSAGE_ERROR_LOG_MESSAGE_FORMAT = "Log message format not as expected: %1$s";
    }

}
