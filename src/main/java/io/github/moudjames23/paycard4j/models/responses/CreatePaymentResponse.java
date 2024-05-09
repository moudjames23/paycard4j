package io.github.moudjames23.paycard4j.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePaymentResponse {



    private int code;

    @JsonProperty("payment_amount")
    private int paymentAmount;

    @JsonProperty("payment_amount_formatted")
    @Nullable
    private String paymentAmountFormatted;

    @JsonProperty("payment_description")
    private String paymentDescription;

    @JsonProperty("operation_reference")
    private String operationReference;

    @JsonProperty("payment_url")
    private String paymentUrl;

    @JsonProperty("error_message")
    @Nullable
    private String erroMessage;

    @Override
    public String toString() {
        return "CreatePaymentResponse{" +
                "code=" + code +
                ", paymentAmount=" + paymentAmount +
                ", paymentAmountFormatted='" + paymentAmountFormatted + '\'' +
                ", paymentDescription='" + paymentDescription + '\'' +
                ", operationReference='" + operationReference + '\'' +
                ", paymentUrl='" + paymentUrl + '\'' +
                ", erroMessage='" + erroMessage + '\'' +
                '}';
    }
}
