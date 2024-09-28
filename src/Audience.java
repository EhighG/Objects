public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        } else {
            Long fee = ticket.getFee();
            bag.setTicket(ticket);
            bag.minusCash(fee);
            return fee;
        }
    }
}
