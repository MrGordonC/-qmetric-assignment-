package kata.supermarket;

import java.math.BigDecimal;

public class WeighedProduct implements Product{

    private final BigDecimal pricePerKilo;
    private final String type;

    public WeighedProduct(final BigDecimal pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
        this.type = "Default";
    }

    public WeighedProduct(final BigDecimal pricePerKilo, String type) {
        this.pricePerKilo = pricePerKilo;
        this.type = type;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos);
    }

    @Override
    public String type() {
        return type;
    }
}
