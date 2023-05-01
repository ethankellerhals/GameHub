package com.gamehub.myapplication;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class NewActivity extends AppCompatActivity {

    ImageButton profileBtn;
    ImageButton logBtn;
    ImageButton homeBtn;
    Button shelfBtn;
    Button gamesBtn;
    Button genreBtn;
    Button friendBtn;
    Button sinUpBtn;
    Button sinInBtn;
    Button saveUseBtn;
    private List<users> userList = new ArrayList<>();
    public List<games> gamesList = new ArrayList<>();
    private List<String> tempGameList = new ArrayList<>();

    public NewActivity(){
        this.userList = userList;
//        this.tempGameList = setgame(tempGameList);
//        this.gamesList = createGame();
    }
    public void setUserList(List<users> userList){
        this.userList = userList;
    }
    //    public void setGamesList(List<games> gamesList){
//        this.gamesList = gamesList;
//    }
    public List<users> getUserList(){
        return this.userList;
    }
//    public List<games> getGamesList(){
//        return this.gamesList;
//    }



    public users createUser(){
        users newUser = new users(0 , "Jonnn", "Jon", "goins@yahoo.com", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        return newUser;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.newprofile);
        // after clicking the profile button, take to profile page
        profileBtn = (ImageButton) findViewById(R.id.profileButton);
        // shelf button, take to shelf page
        shelfBtn = findViewById(R.id.shelfButton);
        // game button, take to game page
        gamesBtn = findViewById(R.id.gameButton);
        // genre button, take to genre page
        genreBtn = findViewById(R.id.genreButton);
        // friend button, take to friend page
        friendBtn = findViewById(R.id.friendsButton);
        // log button, take to log page
        logBtn = (ImageButton) findViewById(R.id.addButton);
        // home button, take to home page
        homeBtn = (ImageButton) findViewById(R.id.homeButton);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewAdd = new Intent(NewActivity.this, LogActivity.class);
                NewActivity.this.startActivity(intentLoadNewAdd);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(NewActivity.this, ProfileActivity.class);
                NewActivity.this.startActivity(intentLoadNewActivity);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewHome = new Intent(NewActivity.this, NewActivity.class);
                NewActivity.this.startActivity(intentLoadNewHome);
            }
        });
        shelfBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadShelfs = new Intent(NewActivity.this, ShelfActivity.class);
                NewActivity.this.startActivity(intendLoadShelfs);

            }
        });
        gamesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGames = new Intent(NewActivity.this, GamesActivity.class);
                NewActivity.this.startActivity(intendLoadGames);
            }
        });

        genreBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGenre = new Intent(NewActivity.this, GenreActivity.class);
                NewActivity.this.startActivity(intendLoadGenre);

            }
        });
        friendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadFriend = new Intent(NewActivity.this, FriendsActivity.class);
                NewActivity.this.startActivity(intendLoadFriend);

            }
        });

    }
}
