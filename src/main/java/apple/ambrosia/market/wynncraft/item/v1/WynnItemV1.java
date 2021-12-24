package apple.ambrosia.market.wynncraft.item.v1;

import apple.ambrosia.market.sale.item.ItemImmutableId;
import apple.ambrosia.market.wynncraft.get.WynnItemV1Raw;
import apple.ambrosia.market.wynncraft.item.DatabaseVersion;
import apple.ambrosia.market.wynncraft.item.WynnItem;
import apple.ambrosia.market.wynncraft.item.v1.damage.WynnItemDamage;
import apple.ambrosia.market.wynncraft.item.v1.defense.WynnItemDefense;
import apple.ambrosia.market.wynncraft.item.v1.id.WynnItemIds;
import apple.ambrosia.market.wynncraft.item.v1.meta.WynnItemMeta;
import apple.ambrosia.market.wynncraft.item.v1.powder.WynnItemPowder;
import apple.ambrosia.market.wynncraft.item.v1.powder.WynnItemSkillPoints;
import apple.ambrosia.market.wynncraft.item.v1.spell.WynnItemSpellCost;

import java.util.List;

public class WynnItemV1 extends WynnItem<WynnItemV1> {
    public DontCare dontCare;
    public WynnItemMeta wynnItemMeta;
    public WynnItemPowder powder;
    public WynnItemDamage damage;
    public WynnItemSkillPoints skillPoints;
    public WynnItemIds healthBonus;
    public WynnItemSpellCost spellCost;
    public WynnItemDefense defense;

    public WynnItemV1() {
        super(DatabaseVersion.ITEM_1);
    }

    public WynnItemV1(WynnItemV1Raw raw) {
        super(DatabaseVersion.ITEM_1);
        dontCare = new DontCare(raw);
        wynnItemMeta = new WynnItemMeta(raw);
        powder = new WynnItemPowder(raw);
        damage = new WynnItemDamage(raw);
        skillPoints = new WynnItemSkillPoints(raw);
        healthBonus = new WynnItemIds(raw);
        spellCost = new WynnItemSpellCost(raw);
        defense = new WynnItemDefense(raw);
    }

    public List<ItemImmutableId> getImmutables() {
        return null;
    }

    @Override
    public String getName() {
        return this.wynnItemMeta.name;
    }
}
