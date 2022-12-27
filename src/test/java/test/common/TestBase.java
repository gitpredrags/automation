package test.common;

import calls.CrocodileAPI;
import data.models.*;
import environment.ConfigSetup;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public String accessToken;

    public String publicID = "2";

    public static String testId;


    @BeforeClass
    public void beforeClass(){
        RestAssured.baseURI = ConfigSetup.getBaseUrl();
        accessToken = CrocodileAPI.login(new LoginRequest(ConfigSetup.getMainUser(), ConfigSetup.getDefaultPsw())).getAccess();
    }

}
