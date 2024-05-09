package io.github.moudjames23.paycard4j.paycard;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.moudjames23.paycard4j.enums.HttpMethod;
import io.github.moudjames23.paycard4j.exceptions.PaycardGlobalException;
import io.github.moudjames23.paycard4j.models.requests.CreatePaymentRequest;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.util.HashMap;
import java.util.Map;

public class CreatePayment implements HttpRequest {

    private static final String CONTENT_TYPE = "application/json";

    private final String merchantCode;
    private final CreatePaymentRequest createPaymentRequest;

    public CreatePayment(String merchantCode, CreatePaymentRequest createPaymentRequest) {
        this.merchantCode = merchantCode;
        this.createPaymentRequest = createPaymentRequest;
    }

    @Override
    public HttpMethod method() {
        return HttpMethod.POST;
    }

    @Override
    public String uri() {
        return baseUrl().concat("/epay/create");
    }

    @Override
    public RequestBody body()  {
        RequestBody requestBody;

        Map<String, String> data = new HashMap<>();
        data.put("c", this.merchantCode);
        data.put("paycard-amount", String.valueOf(createPaymentRequest.getAmount()));

        if (createPaymentRequest.getDescription() != null)
            data.put("paycard-description", createPaymentRequest.getDescription());

        if (createPaymentRequest.getReference() != null)
            data.put("paycard-operation-reference", createPaymentRequest.getReference());

        if (createPaymentRequest.getCallbackUrl() != null)
            data.put("paycard-callback-url", createPaymentRequest.getCallbackUrl());

        data.put("paycard-auto-redirect", createPaymentRequest.isAutoRedirect() ? "on" : "off");
        data.put("paycard-redirect-with-get", createPaymentRequest.isRedirectWithGet() ? "on" : "off");

        if (createPaymentRequest.getPaymentMethod() != null)
        {
            switch (createPaymentRequest.getPaymentMethod())
            {
                case PAYCARD -> data.put("paycard-jump-to-paycard", "on");
                case CREDIT_CARD -> data.put("paycard-jump-to-cc", "on");
                case ORANGE_MONEY -> data.put("paycard-jump-to-om", "on");
                case MOMO -> data.put("paycard-jump-to-momo", "on");
            }
        }


        try {
            String json = new ObjectMapper().writeValueAsString(data);
            requestBody = RequestBody.create(json, MediaType.parse(CONTENT_TYPE));
        } catch (JsonProcessingException e) {
            throw new PaycardGlobalException("Les données fournies sont incorrectes");
        }

        return requestBody;
    }
}
