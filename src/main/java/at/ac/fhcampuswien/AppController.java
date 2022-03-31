package at.ac.fhcampuswien;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        this.articles = articles;
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
     * @return The list of articles
     */
    public List<Article> getArticles()
    {
        return this.articles;
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
            List<Article> outputBuffer = new ArrayList<>();
            for (Article selectedArticle : articles) {
                if (selectedArticle.getTitle().toLowerCase().contains(query.toLowerCase())) {
                    outputBuffer.add(selectedArticle);
                }
            }
            if (outputBuffer.isEmpty()) {
                    return null;
            }
            else {
                return outputBuffer;
            }
    }

    /**
     * Generates a list with dummy articles.
     * @return List of dummy articles
     */
    public static List<Article> generateMockList(int articleAmount)
    {
        List<Article> newArticles = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < articleAmount; i++)
        {
            int articleNumber = random.nextInt(5);

            Article newArticle = null;
            switch (articleNumber)
            {
                case 0:
                    newArticle = new Article("Derek Landy", "Skulduggery Pleasant: And he's the good guy");
                    break;
                case 1:
                    newArticle = new Article("Agatha Christi", "Alibi");
                    break;
                case 2:
                    newArticle = new Article("Rick Riordan", "Percy Jackson");
                    break;
                case 3:
                    newArticle = new Article("Michael Ende", "Momo");
                    break;
                case 4:
                    newArticle = new Article("Markus Heitz", "Zwerge");
            }
            newArticles.add(newArticle);
        }

        return newArticles;
    }
    //endregion
}
