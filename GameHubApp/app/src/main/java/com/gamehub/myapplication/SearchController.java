package com.gamehub.myapplication;
import java.util.List;
import java.util.ArrayList;
public class SearchController {
    //private SearchInterface searchInterface;
    public List<games> gamesList;
    public List<users> userList;
    private SearchInterface gameTitleSearch;
    private SearchInterface usernameSearch;
//    public void setSearchInterface(SearchInterface searchInterface) {
//        this.searchInterface = searchInterface;
//    }

    public SearchController(List<games> gamesList, List<users> userList) {
        this.gamesList = gamesList;
        this.userList = userList;
        this.gameTitleSearch = new GameTitleSearch(gamesList);
        this.usernameSearch = new UsernameSearch(userList);
    }

    public List<SearchResult> searchGames(String searchTerm) {
        return gameTitleSearch.search(searchTerm);
    }
    public List<SearchResult> searchUsers(String searchTerm) {
        return usernameSearch.search(searchTerm);
    }
//    public List<SearchResult> performSearch(String searchTerm) {
//        if (searchInterface == null) {
//            throw new IllegalStateException("Search strategy not selected");
//        }
//        return searchInterface.search(searchTerm);
//    }
//    public List<SearchResult> performSearch(SearchInterface searchInterface, String searchTerm) {
//        List<SearchResult> searchResults = new ArrayList<>();
//        if (seachInterface instanceof GameTitleSearch) {
//            GameTitleSearch gameTitleSearch = (GameTitleSearch) searchInterface;
//            searchResults.addAll(gameTitleSearch.searchByTitle(searchTerm));
//        }
//    }
}
