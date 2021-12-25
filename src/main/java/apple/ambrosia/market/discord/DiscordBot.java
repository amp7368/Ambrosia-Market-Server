package apple.ambrosia.market.discord;

import apple.ambrosia.market.Ambrosia;
import apple.ambrosia.market.discord.admin.AdminDatabase;
import apple.ambrosia.market.discord.sale.CommandSale;
import apple.ambrosia.market.discord.sale.CommandSaleBasic;
import apple.ambrosia.market.logging.LoggingNames;
import apple.discord.acd.ACD;
import apple.discord.acd.slash.base.ACDSlashCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.privileges.CommandPrivilege;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;
import org.slf4j.event.Level;

import javax.security.auth.login.LoginException;
import java.util.*;

public class DiscordBot extends ListenerAdapter {
    public static final long APPLEPTR16 = 253646208084475904L;
    public static ACD acd;
    private final long AMBROSIA_BOTS_SERVER = 923749890104885271L;

    public DiscordBot() throws LoginException, InterruptedException {
        Ambrosia.log("Starting Discord Bot", Level.INFO, LoggingNames.DISCORD);
        JDABuilder builder = JDABuilder.create(DiscordConfig.get().discordToken,
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.DIRECT_MESSAGE_REACTIONS);
        builder.disableCache(CacheFlag.ACTIVITY, CacheFlag.VOICE_STATE, CacheFlag.CLIENT_STATUS, CacheFlag.ONLINE_STATUS);
        JDA client = builder.build();
        acd = new ACD("a!", client, AMBROSIA_BOTS_SERVER);
        AmbrosiaChoiceProviders.addProviders(acd);
        new CommandSale(acd);
        new CommandSaleBasic(acd);
        List<ACDSlashCommand> adminCommands = List.of(
        );
        List<ACDSlashCommand> superAdminCommands = List.of(
        );
        AmbrosiaPermissions.addPermissions(acd);
        acd.updateCommands();
        acd.getJDA().awaitReady();
        Map<String, Collection<? extends CommandPrivilege>> privileges = new HashMap<>();
        for (ACDSlashCommand command : adminCommands) {
            List<CommandPrivilege> privilege = new ArrayList<>();
            for (Long admin : AdminDatabase.get().getAdmins()) {
                privilege.add(new CommandPrivilege(CommandPrivilege.Type.USER, true, admin));
            }
            privileges.put(command.getName(), privilege);
        }
        for (ACDSlashCommand command : superAdminCommands) {
            List<CommandPrivilege> privilege = new ArrayList<>();
            for (Long admin : AdminDatabase.get().getSuperAdmins()) {
                privilege.add(new CommandPrivilege(CommandPrivilege.Type.USER, true, admin));
            }
            privileges.put(command.getName(), privilege);
        }
//        for (Guild guild : acd.getJDA().getGuilds()) {
//            List<Command> commands = guild.retrieveCommands().complete();
//            Map<String, String> nameToId = new HashMap<>();
//            for (Command command : commands) {
//                nameToId.put(command.getName(), command.getId());
//            }
//            Map<String, Collection<? extends CommandPrivilege>> privilegesForGuild = new HashMap<>();
//            for (Map.Entry<String, Collection<? extends CommandPrivilege>> privilege : privileges.entrySet()) {
//                String id = nameToId.get(privilege.getKey());
//                if (id == null) continue;
//                privilegesForGuild.put(id, privilege.getValue());
//            }
//            guild.updateCommandPrivileges(privilegesForGuild).queue();
//        }

        client.addEventListener(this);
        Ambrosia.log("Started Discord Bot", Level.INFO, LoggingNames.DISCORD);
    }

    @Override
    public void onGuildMemberRoleAdd(@NotNull GuildMemberRoleAddEvent event) {
    }

    @Override
    public void onGuildMemberRoleRemove(@NotNull GuildMemberRoleRemoveEvent event) {
    }
}
