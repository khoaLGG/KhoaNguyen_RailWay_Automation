package Common.Common;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class GetDateToday {

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

    public static void main(String[] args) {
        GetDateToday a = new GetDateToday();
        System.out.println("//select[@name='Date']//option[text()=\""+a.getDate()+"\"]");

    }
}
