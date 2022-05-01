package at.ac.fhcampuswien;

import java.util.List;

public class NewsResponse
{
    String status = "";
    int totalResult = 0;
    List<Article> articles;

    public String getStatusString() {
        return status;
    }

    public int getTotalResults() {
        return totalResult;
    }
    
    public List<Article> getArticles() {
        return articles;
    }
}
