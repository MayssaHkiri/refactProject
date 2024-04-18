package organizing.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class encapsulateFields {
  @Test
  void harryPotter() {
    Wizard harryPotter = new Wizard("Harry Potter");
    harryPotter.life = 100;
    harryPotter.magicStick = "Bâton de la Mort";
    harryPotter.weapon = "None";

    assertThat(harryPotter.life).isEqualTo(100);
  }
}
