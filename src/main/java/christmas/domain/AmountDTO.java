package christmas.domain;

public class AmountDTO {

    private int christmasDiscount;
    private int weekdayDiscount;
    private int weekendDiscount;
    private int specialDiscount;
    private int giftDiscount;
    private int amount;

    public int getChristmasDiscount() {
        return christmasDiscount;
    }

    public void setChristmasDiscount(int christmasDiscount) {
        this.christmasDiscount = christmasDiscount;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }

    public void setWeekdayDiscount(int weekdayDiscount) {
        this.weekdayDiscount = weekdayDiscount;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }

    public void setWeekendDiscount(int weekendDiscount) {
        this.weekendDiscount = weekendDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public void setSpecialDiscount(int specialDiscount) {
        this.specialDiscount = specialDiscount;
    }

    public int getGiftDiscount() {
        return giftDiscount;
    }

    public void setGiftDiscount(int giftDiscount) {
        this.giftDiscount = giftDiscount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
