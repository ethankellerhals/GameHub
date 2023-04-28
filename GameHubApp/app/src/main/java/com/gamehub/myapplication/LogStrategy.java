package com.gamehub.myapplication;

public interface LogStrategy {
    public void logGame(String userName, String title, boolean played, boolean playing, boolean play_history, String description, Integer rating, boolean liked);
}

