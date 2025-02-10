package movie_reservation.movie_with_inheritance;

import movie_reservation.Money;
import movie_reservation.Screening;

import java.time.Duration;

public class PercentDiscountMovie extends MovieWithInheritance{
    private double percent;
    private boolean someDiscountCondition;

    public PercentDiscountMovie(String title, Duration runningTime, Money fee, double percent, boolean someDiscountCondition) {
        super(title, runningTime, fee);
        this.percent = percent;
        this.someDiscountCondition = someDiscountCondition;
    }

    @Override
    public Money calculateMovieFee(Screening screening) {
        Money movieFee = screening.getMovieFee();
        if (someDiscountCondition) return movieFee.minus(movieFee.times(percent));
        return movieFee;
    }
}
