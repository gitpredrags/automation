package test.common;

import environment.ConfigSetup;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBaseUsers {

    @BeforeClass
    public void beforeClassRest() {
        RestAssured.baseURI = ConfigSetup.getBaseUrlRest();
    }
}
