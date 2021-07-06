package Common.Constant;

import org.openqa.selenium.WebDriver;

public class Constant {

    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://www.railway2.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "khoa@logigear.com";
    public static final String PASSWORD = "123456789";
    public static final String CONFIRM_INVALID_PASSWORD = "1";
    public static final String PID = "123456789";
    public static final String INVALID_PASSWORD = "1";
    public static final String MSG_THE_TWO_PASSWORD_DO_NOT_MATCH = "There're errors in the form. Please correct the errors and try again.";
    public static final String MSG_CHANGE_PASSWORD_SUCCESS = "Your password has been updated!";
    public static String MSG_WELCOME_USER = "Welcome %s";
    public static String MSG_REGISTER_SUCCESSFULLY = "Thank you for registering your account";
    public static final String MSG_INVALID_USERNAME_PASSWORD = "Invalid username or password. Please try again.";
    public static final String MSG_PROBLEM_WITH_LOGIN = "There was a problem with your login and/or errors exist in your form.";
    public static final String MSG_RUN_OUT_OF_TRY_LOGIN = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
}
