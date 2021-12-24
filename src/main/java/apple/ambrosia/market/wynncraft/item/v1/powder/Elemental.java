package apple.ambrosia.market.wynncraft.item.v1.powder;

import apple.utilities.util.ObjectUtilsFormatting;

import java.util.function.Function;
import java.util.function.Supplier;

public record Elemental<T>(
        T earth,
        T thunder,
        T water,
        T fire,
        T air
)  {
    public Elemental(Supplier<T> thing) {
        this(thing.get(), thing.get(), thing.get(), thing.get(), thing.get());
    }

    public <A> Elemental(A e, A t, A w, A f, A a, Function<A, T> aNew) {
        this(getApply(aNew, e), getApply(aNew, t), getApply(aNew, w), getApply(aNew, f), getApply(aNew, a));
    }

    private static <A, T> T getApply(Function<A, T> aNew, A e) {
        return ObjectUtilsFormatting.failToNull(e, aNew);
    }

}
