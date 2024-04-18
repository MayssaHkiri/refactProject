package organizing.data;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.Test;

class extractConstants {
  @Test
  void validatePassword() {
    String validPassword = "OJ°0I°09121l.";
    assertThatCode(() -> Utils.validatePassword(validPassword)).doesNotThrowAnyException();
  }

  @Test
  void invalidatePassword() {
    String invalidPassword = "Im invalid";
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> Utils.validatePassword(invalidPassword));
  }

  @Test
  void calculatePotentialEnergy() {
    assertThat(Utils.calculatePotentialEnergy(1, 1)).isEqualTo(9.81);
    assertThat(Utils.calculatePotentialEnergy(98.9897, 160.987)).isEqualTo(156332.7, offset(0.01));
    assertThat(Utils.calculatePotentialEnergy(0, 1)).isZero();
    assertThat(Utils.calculatePotentialEnergy(1, 0)).isZero();
  }
}
