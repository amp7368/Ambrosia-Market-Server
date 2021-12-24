package apple.ambrosia.market.wynncraft.item.v1.defense;

import apple.ambrosia.market.wynncraft.get.DataValidation;
import apple.ambrosia.market.wynncraft.get.WynnItemV1Raw;
import apple.ambrosia.market.wynncraft.item.v1.powder.Elemental;

public class WynnItemDefense {
    public Elemental<Integer> bonusElementalDefense;
    public Elemental<Integer> elementalDefense;

    public WynnItemDefense(WynnItemV1Raw raw) {
        this.bonusElementalDefense = new Elemental<>(
                raw.bonusEarthDefense,
                raw.bonusThunderDefense,
                raw.bonusWaterDefense,
                raw.bonusFireDefense,
                raw.bonusAirDefense,
                DataValidation::prepareParseIntS
        );
        this.elementalDefense = new Elemental<>(
                raw.earthDefense,
                raw.thunderDefense,
                raw.waterDefense,
                raw.fireDefense,
                raw.airDefense,
                DataValidation::prepareParseIntS
        );
    }
}
