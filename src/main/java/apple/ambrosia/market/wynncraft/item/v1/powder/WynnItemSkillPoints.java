package apple.ambrosia.market.wynncraft.item.v1.powder;

import apple.ambrosia.market.wynncraft.get.WynnItemV1Raw;
import apple.ambrosia.market.wynncraft.item.v1.damage.DamagePair;

public class WynnItemSkillPoints {
    public Elemental<Integer> skillReq;
    public Elemental<Integer> skillPoints;

    public WynnItemSkillPoints(WynnItemV1Raw raw) {
        this.skillReq = new Elemental<>(
                raw.strength,
                raw.dexterity,
                raw.intelligence,
                raw.defense,
                raw.agility,
                Integer::parseInt);
        this.skillPoints = new Elemental<>(
                raw.strengthPoints,
                raw.dexterityPoints,
                raw.intelligencePoints,
                raw.defensePoints,
                raw.agilityPoints,
                Integer::parseInt);

    }
}
