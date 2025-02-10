package movie_reservation;

import jdk.jfr.Period;
import movie_reservation.discount_condition.PeriodCondition;
import movie_reservation.discount_condition.SequenceCondition;
import movie_reservation.discount_policy.AmountDiscountPolicy;
import movie_reservation.discount_policy.NoneDiscountPolicy;
import movie_reservation.discount_policy.PercentDiscountPolicy;
import movie_reservation.movie_with_inheritance.AmountDiscountMovie;
import movie_reservation.movie_with_inheritance.MovieWithInheritance;
import movie_reservation.movie_with_inheritance.PercentDiscountMovie;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MovieReservation {

    public static void main(String[] args) {
        // 아바타
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));

        // 타이타닉
        Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11000),
                new PercentDiscountPolicy(0.1,
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))));

        // 스타워즈
        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                new NoneDiscountPolicy());

        // 할인 정책 변경
        starWars.changeDiscountPolicy(new PercentDiscountPolicy(0.1, new SequenceCondition(1)));

        // 만약 합성(has-a 관계)이 아닌 상속(is-a 관계)로 구현했다면?
        // 금액 할인 정책을 갖는 영화 생성
        MovieWithInheritance avatar2 = new AmountDiscountMovie("아바타2",
                Duration.ofMinutes(180),
                Money.wons(11000),
                Money.wons(1000),
                true);

        // 비율 할인으로 변경 => 아예 다른 클래스를 생성해야 하므로, 기존 값을 복사해서 새로 생성하는 방법밖에 없음
        avatar2 = new PercentDiscountMovie(avatar2.getTitle(),
                avatar2.getRunningTime(),
                avatar2.getFee(),
                0.1,
                true);

    }
}
