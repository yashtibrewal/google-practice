
public class Solution1242Test {
    
    public static void main(String[] args) throws Exception {
        Solution1242 solution2128 = new Solution1242();
        HtmlParserImpl htmlParserImpl = new HtmlParserImpl();
        solution2128.crawl("http://news.yahoo.com/news/topics/", htmlParserImpl);
    }
}
