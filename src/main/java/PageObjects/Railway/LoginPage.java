package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends GeneralPage {
    // Locators
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='Login']");
    private final By _lblNameLoginPage = By.xpath("//div[@id='content']/h1");
    private final By _btnLogout = By.xpath("//span[contains(.,'Log out')]");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By _errorMsg = By.xpath("//p[contains(.,'There was a problem with your login and/or errors exist in your form.')]");

    // Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }

    public WebElement getLblNameLoginPage() {
        return Constant.WEBDRIVER.findElement(_lblNameLoginPage);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }

    public WebElement getBtnLogout() {
        return Constant.WEBDRIVER.findElement(_btnLogout);
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }


    // Methods
    public String getNameLoginPage() {
        return this.getLblNameLoginPage().getText();
    }

    public Boolean isMsgDisplayed() {
        return Constant.WEBDRIVER.findElement(By.xpath("//p[contains(.,'There was a problem with your login and/or errors exist in your form.')]")).isDisplayed();
    }

    public boolean verifyLoginPagedIsDisplayed() {
        boolean flag = false;
        if (Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']/h1")).isDisplayed()) {
            //Assert.assertEquals(actualMsg, expectedMsg, "don't navigate login page");
            return flag = true;
        }
        return flag;
    }

    public void numberOfLogins(int i) {
        LoginPage loginPage = new LoginPage();
        int count = 1;
        while (count < i) {
            loginPage.login(Constant.USERNAME, "1");
            count = count + 1;
        }
    }

    public HomePage login(String username, String password) {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();

        return new HomePage();
    }

    public boolean isUsernameTbBlank() {
        return Constant.WEBDRIVER.findElements(_errorMsg).size() != 0;
    }

    public void logout() {
        this.getBtnLogout().click();
    }

}
