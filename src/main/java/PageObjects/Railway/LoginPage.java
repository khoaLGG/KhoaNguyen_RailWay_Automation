package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    private final String loginPageTitle = "Login Page";
    private final String myTickKetLbl = "Manage Tickets";
    private final String changePasswordLbl = "Change password";
    // Locators
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='Login']");
    private final By _lblNameLoginPage = By.xpath("//div[@id='content']/h1");
    private final By _btnLogout = By.xpath("//span[contains(.,'Log out')]");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By _errorMsg = By.xpath("//p[contains(.,'There was a problem with your login and/or errors exist in your form.')]");
    private final By _myTicketTab = By.xpath("//span[contains(.,'My ticket')]");
    private final By _changePasswordTab = By.xpath("//span[contains(.,'Change password')]");
    private final By _lblMyTicketPage = By.xpath("//h1[contains(.,'Manage Tickets')]");
    private final By _lblChangePasswordPage = By.xpath("//h1[contains(.,'Change password')]");

    // Elements
    public WebElement getUsername() {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getNameLoginPage() {
        return Constant.WEBDRIVER.findElement(_lblNameLoginPage);
    }

    public WebElement getLogin() {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getLogout() {
        return Constant.WEBDRIVER.findElement(_btnLogout);
    }

    public WebElement getMyTicketPage() {
        return Constant.WEBDRIVER.findElement(_lblMyTicketPage);
    }

    public WebElement getMyTicket() {
        return Constant.WEBDRIVER.findElement(_myTicketTab);
    }

    public WebElement getChangePassword() {
        return Constant.WEBDRIVER.findElement(_changePasswordTab);
    }

    public WebElement getChangePasswordPage() {
        return Constant.WEBDRIVER.findElement(_lblChangePasswordPage);
    }

    // Methods

    public boolean verifyMyTicketTabDisplayed() {
        boolean flag = false;
        if (Constant.WEBDRIVER.findElements(_myTicketTab).size() != 0) {
            flag = true;
        }
        return flag;
    }

    public boolean verifyChangePasswordTabDisplayed() {
        boolean flag = false;
        if (Constant.WEBDRIVER.findElements(_changePasswordTab).size() != 0) {
            flag = true;
        }
        return flag;
    }

    public boolean verifyLogoutTabDisplayed() {
        boolean flag = false;
        if (Constant.WEBDRIVER.findElements(_btnLogout).size() != 0) {
            flag = true;
        }
        return flag;
    }

    public void numberOfLogins(int i) {
        LoginPage loginPage = new LoginPage();
        int count = 1;
        while (count < i) {
            loginPage.login(Constant.USERNAME, Constant.INVALID_PASSWORD);
            count = count + 1;
        }
    }

    public void login(String username, String password) {
        this.getUsername().sendKeys(username);
        this.getPassword().sendKeys(password);
        this.getLogin().click();
    }

    public boolean isAtLoginPage() {
        return getNameLoginPage().getText().equals(loginPageTitle);
    }

    public boolean isAtMyTicketPage() {
        return getMyTicketPage().getText().equals(myTickKetLbl);
    }

    public void gotoMyTicketTab() {
        this.getMyTicket().click();
    }

    public void gotoChangePasswordPage() {
        this.getChangePassword().click();
    }

    public boolean isAtChangePasswordPAge() {
        return getChangePasswordPage().getText().equals(changePasswordLbl);
    }

    public boolean verifyMsgAccountHasNotBeenActivated(boolean check) {
        HomePage homePage = new HomePage();
        boolean flag = false;
        if(check == false){
            String actualMsg = homePage.getErrorMsg();
            String expectedMsg = Constant.MSG_INVALID_USERNAME_PASSWORD;
            if(actualMsg.equals(expectedMsg)){
                flag = true;
            };
        }
        return flag;
    }
}
