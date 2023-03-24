package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.common.EmptyResponse;
import data.models.coverPhotos.CoverPhotosRequest;
import data.models.coverPhotos.CoverPhotosResponse;
import test.common.TestBaseCoverPhotos;

public class CoverPhotosAPI extends TestBaseCoverPhotos {

    public static CoverPhotosResponse[] getCoverPhotos() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.COVER_PHOTOS), CoverPhotosResponse[].class);
    }

    public static CoverPhotosResponse createPhotoCoverResponse (CoverPhotosRequest createPhotoCoverRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.COVER_PHOTOS,createPhotoCoverRequest), CoverPhotosResponse.class);
    }

    public static CoverPhotosResponse getCoverPhotoById (String id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_COVER_PHOTO(id)), CoverPhotosResponse.class);
    }

    public static CoverPhotosResponse updateCoverPhotoResponse (String id, CoverPhotosRequest updateCoverPhotoRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.putActivities(ApiEndpoints.SINGLE_COVER_PHOTO(id), updateCoverPhotoRequest), CoverPhotosResponse.class);
    }

    public static EmptyResponse deleteCoverPhotoResponse (String id) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.deleteActivity(ApiEndpoints.SINGLE_COVER_PHOTO(id)), EmptyResponse.class);
    }
}
