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
public class SignInActivity extends AppCompatActivity {

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

    public SignInActivity(){
        this.userList = userList;

    }
    public void setUserList(List<users> userList){
        this.userList = userList;
    }

    public List<users> getUserList(){
        return this.userList;
    }




    public users createUser(){
        users newUser = new users(0 , "Jonnn", "Jon", "goins@yahoo.com", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        return newUser;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        // after clicking the profile button, take to profile page
        profileBtn = (ImageButton) findViewById(R.id.profileButton);
        // shelf button, take to shelf page

        // log button, take to log page
        logBtn = (ImageButton) findViewById(R.id.addButton);
        // home button, take to home page
        homeBtn = (ImageButton) findViewById(R.id.homeButton);

        sinInBtn = findViewById(R.id.sign_in_button);
        sinUpBtn = findViewById(R.id.sign_up_text_view);
        sinInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(users using : userList) {
                    if(nameT == using.getuserName() && passT == using.getPassword()){

                    }

                }

                Intent intentLoadNewAdd = new Intent(SignInActivity.this, LogActivity.class);
                SignInActivity.this.startActivity(intentLoadNewAdd);
            }
        });

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewAdd = new Intent(SignInActivity.this, LogActivity.class);
                SignInActivity.this.startActivity(intentLoadNewAdd);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(SignInActivity.this, ProfileActivity.class);
                SignInActivity.this.startActivity(intentLoadNewActivity);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewHome = new Intent(SignInActivity.this, NewActivity.class);
                SignInActivity.this.startActivity(intentLoadNewHome);
            }
        });
        shelfBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadShelfs = new Intent(SignInActivity.this, ShelfActivity.class);
                SignInActivity.this.startActivity(intendLoadShelfs);

            }
        });
        gamesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGames = new Intent(SignInActivity.this, GamesActivity.class);
                SignInActivity.this.startActivity(intendLoadGames);
            }
        });

        genreBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGenre = new Intent(SignInActivity.this, GenreActivity.class);
                SignInActivity.this.startActivity(intendLoadGenre);

            }
        });
        friendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadFriend = new Intent(SignInActivity.this, FriendsActivity.class);
                SignInActivity.this.startActivity(intendLoadFriend);

            }
        });

    }
}

