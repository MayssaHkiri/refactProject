package simplifying.method.calls;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class introduceParameterObject {
  private final AccountingService accountingService = new AccountingService(List.of(
      Bill.builder()
          .amount(23_789)
          .invoicedDate(LocalDate.of(1989, 1, 1))
          .dueDate(LocalDate.of(1989, 2, 1))
          .paymentDate(LocalDate.of(2020, 12, 1))
          .build(),
      Bill.builder()
          .amount(67_987)
          .invoicedDate(LocalDate.of(2020, 12, 1))
          .dueDate(LocalDate.of(2021, 1, 1))
          .build(),
      Bill.builder()
          .amount(1256.99)
          .invoicedDate(LocalDate.of(2020, 10, 9))
          .dueDate(LocalDate.of(2020, 12, 1))
          .paymentDate(LocalDate.of(2020, 10, 10))
          .build(),
      Bill.builder()
          .amount(156_987)
          .invoicedDate(LocalDate.of(2020, 10, 9))
          .dueDate(LocalDate.of(2020, 12, 1))
          .paymentDate(LocalDate.of(2020, 12, 1))
          .build(),
      Bill.builder()
          .amount(34_900)
          .invoicedDate(LocalDate.of(2020, 10, 9))
          .dueDate(LocalDate.of(2021, 1, 1))
          .build(),
      Bill.builder()
          .amount(12_897)
          .invoicedDate(LocalDate.of(2020, 1, 1))
          .dueDate(LocalDate.of(2020, 2, 1))
          .paymentDate(LocalDate.of(2020, 1, 16))
          .build(),
      Bill.builder()
          .amount(98_765)
          .invoicedDate(LocalDate.of(2020, 12, 31))
          .dueDate(LocalDate.of(2021, 2, 1))
          .paymentDate(LocalDate.of(2021, 1, 2))
          .build()
  ));

  @Test
  void findBillsInvoicedBetween2Dates() {
    ArrayList<Bill> bills = accountingService.findBillsInvoicedBetween(LocalDate.of(2020, 1, 1),
        LocalDate.of(2020, 12, 31));

    assertThat(bills.size()).isEqualTo(6);
    assertThat(bills.stream().mapToDouble(Bill::getAmount).sum()).isEqualTo(372792.99);
  }

  @Test
  void findBillsDueBetween2Dates() {
    ArrayList<Bill> bills =
        accountingService.findBillsDueBetween(LocalDate.of(1980, 10, 1), LocalDate.of(2019, 1, 31));

    assertThat(bills.size()).isEqualTo(1);
    assertThat(bills.stream().mapToDouble(Bill::getAmount).sum()).isEqualTo(23_789);
  }

  @Test
  void findBillsPaidBetween2Dates() {
    ArrayList<Bill> bills = accountingService.findBillsPaidBetween(LocalDate.of(1980, 10, 1),
        LocalDate.of(2020, 12, 31));

    assertThat(bills.size()).isEqualTo(4);
    assertThat(bills.stream().mapToDouble(Bill::getAmount).sum()).isEqualTo(194_929.99);
  }
}