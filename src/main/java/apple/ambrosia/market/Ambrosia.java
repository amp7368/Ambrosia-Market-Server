package apple.ambrosia.market;

import apple.ambrosia.market.logging.ErrorLogger;
import apple.ambrosia.market.logging.LoggingNames;
import apple.utilities.logging.AppleLoggerManager;
import apple.utilities.logging.AppleLoggerName;
import apple.utilities.util.ArrayUtils;
import apple.utilities.util.FileFormatting;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.boot.SpringApplication;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ambrosia {
    private static final AppleLoggerManager LOGGER;

    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("--yy.MM.dd--hh'h'mm'm'");
        String dateString = dateFormat.format(new Date());
        System.setProperty("logFile.version", dateString);
        System.setProperty("logFile.shouldAppend", String.valueOf(true));
        System.setProperty("logFile.homeDir", FileFormatting.getDBFolder(Ambrosia.class).getAbsolutePath());
        LOGGER = new AppleLoggerManager(
                ArrayUtils.combine(LoggingNames.values(), new ErrorLogger(), AppleLoggerName[]::new),
                LoggerFactory.getLogger("ambrosia")
        );
    }

    public static void main(String[] args) throws InterruptedException, IOException, LoginException {
//        Wynncraft.load();
        log("Starting web server", Level.INFO);
        SpringApplication spring = new SpringApplication(SpringMain.class);
        spring.run(args);
        log("Started web server", Level.INFO, LoggingNames.WEB);
//        DiscordConfig.load();
//        new DiscordBot();
    }

    public static void log(String msg, Level lvl, LoggingNames... loggerName) {
        System.out.println(msg);
        LOGGER.log(msg, lvl, loggerName);
    }

    public static File getDataFolder() {
        File dbFolder = FileFormatting.getDBFolder(Ambrosia.class);
        dbFolder.mkdirs();
        return dbFolder;
    }
}
