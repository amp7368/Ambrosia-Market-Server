package apple.ambrosia.market.wynncraft.item.v1.damage;

import apple.ambrosia.market.wynncraft.get.DataValidation;
import apple.ambrosia.market.wynncraft.get.WynnItemV1Raw;
import apple.ambrosia.market.wynncraft.item.v1.powder.Elemental;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WynnItemDamage implements DataValidation {
    @Nullable
    public DamagePair damage;
    @NotNull
    public Elemental<DamagePair> elementalDamage;
    @Nullable
    public NorRaw<Integer> spellDamage;
    @Nullable
    public Integer rainbowSpellDamageRaw;
    @NotNull
    public Elemental<Integer> bonusElementalDamage;

    public WynnItemDamage(WynnItemV1Raw raw) {
        this.damage = prepareNormal(raw.damage, DamagePair::new);
        this.elementalDamage = new Elemental<>(
                raw.earthDamage,
                raw.thunderDamage,
                raw.waterDamage,
                raw.fireDamage,
                raw.airDamage,
                DamagePair::new);
        this.spellDamage = new NorRaw<>(raw.spellDamage, raw.spellDamageRaw, Integer::parseInt);
        this.rainbowSpellDamageRaw = prepareParseInt(raw.rainbowSpellDamageRaw);
        this.bonusElementalDamage = new Elemental<>(raw.bonusEarthDamage,
                raw.bonusThunderDamage,
                raw.bonusWaterDamage,
                raw.bonusFireDamage,
                raw.bonusAirDamage,
                Integer::parseInt);
    }


}
