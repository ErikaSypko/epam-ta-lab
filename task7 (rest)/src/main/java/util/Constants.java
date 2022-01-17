package util;

public final class Constants {
    public static final String DEFAULT_URL = "http://localhost:8080/api/library";
    public static final String AUTHOR_URL = "/author";
    public static final String AUTHOR_BY_ID_URL = "/author/%s";
    public static final String JSON_FILE_NAME = "author.json";
    public static final String JSON_UPDATED_FILE_NAME = "authorUpdate.json";
    public static final String PATH_TO_JSON_FILE = "src/test/resources/%s";

    public static final String AUTHOR_WITH_ID_ALREADY_EXISTS_MESSAGE = "Author with such 'authorId' already exists!";
    public static final String AUTHOR_TO_DELETE_NOT_FOUND_MESSAGE = "Author with 'authorId' = '%d' doesn't exist!";

    public static final String CONFLICT = "Conflict";
    public static final String NOT_FOUND = "Not Found";

}
