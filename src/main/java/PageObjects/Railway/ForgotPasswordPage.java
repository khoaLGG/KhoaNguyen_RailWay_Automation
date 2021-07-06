package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    // Locators
    private final By emailAddressTextBox = By.xpath("//input[@id='email']");
    private final By sendInstructions = By.xpath("//p[2]/input");

    // Elements
    public WebElement getEmailAddress() {
        return Constant.WEBDRIVER.findElement(emailAddressTextBox);
    }

    public WebElement getSendInstructions() {
        return Constant.WEBDRIVER.findElement(sendInstructions);
    }

    // Methods

    public void sendInstructions(String email) {
        this.submitInstructions(email);
    }

    private void submitInstructions(String email) {
        this.fillInstructionsInformation(email);
        this.getSendInstructions().click();
    }

    private void fillInstructionsInformation(String email) {
        this.getEmailAddress().sendKeys(email);
    }

}
