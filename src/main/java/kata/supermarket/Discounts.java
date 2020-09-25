package kata.supermarket;

import java.math.BigDecimal;
import java.util.*;

public class Discounts {

    List<Item> basket;

    public Discounts(List<Item> basket){
        this.basket = new ArrayList<>(basket);
    }

    private Map<String, List<Item>> itemByCategory(){
        Map<String, List<Item>> mapOfItemsByUnit = new HashMap<>();
        basket.forEach(item ->{
            Product product = item.product();
            if(mapOfItemsByUnit.containsKey(product.type())){
                mapOfItemsByUnit.get(product.type()).add(item);
            } else {
                ArrayList<Item> listOfItems= new ArrayList<>();
                listOfItems.add(item);
                mapOfItemsByUnit.put(product.type(), listOfItems);
            }
        });
        return mapOfItemsByUnit;
    }

    public BigDecimal calculate(){
        BigDecimal discountTotal = BigDecimal.valueOf(0, 2);
        HashMap<String, Offer> discountedOffers = discountedOffersMap();
        Map<String, List<Item>> itemCategoryMap = itemByCategory();
        for(String productType: itemCategoryMap.keySet()) {
            if(discountedOffers.containsKey(productType)) {
                Offer offer = discountedOffers.get(productType);
                discountTotal = discountTotal.add(offer.apply(itemCategoryMap.get(productType)));
            }
        }
        return discountTotal;
    }

    private static HashMap<String, Offer> discountedOffersMap(){
        HashMap<String, Offer> discountedOffers = new HashMap<>();
        discountedOffers.put("sweet", new DiscountPerKilo());
        return discountedOffers;
    }

}
