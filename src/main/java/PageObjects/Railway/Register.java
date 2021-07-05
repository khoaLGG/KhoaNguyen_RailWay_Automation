package PageObjects.Railway;

import Common.Constant.Constant;
import Common.Common.GenerateEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Register {


    public static String email;

    // Locators
    private final By _emailTextBox = By.xpath("//input[@id='email']");
    private final By _passwordTextBox = By.xpath("//input[@id='password']");
    private final By _confirmPassWordTextBox = By.xpath("//input[@id='confirmPassword']");
    private final By _PIDOrPassPortNumberTextBox = By.xpath("//input[@id='pid']");
    private final By _registerBtn = By.xpath("//p/input");
    private final By _registerSuccessMsg = By.xpath("//p");

    // Elements

    public WebElement getEmail() {
        return Constant.WEBDRIVER.findElement(_emailTextBox);
    }

    public WebElement getPassword() {
        return Constant.WEBDRIVER.findElement(_passwordTextBox);
    }

    public WebElement getConfirmPassword() {
        return Constant.WEBDRIVER.findElement(_confirmPassWordTextBox);
    }

    public WebElement getPIDOrPassPortNumber() {
        return Constant.WEBDRIVER.findElement(_PIDOrPassPortNumberTextBox);
    }

    public WebElement getRegister() {
        return Constant.WEBDRIVER.findElement(_registerBtn);
    }

    public WebElement getRegisterSuccess(){
        return Constant.WEBDRIVER.findElement(_registerSuccessMsg);
    }


    //Methods

    public String getRegisterSuccessMsg(){
        return getRegisterSuccess().getText();
    }


    public String register(){
        return this.submitRegister();
    }

    public String submitRegister(){
        email =GenerateEmail.GenRandomString() + "@"+GenerateEmail.GenRandomString()+".com";
        this.fillRegisterInformation(email, Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
        this.getRegister().click();
        return email;
    }

    public void fillRegisterInformation(String email, String password, String confirmPW, String PID){
        this.getEmail().sendKeys(email);
        this.getPassword().sendKeys(password);
        this.getConfirmPassword().sendKeys(confirmPW);
        this.getPIDOrPassPortNumber().sendKeys(PID);
    }

}
