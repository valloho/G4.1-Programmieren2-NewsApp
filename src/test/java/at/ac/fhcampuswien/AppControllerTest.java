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
            articles.add(new Article());
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
            articles.add(new Article());
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


}
