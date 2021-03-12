import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import headers.Headers;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.*;
import org.wiremock.webhooks.Webhooks;
import services.Log;
import stubs.GetPayoutIdStub;
import stubs.PostPayoutStub;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class TestSetup {
    private static final int PORT = 8089;
    private static final String HOST = "localhost";
    private static WireMockServer wireMockServer = new WireMockServer(options().bindAddress(HOST).port(PORT).extensions(new Webhooks()));
    static RequestSpecification requestSpecification = RestAssured.given()
            .headers(Headers.getRestAssuredRequestHeaders())
            .baseUri("http://" + HOST + ":" + PORT + "/api");

    @BeforeClass
    public static void setup () {
        Log.info("===== Starting WireMock server =====");
        wireMockServer.start();
        WireMock.configureFor(HOST, PORT);
        Log.info("===== WireMock server has started =====\n");

        Log.info("===== Stubbing WireMock server =====");
        new PostPayoutStub();
        new GetPayoutIdStub();
        Log.info("===== Stubbing WireMock server is completed =====\n");
    }

    @Before
    public void setupTest() {
        Log.info("=== Start of a test ===");
    }

    @After
    public void teardownTest() {
        Log.info("=== End of a test ===\n");
    }

    @AfterClass
    public static void tearDown() {
        if (wireMockServer != null && wireMockServer.isRunning()) {
            Log.info("Shutting down WireMock server");
            wireMockServer.shutdownServer();
        }}
}
