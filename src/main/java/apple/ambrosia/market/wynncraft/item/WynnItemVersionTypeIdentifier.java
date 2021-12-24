package apple.ambrosia.market.wynncraft.item;

import apple.ambrosia.market.wynncraft.get.WynnItemV1Raw;
import apple.ambrosia.market.wynncraft.item.v1.WynnItemV1;
import apple.utilities.json.gson.GsonTypeAdapterMapper;
import apple.utilities.json.gson.GsonTypeAdapterSerialization;

public enum WynnItemVersionTypeIdentifier implements GsonTypeAdapterSerialization<WynnItem> {
    V1(DatabaseVersion.ITEM_1);

    private final int version;
    private final Class<? extends WynnItem> typeClass;

    WynnItemVersionTypeIdentifier(DatabaseVersion<WynnItemV1Raw, WynnItemV1> version) {
        this.version = version.version();
        this.typeClass = version.outClass();
    }

    public static GsonTypeAdapterMapper<WynnItem, WynnItemVersionTypeIdentifier> createTypeMapper() {
        return GsonTypeAdapterMapper.create(values(), WynnItem.class);
    }

    @Override
    public String getTypeId() {
        return String.valueOf(version);
    }

    @Override
    public Class<? extends WynnItem> getTypeClass() {
        return typeClass;
    }
}
