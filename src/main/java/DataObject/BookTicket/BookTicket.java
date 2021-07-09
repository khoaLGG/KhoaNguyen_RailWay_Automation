package DataObject.BookTicket;

import Common.Common.GetDateToday;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicket {

    GetDateToday getDateToday = new GetDateToday();

    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;
    private String ticketAmount;


    public BookTicket(){
        this.departDate = getDateToday.getDate();
        this.departFrom = "Sài Gòn";
        this.arriveAt = "Nha Trang";
        this.seatType = "Soft bed with air conditioner";
        this.ticketAmount = "1";
    }

}
