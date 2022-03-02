package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

public class AppController
{
    private List<Article> articles;

    public AppController()
    {

    }

    //region SETTER ----------------------------------------------------------------------------------------------------

    public void setArticles(List<Article> articles)
    {

    }

    //endregion

    //region GETTER ----------------------------------------------------------------------------------------------------
    public int getArticleCount()
    {
        return 0;
    }

    public List<Article> getTopHeadLinesAustria()
    {
        return new ArrayList<>();
    }

    public List<Article> getAllNewsBitcoin()
    {
        return new ArrayList<>();
    }

    //endregion

    //region METHODS ---------------------------------------------------------------------------------------------------
    protected List<Article> filterList(String query, List<Article> articles)
    {
        return new ArrayList<>();
    }

    public static List<Article> generateMockList()
    {
        return new ArrayList<>();
    }
    //endregion
}
