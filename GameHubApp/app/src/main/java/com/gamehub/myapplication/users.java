package com.gamehub.myapplication;
import java.util.List;

public class users {
    private Integer userID;
    private String userName;
    private String firstName;
    private String password;
    private List<games> currentPlay;
    private List <games> havePlayed;
    private List <users> myFriends;

    // Not done * char
    public users(Integer userID, String userName, String firstName,String password, List<games> currentPlay ,List<games> havePlayed, List<users> myFriends ){
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;

        this.currentPlay = currentPlay;
        this.havePlayed = havePlayed;
        this.myFriends = myFriends;
    }
    public void setUserID(Integer userID){
        this.userID = userID;

    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setUserName(String userName){
        this.userName = userName;

    }
    public void setFirstName(String firstName){
        this.firstName = firstName;

    }

    public void setCurrentPlay(List<games> currentPlay){
        this.currentPlay = currentPlay;
    }
    public void setHavePlayed(List<games> havePlayed){
        this.havePlayed = havePlayed;
    }
    public void setMyFriends(List<users> myFriends){
        this.myFriends = myFriends;
    }
    public List<games> getCurrentPlay(){
        return this.currentPlay;
    }
    public List<games> getHavePlayed(){
        return this.havePlayed;
    }
    public List<users> getMyFriends(){
        return this.myFriends;
    }
    public Integer getUserID(){
        return this.userID;
    }
    public String getuserName(){
        return this.userName;
    }
    public String getfirstName(){
        return this.firstName;
    }
    public String getPassword(){return this.password;
    }
}
