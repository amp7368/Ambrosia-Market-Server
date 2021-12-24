package apple.ambrosia.market.discord.sale;

import apple.ambrosia.market.sale.item.ItemImplBuilder;
import apple.ambrosia.market.sale.transaction.TransactionSell;
import apple.ambrosia.market.wynncraft.Wynncraft;
import apple.ambrosia.market.wynncraft.item.v1.WynnItemV1;
import apple.discord.acd.ACD;
import apple.discord.acd.gui.awd.main.AWDGui;
import apple.discord.acd.slash.base.ACDBaseCommand;
import apple.discord.acd.slash.base.ACDSlashCommand;
import apple.discord.acd.slash.options.SlashOptionDefault;
import apple.discord.acd.slash.runner.ACDSlashMethodCommand;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import org.jetbrains.annotations.Nullable;

@ACDBaseCommand(alias = "sell", description = "Mark an item that you recently sold")
public class CommandSale extends ACDSlashCommand {
    public CommandSale(ACD acd) {
        super(acd);
    }

    @ACDSlashMethodCommand
    public void sell(SlashCommandEvent event,
                     @SlashOptionDefault(
                             optionType = OptionType.STRING,
                             name = "item_name",
                             description = "The exact name of the item you are selling"
                     ) String itemName) {
        @Nullable WynnItemV1 item = Wynncraft.lookupItem(itemName);
        if (item == null) {
            event.reply(String.format("%s is not a valid item name!", itemName)).queue();
        } else {
            ItemImplBuilder itemImpl = new ItemImplBuilder(item);
            TransactionSell sell = new TransactionSell();
            AWDGui gui = new AWDGui(acd, event);
            MessageSell message = new MessageSell(gui, itemImpl, sell);
            event.reply(message.makeMessage()).queue();
        }
    }
}
