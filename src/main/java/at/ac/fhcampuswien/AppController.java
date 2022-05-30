package at.ac.fhcampuswien;

import at.ac.fhcampuswien.enums.*;
import jdk.dynalink.Operation;

import java.util.*;


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
     * Not implemented yet!
     *
     * @return Empty array list of articles
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

/*   Nico [nicht niggo] working on it
    /**
     * Searches the Articles for the Author with the longest name.
     **/
    /*
    public String getLongestName(){
        List<String> authors = new ArrayList<>();
        if (articles == null) {
            return "There are no authors yet!";
        }else {
            for (Article article : articles) {
                authors.add(article.getAuthor());
            }
            System.out.println(authors);
            String result = authors.stream().
                    max(author -> author.length());
            System.out.println(result);
            return null;
        }
    }
    */

    /**
     * Searches for a list of Articles with a title that consists of less than 15 characters.
     */
    public List<Article> getTitlesLessThan15(){
        List<Article> filteredArticles = new ArrayList<>();
        if (articles == null) {
            return null;
        }else {
             articles.stream()
                    .filter(article -> article.getTitle().length() < 15)
                    .forEach(filteredArticles::add);
                    if(filteredArticles.isEmpty()) {
                        return null;
                    }else {
                        return filteredArticles;
                    }
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

            Article newArticle = switch (articleNumber) {
                case 0 -> new Article("Derek Landy", "Skulduggery Pleasant: And he's the good guy", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content");
                case 1 -> new Article("Agatha Christi", "Alibi", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content");
                case 2 -> new Article("Rick Riordan", "Percy Jackson", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content");
                case 3 -> new Article("Michael Ende", "Momo", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content");
                case 4 -> new Article("Markus Heitz", "Zwerge", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content");
                default -> null;
            };
            newArticles.add(newArticle);
        }

        return newArticles;
    }
    //endregion
}
