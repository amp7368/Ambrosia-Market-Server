package apple.ambrosia.market.wynncraft.get;

import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.function.Function;

public interface DataValidation {
    @Nullable
    default <T> T prepareEnum(String data, Function<String, T> create) {
        if (data == null) return null;
        return create.apply(data.toUpperCase(Locale.ROOT).replace(" ", "_"));
    }

    @Nullable
    default <T> T prepareNormal(String data, Function<String, T> create) {
        return prepareEnum(data, create);
    }

    @Nullable
    default Integer prepareParseInt(String data) {
        return prepareParseIntS(data);
    }

    @Nullable
    static Integer prepareParseIntS(String data) {
        try {
            return Integer.parseInt(data);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
