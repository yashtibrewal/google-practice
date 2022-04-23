package solved.medium;
import java.util.HashMap;

public class Codec {

    HashMap<String, String> encodedUrlStore;
    HashMap<String, String> decodedUrlStore;
    String base;

    Codec() {
        encodedUrlStore = new HashMap<String, String>();
        decodedUrlStore = new HashMap<String, String>();
        base = "http://tinyurl.com/";
    }

    // Sample http://tinyurl.com/4e9iAk
    // Sample "https://leetcode.com/problems/design-tinyurl"
    private String getShortUrl(String url) {
        long time = System.currentTimeMillis();
        return base + time;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (encodedUrlStore.containsKey(longUrl)) {
            return encodedUrlStore.get(longUrl);
        } else {
            String result = getShortUrl(longUrl);
            encodedUrlStore.put(longUrl, result);
            encodedUrlStore.put(result, longUrl);
            return result;
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        // Assumption, it has been encoded before
        return encodedUrlStore.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

class Solution535 {
    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";
        Codec obj = new Codec();
        String tiny = obj.encode(url); // returns the encoded tiny url.
        System.out.println(tiny);
        String ans = obj.decode(tiny); // returns the original url after deconding it.
        System.out.println(ans);
    }
}