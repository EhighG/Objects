package movie_reservation.discount_policy;

import movie_reservation.Money;
import movie_reservation.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
