package christmas.domain.constants;

public enum BadgeConstants {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private final String badge;
    private final int amount;

    private BadgeConstants(final String badge, final int amount) {
        this.badge = badge;
        this.amount = amount;
    }

    public String getBadge() {
        return badge;
    }

    public int getAmount() {
        return amount;
    }
}
