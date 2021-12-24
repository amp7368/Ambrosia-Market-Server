package apple.ambrosia.market.wynncraft.item;

import apple.ambrosia.market.Ambrosia;
import apple.ambrosia.market.logging.LoggingNames;
import apple.ambrosia.market.util.FileIOServiceNow;
import apple.ambrosia.market.wynncraft.Wynncraft;
import apple.ambrosia.market.wynncraft.get.GetItems;
import apple.ambrosia.market.wynncraft.get.WynnItemRaw;
import apple.ambrosia.market.wynncraft.get.WynnItemV1Raw;
import apple.ambrosia.market.wynncraft.item.uuid.ItemUuidDatabase;
import apple.ambrosia.market.wynncraft.item.v1.WynnItemV1;
import apple.utilities.database.SaveFileable;
import apple.utilities.database.singleton.AppleJsonDatabaseSingleton;
import apple.utilities.util.FileFormatting;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.event.Level;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class WynnItemDatabase<Raw extends WynnItemRaw<Raw>, Out extends WynnItem<Out>> implements SaveFileable {
    private static final String ITEM_DATABASE_NAME = "wynnItemDatabase.json";
    private static AppleJsonDatabaseSingleton<WynnItemDatabase> databaseManager;
    private static Map<DatabaseVersion<?, ?>, WynnItemDatabase<?, ?>> databases = new HashMap<>();
    private static WynnItemDatabase<WynnItemV1Raw, WynnItemV1> latestDatabase;

    private final int versionId = DatabaseVersion.getLatest().version();
    private final Map<UUID, Out> itemsByName = new HashMap<>();

    public WynnItemDatabase() {
    }

    public WynnItemDatabase(List<Out> itemsByName) {
        for (Out item : itemsByName) {
            this.itemsByName.put(item.assignUUID(), item);
            ItemUuidDatabase.get().addItem(item.getName(),item.uuid);
        }
    }

    public static void loadAll() throws IOException {
        Ambrosia.log("Loading Item Database", Level.ERROR, LoggingNames.AMBROSIA);
        Gson gson = Wynncraft.getGson();

        databaseManager = new AppleJsonDatabaseSingleton<>(getDataFolder(), FileIOServiceNow.get(), gson);
        @NotNull Collection<WynnItemDatabase> ds = databaseManager.loadAllNow(WynnItemDatabase.class);
        for (WynnItemDatabase<?, ?> d : ds) {
            databases.put(d.getVersion(), d);
        }
        latestDatabase = get(DatabaseVersion.getLatest());
        if (latestDatabase == null) {
            latestDatabase = new WynnItemDatabase<>(GetItems.getItems(DatabaseVersion.getLatest()));
            databases.put(latestDatabase.getVersion(), latestDatabase);
            latestDatabase.save();
        }
        Ambrosia.log("Finished loading Item Database", Level.ERROR, LoggingNames.AMBROSIA);
    }

    private DatabaseVersion<Raw, Out> getVersion() {
        return DatabaseVersion.get(versionId);
    }

    @Nullable
    public static WynnItemV1 lookupItem(UUID itemName) {
        return latestDatabase.getItem(itemName);
    }

    @Nullable
    private Out getItem(UUID itemName) {
        synchronized (itemsByName) {
            return itemsByName.get(itemName);
        }
    }

    private void save() {
        databaseManager.save(this);
    }

    private static <R extends WynnItemRaw<R>, O extends WynnItem<O>> WynnItemDatabase<R, O> get(DatabaseVersion<R, O> version) {
        return (WynnItemDatabase<R, O>) databases.get(version);
    }

    private static File getDataFolder() {
        return FileFormatting.fileWithChildren(Wynncraft.getDataFolder(), "items");
    }

    @Override
    public String getSaveFileName() {
        return ITEM_DATABASE_NAME;
    }
}
