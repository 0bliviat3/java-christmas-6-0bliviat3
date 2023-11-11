package christmas.domain;

import static christmas.domain.constants.BadgeConstants.*;

import christmas.domain.constants.BadgeConstants;

public class Badge {

    private static String MESSAGE = "<12월 이벤트 배지>\n";
    private final int benefitAmount;

    public Badge(final int benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public String getBadge() {
        return String.join(MESSAGE, buildBadge());
    }

    private String buildBadge() {
        for(BadgeConstants badgeConstants : BadgeConstants.values()) {
            if(badgeConstants.getAmount() <= benefitAmount) {
                return badgeConstants.getBadge();
            }
        }
        return NONE.getBadge();
    }

}
