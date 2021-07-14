package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;

public class TicketPricePage {
    // Locators

    //Elements

    //Methods
    public String getTrain(String departFrom, String arriveAt){
        String text = "//li[text()='%s to %s']/parent::td//following-sibling::td//a[text()='Check Price']";
        return String.format(text, departFrom, arriveAt);
    }
    public void checkPriceFromTicketPricePage(String departFrom, String arriveAt){
        Constant.WEBDRIVER.findElement(By.xpath(getTrain(departFrom,arriveAt))).click();
    }
}
