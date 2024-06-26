package simplifying.conditional.expressions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.offset;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class decomposeConditional {
  private final double highSeasonRate = 2.86;
  private final double lowSeasonRate = 0.89;
  private final double lowSeasonExtraCharge = 50;
  private final double regularPrice = 156.89;

  private final RoomPriceCalculator roomPriceCalculator =
      new RoomPriceCalculator(
          LocalDate.of(2021, 1, 1),
          regularPrice,
          highSeasonRate,
          lowSeasonRate,
          lowSeasonExtraCharge,
          Clock.fixed(Instant.parse("2021-01-01T00:00:01Z"), ZoneOffset.UTC));

  @Test
  void roomPriceCalculator_should_apply_high_season_price_in_august() {
    LocalDate augustDate = LocalDate.of(2021, 8, 1);
    double result = roomPriceCalculator.calculatePriceFor(5, augustDate);

    assertThat(result).isEqualTo(2243.527, offset(0.001));
  }

  @Test
  void roomPriceCalculator_should_apply_low_season_price_in_february() {
    LocalDate februaryDate = LocalDate.of(2021, 2, 15);
    double result = roomPriceCalculator.calculatePriceFor(2, februaryDate);

    assertThat(result).isEqualTo(329.264, offset(0.001));
  }

  @Nested
  class roomPriceCalculator_should_throws_illegal_argument_exception {
    private final LocalDate highSeasonDate = LocalDate.of(2021, 9, 1);
    LocalDate lowSeasonDate = LocalDate.of(2021, 12, 20);

    @Test
    void when_selected_date_in_the_past() {
      LocalDate pastDate = LocalDate.of(1985, 10, 25);
      assertThatExceptionOfType(IllegalArgumentException.class)
          .isThrownBy(() -> roomPriceCalculator.calculatePriceFor(5, pastDate));
    }

    @Test
    void when_number_of_rooms_is_0_during_high_season() {
      assertThatExceptionOfType(IllegalArgumentException.class)
          .isThrownBy(() -> roomPriceCalculator.calculatePriceFor(0, highSeasonDate));
    }

    @Test
    void when_number_of_rooms_is_negative_during_high_season() {
      assertThatExceptionOfType(IllegalArgumentException.class)
          .isThrownBy(() -> roomPriceCalculator.calculatePriceFor(-1, highSeasonDate));
    }

    @Test
    void when_number_of_rooms_is_0_during_low_season() {
      assertThatExceptionOfType(IllegalArgumentException.class)
          .isThrownBy(() -> roomPriceCalculator.calculatePriceFor(0, lowSeasonDate));
    }

    @Test
    void when_number_of_rooms_is_negative_during_low_season() {
      assertThatExceptionOfType(IllegalArgumentException.class)
          .isThrownBy(() -> roomPriceCalculator.calculatePriceFor(-1, lowSeasonDate));
    }
  }
}
