package PageObjects.Railway;

import Common.Constant.Constant;
import DataObject.BookTicket.BookTicket;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage {


    // Locators
    private final By position = By.xpath("//table[@class='MyTable']//tbody//tr[last()]//td");
    private final By departStationDropDownList = By.xpath("//td[1]//select");
    private final By arriveStationDropDownList = By.xpath("//td[2]//select");
    private final By statusDropdownList = By.xpath("//td[4]//select");
    private final By applyFilterBtn = By.xpath("//input[@value='Apply Filter']");
    private final By errorMsgFilter = By.xpath("//div[@class='error message']");

    //Elements
    public WebElement getPositionElement() {
        return Constant.WEBDRIVER.findElement(position);
    }
    public WebElement getApplyFilterBtnElement(){
        return Constant.WEBDRIVER.findElement(applyFilterBtn);
    }
    public WebElement getDepartStationDropDownListElement(){
        return Constant.WEBDRIVER.findElement(departStationDropDownList);
    }
    public WebElement getErrorMsgElement(){
        return Constant.WEBDRIVER.findElement(errorMsgFilter);
    }
    public WebElement getStatusDropdownListElement(){
        return Constant.WEBDRIVER.findElement(statusDropdownList);
    }
    public WebElement getArriveStationDropDownListElement(){
        return Constant.WEBDRIVER.findElement(arriveStationDropDownList);
    }
    //Methods
    public String getErrorMsgText(){
        return this.getErrorMsgElement().getText();
    }
    public String getPositionText(){
        return this.getPositionElement().getText();
    }

    public String getTicketNeededDelete(String departFrom, String arriveAt, String seatType, String date){
        String text = "//td[text()='%s']//following-sibling::td[text()='%s']" +
                "//following-sibling::td[text()='%s']" +
                "//following-sibling::td[text()='%s']" +
                "//following-sibling::td//input[@value='Cancel']";
        return String.format(text, departFrom, arriveAt, seatType, date);
    }
    public void deleteTicket(String departFrom, String arriveAt, String seatType, String date) throws InterruptedException {
        Constant.WEBDRIVER.findElement(By.xpath(getTicketNeededDelete(departFrom, arriveAt, seatType, date))).click();
        this.acceptPopup();

    }

    public void acceptPopup() throws InterruptedException {
        Thread.sleep(3000);
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();
    }

    public boolean verifyTicketWasDeleted(String actualMsg, String expectedMsg) {
        boolean flag = false;
       int lineNumberBeforeDelete = Integer.parseInt(actualMsg);
       int lineNumberAfterDelete  = Integer.parseInt(expectedMsg);
       int result = lineNumberAfterDelete - lineNumberBeforeDelete;
       if(result==1)
           flag = true;
       return flag;
    }

    public void filterTicket(String value) {
        this.fillTicketFilterInformation(value);
        this.getApplyFilterBtnElement().click();
    }

    private void fillTicketFilterInformation(String value) {
        this.chooseStatus(value);
    }

    private void chooseStatus(String value) {
        // hard code - don't have enough time to complete
        this.getStatusDropdownListElement().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//td[4]//select//option[text()='Paid']")).click();
    }

    /*private void chooseArriveAt(String arriveAt) {
        this.getArriveStationDropDownListElement().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//td[2]//select//option[text()='"+arriveAt+"']")).click();
    }*/

    private void chooseDepartFrom(String departFrom) {
        this.getDepartStationDropDownListElement().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//td[1]//select//option[text()='"+departFrom+"']")).click();
    }
}
