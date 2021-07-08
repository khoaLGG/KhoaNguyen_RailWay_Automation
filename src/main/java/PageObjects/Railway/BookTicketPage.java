package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BookTicketPage {

    Utilities utilities = new Utilities();

    // Locators
    private final By bookTicketBtn = By.xpath("//input[@value='Book ticket']");
    private final By bookTicketSuccessMsg = By.xpath("//h1[contains(.,'Ticket Booked Successfully!')]");

    // Elements
    public WebElement getBookTicketSuccess() {
        return Constant.WEBDRIVER.findElement(bookTicketSuccessMsg);
    }

    public WebElement getBookTicket() {
        return Constant.WEBDRIVER.findElement(bookTicketBtn);
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
    public String getBookTicketSuccessMsg() {
        return getBookTicketSuccess().getText();
    }

    public void bookTicket() {
        this.fillBookTicketInformation();
        this.getBookTicket().click();
    }

    private void fillBookTicketInformation() {
        this.chooseDepartDate();
        this.chooseDepartFrom();
        this.chooseArriveAt();
        this.chooseTypeSeat();
        this.chooseTicketAmount();
    }

    public void chooseTicketAmount() {
        this.getTicketAmount().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='TicketAmount']//option[text()='1']")).click();
    }

    public void chooseTypeSeat() {
        this.getSeatType().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='SeatType']//option[text()='Soft seat with air conditioner']")).click();
    }

    public void chooseArriveAt() {
        this.getArriveAt().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='ArriveStation']//option[text()='Nha Trang']")).click();
    }

    public void chooseDepartFrom() {
        this.getDepartFrom().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='DepartStation']//option[text()='Sài Gòn']")).click();
    }

    public void chooseDepartDate() {
        this.getDepartDate().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='Date']//option[text()=\"" + utilities.getDate() + "\"]"))
                .click();
    }

}
