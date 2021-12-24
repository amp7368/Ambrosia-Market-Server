package apple.ambrosia.market.wynncraft.item.v1.spell;

import apple.ambrosia.market.wynncraft.get.WynnItemV1Raw;
import apple.ambrosia.market.wynncraft.item.v1.damage.NorRaw;

public class WynnItemSpellCost {
    public NorRaw<Integer> sc1;
    public NorRaw<Integer> sc2;
    public NorRaw<Integer> sc3;
    public NorRaw<Integer> sc4;

    public WynnItemSpellCost(WynnItemV1Raw raw) {
        this.sc1 = new NorRaw<>(raw.spellCostPct1, raw.spellCostRaw1, Integer::parseInt);
        this.sc2 = new NorRaw<>(raw.spellCostPct2, raw.spellCostRaw2, Integer::parseInt);
        this.sc3 = new NorRaw<>(raw.spellCostPct3, raw.spellCostRaw3, Integer::parseInt);
        this.sc4 = new NorRaw<>(raw.spellCostPct4, raw.spellCostRaw4, Integer::parseInt);
    }
}
