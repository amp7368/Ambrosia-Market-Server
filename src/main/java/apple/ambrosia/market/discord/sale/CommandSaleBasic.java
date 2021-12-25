package apple.ambrosia.market.discord.sale;

import apple.ambrosia.market.image.ImageAnalysis;
import apple.discord.acd.ACD;
import apple.discord.acd.command.ACDCommand;
import apple.discord.acd.command.DiscordCommandAlias;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.UUID;

public class CommandSaleBasic extends ACDCommand {
    public CommandSaleBasic(ACD acd) {
        super(acd);
    }

    @DiscordCommandAlias(alias = "image")
    public void sale(MessageReceivedEvent event) {
        List<Message.Attachment> attachments = event.getMessage().getAttachments();
        for (Message.Attachment attachment : attachments) {
            if (attachment.isImage()) {
                UUID uuid = ImageAnalysis.get().download(attachment);
                event.getChannel().sendMessage(String.format("The uuid for the above file is ' %s '", uuid)).queue();
            }
        }
    }
}
