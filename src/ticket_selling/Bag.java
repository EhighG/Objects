package ticket_selling;

/**
 * 가방은 티켓 교환 전부터 들고 있으므로, 가능한 초기값은
 * - 현금만 있거나(0원이라도),
 * - 현금과 초대장이 있거나
 * 의 2가지 경우이다. => 생성자로 강제한다.
 */
public class Bag {
    private Long cashAmount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(long cashAmount) {
        this(null, cashAmount);
    }

    public Bag(Invitation invitation, long cashAmount) {
        this.invitation = invitation;
        this.cashAmount = cashAmount;
    }

    public Long hold(Ticket ticket) {
        setTicket(ticket);
        if (hasInvitation()) {
            return 0L;
        } else {
            Long fee = ticket.getFee();
            minusCash(fee);
            return fee;
        }
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void plusCash(Long amount) {
        this.cashAmount += amount;
    }

    private void minusCash(Long amount) {
        this.cashAmount -= amount;
    }


}
