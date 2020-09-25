package kata.supermarket;

import java.math.BigDecimal;

public class UnitProduct implements Product{

    private final BigDecimal pricePerUnit;
    private final String type;

    public UnitProduct(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit; this.type = "Default";
    }

    public UnitProduct(final BigDecimal pricePerUnit, String type) {
        this.pricePerUnit = pricePerUnit; this.type = type;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }

    @Override
    public String type() {
        return type;
    }
}
