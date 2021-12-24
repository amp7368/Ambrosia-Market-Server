package apple.ambrosia.market.wynncraft.item.v1.id;

import apple.ambrosia.market.wynncraft.get.DataValidation;
import apple.ambrosia.market.wynncraft.get.WynnItemV1Raw;
import apple.ambrosia.market.wynncraft.item.v1.damage.NorRaw;

public class WynnItemIds implements DataValidation {
    public NorRaw<Integer> healthRegen;
    public Integer poison;
    public Integer lifeSteal;
    public Integer manaRegen;
    public Integer thorns;
    public Integer reflection;
    public Integer attackSpeedBonus;
    public Integer speed;
    public Integer exploding;
    public Integer soulPoints;
    public Integer sprint;
    public Integer sprintRegen;
    public Integer jumpHeight;
    public Integer xpBonus;
    public Integer lootBonus;
    public Integer lootQuality;
    public Integer emeraldStealing;
    public Integer gatherXpBonus;
    public Integer gatherSpeed;

    public WynnItemIds(WynnItemV1Raw raw) {
        this.healthRegen = new NorRaw<>(raw.healthRegen, raw.healthRegenRaw, Integer::parseInt);
        this.poison = prepareParseInt(raw.poison);
        this.lifeSteal = prepareParseInt(raw.lifeSteal);
        this.manaRegen = prepareParseInt(raw.manaRegen);
        this.thorns = prepareParseInt(raw.thorns);
        this.reflection = prepareParseInt(raw.reflection);
        this.attackSpeedBonus= prepareParseInt(raw.attackSpeedBonus);
        this.speed = prepareParseInt(raw.speed);
        this.exploding = prepareParseInt(raw.exploding);
        this.soulPoints = prepareParseInt(raw.soulPoints);
        this.sprint = prepareParseInt(raw.sprint);
        this.sprintRegen = prepareParseInt(raw.sprintRegen);
        this.jumpHeight = prepareParseInt(raw.jumpHeight);
        this.xpBonus= prepareParseInt(raw.xpBonus);
        this.lootBonus = prepareParseInt(raw.lootBonus);
        this.lootQuality= prepareParseInt(raw.lootQuality);
        this.emeraldStealing= prepareParseInt(raw.emeraldStealing);
        this.gatherXpBonus= prepareParseInt(raw.gatherXpBonus);
        this.gatherSpeed= prepareParseInt(raw.gatherSpeed);
    }
}
