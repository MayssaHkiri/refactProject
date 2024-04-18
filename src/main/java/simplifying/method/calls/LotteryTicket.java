package simplifying.method.calls;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LotteryTicket {
  private final String number;
  private final UUID customerId;
}