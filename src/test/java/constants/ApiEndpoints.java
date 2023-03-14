package constants;

public class ApiEndpoints {

    //public
    public static final String USERS = "public/crocodiles/";
    public static String SINGLE_USER (String id) {
        return USERS + id + "/";
    }
    //authorization
    public static final String AUTHORIZATION = "/auth/token/login/";
    //private
    public static final String PRIVATE_USERS = "my/crocodiles/";
    public static String GET_PRIVATE_USER (String id) {
        return PRIVATE_USERS + id + "/";
    }

    //activities
    public static final String ACTIVITIES = "api/v1/Activities/";

    public static String SINGLE_ACTIVITY (String id) {return ACTIVITIES + id + "/";}
}

