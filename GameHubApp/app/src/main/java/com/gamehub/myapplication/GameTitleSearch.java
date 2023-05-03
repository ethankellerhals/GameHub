package com.gamehub.myapplication;

import java.util.List;
import java.util.ArrayList;

public class GameTitleSearch implements SearchInterface {
    private List<games> gamesList;

    public GameTitleSearch(List<games> gamesList) {
        this.gamesList = gamesList;
    }
    @Override
    public List<SearchResult> search(String searchTerm) {
        List<SearchResult> results = new ArrayList<>();
        for (games game : gamesList) {
            if (game.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(new SearchResult(game.getTitle(), ResultType.GAME));
            }
        }
        return results;
    }
}
