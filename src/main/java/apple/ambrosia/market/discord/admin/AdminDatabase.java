package apple.ambrosia.market.discord.admin;

import apple.ambrosia.market.Ambrosia;
import apple.ambrosia.market.discord.DiscordBot;
import apple.ambrosia.market.util.FileIOServiceNow;
import apple.utilities.database.SaveFileable;
import apple.utilities.database.singleton.AppleJsonDatabaseSingleton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AdminDatabase implements SaveFileable {
    private static final String FILE_NAME = "adminList.json";
    private static AdminDatabase instance;
    private static AppleJsonDatabaseSingleton<AdminDatabase> databaseManager;
    private final List<Long> superAdmins = new ArrayList<>();
    private final List<Long> admins = new ArrayList<>();

    public AdminDatabase() {
        instance = this;
    }

    public static AdminDatabase get() {
        return instance;
    }

    public static void load() {
        File dataFolder = new File(Ambrosia.getDataFolder(), "admin");
        databaseManager = new AppleJsonDatabaseSingleton<>(dataFolder, FileIOServiceNow.get());
        AdminDatabase adminDatabase = databaseManager.loadNow(AdminDatabase.class, FILE_NAME);
        if (adminDatabase == null) new AdminDatabase();
        instance.superAdmins.add(DiscordBot.APPLEPTR16);
        instance.save();
    }

    public boolean isSuperAdmin(long id) {
        return superAdmins.contains(id);
    }

    public boolean isNormalAdmin(long id) {
        return isSuperAdmin(id) || admins.contains(id);
    }

    @Override
    public String getSaveFileName() {
        return FILE_NAME;
    }

    private void save() {
        databaseManager.save(this);
    }

    public void addAdmin(long admin) {
        admins.add(admin);
        save();
    }


    public void removeAdmin(long admin) {
        admins.remove(admin);
        save();
    }

    public void addSuperAdmin(long admin) {
        superAdmins.add(admin);
        save();
    }

    public void removeSuperAdmin(long admin) {
        superAdmins.remove(admin);
        save();
    }

    public List<Long> getAdmins() {
        ArrayList<Long> ids = new ArrayList<>(this.admins);
        ids.addAll(this.superAdmins);
        return ids;
    }

    public List<Long> getSuperAdmins() {
        return new ArrayList<>(this.superAdmins);
    }
}
