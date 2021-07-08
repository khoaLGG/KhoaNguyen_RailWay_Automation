package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ScrollIntoView {
    public void scrollIntoView1(WebElement element){
        JavascriptExecutor je = (JavascriptExecutor) Constant.WEBDRIVER;
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        element.click();
    }
    public static void main(String[] args) {
    }
}

