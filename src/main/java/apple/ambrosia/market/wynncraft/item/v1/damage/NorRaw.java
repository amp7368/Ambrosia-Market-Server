package apple.ambrosia.market.wynncraft.item.v1.damage;

import apple.utilities.util.ObjectUtilsFormatting;

import java.util.Objects;
import java.util.function.Function;

public final class NorRaw<T> {
    private final T normal;
    private final T raw;

    public NorRaw(T normal, T raw) {
        this.normal = normal;
        this.raw = raw;
    }

    public <A> NorRaw(A n, A r, Function<A, T> converter) {
        this(getApply(converter, n), getApply(converter, r));
    }

    private static <A, T> T getApply(Function<A, T> aNew, A e) {
        return ObjectUtilsFormatting.failToNull(e, aNew);
    }

    public T normal() {
        return normal;
    }

    public T raw() {
        return raw;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (NorRaw) obj;
        return Objects.equals(this.normal, that.normal) &&
                Objects.equals(this.raw, that.raw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(normal, raw);
    }

    @Override
    public String toString() {
        return "NorRaw[" +
                "normal=" + normal + ", " +
                "raw=" + raw + ']';
    }

}
