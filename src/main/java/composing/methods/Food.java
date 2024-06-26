package composing.methods;

import java.time.LocalDate;
import lombok.Builder;

@Builder
public class Food {
  private final LocalDate expirationDate;
  private final Boolean approvedForConsumption;
  private final Integer inspectorId;

  public Food(LocalDate expirationDate, Boolean approvedForConsumption, Integer inspectorId) {
    this.expirationDate = expirationDate;
    this.approvedForConsumption = approvedForConsumption;
    this.inspectorId = inspectorId;
  }

  public boolean isEdible() {
    if (this.expirationDate.isAfter(LocalDate.now()) && this.approvedForConsumption == true &&
        this.inspectorId != null) {
      return true;
    } else {
      return false;
    }
  }
}
