package Testcases.Railway;

import Common.Constant.Constant;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePasswordTest extends TestBase{


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        homePage.open();
        generalPage.goToLoginPage();
    }
    @Test(description = "TC09 - User can change password")
    public void TC09(){
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoChangePasswordPage();
        changePasswordPage.changePassword(Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
        String actualMsg = changePasswordPage.getChangePasswordSuccessMsg();
        String expectedMsg = Constant.MSG_CHANGE_PASSWORD_SUCCESS;
        Assert.assertEquals(actualMsg,expectedMsg,"The message content is not displayed correctly" );
    }
}
