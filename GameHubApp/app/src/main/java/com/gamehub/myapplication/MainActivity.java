package com.gamehub.myapplication;

import android.content.Context;
import android.media.Image;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
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
    public Integer currIDCount = 1;
    private List<users> userList = new ArrayList<>();
    public List<games> gamesList = new ArrayList<>();
    private List<String> tempGameList = new ArrayList<>();
    public int generateID(){
        return this.currIDCount++;
    }
    public MainActivity(){
        this.userList = userList;
//        this.tempGameList = setgame(tempGameList);
//        this.gamesList = createGame();
    }
    public void setUserList(List<users> userList){
        this.userList = userList;
    }
    public void setGamesList(List<games> gamesList){
        this.gamesList = gamesList;
    }
    public List<users> getUserList(){
        return this.userList;
    }
    public List<games> getGamesList(){
        return this.gamesList;
    }

    public users createUser(){
        users newUser = new users(0 , "Jonnn", "Jon","abc123",  new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        return newUser;
    }
    public void setgame(Context context) {

        List<games> currList = new ArrayList<>();
        try {
            // Open the file from assets directory
            InputStream inputStream = getAssets().open("gameDataset.csv");

            // Read the contents of the file
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");
                String title = tokens[1];
                String publisher = tokens[2];
                if (title != "Name"){
                    currList.add(new games(generateID(), title, publisher, 0.0, new ArrayList<>()));
                }
            }
            System.out.println("curr "+currList.size());
        } catch (IOException e) {
            System.out.println("eerr");
        }
        gamesList = currList;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setgame(getApplicationContext());
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
        profileBtn.setVisibility(View.VISIBLE);
        logBtn.setVisibility(View.VISIBLE);
        homeBtn.setVisibility(View.VISIBLE);


        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewAdd = new Intent(MainActivity.this, LogActivity.class);
                intentLoadNewAdd.putExtra("gamesL", (Serializable) gamesList);
                MainActivity.this.startActivity(intentLoadNewAdd);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this, ProfileActivity.class);
                intentLoadNewActivity.putExtra("gamesL", (Serializable) gamesList);
                MainActivity.this.startActivity(intentLoadNewActivity);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewHome = new Intent(MainActivity.this, MainActivity.class);
                intentLoadNewHome.putExtra("gamesL", (Serializable) gamesList);
                MainActivity.this.startActivity(intentLoadNewHome);
            }
        });
        shelfBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadShelfs = new Intent(MainActivity.this, ShelfActivity.class);
                intendLoadShelfs.putExtra("gamesL", (Serializable) gamesList);

                MainActivity.this.startActivity(intendLoadShelfs);

            }
        });
        gamesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGames = new Intent(MainActivity.this, GamesActivity.class);
                intendLoadGames.putExtra("gamesL", (Serializable) gamesList);
                MainActivity.this.startActivity(intendLoadGames);
            }
        });

        genreBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGenre = new Intent(MainActivity.this, GenreActivity.class);
                intendLoadGenre.putExtra("gamesL", (Serializable) gamesList);

                MainActivity.this.startActivity(intendLoadGenre);

            }
        });
        friendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadFriend = new Intent(MainActivity.this, FriendsActivity.class);
                intendLoadFriend.putExtra("gamesL", (Serializable) gamesList);

                MainActivity.this.startActivity(intendLoadFriend);

            }
        });

    }
}