package stubs;

import com.github.tomakehurst.wiremock.client.WireMock;
import responses.GetPayoutIdResponse;
import services.Log;

public class GetPayoutIdStub {
    public GetPayoutIdStub () {
        String endPoint = "/api/payouts(/.{8}-.{4}-.{4}-.{4}-.{12})";

        Log.info("Stubbing GET endpoint for 'payoutId': " + endPoint);
        WireMock.stubFor(
                WireMock.get(WireMock.urlPathMatching(endPoint))
                        .willReturn(new GetPayoutIdResponse().getMockResponse200ForGetRequest(endPoint))
        );
    }
}
