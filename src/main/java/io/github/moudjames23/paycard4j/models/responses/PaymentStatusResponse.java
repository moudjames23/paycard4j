package io.github.moudjames23.paycard4j.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.Nullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentStatusResponse {

    private int code;

    @JsonProperty("transaction_date")
    @Nullable
    private String transactionDate;

    private String status;

    @JsonProperty("status_description")
    private String statusDescription;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("payment_method")
    @Nullable
    private String paymentMethod;

    @JsonProperty("payment_description")
    @Nullable
    private String description;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("payment_reference")
    @Nullable
    private String paymentReference;

    @JsonProperty("payment_method_reference")
    @Nullable
    private String paymentMethodReference;

    @JsonProperty("payment_amount")
    private String amount;

    @JsonProperty("payment_amount_formatted")
    private String formattedAmount;

    @JsonProperty("ecommerce_description")
    private String eCommerceDescription;

    @JsonProperty("merchant_name")
    @Nullable
    private String merchantName;

    @Override
    public String toString() {
        return "PaymentStatusResponse{" +
                "code=" + code +
                ", transactionDate='" + transactionDate + '\'' +
                ", status='" + status + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", description='" + description + '\'' +
                ", reference='" + reference + '\'' +
                ", paymentReference='" + paymentReference + '\'' +
                ", paymentMethodReference='" + paymentMethodReference + '\'' +
                ", amount='" + amount + '\'' +
                ", merchantName='" + merchantName + '\'' +
                '}';
    }
}
