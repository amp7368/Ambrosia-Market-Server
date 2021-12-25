package apple.ambrosia.market.image;

import apple.ambrosia.market.Ambrosia;
import net.dv8tion.jda.api.entities.Message;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.util.UUID;

public class ImageAnalysis {
    private static ImageAnalysis instance = new ImageAnalysis();
    private final Tesseract tesseract = new Tesseract();

    public ImageAnalysis() {
        tesseract.setDatapath(getImageFolder().getAbsolutePath());
        tesseract.setLanguage("eng");
        tesseract.setPageSegMode(1);
    }

    public static ImageAnalysis get() {
        return instance;
    }

    public UUID download(Message.Attachment attachment) {
        UUID uuid = UUID.randomUUID();
        attachment.downloadToFile(getImageFile(uuid));
        return uuid;
    }

    private File getImageFile(UUID uuid) {
        return new File(getImageFolder(), uuid.toString() + ".png");
    }

    private File getDataFolder() {
        File file = new File(Ambrosia.getDataFolder(), "image");
        file.mkdirs();
        return file;
    }

    private File getImageFolder() {
        File file = new File(getDataFolder(), "files");
        file.mkdirs();
        return file;
    }

    public void imageAnalysis(UUID image) throws TesseractException {
        System.out.println(tesseract.doOCR(getImageFile(image)));
    }
}
