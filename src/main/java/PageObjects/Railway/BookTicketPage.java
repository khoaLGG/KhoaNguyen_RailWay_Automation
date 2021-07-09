package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import DataObject.BookTicket.BookTicket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BookTicketPage {

    Utilities utilities = new Utilities();

    // Locators
    private final By SubmitBookTicketBtn = By.xpath("//input[@value='Book ticket']");
    private final By bookTicketSuccessMsg = By.xpath("//h1[contains(.,'Ticket Booked Successfully!')]");
    private final By ContentBookTicketLbl = By.xpath("//h1[contains(.,'Book ticket')]");
    private final By valueSelectedOfDepartFromDropbox = By.xpath("//select[@name = 'DepartStation']//option[@selected]");
    private final By valueSelectedOfArriveAtDropbox = By.xpath("//select[@name = 'ArriveStation']//option[@selected]");

    // Elements
    private WebElement getSelectedOfArriveAt(){
        return Constant.WEBDRIVER.findElement(valueSelectedOfArriveAtDropbox);
    }
    public WebElement getSelectedOfDepartFrom(){
        return Constant.WEBDRIVER.findElement(valueSelectedOfDepartFromDropbox);
    }
    public WebElement getContentBookTicket() {
        return Constant.WEBDRIVER.findElement(ContentBookTicketLbl);
    }

    public WebElement getBookTicketSuccess() {
        return Constant.WEBDRIVER.findElement(bookTicketSuccessMsg);
    }

    public WebElement getBookTicket() {
        return Constant.WEBDRIVER.findElement(SubmitBookTicketBtn);
    }

    public WebElement getDepartDate() {
        return Constant.WEBDRIVER.findElement(By
                .xpath("//select[@name='Date']"));
    }

    public WebElement getDepartFrom() {
        return Constant.WEBDRIVER.findElement(By
                .xpath("//select[@name='DepartStation']"));
    }

    public WebElement getArriveAt() {
        return Constant.WEBDRIVER.findElement(By
                .xpath("//select[@name='ArriveStation']"));
    }

    public WebElement getSeatType() {
        return Constant.WEBDRIVER.findElement(By
                .xpath("//select[@name='SeatType']"));
    }

    public WebElement getTicketAmount() {
        return Constant.WEBDRIVER.findElement(By
                .xpath("//select[@name='TicketAmount']"));
    }

    // Methods

    public String valueSelectedOfArriveAt(){
        return getSelectedOfArriveAt().getText();
    }
    public String valueSelectedOfDepartStation(){
        return getSelectedOfDepartFrom().getText();
    }
    public String getContentBookTicketPage(){
        return getContentBookTicket().getText();
    }

    public String getBookTicketSuccessMsg() {
        return getBookTicketSuccess().getText();
    }

    public void bookTicket(BookTicket value) {
        this.fillBookTicketInformation(value);
        this.getBookTicket().click();
    }

    private void fillBookTicketInformation(BookTicket value) {
        this.chooseDepartDate();
        this.chooseDepartFrom(value.getDepartFrom());
        this.chooseArriveAt(value.getArriveAt());
        this.chooseTypeSeat(value.getSeatType());
        this.chooseTicketAmount(value.getTicketAmount());
    }

    public void chooseTicketAmount(String value) {
        this.getTicketAmount().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='TicketAmount']//option[text()='"+value+"']")).click();
    }

    public void chooseTypeSeat(String value) {
        this.getSeatType().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='SeatType']//option[text()='"+value+"']")).click();
    }

    public void chooseArriveAt(String value) {
        this.getArriveAt().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='ArriveStation']//option[text()='"+value+"']")).click();
    }

    public void chooseDepartFrom(String value) {
        this.getDepartFrom().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='DepartStation']//option[text()='"+value+"']")).click();
    }

    public void chooseDepartDate() {
        this.getDepartDate().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='Date']//option[text()=\"" + utilities.getDate() + "\"]"))
                .click();
    }


}
