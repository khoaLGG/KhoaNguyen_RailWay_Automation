package PageObjects.Railway;

import Common.Common.GetDateToday;
import Common.Common.ScrollIntoView;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BookTicketPage {


    GetDateToday getDateToday = new GetDateToday();

    // Locators
    private final By departDateDropdown = By.xpath("//form[@method='post']//fieldset//ol//li//select[@name=\"Date\"]");

    // Elements
    public WebElement getDepartDate() {
        return Constant.WEBDRIVER.findElement(By
                .xpath("//form[@method='post']//fieldset//ol//li//select[@name=\"Date\"]"));

    }

    // Methods
    public void chooseDepartDate() {
        this.getDepartDate().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='Date']//option[text()=\""+getDateToday.getDate()+"\"]"))
                .click();
        /*Select d = new Select(Constant.WEBDRIVER.findElement(By
                .xpath("//form//li[1]//select")));
        d.selectByVisibleText("7/11/2021");*/
    }

    /* public void selectDepartDate(String departDate){
        this.getDepartDate().selectByVisibleText(departDate);
    }*///"+getDateToday.getDate()+"
}
