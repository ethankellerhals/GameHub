package com.gamehub.myapplication;

import java.util.List;
import java.util.ArrayList;
public class UsernameSearch implements SearchInterface {
    private List<users> usersList;

    public UsernameSearch(List<users> usersList) {
        this.usersList = usersList;
    }
    @Override
    public List<SearchResult> search(String searchTerm) {
        List<SearchResult> results = new ArrayList<>();
        for (users user : usersList) {
            if (user.getuserName().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(new SearchResult(user.getuserName(), ResultType.USER));
            }
        }
        return results;
    }

}
