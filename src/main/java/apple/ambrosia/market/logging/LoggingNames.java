package apple.ambrosia.market.logging;

import apple.utilities.logging.AppleLoggerName;

public enum LoggingNames implements AppleLoggerName {
    ALL("all"),
    AMBROSIA("ambrosia"),
    WYNN("wynn"),
    DISCORD("discord"),
    DAEMON("daemon"),
    FAILURE("failure");

    private final String name;

    LoggingNames(String name) {
        this.name = name;
    }

    @Override
    public String getLoggerName() {
        return name;
    }
}
