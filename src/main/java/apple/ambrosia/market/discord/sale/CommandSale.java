package apple.ambrosia.market.discord.sale;

import apple.ambrosia.market.image.ImageAnalysis;
import apple.discord.acd.ACD;
import apple.discord.acd.slash.base.ACDBaseCommand;
import apple.discord.acd.slash.base.ACDSlashCommand;
import apple.discord.acd.slash.options.SlashOptionDefault;
import apple.discord.acd.slash.runner.ACDSlashMethodCommand;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.sourceforge.tess4j.TesseractException;

import java.util.UUID;

@ACDBaseCommand(alias = "sell", description = "Mark an item that you recently sold")
public class CommandSale extends ACDSlashCommand {
    public CommandSale(ACD acd) {
        super(acd);
    }

    @ACDSlashMethodCommand
    public void sell(SlashCommandEvent event,
//                     @SlashOptionDefault(
//                             optionType = OptionType.STRING,
//                             name = "item_name",
//                             description = "The exact name of the item you are selling"
//                     ) String itemName,
                     @SlashOptionDefault(
                             optionType = OptionType.STRING,
                             name = "img_uuid",
                             description = "The uuid of the image"
                     ) String image
    ) {
        try {
            ImageAnalysis.get().imageAnalysis(UUID.fromString(image));
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        event.reply("whoa").queue();
//        @Nullable WynnItemV1 item = Wynncraft.lookupItem(itemName);
//        if (item == null) {
//            event.reply(String.format("%s is not a valid item name!", itemName)).queue();
//        } else {
//            ItemImplBuilder itemImpl = new ItemImplBuilder(item);
//            TransactionSell sell = new TransactionSell();
//            AWDGui gui = new AWDGui(acd, event);
//            MessageSell message = new MessageSell(gui, itemImpl, sell);
//        }

    }
}
