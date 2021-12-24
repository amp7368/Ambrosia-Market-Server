package apple.ambrosia.market.wynncraft.get;

import apple.ambrosia.market.wynncraft.item.DatabaseVersion;
import apple.ambrosia.market.wynncraft.item.WynnItem;
import apple.ambrosia.market.wynncraft.item.WynnItemVersionTypeIdentifier;
import apple.utilities.json.gson.GsonTypeAdapterMapper;
import apple.utilities.json.gson.GsonTypeAdapterSerialization;

public enum WynnItemRawVersionTypeIdentifier implements GsonTypeAdapterSerialization<WynnItemRaw> {
    V1(DatabaseVersion.ITEM_1.version(), WynnItemV1Raw.class);

    private final int version;
    private final Class<? extends WynnItemRaw> typeClass;

    WynnItemRawVersionTypeIdentifier(int version, Class<? extends WynnItemRaw<?>> typeClass) {
        this.version = version;
        this.typeClass = typeClass;
    }

    public static GsonTypeAdapterMapper<WynnItemRaw, WynnItemRawVersionTypeIdentifier> createTypeMapper() {
        return GsonTypeAdapterMapper.create(values(), WynnItemRaw.class);
    }

    @Override
    public String getTypeId() {
        return String.valueOf(version);
    }

    @Override
    public Class<? extends WynnItemRaw> getTypeClass() {
        return typeClass;
    }
}