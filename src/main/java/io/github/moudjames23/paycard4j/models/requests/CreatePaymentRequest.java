package io.github.moudjames23.paycard4j.models.requests;

import io.github.moudjames23.paycard4j.enums.PaymentMethod;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest {

    private double amount;
    private String description;
    private String reference;

    private PaymentMethod paymentMethod;

    private String callbackUrl;

    private boolean autoRedirect;

    private boolean redirectWithGet;

}
