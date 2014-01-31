import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Slawomir Bolimowski
 * @since 2014-01-31 10:52
 */
public class Flight {
    private String number;
    private Map<String, BigDecimal> seats = new HashMap<>();

    public Flight(String number) {
        this.number = number;
    }


    public void addSeat(String number, BigDecimal price) {
        seats.put(number, price);
    }

    public BigDecimal getSeatPrice(String number) {
        return seats.get(number);
    }

    public String getNumber() {
        return number;
    }

    public int getAvailableSeats() {
        return seats.size();
    }

    public BigDecimal getCheapestSeatPrice() {
        if (seats.isEmpty()) {
            return null;
        }

        BigDecimal cheapestPrice = BigDecimal.valueOf(Long.MAX_VALUE);
        for (BigDecimal price : seats.values()) {
            if (price.compareTo(cheapestPrice) < 0) {
                cheapestPrice = price;
            }
        }

        return cheapestPrice;
    }
}
