package ticket_reservation;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
