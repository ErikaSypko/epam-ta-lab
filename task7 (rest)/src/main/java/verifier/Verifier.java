package verifier;

import service.AuthorService;
import org.junit.Assert;

public class Verifier {

    public Verifier checkThatStatusCodeEqualsResponse(int code) {
        Assert.assertEquals(AuthorService.getStatusCode(), code);
        return this;
    }

    public <T> void checkThatResponseEqualsObject(T obj) {
        Assert.assertEquals(AuthorService.extractResponseAsObject(obj.getClass()), obj);
    }

    public Verifier checkResponseBodyAttributeValue(String expectedMsg, String msg) {
        Assert.assertEquals(expectedMsg, AuthorService.extractResponseAttributeValue(msg));
        return this;
    }


}
