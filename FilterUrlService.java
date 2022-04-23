import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FilterUrlService {
    private List<String> filteredUrls;
    private List<String> allUrls;
    private String hostname;

    FilterUrlService(String hostname, List<String> urls) {
        this.hostname = hostname;
        this.filteredUrls = new ArrayList<>();
        this.allUrls = new ArrayList<>(urls);
    }

    public void filterUrls() throws MalformedURLException {
        URL url;
        for (String entry : this.allUrls) {
            url = new URL(entry);
            if (url.getHost().equals(hostname)) {
                filteredUrls.add(entry);
            }
        }
    }

    public List<String> getFilteredUrls() {
        return this.filteredUrls;
    }
}
