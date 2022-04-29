package at.ac.fhcampuswien;

import at.ac.fhcampuswien.enums.Language;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

public class NewsApi {

    NewsApiClient newsApiClient = new NewsApiClient("f4d4ec56134741e8a937aa730e1ca155");

    public void getTopHeadlines(String q, Language language) {
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .q(q)
                        .language(String.valueOf(language))
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
    }
}
