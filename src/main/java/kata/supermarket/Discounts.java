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

    public Set<String> discountedOffers(){
        HashSet<String> discountedOffers = new HashSet<>();
        discountedOffers.add("sweet");
        return discountedOffers;
    }


}
