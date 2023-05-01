package com.gamehub.myapplication;

public class logStrategyObj {
    private LogStrategy logStrategy;

    public logStrategyObj(LogStrategy logStrategy) {
        this.logStrategy = logStrategy;
    }

    public void log(String userName, String title, boolean played, boolean playing, boolean play_history, String description, Integer rating, boolean liked) {
        logStrategy.logGame(userName, title, played, playing, play_history, description, rating, liked);
    }
}
