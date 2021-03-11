package stubs;

import com.github.tomakehurst.wiremock.client.WireMock;
import headers.Headers;
import responses.PostPayoutResponse;
import services.JsonObject;
import services.Log;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;

public class PostPayoutStub {
    public PostPayoutStub () {
        String endPoint = "/api/payouts";
        String postRequestMatcherFile = "src/test/resources/__files/post_payout/post_payout_request_matcher.json";

        Log.info("Stubbing POST endpoint for a disbursement': " + endPoint);
        WireMock.stubFor(
                WireMock.post(WireMock.urlPathMatching(endPoint))
                        .withHeader(Headers.getHeaderContentType(), equalTo(Headers.getContentType()))
                        .withRequestBody(equalToJson(JsonObject.convertJsonObjectToStringFromFile(postRequestMatcherFile), true, false))
                        .willReturn(new PostPayoutResponse().getMockResponse200ForPostRequest(endPoint))
        );
    }
}
