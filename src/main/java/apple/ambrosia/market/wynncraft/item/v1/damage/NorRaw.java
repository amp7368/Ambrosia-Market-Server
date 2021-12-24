package apple.ambrosia.market.wynncraft.item.v1.damage;

import apple.utilities.util.ObjectUtilsFormatting;

import java.util.function.Function;

public record NorRaw<T>(T normal, T raw) {
    public <A> NorRaw(A n, A r, Function<A, T> converter) {
        this(getApply(converter, n), getApply(converter, r));
    }

    private static <A, T> T getApply(Function<A, T> aNew, A e) {
        return ObjectUtilsFormatting.failToNull(e, aNew);
    }
}
