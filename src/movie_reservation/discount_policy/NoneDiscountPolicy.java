package movie_reservation.discount_policy;

import movie_reservation.Money;
import movie_reservation.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
