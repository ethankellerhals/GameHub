package com.gamehub.myapplication;

import java.util.List;

public interface SearchInterface {
    // Strategy pattern
    List<SearchResult> search(String searchTerm);
    //List<String> search(String searchTerm);

}
