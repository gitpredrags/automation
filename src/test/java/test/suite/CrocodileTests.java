package test.suite;

import calls.CrocodileAPI;
import data.models.*;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class CrocodileTests extends TestBase {

    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

   @Test
   @Description("Public crocodile list")
   public void getListOfPublicCrocodiles() {
       GetPublicCrocodileResponse[] getPublicCrocodileResponse = CrocodileAPI.getPublicCrocodileResponse();

       crocodileAsserts.assertListOfPublicCrocodiles(getPublicCrocodileResponse);
   }


   @Test
   @Description("Public crocodile by ID test")
   public void getCrocodileById() {
       GetPublicCrocodileByIdResponse getPublicCrocodileByIdResponse = CrocodileAPI.getPublicCrocodileById();

       crocodileAsserts.assertCrocodileById(getPublicCrocodileByIdResponse);
   }

    @Test
    @Description("Login test")
    public void loginTest(){
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty");
    }

    @Test
    @Description("Private crocodile list")
    public void getListOfPrivateCrocodiles() {
        GetPrivateCrocodileResponse[] getPrivateCrocodileResponses = CrocodileAPI.getPrivateCrocodileResponses(accessToken);

        crocodileAsserts.assertListOfPrivateCrocodiles(getPrivateCrocodileResponses);
    }

    @Test
    @Description("Get private crocodile by ID test")
    public void getPrivateCrocodileById(){
       GetPrivateCrocodileByIdResponse getPrivateCrocodileByIdResponse = CrocodileAPI.getPrivateCrocodileByIdResponse(accessToken);

        crocodileAsserts.assertPrivateCrocodileById(getPrivateCrocodileByIdResponse);
    }

    @Test
    @Description("Verify crocodile is created")
    public void createCrocodileTest(){
        CreateCrocodileRequest createCrocodileRequest = new CreateCrocodileRequest("Milutin", "M", "2020-01-01");

        CreateCrocodileResponse createCrocodileResponse = CrocodileAPI.createNewCrocodile(accessToken, createCrocodileRequest);

        crocodileAsserts.assertCrocodileNewCrocodile(createCrocodileResponse, createCrocodileRequest);
    }

    @Test
    @Description("Verify that crocodile is updated")
    public void updateCrocodileTest(){
       UpdateCrocodileRequest updateCrocodileRequest = new UpdateCrocodileRequest("MIKICA","M", "1990-03-03");

       UpdateCrocodileResponse updateCrocodileResponse = CrocodileAPI.updateCrocodile(accessToken, updateCrocodileRequest);

       crocodileAsserts.assertUpdateCrocodile(updateCrocodileResponse, updateCrocodileRequest);
    }

    @Test
    @Description("Verify that name is updated")
    public void updateCrocodileNameTest(){
       UpdateNameFieldRequest updateNameFieldRequest = new UpdateNameFieldRequest("Mitrogol");

       UpdateNameFieldResponse updateNameFieldResponse = CrocodileAPI.updateNameFieldResponse(accessToken, updateNameFieldRequest);

       crocodileAsserts.assertUpdateCrocodileName(updateNameFieldResponse, updateNameFieldRequest);
    }

    @Test
    @Description("Delete crocodile")
    public void deleteCrocodile(){
       DeleteCrocodileResponse deleteCrocodileResponse = CrocodileAPI.deleteCrocodileResponse(accessToken);

       GetPrivateCrocodileResponse[] getPrivateCrocodileResponses = CrocodileAPI.getPrivateCrocodileResponses(accessToken);

       crocodileAsserts.assertDeleteCrocodile(getPrivateCrocodileResponses);
    }
}
