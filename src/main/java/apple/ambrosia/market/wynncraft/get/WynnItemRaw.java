package apple.ambrosia.market.wynncraft.get;

import apple.ambrosia.market.wynncraft.item.DatabaseVersion;

public abstract class WynnItemRaw<Ver extends WynnItemRaw<Ver>> {
    private transient DatabaseVersion<Ver, ?> version;

    public WynnItemRaw(DatabaseVersion<Ver, ?> version) {
        this.version = version;
    }

    public abstract String getName();
}
