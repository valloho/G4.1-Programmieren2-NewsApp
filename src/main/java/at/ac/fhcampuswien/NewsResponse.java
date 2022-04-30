package at.ac.fhcampuswien;

import java.util.ArrayList;

public class NewsResponse
{
    String status = "";
    int totalResult = 0;
    ArrayList<Article> articles = new ArrayList<>();

    public String getStatusString() {
        return status;
    }

    public int getTotalResults() {
        return totalResult;
    }
    
    public ArrayList<Article> getArticles() {
        return articles;
    }
}
