package at.ac.fhcampuswien.enums;

public enum Endpoint {
    EVERYTHING("everything"),
    TOP_HEADLINES("top-headlines"),
    SOURCES("sources");

    public final String endpoint;

    Endpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
