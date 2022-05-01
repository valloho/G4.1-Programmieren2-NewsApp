package at.ac.fhcampuswien;

public class Article {

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    //Article constructor: will be used with APIs in future exercises
    public Article(String author, String title, String description, String url, String urlToImage, String publishedAt, String content){
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    //Author Getter
    public String getAuthor(){
        return this.author;
    }

    //Title Getter
    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUrlToImage() {
        return this.urlToImage;
    }

    public String getPublishedAt() {
        return this.publishedAt;
    }

    public String getContent() {
        return this.content;
    }

    //toString function for Author and Title
    @Override
    public String toString(){
        return "Author: " + this.author + " , Title: " + this.title + System.lineSeparator() + "Description: " +
                this.description + System.lineSeparator() + "Url: " + this.url + System.lineSeparator() + "UrlToImage: " + this.urlToImage + System.lineSeparator() +  "PublishedAt: " + this.publishedAt + System.lineSeparator() +
                "Content: " + this.content + System.lineSeparator();
    }
}
