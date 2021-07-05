package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage {

    // Locators
    private final By currentPasswordTextBox = By.xpath("//input[@id='currentPassword']");
    private final By newPasswordTextBox = By.xpath("//input[@id='newPassword']");
    private final By confirmPasswordTextBox = By.xpath("//input[@id='confirmPassword']");
    private final By changePasswordBtn = By.xpath("//input[@value='Change Password']");
    private final By changePasswordSuccessMsg = By.xpath("//fieldset/p");

    // Elements
    public WebElement getCurrentPassword() {
        return Constant.WEBDRIVER.findElement(currentPasswordTextBox);
    }

    public WebElement getChangePasswordSuccess() {
        return Constant.WEBDRIVER.findElement(changePasswordSuccessMsg);
    }

    public WebElement getNewPassword() {
        return Constant.WEBDRIVER.findElement(newPasswordTextBox);
    }

    public WebElement getConfirmPassword() {
        return Constant.WEBDRIVER.findElement(confirmPasswordTextBox);
    }

    public WebElement getChangePassword() {
        return Constant.WEBDRIVER.findElement(changePasswordBtn);
    }


    // Methods

    public String getChangePasswordSuccessMsg(){
        return getChangePasswordSuccess().getText();
    }

    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        this.submitChangePassword(currentPassword, newPassword, confirmPassword);
    }

    private void submitChangePassword(String currentPassword, String newPassword, String confirmPassword) {
        this.fillChangePasswordInformation(currentPassword, newPassword, confirmPassword);
        this.getChangePassword().click();
    }

    private void fillChangePasswordInformation(String currentPassword, String newPassword, String confirmPassword) {
        this.getCurrentPassword().sendKeys(currentPassword);
        this.getNewPassword().sendKeys(newPassword);
        this.getConfirmPassword().sendKeys(confirmPassword);
    }
}
