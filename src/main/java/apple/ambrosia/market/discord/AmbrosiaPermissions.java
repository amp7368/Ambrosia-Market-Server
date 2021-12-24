package apple.ambrosia.market.discord;

import apple.ambrosia.market.discord.admin.AdminDatabase;
import apple.discord.acd.ACD;
import apple.discord.acd.permission.ACDPermission;
import net.dv8tion.jda.api.entities.Member;

public class AmbrosiaPermissions {
    public static boolean isSuperAdmin(long id) {
        return AdminDatabase.get().isSuperAdmin(id);
    }

    public static boolean isNormalAdmin(long id) {
        return AdminDatabase.get().isNormalAdmin(id);
    }

    public static void addPermissions(ACD acd) {
        acd.getPermissions().addPermission(new ACDPermission("normalAdmin", 1) {
            @Override
            public boolean hasPermission(Member member) {
                return isNormalAdmin(member.getIdLong());
            }
        });
        acd.getPermissions().addPermission(new ACDPermission("superAdmin", 1) {
            @Override
            public boolean hasPermission(Member member) {
                return isSuperAdmin(member.getIdLong());
            }
        });
    }
}

