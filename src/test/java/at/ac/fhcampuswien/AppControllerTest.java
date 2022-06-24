package at.ac.fhcampuswien;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;


public class AppControllerTest
{

    /**
     * Test if article count is 3 when there are 3 articles
     */
    @Test
    public void getArticleCountTest1()
    {
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < 3; i++)
        {
            articles.add(new Article("bob", "bob's adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        }

        AppController.getInstance().setArticles(articles);

        assertEquals(3, AppController.getInstance().getArticleCount());
    }

    /**
     * Test if article count is 6 when there are 6 articles
     */
    @Test
    public void getArticleCountTest2()
    {
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < 6; i++)
        {
            articles.add(new Article("bob", "bob's adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        }

        AppController.getInstance().setArticles(articles);

        assertEquals(6, AppController.getInstance().getArticleCount());
    }

    /**
     * Test if article count is 0 when null
     */
    @Test
    public void getArticleCountTest3()
    {
        AppController.getInstance().setArticles(null);

        assertEquals(0, AppController.getInstance().getArticleCount());
    }

    @Test
    public void setArticleTest1(){

        AppController.getInstance().setArticles(null);

        assertNull(AppController.getInstance().getArticles());

    }

    @Test
    public void setArticleTest2(){

        List<Article> articleList = new ArrayList<Article>();
        articleList.add(new Article("bobby", "bobby's great adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("boberts", "boberts' amazing adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        AppController.getInstance().setArticles(articleList);

        assertEquals(articleList, AppController.getInstance().getArticles());

    }

    @Test
    public void setArticleTest3(){

        List<Article> articleList = new ArrayList<Article>();
        articleList.add(new Article("bobby", "bobby's great adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("boberts", "boberts' amazing adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("bobbie", "bobbie's shining adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("bubba", "bubba's shrimp company", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("brobob", "brobob's confusing adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        AppController.getInstance().setArticles(articleList);

        assertEquals(articleList, AppController.getInstance().getArticles());

    }

    @Test
    public void getTopHeadlinesAustria1(){

        AppController.getInstance().getTopHeadLinesAustria();

        assertNull(AppController.getInstance().getArticles());
    }

    @Test
    public void getTopHeadlinesAustria2(){

        List<Article> articleList = new ArrayList<Article>();
        articleList.add(new Article("bobby", "bobby's great adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("boberts", "boberts' amazing adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("bobbie", "bobbie's shining adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        AppController.getInstance().setArticles(articleList);

        assertEquals(articleList, AppController.getInstance().getTopHeadLinesAustria());

    }

    @Test
    public void getAllNewsBitcoin1(){
        AppController.getInstance().setArticles(null);

        assertNull(AppController.getInstance().getAllNewsBitcoin());
    }

    @Test
    public void getAllNewsBitcoin2(){
        List<Article> articleList = new ArrayList<Article>();
        articleList.add(new Article("bobby", "bobby's great adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("boberts", "boberts' amazing adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("boberts", "babbe's amazing adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        AppController.getInstance().setArticles(articleList);

        assertNull(AppController.getInstance().getAllNewsBitcoin());
    }

    @Test
    public void getAllNewsBitcoin3(){
        List<Article> articleList = new ArrayList<Article>();
        articleList.add(new Article("bobby", "bobby's great adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("boberts", "boberts' amazing adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("boberts", "bitcoin's amazing adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        AppController.getInstance().setArticles(articleList);

        assertEquals(AppController.getInstance().filterList("bitcoin", articleList), AppController.getInstance().getAllNewsBitcoin());
    }

    @Test
    public void filterListTest1(){

        List<Article> articleList = new ArrayList<Article>();
        articleList.add(new Article("bobby", "bobby's great adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("boberts", "boberts' amazing adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        AppController.getInstance().setArticles(articleList);

        assertEquals(articleList.get(0), AppController.getInstance().filterList("bobby", articleList).get(0));
    }

    @Test
    public void filterListTest2(){

        List<Article> articleList = new ArrayList<Article>();
        articleList.add(new Article("bobby", "bobby's great adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("bobby", "bobby's amazing adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("bobby", "bobby's amazing adventure 2", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        AppController.getInstance().setArticles(articleList);

        assertEquals(articleList, AppController.getInstance().filterList("bobby", articleList));
    }

    @Test
    public void filterListTest3(){

        List<Article> articleList = new ArrayList<Article>();
        articleList.add(new Article("bobby", "bobby's great adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        articleList.add(new Article("boberts", "boberts' amazing adventure", "description", "www.newsapi.com", "urlToImage", "1-1-2000","content"));
        AppController.getInstance().setArticles(articleList);

        assertNull(AppController.getInstance().filterList("boberta", articleList));
    }
}
