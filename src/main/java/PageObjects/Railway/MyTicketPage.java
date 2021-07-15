package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage {


    // Locators
    private final By position = By.xpath("//table[@class='MyTable']//tbody//tr[last()]//td");

    //Elements
    public WebElement getPositionElement() {
        return Constant.WEBDRIVER.findElement(position);
    }

    //Methods
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
}
