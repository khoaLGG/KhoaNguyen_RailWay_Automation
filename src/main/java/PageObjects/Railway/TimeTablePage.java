package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;

public class TimeTablePage {

    // Locators

    //Elements

    //Methods
    public String getDepartFromAndArriveAt(String departFrom, String arriveAt){
        String text = "//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//a[text()='book ticket']";
        return String.format(text, departFrom, arriveAt);
    }
    //td[text()='Hard seat']//following-sibling::td//a           get seatype from ticketprice
    //th[contains(text(),'Price')]//following-sibling::td[1]     get price from ticketprice
    public void bookTicketFromTimeTablePage(String departFrom, String arriveAt){
        Constant.WEBDRIVER.findElement(By.xpath(getDepartFromAndArriveAt(departFrom,arriveAt))).click();
    }
}
