package com.gamehub.myapplication;

import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.UUID;
public class games {
    private Double gameID;
    private String title;
    private String publisher;
    private Integer rating;
    // Should I have a slot for avg rating and also make a list of all of its ratings maybe mapped to user id so you cant have more than one vote
    public games(Double gameID, String title, String publisher, Integer rating){
        this.gameID = gameID;
        this.title = title;
        this.publisher = publisher;
        this.rating = rating;
    }
    public void setID(Double gameID){
        this.gameID = gameID;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public void setRating(Integer rating){
        this.rating = rating;
    }
    public Double getID(){
        return this.gameID;
    }
    public String getTitle(){
        return this.title;
    }
    public String getPublisher(){
        return this.publisher;
    }
    public Integer getRating(){
        return this.rating;
    }
}
