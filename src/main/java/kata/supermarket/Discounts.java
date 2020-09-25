package kata.supermarket;

import java.math.BigDecimal;
import java.util.*;

public class Discounts {

    List<Item> basket;

    public Discounts(List<Item> basket){
        this.basket = new ArrayList<>(basket);
    }

    public Set<String> discountedOffers(){
        HashSet<String> discountedOffers = new HashSet<>();
        discountedOffers.add("sweet");
        return discountedOffers;
    }


}
