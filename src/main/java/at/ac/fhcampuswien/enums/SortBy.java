package at.ac.fhcampuswien.enums;

public enum SortBy {
    RELEVANCY("relevancy"),
    POPULARITY("popularity"),
    PUBLISHED("publishedAt");

    public final String sortby;

    SortBy(String sortby){
        this.sortby = sortby;
    }
}
