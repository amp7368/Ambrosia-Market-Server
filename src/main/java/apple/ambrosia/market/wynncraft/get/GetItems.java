package apple.ambrosia.market.wynncraft.get;

import apple.ambrosia.market.Ambrosia;
import apple.ambrosia.market.logging.LoggingNames;
import apple.ambrosia.market.util.FileIOServiceNow;
import apple.ambrosia.market.wynncraft.Wynncraft;
import apple.ambrosia.market.wynncraft.item.DatabaseVersion;
import apple.ambrosia.market.wynncraft.item.WynnItem;
import apple.utilities.request.AppleJsonFromFile;
import apple.utilities.request.AppleJsonFromURL;
import apple.utilities.request.AppleJsonToFile;
import apple.utilities.util.FileFormatting;
import com.google.gson.reflect.TypeToken;
import org.slf4j.event.Level;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class GetItems {
    private static final String GET_ITEMS_URL = "https://api.wynncraft.com/public_api.php?action=itemDB&category=all";

    public static <R extends WynnItemRaw<R>, O extends WynnItem<O>> List<O> getItems(DatabaseVersion<R, O> version) throws IOException {
        Type itemResponseType = TypeToken.getParameterized(GetItemsResponse.class, version.getRawClass(), version.getOutClass()).getType();
        File itemsJsonFile = new File(getDataFolder(), "items" + version.version() + ".json");
        if (!itemsJsonFile.exists()) itemsJsonFile.createNewFile();
        Ambrosia.log("Getting items from json file.", Level.INFO, LoggingNames.WYNN);
        GetItemsResponse<R, O> response = FileIOServiceNow.get().queue(new AppleJsonFromFile<GetItemsResponse<R, O>>(itemsJsonFile, itemResponseType), e -> {
        }).complete();
        if (response != null) return response.getItems(version);
        Ambrosia.log("Retrieving latest items from url.", Level.INFO, LoggingNames.WYNN);
        response = FileIOServiceNow.get().queue(new AppleJsonFromURL<GetItemsResponse<R, O>>(GET_ITEMS_URL, itemResponseType), e -> {
        }).complete();
        FileIOServiceNow.get().queueVoid(new AppleJsonToFile(itemsJsonFile, response)).complete();
        return response.getItems(version);
    }

    private static File getDataFolder() {
        File get = FileFormatting.fileWithChildren(Wynncraft.getDataFolder(), "get");
        get.mkdirs();
        return get;
    }

}
