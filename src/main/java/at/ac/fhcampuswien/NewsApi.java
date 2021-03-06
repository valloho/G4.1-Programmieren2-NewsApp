package at.ac.fhcampuswien;

import at.ac.fhcampuswien.enums.*;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Objects;

public class NewsApi {

    private static final String everything = "https://newsapi.org/v2/everything?";
    private static final String topHeadlines = "https://newsapi.org/v2/top-headlines?";
    private static final String sources = "https://newsapi.org/v2/top-headlines/sources?";
    private static final String apiKey = "f4d4ec56134741e8a937aa730e1ca155";

    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();


    /*
    private static String getURL(Endpoint endPoint, String q, Language language, SortBy sortBy, Country country, Category category) {
        String url = "";

        switch (endPoint) {
            case SOURCES -> url = sources + "category=" + category.category + "&language=" + language.label + "&country=" + country.countrycode;

            case EVERYTHING -> url = everything + "q=" + q + "&language=" + language.label + "&sortBy=" + sortBy.sortby + "&apiKey=" + apiKey;

            case TOP_HEADLINES -> url = topHeadlines + "country=" + country.countrycode + "&category=" + category.category + "&q=" + q + "&apiKey=" + apiKey;
        }
        return url;
    }
     */

    private static NewsResponse request(String url) throws NewsAPIException {

        try {

            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            String json = Objects.requireNonNull(response.body()).string();
            return gson.fromJson(json, NewsResponse.class);
        }
        catch (UnknownHostException e) {

            client.dispatcher().executorService().shutdown();
            System.out.println("Please check your internet connectivity.");
            return null;
        }
        catch (IllegalArgumentException e) {

            System.out.println("Sorry! Invalid URL.");
            return null;
        }
        catch (JsonSyntaxException e) {

            System.out.println("Sorry! Invalid Json Syntax.");
            return null;
        }
        catch (IllegalStateException e) {

            System.out.println("Sorry! Illegal Json Statement.");
            return null;
        }
        catch (IOException e) {

            throw new NewsAPIException(e.getMessage());
        }
    }

    public static class URLBuilder {

        private final String initialURL;
        private Category category;
        private String q;
        private Language language;
        private Country country;
        private SortBy sortBy;
        private String apiKey;

        private String finalURL;

        public URLBuilder (String initialURL) {

            this.initialURL = initialURL;
            this.finalURL = initialURL;
        }

        public URLBuilder category(Category category) {

            this.category = category;
            finalURL += finalURL == initialURL ? "" : "&";
            finalURL += "category=" + category.category;
            return this;
        }
        public URLBuilder query(String q) {

            this.q = q;
            finalURL += finalURL == initialURL ? "" : "&";
            finalURL += "q=" + q;
            return this;
        }
        public URLBuilder language(Language language) {

            this.language = language;
            finalURL += finalURL == initialURL ? "" : "&";
            finalURL += "language=" + language.label;
            return this;
        }
        public URLBuilder country(Country country) {

            this.country = country;
            finalURL += finalURL == initialURL ? "" : "&";
            finalURL += "country=" + country.countrycode;
            return this;
        }
        public URLBuilder sortBy(SortBy sortBy) {

            this.sortBy = sortBy;
            finalURL += finalURL == initialURL ? "" : "&";
            finalURL += "sortBy=" + sortBy.sortby;
            return this;
        }
        public URLBuilder apiKey(String apiKey) {

            this.apiKey = apiKey;
            finalURL += finalURL == initialURL ? "" : "&";
            finalURL += "apiKey=" + apiKey;
            return this;
        }

        public String build() {

            return finalURL;
        }
    }

    public static NewsResponse getEverything(String q, Language language, SortBy sortBy) throws NewsAPIException {

        String url = new URLBuilder(everything)
                .query(q)
                .language(language)
                .sortBy(sortBy)
                .apiKey(apiKey)
                .build();

        return request(url);
    }

    public static NewsResponse getTopHeadlines(String q, Language language, Country country, Category category) throws NewsAPIException {

        String url = new URLBuilder(topHeadlines)
                .query(q)
                .language(language)
                .country(country)
                .category(category)
                .apiKey(apiKey)
                .build();

        return request(url);
    }

    public static NewsResponse getSources(Country country, Category category) throws NewsAPIException {

        String url = new URLBuilder(sources)
                .country(country)
                .category(category)
                .build();

        return request(url);
    }
}
