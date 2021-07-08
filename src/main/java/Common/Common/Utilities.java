package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Utilities {

    public static void scrollAndClickIntoView(WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor) Constant.WEBDRIVER;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
}
