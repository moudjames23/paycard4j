package io.github.moudjames23.paycard4j.paycard;

import io.github.moudjames23.paycard4j.enums.HttpMethod;
import okhttp3.RequestBody;

public interface HttpRequest {

    default String baseUrl()
    {
        return "https://mapaycard.com";
    }

    default RequestBody body()
    {
        return null;
    }

    default HttpMethod method()
    {
        return  HttpMethod.GET;
    }

    default String uri() {
        return "";
    }
}
