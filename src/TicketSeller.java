public class TicketSeller {
    private TicketOffice ticketOffice;

    // 가정하기로, 매표소 없이는 판매원이 있을 수 없음. => 강제
    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        Bag bag = audience.getBag();
        Ticket ticket = ticketOffice.getTicket();
        if (!bag.hasInvitation()) {
            bag.minusCash(ticket.getFee());
            ticketOffice.plusCash(ticket.getFee());
        }
        bag.setTicket(ticket);
    }
}
