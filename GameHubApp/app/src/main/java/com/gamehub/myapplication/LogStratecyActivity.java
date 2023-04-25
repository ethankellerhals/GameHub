package com.gamehub.myapplication;

public class LogStratecyActivity {
    private Logger logger;

    protected void onCreate() {
        // create logger with file logging strategy
        logger = new Logger(new FileLoggingStrategy("games.log"));

        // log a game
        games temp_Game = new games(101.01,"Super Mario Bros.", "Nintendo", 3);
        logger.game_log(temp_Game);
    }
}

