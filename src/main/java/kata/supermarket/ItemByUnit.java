package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final UnitProduct product;

    ItemByUnit(final UnitProduct unitProduct) {
        this.product = unitProduct;
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }

    public UnitProduct product(){
        return product;
    }
}
