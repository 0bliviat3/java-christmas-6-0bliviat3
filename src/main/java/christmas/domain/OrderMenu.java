package christmas.domain;

import java.util.Map;

import christmas.domain.constants.FoodConstants;

public class OrderMenu {

    private final Map<FoodConstants, Integer> order;

    public OrderMenu(final Map<FoodConstants, Integer> order) {
        this.order = order;
    }

}
