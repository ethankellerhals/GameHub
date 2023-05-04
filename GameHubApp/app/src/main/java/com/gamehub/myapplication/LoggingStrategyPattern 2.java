//package com.gamehub.myapplication;
//
//// https://www.digitalocean.com/community/tutorials/strategy-design-pattern-in-java-example-tutorial
//
//public interface LoggingStrategyPattern {
//    void game_log(games Game);
////    String getLog();
//}
//
//class FileLoggingStrategy implements LoggingStrategyPattern {
//    private String filename;
//
//    public FileLoggingStrategy(String filename) {
//        this.filename = filename;
//    }
//
//    @Override
//    public void game_log(games Game) {
//        // code to log game to a file
//    }
//}
//
//class Logger {
//    private LoggingStrategyPattern loggingStrategy;
//
//    public Logger(LoggingStrategyPattern loggingStrategy) {
//        this.loggingStrategy = loggingStrategy;
//    }
//
//    public void game_log(games Game) {
//        loggingStrategy.game_log(Game);
//    }
//}
//
//
////class DatabaseLoggingStrategy implements LoggingStrategy {
////    private Database database;
////
////    public DatabaseLoggingStrategy(Database database) {
////        this.database = database;
////    }
////
////    @Override
////    public void logGame(Game game) {
////        // code to log game to a database
////    }
////}
