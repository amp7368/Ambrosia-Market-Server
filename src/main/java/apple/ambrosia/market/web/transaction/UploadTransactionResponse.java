package apple.ambrosia.market.web.transaction;

import apple.ambrosia.market.web.AmbrosiaResponseCode;

public class UploadTransactionResponse {
    private AmbrosiaResponseCode code;

    public UploadTransactionResponse(AmbrosiaResponseCode code) {
        this.code = code;
    }
}

