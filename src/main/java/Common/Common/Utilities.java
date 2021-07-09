package Common.Common;

import Common.Constant.Constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Utilities {

    private static final String alpha = "abcdefghijklmnopqrstwvxyzABCDEFGHIJKLMNOPQRSTWVXYZ";
    private static final String digits = "0123456789";

    public static void scrollAndClickIntoView(WebElement element) {
        JavascriptExecutor je = (JavascriptExecutor) Constant.WEBDRIVER;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
    public String getDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("M-d-yyyy");

        Calendar c1 = Calendar.getInstance();

        String today = java.time.LocalDate.now().toString();

        Date date = Date.valueOf(today);
        c1.setTime(date);
        c1.roll(Calendar.DATE, 5);
        String result =  dateFormat.format(c1.getTime());
        System.out.println(result);
        result = result.replace("-","/");
        System.out.println(result);

        return result;
    }
    public static String GenRandomString() {
        int rdText;
        int rdNumber;
        String randomString = "";
        Random rd = new Random();
        for (int i = 0; i < 3; i++) {
            rdText = rd.nextInt(alpha.length() - 1);
            randomString+=(Character.toString(alpha.charAt(rdText)));
            rdNumber = rd.nextInt(digits.length() - 1);
            randomString+=(Character.toString(digits.charAt(rdNumber)));
        }
        return randomString ;
    }
    public void test(){
        String a = "a %s, l %s";
        String b = String.format(a,"hihi","haha");
        System.out.println(b);
    }

    public static void main(String[] args) {
        Utilities a = new Utilities();
        a.test();
    }
}
