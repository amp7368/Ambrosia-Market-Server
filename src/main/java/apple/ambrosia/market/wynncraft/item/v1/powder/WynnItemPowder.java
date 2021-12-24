package apple.ambrosia.market.wynncraft.item.v1.powder;

import apple.ambrosia.market.wynncraft.get.WynnItemV1Raw;

public class WynnItemPowder {
    public int sockets;

    public WynnItemPowder(WynnItemV1Raw raw) {
        this.sockets = Integer.parseInt(raw.sockets);
    }
}
