package dealing.with.generalization;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Prospect {
  private final String name;
  private final String email;
  private final String phone;
  private final LocalDate creationDate;
  private final List<String> messages;
}