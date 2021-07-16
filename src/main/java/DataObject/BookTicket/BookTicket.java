package DataObject.BookTicket;

import Common.Common.Utilities;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicket {

    Utilities utilities = new Utilities();

    private String departDate;
    private String departFrom;
    private String arriveAt;
    private String seatType;
    private String ticketAmount;


    public BookTicket(){
        this.departDate = utilities.getDate();
        this.departFrom = "Huế";
        this.arriveAt = "Quảng Ngãi";
        this.seatType = "Soft bed with air conditioner";
        this.ticketAmount = "3";
    }

}
