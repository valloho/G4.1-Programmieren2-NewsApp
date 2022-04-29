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
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class NewsApi
{

    private static final String everything = "https://newsapi.org/v2/everything?";
    private static final String topHeadlines = "https://newsapi.org/v2/top-headlines?";
    private static final String sources = "https://newsapi.org/v2/top-headlines/sources?";
    private static final String apiKey = "f4d4ec56134741e8a937aa730e1ca155";

    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();

    NewsApiClient newsApiClient = new NewsApiClient("f4d4ec56134741e8a937aa730e1ca155");

    private static String getURL(Endpoint endPoint, String q, Language language, SortBy sortBy, Country country, Category category)
    {
        String url = "";

        switch (endPoint)
        {
            case SOURCES -> url = sources + "category=" + category + "&language=" + language + "&country=" + country;

            case EVERYTHING -> url = everything + "q=" + q + "&language=" + language + "&sortBy=" + sortBy + "&apiKey=" + apiKey;

            case TOP_HEADLINES -> url = topHeadlines + "country=" + country + "&category=" + category + "&q=" + q + "&apiKey=" + apiKey;
        }

        return url;
    }

    private static NewsResponse request(String url)
    {
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute())
        {
            String json = response.body().string();
            return gson.fromJson(json, NewsResponse.class);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static NewsResponse getEverything(String q, Language language, SortBy sortBy)
    {
        return request(getURL(Endpoint.EVERYTHING, q, language, sortBy, null, null));
    }

    public static NewsResponse getTopHeadlines(String q, Language language, Country country, Category category)
    {
        return request(getURL(Endpoint.TOP_HEADLINES, q, language, null, country, category));
    }

    public static NewsResponse getSources(Language language, Country country, Category category)
    {
        return request(getURL(Endpoint.SOURCES, null, null, null, country, category));
    }
}
