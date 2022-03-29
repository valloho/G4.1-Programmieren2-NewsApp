package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages a list of articles
 */
public class AppController
{
    private List<Article> articles;

    public AppController()
    {

    }

    //region SETTER ----------------------------------------------------------------------------------------------------

    /**
     * Sets the current article list to a given article list.
     * @param articles List of articles to set
     */
    public void setArticles(List<Article> articles)
    {
        List<Article> articleList = new ArrayList<Article>();
    }

    //endregion

    //region GETTER ----------------------------------------------------------------------------------------------------

    /**
     * @return The amount of articles
     */
    public int getArticleCount()
    {
        if (articles == null)
        {
            return 0;
        }

        return this.articles.size();
    }

    /**
     * Not implemented yet!
     * @return Empty array list of articles
     */
    public List<Article> getTopHeadLinesAustria()
    {
        return new ArrayList<>();
    }

    /**
     * Searches for all articles with the query "bitcoin".
     * @return A list of articles about bitcoins
     */
    public List<Article> getAllNewsBitcoin()
    {
        return new ArrayList<>();
    }

    //endregion

    //region METHODS ---------------------------------------------------------------------------------------------------

    /**
     * Searches a list of articles with a given query in the title.
     * @param query What articles are searched
     * @param articles Where articles are searched
     * @return List of all articles with the given query
     */
    protected List<Article> filterList(String query, List<Article> articles)
    {
        return new ArrayList<>();
    }

    /**
     * Generates a list with dummy articles.
     * @return List of dummy articles
     */
    public static List<Article> generateMockList()
    {
        return new ArrayList<>();
    }
    //endregion
}
