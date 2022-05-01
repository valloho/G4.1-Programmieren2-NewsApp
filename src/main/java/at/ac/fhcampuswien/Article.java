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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.lineSeparator());

        if(this.author != null){
            stringBuilder.append("Author: ").append(this.author).append(System.lineSeparator());
        }
        if(this.title != null){
            stringBuilder.append("Title: ").append(this.title).append(System.lineSeparator());
        }
        if (this.description != null){
            stringBuilder.append("Description: ").append(this.description).append(System.lineSeparator());
        }
        if (this.url != null) {
            stringBuilder.append("URL: ").append(this.url).append(System.lineSeparator());
        }
        if (this.urlToImage != null) {
            stringBuilder.append("URLToImage: ").append(this.urlToImage).append(System.lineSeparator());
        }
        if (this.publishedAt != null) {
            stringBuilder.append("PublishedAt: ").append(this.publishedAt).append(System.lineSeparator());
        }
        if (this.content != null) {
            stringBuilder.append("Content: ").append(this.content).append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
