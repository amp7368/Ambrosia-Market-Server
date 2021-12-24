package apple.ambrosia.market.util;

import apple.utilities.request.AppleRequestService;

public class FileIOServiceNow extends AppleRequestService {
    private static final FileIOServiceNow instance = new FileIOServiceNow();

    public static FileIOServiceNow get() {
        return instance;
    }

    @Override
    public int getRequestsPerTimeUnit() {
        return 10;
    }

    @Override
    public int getTimeUnitMillis() {
        return 0;
    }

    @Override
    public int getSafeGuardBuffer() {
        return 0;
    }
}
