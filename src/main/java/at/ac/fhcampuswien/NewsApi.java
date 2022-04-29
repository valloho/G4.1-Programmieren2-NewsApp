package at.ac.fhcampuswien;

import at.ac.fhcampuswien.enums.*;
import com.google.gson.Gson;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.request.SourcesRequest;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.models.response.SourcesResponse;
import okhttp3.OkHttpClient;

public class NewsApi {

    private static final String everything = "https://newsapi.org/v2/everything?";
    private static final String topHeadlines = "https://newsapi.org/v2/top-headlines?";
    private static final String sources = "https://newsapi.org/v2/top-headlines/sources?";
    private static final String apiKey = "f4d4ec56134741e8a937aa730e1ca155";

    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    NewsApiClient newsApiClient = new NewsApiClient("f4d4ec56134741e8a937aa730e1ca155");

    public String getURL(Endpoint endPoint, String q, Language language, SortBy sortBy, Country country, Category category)
    {
        String url = "";

        switch (endPoint)
        {
            case SOURCES -> url = sources + "category=" + category + "&language=" + language + "&country=" + country;

            case EVERYTHING -> url = everything + "q=" + q + "&language=" + language + "&sortBy=" + sortBy + "&apiKey=" + apiKey;

            case TOP_HEADLINES -> url = topHeadlines + "country="+ country + "&category=" + category + "&q=" + q + "&apiKey=" + apiKey;
        }

        return url;
    }

    public NewsResponse everyThing(String q, Language language, SortBy sortBy)
    {
        // /v2/everything
        newsApiClient.getEverything(
                new EverythingRequest.Builder()
                        .q(q)
                        .language(language.label)
                        .sortBy(sortBy.sortby)
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        System.out.println(response.getArticles().get(0).getTitle());

                        String json = response.getArticles().toString();

                        System.out.println(json);

                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );

        return null;
    }

    public NewsResponse getTopHeadlines(String q, Language language, Country country, Category category)
    {
        // /v2/top-headlines
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .q(q)
                        .language(language.label)
                        .category(category.category)
                        .country(country.countrycode)
                        .build(),

                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        System.out.println(response.getArticles().get(0).getTitle());
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
        return null;
    }

    public NewsResponse getSources(Language language, Country country, Category category)
    {
        // /v2/top-headlines/sources
        newsApiClient.getSources(
                new SourcesRequest.Builder()
                        .language(language.label)
                        .country(country.countrycode)
                        .category(category.category)
                        .build(),
                new NewsApiClient.SourcesCallback() {
                    @Override
                    public void onSuccess(SourcesResponse response) {
                        System.out.println(response.getSources().get(0).getName());
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );

        return null;
    }
}
