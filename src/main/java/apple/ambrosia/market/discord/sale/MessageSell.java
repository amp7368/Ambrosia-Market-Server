package apple.ambrosia.market.discord.sale;

import apple.ambrosia.market.sale.item.ItemImplBuilder;
import apple.ambrosia.market.sale.transaction.TransactionSell;
import apple.discord.acd.gui.awd.main.AWDGui;
import net.dv8tion.jda.api.entities.Message;

public class MessageSell extends MessageTransaction {
    public MessageSell(AWDGui parent, ItemImplBuilder itemImpl, TransactionSell sell) {
        super(parent, itemImpl);
    }

    @Override
    protected Message makeMessage() {
        return null;
    }
}
