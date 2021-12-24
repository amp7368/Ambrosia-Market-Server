package apple.ambrosia.market.wynncraft.item.v1.damage;

import apple.ambrosia.market.wynncraft.get.DataValidation;

public class DamagePair implements DataValidation {
    public int lower;
    public int upper;

    public DamagePair(String damage) throws IllegalArgumentException {
        String[] s = damage.split("-");
        try {
            lower = Integer.parseInt(s[0]);
            upper = Integer.parseInt(s[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
