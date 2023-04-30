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
public class MainActivity extends AppCompatActivity {

    ImageButton profileBtn;
    ImageButton logBtn;
    ImageButton homeBtn;
    Button shelfBtn;
    Button gamesBtn;
    Button genreBtn;
    Button friendBtn;
    private List<users> userList = new ArrayList<>();
    public List<games> gamesList = new ArrayList<>();
    private List<String> tempGameList = new ArrayList<>();

    public MainActivity(){
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


//    public List<String> setgame(List<String> currList){
//        try {
//            // Open the file from assets directory
//            InputStream inputStream = getAssets().open("gameDataset.csv");
//
//            // Read the contents of the file
//            Scanner scanner = new Scanner(inputStream);
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                currList.add(line);
//                // Process the line
//            }
//        } catch (IOException e) {
//            // Handle the error
//        }
//
//        return currList;
//    }
//    public List<games> createGame(){
//
//        List<games> temp = new ArrayList<>();
//        int dex = 0;
//        String[] splitstr;
//        // split list. Should be in order (car, performance, pickup) used https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
//        while(dex < tempGameList.size()){
//            splitstr = this.tempGameList.get(dex).split("\\s+"); // ID, title, publisher,rating
//            games newGame = new games(0.0, splitstr[1], splitstr[5], 0.0);
//            gamesList.add(newGame);
//            dex++;
//        }
//        return temp;
//    }

    public users createUser(){
        users newUser = new users(0 , "Jonnn", "Jon", "goins@yahoo.com", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        return newUser;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        tempGameList = setgame(tempGameList);
//        gamesList = createGame();
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
//        setgame(tempGameList);
//        createGame();


        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewAdd = new Intent(MainActivity.this, LogActivity.class);
                MainActivity.this.startActivity(intentLoadNewAdd);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, ProfileActivity.class);
                MainActivity.this.startActivity(intentLoadNewActivity);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewHome = new Intent(MainActivity.this, MainActivity.class);
                MainActivity.this.startActivity(intentLoadNewHome);
            }
        });
        shelfBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadShelfs = new Intent(MainActivity.this, ShelfActivity.class);
                MainActivity.this.startActivity(intendLoadShelfs);

            }
        });
        gamesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGames = new Intent(MainActivity.this, GamesActivity.class);
                MainActivity.this.startActivity(intendLoadGames);
//            This is for the game library page yea?
//                TableLayout tb1=findViewById(R.id.allGamesTable);
//                TableRow r1 = new TableRow(MainActivity.this);
//                r1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
//
//                TextView v1 = new TextView(MainActivity.this);
//                v1.setText("Yooo");
//                r1.addView(v1);
            }
        });
//        public void create_Table(){
//            TableLayout tb1=findViewById(R.id.allGamesTable);
//
//        }
        genreBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGenre = new Intent(MainActivity.this, GenreActivity.class);
                MainActivity.this.startActivity(intendLoadGenre);

            }
        });
        friendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadFriend = new Intent(MainActivity.this, FriendsActivity.class);
                MainActivity.this.startActivity(intendLoadFriend);

            }
        });

    }
}