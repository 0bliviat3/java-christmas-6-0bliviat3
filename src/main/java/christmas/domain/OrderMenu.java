package christmas.domain;

import java.util.Map;

import christmas.domain.constants.FoodConstants;

public class OrderMenu {

    private static final String MENU_FORMAT = "%s %d개\n";
    private final Map<FoodConstants, Integer> order;

    public OrderMenu(final Map<FoodConstants, Integer> order) {
        validateOrderCount(order);
        this.order = order;
    }

    private void validateOrderCount(final Map<FoodConstants, Integer> order) { // TODO: 상수처리 및 예외 별도관리 고민
        int sum = 0;
        for(int count : order.values()) {
            sum += count;
            if(sum > 20) {
                throw new IllegalArgumentException("[ERROR] 메뉴는 최대 20개까지만 주문할 수 있습니다.");
            }
        }
    }

    public int getAmount() {
        int sum = 0;
        for(FoodConstants foodConstants : order.keySet()) {
            sum += foodConstants.getAmount() * order.get(foodConstants);
        }
        return sum;
    }

    @Override
    public String toString() {
       StringBuilder orderBuilder = new StringBuilder();
       order.forEach((foodConstants, count) -> {
           orderBuilder.append(
                   String.format(MENU_FORMAT,foodConstants.getFood(),count));
       });
       return orderBuilder.toString();
    }
}
