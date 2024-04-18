package simplifying.method.calls;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Bill {
  private final double amount;
  private final LocalDate invoicedDate;
  private final LocalDate paymentDate;
  private final LocalDate dueDate;
}