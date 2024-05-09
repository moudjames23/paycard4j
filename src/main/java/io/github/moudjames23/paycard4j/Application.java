package io.github.moudjames23.paycard4j;

import io.github.moudjames23.paycard4j.enums.PaymentMethod;
import io.github.moudjames23.paycard4j.models.requests.CreatePaymentRequest;
import io.github.moudjames23.paycard4j.paycard.Paycard;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        Paycard paycard = new Paycard("xxxxxxx");

        CreatePaymentRequest paymentRequest = CreatePaymentRequest.builder()
                .amount(50000)
                .paymentMethod(PaymentMethod.PAYCARD)
                .callbackUrl("http://www.monsite.com/api/payement/status")
                .description("Commande 23")
                .build();

       paycard.createPayment(paymentRequest);



    }
}