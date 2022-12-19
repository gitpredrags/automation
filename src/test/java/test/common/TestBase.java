package test.common;

import calls.CrocodileAPI;
import data.models.*;
import environment.ConfigSetup;
import io.restassured.RestAssured;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public String accessToken;

    public String publicID = "2";

    public String privateID = "12203162";

    public int testId;


    @BeforeClass
    public void beforeClass(){
        RestAssured.baseURI = ConfigSetup.getBaseUrl();
        accessToken = CrocodileAPI.login(new LoginRequest(ConfigSetup.getMainUser(),ConfigSetup.getDefaultPsw())).getAccess();
    }

    @BeforeClass
    public void createTestCrocodile() {
        CreateCrocodileRequest createTestCrocodileRequest = new CreateCrocodileRequest("TEST", "M", "2000-01-01");

        CreateCrocodileResponse createTestCrocodileResponse = CrocodileAPI.createNewCrocodile(accessToken, createTestCrocodileRequest);

        testId = createTestCrocodileResponse.getId();
    }

    @AfterClass
    public void afterClass() {
        DeleteTestCrocodileResponse deleteTestCrocodileResponse = CrocodileAPI.deleteTestCrocodileResponse("my/crocodiles/" + testId+  "/", accessToken);
    }
}
