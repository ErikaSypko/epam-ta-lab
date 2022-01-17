package util;

import model.Author;
import model.Birth;
import model.Name;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser {
    private static Author author = new Author();

    public static Author convertToAuthor(String fileName) {
        JSONParser jsonParser = new JSONParser();
        Author author = new Author();

        try (FileReader reader = new FileReader(String.format(Constants.PATH_TO_JSON_FILE, fileName))) {
            Object obj = jsonParser.parse(reader);
            JSONObject authorObj = (JSONObject) obj;
            author = parseAuthorObject(authorObj);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return author;
    }

    private static Author parseAuthorObject(JSONObject jsonObject) {
        JSONObject authorName = (JSONObject) jsonObject.get("authorName");
        JSONObject birth = (JSONObject) jsonObject.get("birth");

        author.setAuthorId((long) Integer.parseInt(jsonObject.get("authorId").toString()));
        author.setAuthorName(new Name(String.valueOf(authorName.get("first")),
                String.valueOf(authorName.get("second"))));
        author.setNationality(jsonObject.get("nationality").toString());
        author.setBirth(new Birth(String.valueOf(birth.get("date")),
                String.valueOf(birth.get("country")), String.valueOf(birth.get("city"))));
        author.setAuthorDescription(jsonObject.get("authorDescription").toString());
        return author;
    }
}
