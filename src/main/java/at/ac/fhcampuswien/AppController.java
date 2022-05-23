package at.ac.fhcampuswien;

import at.ac.fhcampuswien.enums.Category;
import at.ac.fhcampuswien.enums.Country;
import at.ac.fhcampuswien.enums.Language;
import at.ac.fhcampuswien.enums.SortBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Manages a list of articles
 */
public class AppController {
    private List<Article> articles;

    public AppController() {
    }

    //region SETTER ----------------------------------------------------------------------------------------------------

    /**
     * Sets the current article list to a given article list.
     *
     * @param articles List of articles to set
     */
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    //endregion

    //region GETTER ----------------------------------------------------------------------------------------------------

    /**
     * @return The amount of articles
     */
    public int getArticleCount() {
        if (articles == null) {
            return 0;
        }
        return this.articles.size();
    }

    /**
     * @return The list of articles
     */
    public List<Article> getArticles() {
        return this.articles;
    }

    /**
     * Searches for all articles from Austria (in German) with the query "ukraine"
     *
     * @return a list of articles from Austria about Ukraine
     */
    public List<Article> getTopHeadLinesAustria() {

        articles = NewsApi.getTopHeadlines("ukraine", Language.GERMAN, Country.AUSTRIA, Category.GENERAL).getArticles();

        if (articles == null) {
            return new ArrayList<>();
        }
        return articles;
    }

    /**
     * Searches for all articles with the query "bitcoin".
     *
     * @return A list of articles about bitcoins
     */
    public List<Article> getAllNewsBitcoin() {

        articles = NewsApi.getEverything("bitcoin", Language.ENGLISH, SortBy.RELEVANCY).getArticles();

        return articles;
    }

    //endregion

    //region METHODS ---------------------------------------------------------------------------------------------------

    /**
     * Searches a list of articles with a given query in the title.
     *
     * @param query    What articles are searched
     * @param articles Where articles are searched
     * @return List of all articles with the given query
     */
    protected List<Article> filterList(String query, List<Article> articles) {
        List<Article> outputBuffer = new ArrayList<>();
        for (Article selectedArticle : articles) {
            if (selectedArticle.getTitle().toLowerCase().contains(query.toLowerCase())) {
                outputBuffer.add(selectedArticle);
            }
        }
        if (outputBuffer.isEmpty()) {
            return null;
        } else {
            return outputBuffer;
        }
    }

    /**
     * Generates a list with dummy articles.
     *
     * @return List of dummy articles
     */
    public static List<Article> generateMockList(int articleAmount) {
        List<Article> newArticles = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < articleAmount; i++) {
            int articleNumber = random.nextInt(5);

            Article newArticle = null;
            switch (articleNumber) {
                case 0:
                    newArticle = new Article("Derek Landy", "Skulduggery Pleasant: And he's the good guy", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content");
                    break;
                case 1:
                    newArticle = new Article("Agatha Christi", "Alibi", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content");
                    break;
                case 2:
                    newArticle = new Article("Rick Riordan", "Percy Jackson", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content");
                    break;
                case 3:
                    newArticle = new Article("Michael Ende", "Momo", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content");
                    break;
                case 4:
                    newArticle = new Article("Markus Heitz", "Zwerge", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content");
            }
            newArticles.add(newArticle);
        }

        return newArticles;
    }
    //endregion
}
