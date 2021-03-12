package stubs;

import com.github.tomakehurst.wiremock.client.WireMock;
import headers.Headers;
import responses.GetPayoutIdResponse;
import services.Log;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;

public class GetPayoutIdStub {
    public GetPayoutIdStub () {
        String endPoint = "/api/payouts(/.{8}-.{4}-.{4}-.{4}-.{12})";

        Log.info("Stubbing GET endpoint for 'payoutId': " + endPoint);
        WireMock.stubFor(
                WireMock.get(WireMock.urlPathMatching(endPoint))
                        .withHeader(Headers.getHeaderAccept(), equalTo(Headers.getContentType()))
                        .willReturn(new GetPayoutIdResponse().getMockResponse200ForGetRequest(endPoint))
        );
    }
}
