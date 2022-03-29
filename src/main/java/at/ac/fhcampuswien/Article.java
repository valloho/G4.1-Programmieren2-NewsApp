package at.ac.fhcampuswien;

public class Article {

    private String author;
    private String title;

    //Article constructor: will be used with APIs in future exercises
    public Article(String author, String title){
        this.author = author;
        this.title = title;
    }

    //Author Getter
    public String getAuthor(){
        return this.author;
    }

    //Title Getter
    public String getTitle(){
        return this.title;
    }
    //toString function for Author and Title
    @Override
    public String toString(){
        return "Author: " + this.author.toString() + " , Title: " + this.title.toString();
    }
}
