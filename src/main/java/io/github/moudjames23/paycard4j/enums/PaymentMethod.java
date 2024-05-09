package io.github.moudjames23.paycard4j.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentMethod {


    ORANGE_MONEY(1),
    MOMO(2),
    CREDIT_CARD(3),
    PAYCARD(4);

    private final int code;
}
