package responses;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import headers.Headers;
import org.apache.http.HttpStatus;
import services.JsonObject;

public class GetPayoutIdResponse extends ResponseBuildLogger {
    public ResponseDefinitionBuilder getMockResponse200ForGetRequest(String endPoint) {
        String responseFile = "src/test/resources/__files/get_payoutId_response.json";

        super.logBuilding("GET", responseFile, endPoint);

        return new ResponseDefinitionBuilder()
                .withStatus(HttpStatus.SC_OK)
                .withHeader(Headers.getHeaderContentType(), Headers.getContentType())
                .withJsonBody(JsonObject.getJsonObject(responseFile));
    }
}
