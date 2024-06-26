package simplifying.method.calls;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class renameMethod {
  @Test
  void john_doe_is_a_model_employee() {
    Employee johnDoe = new Employee("John Doe", "?", "Beach", List.of("Hunter", "Accountant"));

    assertThat(johnDoe.get()).isNotNull();
    assertThat(johnDoe.getN()).isEqualTo("John Doe");
    assertThat(johnDoe.getR()).isEqualTo("?");
    assertThat(johnDoe.getP()).isEqualTo("Beach");
    assertThat(johnDoe.isProfessionalService()).isTrue();
    assertThat(johnDoe.isIdeal()).isTrue();
    assertThat(johnDoe.hasSomething("Accountant")).isTrue();
    assertThat(johnDoe.hasSomething("Football")).isFalse();
  }
}