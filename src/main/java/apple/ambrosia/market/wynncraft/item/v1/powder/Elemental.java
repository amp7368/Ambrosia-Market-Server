package apple.ambrosia.market.wynncraft.item.v1.powder;

import apple.utilities.util.ObjectUtilsFormatting;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public final class Elemental<T> {
    private final T earth;
    private final T thunder;
    private final T water;
    private final T fire;
    private final T air;

    public Elemental(
            T earth,
            T thunder,
            T water,
            T fire,
            T air
    ) {
        this.earth = earth;
        this.thunder = thunder;
        this.water = water;
        this.fire = fire;
        this.air = air;
    }

    public Elemental(Supplier<T> thing) {
        this(thing.get(), thing.get(), thing.get(), thing.get(), thing.get());
    }

    public <A> Elemental(A e, A t, A w, A f, A a, Function<A, T> aNew) {
        this(getApply(aNew, e), getApply(aNew, t), getApply(aNew, w), getApply(aNew, f), getApply(aNew, a));
    }

    private static <A, T> T getApply(Function<A, T> aNew, A e) {
        return ObjectUtilsFormatting.failToNull(e, aNew);
    }

    public T earth() {
        return earth;
    }

    public T thunder() {
        return thunder;
    }

    public T water() {
        return water;
    }

    public T fire() {
        return fire;
    }

    public T air() {
        return air;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Elemental) obj;
        return Objects.equals(this.earth, that.earth) &&
                Objects.equals(this.thunder, that.thunder) &&
                Objects.equals(this.water, that.water) &&
                Objects.equals(this.fire, that.fire) &&
                Objects.equals(this.air, that.air);
    }

    @Override
    public int hashCode() {
        return Objects.hash(earth, thunder, water, fire, air);
    }

    @Override
    public String toString() {
        return "Elemental[" +
                "earth=" + earth + ", " +
                "thunder=" + thunder + ", " +
                "water=" + water + ", " +
                "fire=" + fire + ", " +
                "air=" + air + ']';
    }


}
