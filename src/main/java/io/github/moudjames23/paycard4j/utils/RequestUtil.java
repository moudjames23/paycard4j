package io.github.moudjames23.paycard4j.utils;

import io.github.moudjames23.paycard4j.enums.HttpMethod;
import io.github.moudjames23.paycard4j.exceptions.PaycardGlobalException;
import io.github.moudjames23.paycard4j.models.responses.HttpResponse;
import io.github.moudjames23.paycard4j.paycard.HttpRequest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

import static io.github.moudjames23.paycard4j.utils.JsonUtils.getObjectFromJsonString;


public class RequestUtil {

    private static final OkHttpClient httpClient = new OkHttpClient();

    private RequestUtil() {
    }

    public static <T> T performRequest(HttpRequest httpRequest, Class<T> clazz) throws IOException {
        HttpResponse execute = execute(httpRequest);

        return getObjectFromJsonString(Objects.requireNonNull(execute.getData()), clazz);
    }

    private static HttpResponse execute(HttpRequest httpRequest) {
        Request.Builder requestBuilder = createRequestBuilder(httpRequest);

        try (Response response = httpClient.newCall(requestBuilder.build()).execute()) {
            return createHttpResponse(response);
        } catch (IOException e) {
            throw new PaycardGlobalException(e.getMessage());
        }
    }

    @NotNull
    private static Request.Builder createRequestBuilder(HttpRequest httpRequest) {
        Request.Builder requestBuilder = new Request.Builder()
                .url(httpRequest.uri());

        if (httpRequest.method() == HttpMethod.POST) {
            requestBuilder.post(httpRequest.body());
        } else {
            requestBuilder.get();
        }

        return requestBuilder;
    }

    @NotNull
    private static HttpResponse createHttpResponse(Response response) throws IOException {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setStatus(response.code());
        httpResponse.setData(Objects.requireNonNull(response.body()).string());
        return httpResponse;
    }


}
