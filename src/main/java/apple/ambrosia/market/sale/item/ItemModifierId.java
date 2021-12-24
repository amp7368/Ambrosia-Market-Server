package apple.ambrosia.market.sale.item;

public class ItemModifierId {
    private int id;

    public ItemModifierId() {

    }

    public ItemModifierId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ItemModifierId other && other.id == this.id;
    }
}
