package movie_reservation.discount_condition;

import movie_reservation.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
