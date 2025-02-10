package movie_reservation.movie_with_inheritance;

import movie_reservation.Money;
import movie_reservation.Screening;

import java.time.Duration;

public class AmountDiscountMovie extends MovieWithInheritance{
    private Money discountAmount;
    private boolean someDiscountCondition;

    public AmountDiscountMovie(String title, Duration runningTime, Money fee, Money discountAmount, boolean someDiscountCondition) {
        super(title, runningTime, fee);
        this.discountAmount = discountAmount;
        this.someDiscountCondition = someDiscountCondition;
    }

    @Override
    public Money calculateMovieFee(Screening screening) {
        if (someDiscountCondition) return screening.getMovieFee().minus(discountAmount);
        return screening.getMovieFee();
    }
}
