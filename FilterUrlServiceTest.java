import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class FilterUrlServiceTest {

    private FilterUrlService filterUrlService;
    ArrayList<String> expected = new ArrayList<>();
    @Before
    void setUp() {
        filterUrlService = new FilterUrlService("http://news.yahoo.com/news/topics/", expected);
        expected.add("http://news.yahoo.com/news");
        expected.add("http://news.google.com");
    }

    @Test(expected = MalformedURLException.class)
    public void testObjectCreation() throws MalformedURLException {
        filterUrlService.filterUrls();
    }
}
