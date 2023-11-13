package christmas.domain;

import static christmas.exception.ExceptionConstants.ORDER;

import christmas.domain.constants.BadgeConstants;

public class Badge {
    private final int benefitAmount;

    public Badge(final int benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    @Override
    public String toString() {
        for (BadgeConstants badgeConstants : BadgeConstants.values()) {
            if (badgeConstants.getAmount() <= benefitAmount) {
                return badgeConstants.getBadge();
            }
        }
        throw new IllegalArgumentException(ORDER.getMessage());
    }
}
