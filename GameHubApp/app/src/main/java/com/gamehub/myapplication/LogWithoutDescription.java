package com.gamehub.myapplication;

public class LogWithoutDescription implements LogStrategy {
    @Override
    public void logGame(String userName, String title, boolean played, boolean playing, boolean play_history, String description, Integer rating, boolean liked) {
        // Log the game without a description
        logObj new_log = new logObj(userName, title, played, playing, play_history, rating, liked);
        // ...
    }
}


