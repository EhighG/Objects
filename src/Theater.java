public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        // 초대권이 있으면, 티켓으로 바꿔준다.
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else { // 초대권이 없으면, 돈을 받고 바꿔준다.
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusCash(ticket.getFee());
            ticketSeller.getTicketOffice().plusCash(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }

    }
}
