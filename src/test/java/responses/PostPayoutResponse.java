package responses;

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import headers.Headers;
import org.apache.http.HttpStatus;
import services.JsonObject;

public class PostPayoutResponse extends ResponseBuildLogger {
    public ResponseDefinitionBuilder getMockResponse200ForPostRequest(String endPoint) {
        String responseFile = "src/test/resources/__files/post_payout/post_payout_response.json";

        super.logBuilding("POST", responseFile, endPoint);

        return new ResponseDefinitionBuilder()
                .withStatus(HttpStatus.SC_OK)
                .withHeader(Headers.getHeaderContentType(), Headers.getContentType())
                .withJsonBody(JsonObject.getJsonObject(responseFile));
    }
}
