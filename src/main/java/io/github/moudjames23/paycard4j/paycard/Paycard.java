package io.github.moudjames23.paycard4j.paycard;


import io.github.moudjames23.paycard4j.exceptions.PaycardAmountException;
import io.github.moudjames23.paycard4j.exceptions.PaycardCallbackException;
import io.github.moudjames23.paycard4j.exceptions.PaycardGlobalException;
import io.github.moudjames23.paycard4j.models.requests.CreatePaymentRequest;
import io.github.moudjames23.paycard4j.models.responses.CreatePaymentResponse;
import io.github.moudjames23.paycard4j.models.responses.PaymentStatusResponse;
import io.github.moudjames23.paycard4j.utils.URLValidator;

import java.io.IOException;

import static io.github.moudjames23.paycard4j.utils.RequestUtil.performRequest;

public class Paycard {

    private final String merchantCode;

    public Paycard(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public CreatePaymentResponse createPayment(CreatePaymentRequest request) throws IOException {

        if (request.getAmount() == 0)
            throw new PaycardAmountException("Le montant est obligatoire");

        if (request.getCallbackUrl() != null && !URLValidator.isValid(request.getCallbackUrl()))
            throw  new PaycardCallbackException("L'URL du callback est incorrect");


        CreatePayment createPayment = new CreatePayment(merchantCode, request);

        CreatePaymentResponse createPaymentResponse = performRequest(createPayment, CreatePaymentResponse.class);

        if (createPaymentResponse.getCode() != 0)
            throw new PaycardGlobalException(createPaymentResponse.getErroMessage());

        return createPaymentResponse;
    }

    public PaymentStatusResponse getPaymentStatus(String reference) throws IOException {
        StatusPayment statusPayment = new StatusPayment(this.merchantCode, reference);

        PaymentStatusResponse paymentStatusResponse = performRequest(statusPayment, PaymentStatusResponse.class);

        if (paymentStatusResponse.getCode() != 0)
            throw new PaycardGlobalException(paymentStatusResponse.getErrorMessage());

        return paymentStatusResponse;
    }
}
