package apple.ambrosia.market.sale;

import apple.ambrosia.market.Ambrosia;
import apple.utilities.util.FileFormatting;
import net.sourceforge.tess4j.Tesseract;

import java.io.File;

public class Sales implements FileFormatting {
    private static Sales instance = new Sales();

    public static Sales get() {
        return instance;
    }

    public File getDataFolder() {
        File sale = new File(Ambrosia.getDataFolder(), "sale");
        sale.mkdirs();
        return sale;
    }

    public File file(String... path) {
        return fileWithChildrenI(getDataFolder(), path);
    }


}
