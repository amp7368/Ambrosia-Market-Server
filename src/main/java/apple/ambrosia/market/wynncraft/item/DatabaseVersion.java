package apple.ambrosia.market.wynncraft.item;

import apple.ambrosia.market.wynncraft.get.WynnItemRaw;
import apple.ambrosia.market.wynncraft.get.WynnItemV1Raw;
import apple.ambrosia.market.wynncraft.item.v1.WynnItemV1;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public record DatabaseVersion<Raw extends WynnItemRaw<Raw>, Out extends WynnItem<Out>>(int version, Class<Raw> rawClass,
                                                                                       Class<Out> outClass,
                                                                                       Function<Raw, Out> out) {
    public DatabaseVersion(int version, Class<Raw> rawClass, Class<Out> outClass, Function<Raw, Out> out) {
        this.version = version;
        this.rawClass = rawClass;
        this.outClass = outClass;
        this.out = out;
        versions.put(this.version, this);
    }

    public static Map<Integer, DatabaseVersion<?, ?>> versions = new HashMap<>();
    public static DatabaseVersion<WynnItemV1Raw, WynnItemV1> ITEM_1 = new DatabaseVersion<>(1, WynnItemV1Raw.class, WynnItemV1.class, WynnItemV1::new);

    public static DatabaseVersion<WynnItemV1Raw, WynnItemV1> getLatest() {
        return ITEM_1;
    }

    public static <Raw extends WynnItemRaw<Raw>, Out extends WynnItem<Out>> DatabaseVersion<Raw, Out> get(int ver) {
        return (DatabaseVersion<Raw, Out>) versions.get(ver);
    }

    public static Collection<DatabaseVersion<?, ?>> getVersions() {
        return new ArrayList<>(versions.values());
    }

    public Function<Raw, Out> getConstructor() {
        return out;
    }

    public Type getRawClass() {
        return rawClass;
    }

    public Type getOutClass() {
        return outClass;
    }
}
