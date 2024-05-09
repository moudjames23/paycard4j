package io.github.moudjames23.paycard4j.models.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class HttpResponse {

    private int status;
    private String data;
}
