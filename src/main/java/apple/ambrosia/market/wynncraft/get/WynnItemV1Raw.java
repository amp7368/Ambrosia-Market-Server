package apple.ambrosia.market.wynncraft.get;

import apple.ambrosia.market.wynncraft.item.DatabaseVersion;

public class WynnItemV1Raw extends WynnItemRaw<WynnItemV1Raw> {
    public String name;
    public String tier;
    public String type;
    public String set;
    public String restrictions;
    public String material;
    public String dropType;
    public String addedLore;
    public String sockets;
    public String damage;
    public String earthDamage;
    public String thunderDamage;
    public String waterDamage;
    public String fireDamage;
    public String airDamage;
    public String attackSpeed;
    public String level;
    public String quest;
    public String classRequirement;
    public String strength;
    public String dexterity;
    public String intelligence;
    public String defense;
    public String agility;
    public String strengthPoints;
    public String dexterityPoints;
    public String intelligencePoints;
    public String defensePoints;
    public String agilityPoints;
    public String damageBonus;
    public String damageBonusRaw;
    public String spellDamage;
    public String spellDamageRaw;
    public String rainbowSpellDamageRaw;
    public String healthRegen;
    public String healthRegenRaw;
    public String healthBonus;
    public String poison;
    public String lifeSteal;
    public String manaRegen;
    public String manaSteal;
    public String spellCostPct1;
    public String spellCostRaw1;
    public String spellCostPct2;
    public String spellCostRaw2;
    public String spellCostPct3;
    public String spellCostRaw3;
    public String spellCostPct4;
    public String spellCostRaw4;
    public String thorns;
    public String reflection;
    public String attackSpeedBonus;
    public String speed;
    public String exploding;
    public String soulPoints;
    public String sprint;
    public String sprintRegen;
    public String jumpHeight;
    public String xpBonus;
    public String lootBonus;
    public String lootQuality;
    public String emeraldStealing;
    public String gatherXpBonus;
    public String gatherSpeed;
    public String bonusEarthDamage;
    public String bonusThunderDamage;
    public String bonusWaterDamage;
    public String bonusFireDamage;
    public String bonusAirDamage;
    public String bonusEarthDefense;
    public String bonusThunderDefense;
    public String bonusWaterDefense;
    public String bonusFireDefense;
    public String bonusAirDefense;
    public String earthDefense;
    public String thunderDefense;
    public String waterDefense;
    public String fireDefense;
    public String airDefense;
    public String category;

    public WynnItemV1Raw() {
        super(DatabaseVersion.ITEM_1);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
