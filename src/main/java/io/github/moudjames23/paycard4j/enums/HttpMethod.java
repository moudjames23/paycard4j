package io.github.moudjames23.paycard4j.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HttpMethod {

    POST(1), GET(2);

    private final int code;
}
