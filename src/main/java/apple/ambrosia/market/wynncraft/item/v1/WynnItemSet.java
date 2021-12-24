package apple.ambrosia.market.wynncraft.item.v1;

public class WynnItemSet {
    private String name;

    public WynnItemSet(String name) {
        this.name = name;
    }

    public static WynnItemSet valueOf(String name) {
        return new WynnItemSet(name);
    }
}
