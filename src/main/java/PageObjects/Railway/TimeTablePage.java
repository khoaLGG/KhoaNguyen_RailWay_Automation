package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage {

    // Locators
    //Elements

    //Methods
    public String getDepartFromAndArriveAt(String departFrom, String arriveAt){
        String text = "//td[text()='%s']//following-sibling::td[text()='%s']//following-sibling::td//a[text()='book ticket']";
        return String.format(text, departFrom, arriveAt);
    }
    public void bookTicketFromTimeTablePage(String departFrom, String arriveAt){
        Constant.WEBDRIVER.findElement(By.xpath(String.format(getDepartFromAndArriveAt(departFrom,arriveAt),departFrom,arriveAt))).click();
    }
}
