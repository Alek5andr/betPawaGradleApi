import com.fasterxml.jackson.databind.JsonNode;
import org.apache.http.HttpStatus;
import org.junit.Test;
import services.JsonObject;
import services.Log;

import static org.hamcrest.Matchers.equalTo;

public class PawaPayPayoutTest extends TestSetup {
    private String payoutId = "8917c345-4791-4285-a416-62f24b6982db";

    @Test
    public void makeDisbursementSuccessfully() {
        String jsonBodyFile = "src/test/resources/payloads/payment_data.json";
        JsonNode jsonBody = JsonObject.getJsonObject(jsonBodyFile);
        String acceptanceStatus = "ACCEPTED";

        Log.info("Making a successful disbursement & verifying its acceptance status: " + acceptanceStatus);
        requestSpecification
                .body(jsonBody)
                .when()
                .post("/payouts")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("payoutId", equalTo(payoutId))
                .and()
                .body("status", equalTo(acceptanceStatus));
    }

    @Test
    public void checkOutPayoutIdSuccessfully() {
        String paymentStatus = "COMPLETED";

        Log.info("Checking status '" + paymentStatus + "' of payment by 'payoutId': " + payoutId);
        requestSpecification
                .when()
                .get("/payouts/" + payoutId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("payoutId", equalTo(payoutId))
                .and()
                .body("status", equalTo(paymentStatus));
    }

}
