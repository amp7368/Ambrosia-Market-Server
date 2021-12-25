package apple.ambrosia.market.web.transaction;

import apple.ambrosia.market.web.AmbrosiaResponseCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController()
public class WebImagePost {
    @PostMapping(value = "/ambrosia/transaction/submit",
            consumes = MediaType.IMAGE_PNG_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UploadTransactionResponse submit(@RequestParam(value = "password") String password,
                                            @RequestParam(value = "image") MultipartFile image,
                                            @RequestParam(value = "item") AtlasItemUpload item) {
        return new UploadTransactionResponse(
                AmbrosiaResponseCode.SUCCESS
        );
    }
}
