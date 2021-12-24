package apple.ambrosia.market.discord;

import apple.ambrosia.market.Ambrosia;
import apple.ambrosia.market.util.FileIOServiceNow;
import apple.utilities.database.SaveFileable;
import apple.utilities.database.singleton.AppleJsonDatabaseSingleton;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class DiscordConfig implements SaveFileable {
    private static final String FILE_NAME = "discordConfig.json";
    private static DiscordConfig instance;
    public String discordToken = "discordToken";

    public DiscordConfig() {
        instance = this;
    }

    public static void load() {
        File dataFolder = new File(Ambrosia.getDataFolder(), "discord");
        AppleJsonDatabaseSingleton<DiscordConfig> manager = new AppleJsonDatabaseSingleton<>(dataFolder, FileIOServiceNow.get());
        @Nullable DiscordConfig config = manager.loadNow(DiscordConfig.class, FILE_NAME);
        if (config == null) new DiscordConfig();
        manager.save(instance);
    }

    public static DiscordConfig get() {
        return instance;
    }

    @Override
    public String getSaveFileName() {
        return FILE_NAME;
    }
}
