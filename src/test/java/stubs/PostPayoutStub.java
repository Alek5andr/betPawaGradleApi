package stubs;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.RequestMethod;
import headers.Headers;
import responses.PostPayoutResponse;
import services.JsonObject;
import services.Log;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static org.wiremock.webhooks.Webhooks.webhook;

public class PostPayoutStub {
    public PostPayoutStub () {
        String endPoint = "/api/payouts";
        String filePath = "src/test/resources/__files";
        String postRequestMatcherFile = filePath +"/post_payout/post_payout_request_matcher.json";

        Log.info("Stubbing POST endpoint for a disbursement': " + endPoint);
        WireMock.stubFor(
                WireMock.post(WireMock.urlPathMatching(endPoint))
                        .withHeader(Headers.getHeaderContentType(), equalTo(Headers.getContentTypeWithCharset()))
                        .withRequestBody(equalToJson(JsonObject.convertJsonObjectToStringFromFile(postRequestMatcherFile), true, false))
                        .willReturn(new PostPayoutResponse().getMockResponse200ForPostRequest(endPoint))
                        .withPostServeAction("webhook", webhook()
                                .withMethod(RequestMethod.POST)
                                .withUrl(endPoint + "/subscribe")
                                .withHeaders(Headers.getPostCallbackHeaders())
                                .withBody(filePath + "post_subscribe_request.json")
                        )
        );
    }
}
