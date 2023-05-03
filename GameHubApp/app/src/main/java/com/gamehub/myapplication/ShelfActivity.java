package com.gamehub.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShelfActivity extends AppCompatActivity {

    ImageButton profileBtn;
    ImageButton logBtn;
    ImageButton homeBtn;
    Button gamesBtn;
    Button genreBtn;
    Button friendBtn;
    public List<games> gamesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelf);
        gamesList = (List<games>) getIntent().getSerializableExtra("gamesL");
        // after clicking the profile button, take to profile page
        profileBtn = (ImageButton) findViewById(R.id.profileButton);
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
                Intent intentLoadNewAdd = new Intent(ShelfActivity.this, LogActivity.class);
                intentLoadNewAdd.putExtra("gamesL", (Serializable) gamesList);
                ShelfActivity.this.startActivity(intentLoadNewAdd);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(ShelfActivity.this, ProfileActivity.class);
                intentLoadNewActivity.putExtra("gamesL", (Serializable) gamesList);
                ShelfActivity.this.startActivity(intentLoadNewActivity);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewHome = new Intent(ShelfActivity.this, MainActivity.class);
                intentLoadNewHome.putExtra("gamesL", (Serializable) gamesList);
                ShelfActivity.this.startActivity(intentLoadNewHome);
            }
        });

        gamesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGames = new Intent(ShelfActivity.this, GamesActivity.class);
                intendLoadGames.putExtra("gamesL", (Serializable) gamesList);
                ShelfActivity.this.startActivity(intendLoadGames);
            }
        });

        genreBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGenre = new Intent(ShelfActivity.this, GenreActivity.class);
                intendLoadGenre.putExtra("gamesL", (Serializable) gamesList);

                ShelfActivity.this.startActivity(intendLoadGenre);

            }
        });
        friendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadFriend = new Intent(ShelfActivity.this, FriendsActivity.class);
                intendLoadFriend.putExtra("gamesL", (Serializable) gamesList);

                ShelfActivity.this.startActivity(intendLoadFriend);

            }
        });
    }
}