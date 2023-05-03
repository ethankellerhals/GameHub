package com.gamehub.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamesActivity extends AppCompatActivity {

    ImageButton profileBtn;
    ImageButton logBtn;
    ImageButton homeBtn;
    Button shelfBtn;
    Button genreBtn;
    Button friendBtn;
    Switch playSw;

    private List<users> userList = new ArrayList<>();
    public List<games> gamesList = new ArrayList<>();
    private List<String> tempGameList = new ArrayList<>();
    public Integer currIDCount = 1;
    public int generateID(){
        return this.currIDCount++;
    }
    public void rateGame(){

    }
//    public void removePlayed(){
//        for(games game:gamesList){
//            if()
//        }
//    }
    public void setgame() {


        TableLayout tableLayout = findViewById(R.id.allGamesTable);
        ScrollView scrollView = findViewById(R.id.tableScroll);
//
        Switch swtch = findViewById(R.id.switch1);
        CardView cardV = findViewById(R.id.gameCard);
        CardView cardView = findViewById(R.id.gameCard);
        TextView titl = findViewById(R.id.titleTextView);
        TextView publ = findViewById(R.id.publisherTextView);
        TextView ratl = findViewById(R.id.ratingTextView);
        if(!gamesList.isEmpty()){
            for (games tee : gamesList) {
                TableRow tableRow = new TableRow(this);

                cardView.setLayoutParams(cardV.getLayoutParams());
                cardView.setBottom(cardV.getBottom());
                cardView.setId(cardV.getId());
                cardView.setVisibility(cardV.getVisibility());
                TextView nameTextView = new TextView(this);
                TextView pubTextView = new TextView(this);
                TextView ratTextView = new TextView(this);

                nameTextView.setText(tee.getTitle() );
                pubTextView.setText(tee.getPublisher());
                ratTextView.setText(String.valueOf(tee.getRating()));
                titl.setText(tee.getTitle());
                ratl.setText(String.valueOf(tee.getRating()));
                publ.setText(tee.getPublisher());

                tableRow.addView(nameTextView);
                tableRow.addView(pubTextView);
                tableRow.addView(ratTextView);
                tableLayout.addView(tableRow);
                tableRow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        cardView.setVisibility(View.VISIBLE);
                        tableLayout.setVisibility(View.GONE);
                    }
                });
            }
        }
        else{
            System.out.println("Empty game list ");
            System.out.println("Number of games: " + gamesList.size());
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        gamesList = (List<games>) getIntent().getSerializableExtra("gamesL");

        setgame();
//        TableLayout tableLayout = findViewById(R.id.allGamesTable);

        // to use the iteratore for games
//        gameIterator TempGameLibary = new gameIterator();
//        for(IteratorPattern x = TempGameLibary.returnIteratorPattern(); x.validNext();){
//            String title = (String)x.next();
//            System.out.println("Title: " + title);
//        }

        // after clicking the profile button, take to profile page
        profileBtn = (ImageButton) findViewById(R.id.profileButton);
        // shelf button, take to shelf page
        shelfBtn = findViewById(R.id.shelfButton);
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
                Intent intentLoadNewAdd = new Intent(GamesActivity.this, LogActivity.class);
                intentLoadNewAdd.putExtra("gamesL",(Serializable) gamesList);
                GamesActivity.this.startActivity(intentLoadNewAdd);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(GamesActivity.this, ProfileActivity.class);
                intentLoadNewActivity.putExtra("gamesL",(Serializable) gamesList);
                GamesActivity.this.startActivity(intentLoadNewActivity);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewHome = new Intent(GamesActivity.this, MainActivity.class);
                intentLoadNewHome.putExtra("gamesL",(Serializable) gamesList);
                GamesActivity.this.startActivity(intentLoadNewHome);
            }
        });
        shelfBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadShelfs = new Intent(GamesActivity.this, ShelfActivity.class);
                intendLoadShelfs.putExtra("gamesL",(Serializable) gamesList);
                GamesActivity.this.startActivity(intendLoadShelfs);

            }
        });
        genreBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGenre = new Intent(GamesActivity.this, GenreActivity.class);
                intendLoadGenre.putExtra("gamesL",(Serializable) gamesList);
                GamesActivity.this.startActivity(intendLoadGenre);

            }
        });
        friendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadFriend = new Intent(GamesActivity.this, FriendsActivity.class);
                intendLoadFriend.putExtra("gamesL",(Serializable) gamesList);
                GamesActivity.this.startActivity(intendLoadFriend);

            }
        });



    }


}

