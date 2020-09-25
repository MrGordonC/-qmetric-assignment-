package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class DiscountPerKilo implements Offer{

    public DiscountPerKilo() {
    }

    @Override
    public BigDecimal apply(List<Item> items) {
        BigDecimal discountTotal = BigDecimal.valueOf(0, 2);
        double remainingWeightToApplyDiscount = 0;
        BigDecimal newPricePerKilo = BigDecimal.valueOf(0, 2);
        for (Item item : items) {
            ItemByWeight itemByWeight = (ItemByWeight) item;
            remainingWeightToApplyDiscount += itemByWeight.getWeightInKilos().doubleValue();
            WeighedProduct weighedProduct = (WeighedProduct) item.product();
            newPricePerKilo = newPricePerKilo.max(weighedProduct.pricePerKilo());
        }

        while (remainingWeightToApplyDiscount >= 1.0) {
            discountTotal = discountTotal.add(newPricePerKilo);
            remainingWeightToApplyDiscount -= 1;
        }
        return discountTotal;
    }
}
