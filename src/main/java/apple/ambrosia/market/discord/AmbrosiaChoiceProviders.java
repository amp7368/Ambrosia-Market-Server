package apple.ambrosia.market.discord;

import apple.ambrosia.market.sale.item.ItemImplBuilder;
import apple.ambrosia.market.sale.item.ItemSaleBuilder;
import apple.ambrosia.market.wynncraft.Wynncraft;
import apple.discord.acd.ACD;
import apple.utilities.util.ObjectUtilsFormatting;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.Nullable;

public class AmbrosiaChoiceProviders {
    public static void addProviders(ACD acd) {
        acd.getChoiceProviders().add("item_name", ItemImplBuilder.class,
                AmbrosiaChoiceProviders::convertItemName);
    }

    private static @Nullable ItemImplBuilder convertItemName(SlashCommandEvent event, @Nullable OptionMapping optionMapping) {
        return ObjectUtilsFormatting.failToNull(optionMapping, o -> Wynncraft.lookupItem(o.getAsString()), ItemImplBuilder::new);
    }
}
