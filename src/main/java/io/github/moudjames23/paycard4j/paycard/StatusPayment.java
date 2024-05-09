package io.github.moudjames23.paycard4j.paycard;

public class StatusPayment implements HttpRequest {

    private final String merchantCode;
    private final String reference;


    public StatusPayment(String merchantCode, String reference) {
        this.merchantCode = merchantCode;
        this.reference = reference;
    }

    @Override
    public String uri() {
        return baseUrl()
                .concat("/epay")
                .concat("/" +this.merchantCode)
                .concat("/" +this.reference)
                .concat("/status");
    }


}
