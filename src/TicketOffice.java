import java.util.*;

public class TicketOffice {
    private Long cashAmount;
    private Queue<Ticket> tickets = new ArrayDeque<>();

    public TicketOffice(Long cashAmount, Ticket ... tickets) { // 가변인자 : jdk 1.5 ~
        this.cashAmount = cashAmount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public Ticket getTicket() {
        return tickets.poll();
    }

    public void minusCash(Long amount) {
        this.cashAmount -= amount;
    }

    public void plusCash(Long amount) {
        this.cashAmount += amount;
    }
}
