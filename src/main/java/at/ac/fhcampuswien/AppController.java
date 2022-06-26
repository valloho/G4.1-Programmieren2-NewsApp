package at.ac.fhcampuswien;

import at.ac.fhcampuswien.downloader.Downloader;
import at.ac.fhcampuswien.enums.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Manages a list of articles
 */
public class AppController {

    // Singleton
    private static AppController instance = null;
    public AppController() {

    }

    public static AppController getInstance() {

        if (instance == null) {

            instance = new AppController();
        }

        return instance;
    }

    // Articles
    private List<Article> articles;

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
    public List<Article> getTopHeadLinesAustria() throws NewsAPIException {

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
    public List<Article> getAllNewsBitcoin() throws NewsAPIException {

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
     * Searches the Articles for the Author with the longest name.
     **/

    public String getLongestName(){
        if (articles == null) {
            return "There are no authors yet!";
        }else {
            return articles.stream().max(Comparator.comparingInt(Article::getAuthorLength)).orElse(null).getAuthor();
        }
    }

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
     * Orders the Articles based on the length of the description.
     */
    public List<Article> getOrderedBasedOnDescription(){
        if (articles == null) {
            return null;
        }else {

            return articles.stream()
                    .sorted(Comparator.comparingInt(Article::getDescriptionLength).thenComparing(Article::getDescription))
                    .collect(Collectors.toList());
        }
    }

    /**
     * Orders the Articles and outputs a short version with the title, description length and the description.
     */
    public List<String> getOrderedBasedOnDescriptionShort(){
        List<String> orderedArticles = new ArrayList<>();
        if (articles == null) {
            return null;
        }else {
            articles.stream()
                    .sorted(Comparator.comparingInt(Article::getDescriptionLength).thenComparing(Article::getDescription))
                    .forEach(article -> orderedArticles.add("Title: " + article.getTitle() + "\n" + "Desc (length): " + article.getDescription().length() + "\n" + "Desc: " + article.getDescription() + "\n"));
            return orderedArticles;
        }
    }

    public String outputMostArticleSource() {
        String test = articles.stream().parallel().map(Article::getSource)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream().parallel()
            .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey)
            .orElse(null);
        return test;
    }  
    
    public long checkForSpecificSource(String sourceName) {
        if (sourceName != null && sourceName != "") {
            long count = articles.stream().filter(article -> sourceName.equals(article.getSource())).count();
            return count;
        }
        else {
            return 0;
        }
    }

    public int downloadURLs(Downloader downloadObject) throws NewsAPIException {
        //return information in a list
        /**
         * manual iterating
         * Map<Integer, List<String>> articleURLs = new HashMap<>();
        String bufferList[];
        for (int i = 0; i < articles.size(); i++) {
            //add element
            bufferList = null;
            bufferList = { articles.get(i).getUrl(), articles.get(i).getUrlToImage() };
            articleURLs.put(i, new ArrayList<String>());
        }*/
        //list all elements of articles
        if (AppController.getInstance().getArticles() == null) {
            return 0;
        }
        List<String> articleList = AppController.getInstance().getArticles().stream().map(Article::getUrl).filter(Objects::nonNull).collect(Collectors.toList());
        return downloadObject.process(articleList);
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
                    /**newArticle = new Article("Derek Landy", "Skulduggery Pleasant: And he's the good guy", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content", new List<String>("test"));
                    break;
                case 1:
                    newArticle = new Article("Agatha Christi", "Alibi", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content", new String[]{"test"});
                    break;
                case 2:
                    newArticle = new Article("Rick Riordan", "Percy Jackson", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content", new String[]{"test"});
                    break;
                case 3:
                    newArticle = new Article("Michael Ende", "Momo", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content", new String[]{"test"});
                    break;
                case 4:*/
                    /* newArticle = new Article("Markus Heitz", "Zwerge", "description", "www.newsapi.com", "urlToImage", "1-1-2000", "content", new String[]{"test"}); */
            }
            newArticles.add(newArticle);
        }

        return newArticles;
    }
    //endregion
}
