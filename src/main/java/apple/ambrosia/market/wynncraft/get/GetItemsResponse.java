package apple.ambrosia.market.wynncraft.get;

import apple.ambrosia.market.wynncraft.item.DatabaseVersion;
import apple.ambrosia.market.wynncraft.item.WynnItem;

import java.util.List;
import java.util.stream.Collectors;

public class GetItemsResponse<R extends WynnItemRaw<R>, O extends WynnItem<O>> {
    public List<R> items;


    public List<O> getItems(DatabaseVersion<R, O> version) {
        return items.stream().map(version.getConstructor()).collect(Collectors.toList());
    }
}
