package DataObject.BookTicket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicket {
    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;
    private String ticketAmount;


    public BookTicket(){
        this.departDate = "7/12/2021";
        this.departFrom = "Sài Gòn";
        this.arriveAt = "Nha Trang" ;
        this.seatType = "Soft bed with air conditioner";
        this.ticketAmount = "1";
    }

}
