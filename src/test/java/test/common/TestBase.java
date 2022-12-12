package test.common;

import calls.CrocodileAPI;
import data.models.*;
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
        RestAssured.baseURI = "https://test-api.k6.io";
        accessToken = CrocodileAPI.login(new LoginRequest("PredragSebek", "test123")).getAccess();
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
