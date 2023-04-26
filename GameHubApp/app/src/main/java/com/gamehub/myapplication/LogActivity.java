package com.gamehub.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.HashMap;

public class LogActivity extends AppCompatActivity {

    ImageButton profileBtn;
    ImageButton homeBtn;
    Button shelfBtn;
    Button gamesBtn;
    Button genreBtn;
    Button friendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

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
        // home button, take to home page
        homeBtn = (ImageButton) findViewById(R.id.homeButton);

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(LogActivity.this, ProfileActivity.class);
                LogActivity.this.startActivity(intentLoadNewActivity);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewHome = new Intent(LogActivity.this, MainActivity.class);
                LogActivity.this.startActivity(intentLoadNewHome);
            }
        });
        shelfBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadShelfs = new Intent(LogActivity.this, ShelfActivity.class);
                LogActivity.this.startActivity(intendLoadShelfs);

            }
        });
        gamesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGames = new Intent(LogActivity.this, GamesActivity.class);
                LogActivity.this.startActivity(intendLoadGames);

            }
        });
        genreBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGenre = new Intent(LogActivity.this, GenreActivity.class);
                LogActivity.this.startActivity(intendLoadGenre);

            }
        });
        friendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadFriend = new Intent(LogActivity.this, FriendsActivity.class);
                LogActivity.this.startActivity(intendLoadFriend);

            }
        });

        // log functions
        Button saveButton = (Button) findViewById(R.id.button_save);
        EditText titleEditText = (EditText) findViewById(R.id.titleEditText);
        CheckBox played_log = (CheckBox) findViewById(R.id.checkBox_Played);
        CheckBox playing_log = (CheckBox) findViewById(R.id.checkBox_Playing);
        CheckBox play_history_log = (CheckBox) findViewById(R.id.checkBox_Played_before);
        EditText discription_log = (EditText) findViewById(R.id.reviewEditText);
        RatingBar rating_log = (RatingBar) findViewById(R.id.ratingBar);
        CheckBox liked_log = (CheckBox) findViewById(R.id.Liked);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, logObj> userLogDictionary = new HashMap<>();
                logObj new_log = new logObj("Adrian", titleEditText.getText().toString(), played_log.isChecked(), playing_log.isChecked(), play_history_log.isChecked(), discription_log.getText().toString(), rating_log.getNumStars(), liked_log.isChecked());
                if (!TextUtils.isEmpty(new_log.getuserName()) && !TextUtils.isEmpty(new_log.gettitle())) {
                    userLogDictionary.put(new_log.getuserName(), new_log);
                    Toast.makeText(getApplicationContext(), "Text saved for user: " + new_log.getuserName(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter a name and text to save.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}