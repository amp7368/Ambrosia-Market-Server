package apple.ambrosia.market.wynncraft;

import apple.ambrosia.market.Ambrosia;
import apple.ambrosia.market.wynncraft.get.WynnItemRaw;
import apple.ambrosia.market.wynncraft.get.WynnItemRawVersionTypeIdentifier;
import apple.ambrosia.market.wynncraft.item.WynnItem;
import apple.ambrosia.market.wynncraft.item.WynnItemDatabase;
import apple.ambrosia.market.wynncraft.item.WynnItemVersionTypeIdentifier;
import apple.ambrosia.market.wynncraft.item.uuid.ItemUuidDatabase;
import apple.ambrosia.market.wynncraft.item.v1.WynnItemV1;
import apple.utilities.json.gson.GsonBuilderDynamic;
import apple.utilities.util.FileFormatting;
import com.google.gson.Gson;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Wynncraft {
    public static void load() throws IOException {
        ItemUuidDatabase.load();
        WynnItemDatabase.loadAll();
    }

    public static File getDataFolder() {
        return FileFormatting.fileWithChildren(Ambrosia.getDataFolder(), "wynn");
    }

    public static Gson getGson() {
        GsonBuilderDynamic gsonBuilder = new GsonBuilderDynamic();
        gsonBuilder.registerTypeHierarchyAdapter(WynnItem.class, WynnItemVersionTypeIdentifier.createTypeMapper().getGsonSerializing(gsonBuilder));
        gsonBuilder.registerTypeHierarchyAdapter(WynnItemRaw.class, WynnItemRawVersionTypeIdentifier.createTypeMapper().getGsonSerializing(gsonBuilder));
        return gsonBuilder.create();
    }

    @Nullable
    public static WynnItemV1 lookupItem(String itemName) {
        UUID itemUUID = ItemUuidDatabase.get().lookupItem(itemName);
        if (itemUUID == null) return null;
        return WynnItemDatabase.lookupItem(itemUUID);
    }
}
