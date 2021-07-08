package PageObjects.Railway;

import Common.Common.GetDateToday;
import Common.Common.ScrollIntoView;
import Common.Common.Utilities;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class BookTicketPage {


    ScrollIntoView scrollIntoView = new ScrollIntoView();
    GetDateToday getDateToday = new GetDateToday();

    // Locators
    private final By departDateDropdown = By.xpath("//form[@method='post']//fieldset//ol//li//select[@name=\"Date\"]");

    // Elements
    public WebElement getDepartDate() {
        return Constant.WEBDRIVER.findElement(By
                .xpath("//select[@name='Date']"));

    }

    // Methods


    public void a() {
        Utilities.scrollAndClickIntoView(this.getDepartDate());
        Select departDate = new Select(this.getDepartDate());
        departDate.selectByVisibleText("7/13/2021");
    }
    public void chooseDepartDate()  {
        /*this.getDepartDate().click();
        Constant.WEBDRIVER.findElement(
                By.xpath("//select[@name='Date']//option[text()=\""+getDateToday.getDate()+"\"]"))
                .click();*/



        Utilities.scrollAndClickIntoView(this.getDepartDate());
        Select departDate = new Select(this.getDepartDate());
        departDate.selectByVisibleText("7/13/2021");







        /*WebElement element = Constant.WEBDRIVER.findElement(By.xpath("//form//li[1]//select"));
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(3000);









        WebElement c = Constant.WEBDRIVER.findElement(By.xpath("//form//li[1]//select"));
        ((JavascriptExecutor)Constant.WEBDRIVER).executeScript("arguments[0].value='7/12/2021';",c);*/

       /* WebElement haha = Constant.WEBDRIVER.findElement(By.xpath("//form//li[1]//select"));
        Select hihi = new Select(haha);
        hihi.selectByVisibleText("7/11/2021");*/
        /*Select d = new Select(Constant.WEBDRIVER.findElement(By
                .xpath("//form//li[1]//select")));
        d.selectByVisibleText("7/11/2021");*/
    }

    /* public void selectDepartDate(String departDate){
        this.getDepartDate().selectByVisibleText(departDate);
    }*///"+getDateToday.getDate()+"
}
