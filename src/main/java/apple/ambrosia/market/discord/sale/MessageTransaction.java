package apple.ambrosia.market.discord.sale;

import apple.ambrosia.market.sale.item.ItemImplBuilder;
import apple.ambrosia.market.wynncraft.item.v1.WynnItemV1;
import apple.ambrosia.market.wynncraft.item.v1.damage.DamagePair;
import apple.ambrosia.market.wynncraft.item.v1.powder.Elemental;
import apple.discord.acd.gui.awd.main.AWDGui;
import apple.discord.acd.gui.awd.page.AWDPageGui;
import apple.discord.acd.util.MessageFactory;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;

public abstract class MessageTransaction extends AWDPageGui<AWDGui> implements MessageFactory {
    protected ItemImplBuilder item;

    public MessageTransaction(AWDGui parent, ItemImplBuilder item) {
        super(parent);
        this.item = item;
    }

    public Message getItemIcon() {
        MessageBuilder messageBuilder = messageBuilder();

        EmbedBuilder meta = embedBuilder();
        meta.setAuthor(item.getOriginal().wynnItemMeta.name);

        EmbedBuilder damage = immutables();

        messageBuilder.setEmbeds(
                meta.build(),
                damage.build()
        );
        return messageBuilder.build();
    }

    private EmbedBuilder immutables() {
        EmbedBuilder immutable = embedBuilder();
        WynnItemV1 original = item.getOriginal();
        Elemental<DamagePair> elementalDamage = original.damage.elementalDamage;
        if (elementalDamage.air() == null) {

        }
        DamagePair damage = original.damage.damage;
        return embedBuilder();
    }
}
