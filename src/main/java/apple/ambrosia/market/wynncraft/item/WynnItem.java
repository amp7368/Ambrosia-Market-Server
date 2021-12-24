package apple.ambrosia.market.wynncraft.item;

import java.util.UUID;

public abstract class WynnItem<Ver extends WynnItem<Ver>> {
    private transient DatabaseVersion<?, Ver> version;
    public UUID uuid;

    public WynnItem(DatabaseVersion<?, Ver> version) {
        this.version = version;
    }

    public abstract String getName();

    public UUID assignUUID() {
        return this.uuid = UUID.randomUUID();
    }
}
