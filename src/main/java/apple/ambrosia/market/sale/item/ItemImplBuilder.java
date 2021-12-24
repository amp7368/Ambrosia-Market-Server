package apple.ambrosia.market.sale.item;

import apple.ambrosia.market.wynncraft.item.v1.WynnItemV1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemImplBuilder {
    private Map<ItemModifierId, ItemModifier> modifiers = new HashMap<>();
    private WynnItemV1 original;
    private List<ItemImmutableId> immutables = new ArrayList<>();

    public ItemImplBuilder(WynnItemV1 original) {
        this.original = original;
        this.immutables = original.getImmutables();
    }

    public WynnItemV1 getOriginal() {
        return original;
    }
}
