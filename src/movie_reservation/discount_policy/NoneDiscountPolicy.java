package movie_reservation.discount_policy;

import movie_reservation.Money;
import movie_reservation.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
