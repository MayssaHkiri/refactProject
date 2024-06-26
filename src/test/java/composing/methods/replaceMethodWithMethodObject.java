package composing.methods;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;

class replaceMethodWithMethodObject {
  private final Warehouse warehouse = new Warehouse(9, new LinkedHashMap<>() {{
    put(Product.builder().name("Iphone 12").price(989).build(), 568);
    put(Product.builder().name("Super Mario 3D World").price(59.67).build(), 98);
    put(Product.builder().name("Blu Ray Avengers End Game").price(28.99).build(), 568);
    put(Product.builder().name("Liverpool FC T-Shirt").price(68).build(), 78);
  }});

  @Test
  void generateStockReport() {
    assertThat(warehouse.generateStockReport()).isEqualTo("Report for warehouse : 9%n" +
        "Product: Iphone 12 Price: 989.0 Stock : 568 units%n" +
        "Product: Super Mario 3D World Price: 59.67 Stock : 98 units%n" +
        "Product: Blu Ray Avengers End Game Price: 28.99 Stock : 568 units%n" +
        "Product: Liverpool FC T-Shirt Price: 68.0 Stock : 78 units%n" +
        "Total: 589369.98€");
  }
}
