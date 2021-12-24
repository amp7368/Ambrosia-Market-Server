package apple.ambrosia.market.wynncraft.item.uuid;

import apple.ambrosia.market.util.FileIOServiceNow;
import apple.ambrosia.market.wynncraft.Wynncraft;
import apple.utilities.database.SaveFileable;
import apple.utilities.database.singleton.AppleJsonDatabaseSingleton;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

public class ItemUuidDatabase implements SaveFileable {
    private static final AppleJsonDatabaseSingleton<ItemUuidDatabase> databaseManager = new AppleJsonDatabaseSingleton<>(getDataFolder(), FileIOServiceNow.get());
    private static final String SAVE_FILE_NAME = "item_uuid.json";
    private static ItemUuidDatabase instance;
    private final BiMap<String, UUID> itemNames = HashBiMap.create();

    public static void load() {
        @Nullable ItemUuidDatabase save = databaseManager.loadNow(ItemUuidDatabase.class, SAVE_FILE_NAME);
        instance = Objects.requireNonNullElseGet(save, ItemUuidDatabase::new);
    }

    public static ItemUuidDatabase get() {
        return instance;
    }

    private static File getDataFolder() {
        return new File(Wynncraft.getDataFolder(), "mapping");
    }

    @Override
    public String getSaveFileName() {
        return SAVE_FILE_NAME;
    }

    @Nullable
    public UUID lookupItem(String itemName) {
        return itemNames.get(itemName);
    }

    public void addItem(String name, UUID uuid) {
        this.itemNames.put(name, uuid);
    }
}
