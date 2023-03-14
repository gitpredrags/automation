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

    //authors
    public static final String AUTHORS = "api/v1/Authors/";

    public static String SINGLE_BOOK (String id) {return AUTHORS + "authors/books/" + id;}

    public static String SINGLE_AUTHOR (String id) {return AUTHORS + id + "/";}

    //books
    public static final String BOOKS = "api/v1/Books/";

    public static String BOOK (String id) {return BOOKS + id + "/";}
}

