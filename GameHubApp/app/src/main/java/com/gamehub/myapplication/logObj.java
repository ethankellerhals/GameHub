package com.gamehub.myapplication;

import java.util.List;

public class logObj {
    private String userName;
    private String title;
    private boolean played;
    private boolean playing;
    private boolean play_history;
    private String discription;
    private Integer rating;
    private boolean liked;

    // without description
    public logObj(String user_input, String title_input, boolean played_input, boolean playing_input, boolean play_history_input, Integer rating_intput, boolean liked_input){
        this.userName = user_input;
        this.title = title_input;
        this.played = played_input;
        this.playing = playing_input;
        this.play_history = play_history_input;
        this.rating = rating_intput;
        this.liked = liked_input;
    }

    // with description
    public logObj(String user_input, String title_input, boolean played_input, boolean playing_input, boolean play_history_input, String discription_input, Integer rating_intput, boolean liked_input){
        this.userName = user_input;
        this.title = title_input;
        this.played = played_input;
        this.playing = playing_input;
        this.play_history = play_history_input;
        this.discription = discription_input;
        this.rating = rating_intput;
        this.liked = liked_input;
    }

    // getters
    public String getuserName(){ return this.userName; }
    public String gettitle(){ return this.title; }
    public boolean getplayed(){ return this.played; }
    public boolean getplaying(){ return this.playing; }
    public boolean getplay_history(){ return this.play_history; }
    public String getdiscription(){ return this.discription; }
    public Integer getrating(){ return this.rating; }
    public boolean getliked(){ return this.liked; }
}

