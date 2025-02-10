package movie_reservation.movie_with_inheritance;

import movie_reservation.Money;
import movie_reservation.Screening;
import movie_reservation.discount_policy.DiscountPolicy;

import java.time.Duration;

public abstract class MovieWithInheritance {
    private String title;
    private Duration runningTime;
    private Money fee;

    public MovieWithInheritance(String title, Duration runningTime, Money fee) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public Money getFee() {
        return fee;
    }

    public abstract Money calculateMovieFee(Screening screening);

//    public Money calculateMovieFee(Screening screening) {
//        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
//    }
}
