package Common.Constant;

import org.openqa.selenium.WebDriver;

public class Constant {


    public static final int NUMBER_OF_LOGIN = 4 ;
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.railway2.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "khoa@logigear.com";
    public static final String PASSWORD = "123456789";
    public static final String CONFIRM_INVALID_PASSWORD = "1";
    public static final String PID = "123456789";
    public static final String ErrorPage = "Server Error";
    public static final String EMPTY_PID = "";
    public static final String EMPTY_PASSWORD = "";
    public static final String EMPTY_CONFIRM_PASSWORD = "";
    public static final String INVALID_PASSWORD = "1";
    public static final String DEPART_FROM = "Huế";
    public static final String ARRIVE_AT = "Sài Gòn";
    public static final String MSG_REGISTER_FAILED = "There're errors in the form. Please correct the errors and try again.";
    public static final String MSG_PASSWORD_FIELD = "Invalid password length";
    public static final String MSG_PID_FIELD = "Invalid ID length";
    public static final String MSG_CHANGE_PASSWORD_SUCCESS = "Your password has been updated!";
    public static String MSG_WELCOME_USER = "Welcome %s";
    public static String MSG_REGISTER_SUCCESSFULLY = "Thank you for registering your account";
    public static String MSG_CONTENT_OF_BOOK_TICKET_PAGE = "Book ticket";
    public static final String MSG_INVALID_USERNAME_PASSWORD = "Invalid username or password. Please try again.";
    public static final String MSG_PROBLEM_WITH_LOGIN = "There was a problem with your login and/or errors exist in your form.";
    public static final String MSG_RUN_OUT_OF_TRY_LOGIN = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
    public static final String MSG_BOOK_TICKET_SUCCESS = "Ticket Booked Successfully!";
}
