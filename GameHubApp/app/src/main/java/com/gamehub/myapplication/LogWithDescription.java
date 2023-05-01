package com.gamehub.myapplication;

public class LogWithDescription implements LogStrategy {
    @Override
    public void logGame(String userName, String title, boolean played, boolean playing, boolean play_history, String description, Integer rating, boolean liked) {
        // Log the game with a description
        logObj new_log = new logObj(userName, title, played, playing, play_history, description, rating, liked);
        // ...
    }
}

