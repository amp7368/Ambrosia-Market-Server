package apple.ambrosia.market.wynncraft.item.v1.meta;

import apple.ambrosia.market.wynncraft.get.DataValidation;
import apple.ambrosia.market.wynncraft.get.WynnItemV1Raw;
import apple.ambrosia.market.wynncraft.item.v1.WynnItemSet;

public class WynnItemMeta implements DataValidation {
    public String name;
    public WynnItemTier tier;
    public WynnItemType type;
    public Restrictions restrictions;
    public WynnItemDropType dropType;
    public String addedLore;
    public short level;
    public WynnItemSet set;
    public String category;

    public WynnItemMeta(WynnItemV1Raw raw) {
        this.name = raw.name;
        this.tier = prepareEnum(raw.tier, WynnItemTier::valueOf);
        this.type = prepareEnum(raw.type, WynnItemType::valueOf);
        this.restrictions = prepareEnum(raw.restrictions, Restrictions::valueOf);
        this.dropType = prepareEnum(raw.dropType, WynnItemDropType::valueOf);
        this.addedLore = raw.addedLore;
        this.level = Short.parseShort(raw.level);
        this.set = new WynnItemSet(raw.set);
        this.category = raw.category;
    }
}
