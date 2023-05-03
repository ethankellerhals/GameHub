package com.gamehub.myapplication;

public class SearchResult {
    private String title;
    private String username;
    private ResultType resultType;

    public SearchResult(String title, ResultType resultType) {
        this.title = title;
        this.resultType = resultType;
    }

    public SearchResult(String username, ResultType resultType, boolean isUsername) {
        this.username = username;
        this.resultType = resultType;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUsername() {
        return this.username;
    }

}
