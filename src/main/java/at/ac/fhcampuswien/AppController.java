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
        AppController appController = new AppController();
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < 3; i++)
        {
            articles.add(new Article("bob", "bob's adventure"));
        }

        appController.setArticles(articles);

        assertEquals(3, appController.getArticleCount());
    }

    /**
     * Test if article count is 6 when there are 6 articles
     */
    @Test
    public void getArticleCountTest2()
    {
        AppController appController = new AppController();
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < 6; i++)
        {
            articles.add(new Article("bob", "bob's adventure"));
        }

        appController.setArticles(articles);

        assertEquals(6, appController.getArticleCount());
    }

    /**
     * Test if article count is 0 when null
     */
    @Test
    public void getArticleCountTest3()
    {
        AppController appController = new AppController();
        appController.setArticles(null);

        assertEquals(0, appController.getArticleCount());
    }

    @Test
    public void setArticleTest1(){

        AppController appController = new AppController();
        appController.setArticles(null);

        assertNull(appController.getArticles());

    }

    @Test
    public void setArticleTest2(){

        AppController appController = new AppController();
        List<Article> articleList = new ArrayList<Article>();
        articleList.add(new Article("bobby", "bobby's great adventure"));
        articleList.add(new Article("boberts", "boberts' amazing adventure"));
        appController.setArticles(articleList);

        assertEquals(articleList, appController.getArticles());

    }


    @Test
    public void setArticleTest3(){

        AppController appController = new AppController();
        List<Article> articleList = new ArrayList<Article>();
        articleList.add(new Article("bobby", "bobby's great adventure"));
        articleList.add(new Article("boberts", "boberts' amazing adventure"));
        articleList.add(new Article("bobbie", "bobbie's shining adventure"));
        articleList.add(new Article("bubba", "bubba's shrimp company"));
        articleList.add(new Article("brobob", "brobob's confusing adventure"));
        appController.setArticles(articleList);

        assertEquals(articleList, appController.getArticles());

    }

    @Test
    public void filterListTest1(){

        AppController appController = new AppController();
        List<Article> articleList = new ArrayList<Article>();
        articleList.add(new Article("bobby", "bobby's great adventure"));
        articleList.add(new Article("boberts", "boberts' amazing adventure"));
        appController.setArticles(articleList);

        assertEquals(articleList.get(0), appController.filterList("bobby", articleList).get(0));
    }

    @Test
    public void filterListTest2(){

        AppController appController = new AppController();
        List<Article> articleList = new ArrayList<Article>();
        articleList.add(new Article("bobby", "bobby's great adventure"));
        articleList.add(new Article("bobby", "bobby's amazing adventure"));
        articleList.add(new Article("bobby", "bobby's amazing adventure 2"));
        appController.setArticles(articleList);

        assertEquals(articleList, appController.filterList("bobby", articleList));
    }

    @Test
    public void filterListTest3(){

        AppController appController = new AppController();
        List<Article> articleList = new ArrayList<Article>();
        articleList.add(new Article("bobby", "bobby's great adventure"));
        articleList.add(new Article("boberts", "boberts' amazing adventure"));
        appController.setArticles(articleList);

        assertEquals(null, appController.filterList("boberta", articleList));
    }
}
