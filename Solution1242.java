import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class Solution1242 {

    class WebAPIService implements Callable<List<String>> {
        private String url;
        private HtmlParser htmlParser;

        WebAPIService(String url, HtmlParser htmlParser) {
            this.url = url;
            this.htmlParser = htmlParser;
        }

        @Override
        public List<String> call() {
            return this.htmlParser.getUrls(url);
        }
    }

    class VisitHistoryUrlService {
        private VisitHistoryUrlService() {
        }

        private static HashSet<String> urlVisitHistory = new HashSet<>();

        public static boolean isVisited(String url) {
            return urlVisitHistory.contains(url);
        }

        public static boolean addToVisited(String url) {
            return urlVisitHistory.add(url);
        }

        public static List<String> getVisitedUrls(){
            return new ArrayList<>(urlVisitHistory);
        }
    }

    class WebCrawler {

        private HtmlParser htmlParser;
        private ExecutorService executorService;
        private String startingUrl;

        WebCrawler(HtmlParser htmlParser, String startingUrl) {
            executorService = Executors.newCachedThreadPool();
            this.startingUrl = startingUrl;
            this.htmlParser = htmlParser;
        }

        public void setHtmlParser(HtmlParser htmlParser2) {
            this.htmlParser = htmlParser2;
        }

        public void runWebCrawler() {
            FilterUrlService filterUrlService;
            URL url;
            try {
                url = new URL(this.startingUrl);
                WebAPIService webAPIService = new WebAPIService(this.startingUrl, this.htmlParser);
                Future<List<String>> webAPIServiceFuture = executorService.submit(webAPIService);
                List<String> urls = webAPIServiceFuture.get();

                filterUrlService = new FilterUrlService(url.getHost(), urls);
                filterUrlService.filterUrls();
                List<String> filteredUrls = filterUrlService.getFilteredUrls();

                for (String entryUrl : filteredUrls) {
                    if (!VisitHistoryUrlService.isVisited(entryUrl)) {
                        VisitHistoryUrlService.addToVisited(entryUrl);
                        this.startingUrl = entryUrl;
                        runWebCrawler();
                    }
                }
            } catch (MalformedURLException | InterruptedException | ExecutionException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        WebCrawler webCrawler = new WebCrawler(htmlParser, startUrl);
        webCrawler.runWebCrawler();
        return VisitHistoryUrlService.getVisitedUrls();
    }

}