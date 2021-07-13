package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import DataObject.BookTicket.BookTicket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BookTicketPage {

    Utilities utilities = new Utilities();

    // Locators
    private final By bookTicketBtn = By.xpath("//input[@value='Book ticket']");
    private final By bookTicketSuccessMsg = By.xpath("//h1[contains(.,'Ticket Booked Successfully!')]");
    private final By bookTicketLbl = By.xpath("//h1[contains(.,'Book ticket')]");
    private final By valueSelectedOfDepartFromDropbox = By.xpath("//select[@name = 'DepartStation']//option[@selected]");
    private final By valueSelectedOfArriveAtDropbox = By.xpath("//select[@name = 'ArriveStation']//option[@selected]");
    private final By departDateDropbox = By.xpath("//select[@name='Date']");
    private final By departFromDropbox = By.xpath("//select[@name='DepartStation']");
    private final By arriveAtDropbox = By.xpath("//select[@name='ArriveStation']");
    private final By seatTypeDropbox = By.xpath("//select[@name='SeatType']");
    private final By ticketAmountDropbox = By.xpath("//select[@name='TicketAmount']");

    // Elements
    private WebElement getSelectedOfArriveAtElement(){
        return Constant.WEBDRIVER.findElement(valueSelectedOfArriveAtDropbox);
    }
    public WebElement getSelectedOfDepartFromElement(){
        return Constant.WEBDRIVER.findElement(valueSelectedOfDepartFromDropbox);
    }
    public WebElement getContentBookTicket() {
        return Constant.WEBDRIVER.findElement(bookTicketLbl);
    }

    public WebElement getContentBookTicketSuccess() {
        return Constant.WEBDRIVER.findElement(bookTicketSuccessMsg);
    }

    public WebElement getBookTicket() {
        return Constant.WEBDRIVER.findElement(bookTicketBtn);
    }

    public WebElement getDepartDateDropboxElement() {
        return Constant.WEBDRIVER.findElement(departDateDropbox);
    }

    public WebElement getDepartFromDropboxElement() {
        return Constant.WEBDRIVER.findElement(departFromDropbox);
    }

    public WebElement getArriveAtDropboxElement() {
        return Constant.WEBDRIVER.findElement(arriveAtDropbox);
    }

    public WebElement getSeatTypeDropboxElement() {
        return Constant.WEBDRIVER.findElement(seatTypeDropbox);
    }

    public WebElement getTicketAmountElement() {
        return Constant.WEBDRIVER.findElement(ticketAmountDropbox);
    }

    // Methods

    public String valueSelectedOfArriveAt(){
        return getSelectedOfArriveAtElement().getText();
    }
    public String valueSelectedOfDepartStation(){
        return getSelectedOfDepartFromElement().getText();
    }
    public String getContentBookTicketPage(){
        return getContentBookTicket().getText();
    }

    public String getBookTicketSuccessMsg() {
        return getContentBookTicketSuccess().getText();
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
        this.getTicketAmountElement().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='TicketAmount']//option[text()='"+value+"']")).click();
    }

    public void chooseTypeSeat(String value) {
        this.getSeatTypeDropboxElement().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='SeatType']//option[text()='"+value+"']")).click();
    }

    public void chooseArriveAt(String value) {
        this.getArriveAtDropboxElement().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='ArriveStation']//option[text()='"+value+"']")).click();
    }

    public void chooseDepartFrom(String value) {
        this.getDepartFromDropboxElement().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='DepartStation']//option[text()='"+value+"']")).click();
    }

    public void chooseDepartDate() {
        this.getDepartDateDropboxElement().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='Date']//option[text()=\"" + utilities.getDate() + "\"]"))
                .click();
    }


}
