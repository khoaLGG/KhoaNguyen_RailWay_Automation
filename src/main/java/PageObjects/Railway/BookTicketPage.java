package PageObjects.Railway;

import Common.Common.ScrollIntoView;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BookTicketPage {

    ScrollIntoView scrollIntoView = new ScrollIntoView();

    // Locators
    private final By departDateDropdown = By.xpath("//select");

    // Elements
    public WebElement getDepartDate() {
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name='Date']"));

    }

    // Methods
    public void chooseDepartDate() {
        this.getDepartDate().click();
        Constant.WEBDRIVER.findElement(By.xpath("//select[@name='Date']//option[text()='7/11/2021']")).click();
    }

    /* public void selectDepartDate(String departDate){
        this.getDepartDate().selectByVisibleText(departDate);
    }*/
}
