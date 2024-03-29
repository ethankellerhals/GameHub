package com.gamehub.myapplication;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.UUID;
public class games implements Serializable {
    private Integer gameID;
    private String title;
    private String publisher;
    private Double rating;
    public List<Integer> totalRating;
    // Should I have a slot for avg rating and also make a list of all of its ratings maybe mapped to user id so you cant have more than one vote
    public games(Integer gameID, String title, String publisher, Double rating, List<Integer> totalRating){
        this.gameID = gameID;
        this.title = title;
        this.publisher = publisher;
        this.rating = rating;
        this.totalRating = totalRating;
    }
    public void setID(Integer gameID){
        this.gameID = gameID;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public void setRating(Double rating){
        this.rating = rating;
    }
    public Integer getID(){
        return this.gameID;
    }
    public String getTitle(){
        return this.title;
    }
    public String getPublisher(){
        return this.publisher;
    }
    public Double getRating(){
        return this.rating;
    }
}
