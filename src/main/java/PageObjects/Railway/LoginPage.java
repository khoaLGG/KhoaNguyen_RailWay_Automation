package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends GeneralPage {

    private final String loginPageTitle = "Login Page";

    // Locators
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='Login']");
    private final By _lblNameLoginPage = By.xpath("//div[@id='content']/h1");
    private final By _btnLogout = By.xpath("//span[contains(.,'Log out')]");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By _errorMsg = By.xpath("//p[contains(.,'There was a problem with your login and/or errors exist in your form.')]");

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

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }


    // Methods

    public boolean isAt(){
        return getNameLoginPage().equals(loginPageTitle);
    }

    public String getNameOfLoginPage() {
        return this.getNameLoginPage().getText();
    }

    public Boolean isMsgDisplayed() {
        return Constant.WEBDRIVER.findElement(By.xpath("//p[contains(.,'There was a problem with your login and/or errors exist in your form.')]")).isDisplayed();
    }

    public boolean verifyLoginPagedIsDisplayed() {
        boolean flag = false;
        if (Constant.WEBDRIVER.findElement(_lblNameLoginPage).isDisplayed()) {
            //Assert.assertEquals(actualMsg, expectedMsg, "don't navigate login page");
            return flag = true;
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

    public HomePage login(String username, String password) {
        this.getUsername().sendKeys(username);
        this.getPassword().sendKeys(password);
        this.getLogin().click();

        return new HomePage();
    }

    public boolean isUsernameTbBlank() {
        return Constant.WEBDRIVER.findElements(_errorMsg).size() != 0;
    }

    public void logout() {
        this.getLogout().click();
    }

}
