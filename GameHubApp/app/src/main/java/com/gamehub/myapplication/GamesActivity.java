package com.gamehub.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
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
    public String currUser;

    private List<users> userList = new ArrayList<>();
    public List<games> gamesList = new ArrayList<>();
    public List<users> tempFriendList = new ArrayList<>();
    public List<games> tempGameList = new ArrayList<>();
    public Integer currIDCount = 1;
    public int generateID(){
        return this.currIDCount++;
    }
    public void rateGame(){

    }
    public GamesActivity(){
        this.userList = new ArrayList<>();
    }
    public void setUserList(List<users> userList){
        this.userList = userList;
    }
    public void setGamesList(List<games> gamesList){
        this.gamesList = gamesList;
    }
    public void setCurrUser(String currUser){
        this.currUser = currUser;
    }
    public List<users> getUserList(){
        return this.userList;
    }
    public List<games> getGamesList(){
        return this.gamesList;
    }
    // reference
    // https://developer.android.com/reference/android/widget/TableLayout
    // https://developer.android.com/reference/android/widget/TableRow
    // https://developer.android.com/reference/android/view/View
    // https://developer.android.com/reference/android/graphics/drawable/ShapeDrawable

    public void setgame() {
        TableLayout tableLayout = findViewById(R.id.allGamesTable);
        ScrollView scrollView = findViewById(R.id.tableScroll);
        Switch swtch = findViewById(R.id.switch1);
        CardView cardV = findViewById(R.id.gameCard);
        CardView cardView = findViewById(R.id.gameCard);
        TextView titl = findViewById(R.id.titleTextView);
        TextView publ = findViewById(R.id.publisherTextView);
        TextView ratl = findViewById(R.id.ratingTextView);


        // padding and margins for the table
        int tablePadding = 16;
        tableLayout.setPadding(tablePadding, tablePadding, tablePadding, tablePadding);
        TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
        );
        int tableMargin = 8;
        tableParams.setMargins(tableMargin, tableMargin, tableMargin, tableMargin);
        tableLayout.setLayoutParams(tableParams);

        // background color
        tableLayout.setBackgroundColor(Color.WHITE);

        // divider drawable
        ShapeDrawable dividerDrawable = new ShapeDrawable(new RectShape());
        int dividerHeight = 2;
        dividerDrawable.setIntrinsicHeight(dividerHeight);
        dividerDrawable.getPaint().setColor(Color.LTGRAY);

        // divider for the table
        tableLayout.setDividerDrawable(dividerDrawable);
        tableLayout.setShowDividers(TableLayout.SHOW_DIVIDER_MIDDLE);

        if (gamesList != null && !gamesList.isEmpty()) {
            for (int i = 0; i < gamesList.size(); i++) {
                final games tee = gamesList.get(i);
                // new row
                TableRow tableRow = new TableRow(this);
                int rowPadding = 8;
                tableRow.setPadding(rowPadding, rowPadding, rowPadding, rowPadding);
                TableRow.LayoutParams rowParams = new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                );
                int rowMargin = 4;
                rowParams.setMargins(rowMargin, rowMargin, rowMargin, rowMargin);
                tableRow.setLayoutParams(rowParams);

                // every other row
                if (i % 2 == 0) {
                    tableRow.setBackgroundColor(Color.LTGRAY);
                } else {
                    tableRow.setBackgroundColor(Color.WHITE);
                }

                // populate each cell
                TextView nameTextView = new TextView(this);
                nameTextView.setText(tee.getTitle());
                nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                nameTextView.setTypeface(Typeface.DEFAULT_BOLD);
                tableRow.addView(nameTextView);

                TextView pubTextView = new TextView(this);
                pubTextView.setText(tee.getPublisher());
                pubTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                tableRow.addView(pubTextView);

                TextView ratTextView = new TextView(this);
                ratTextView.setText(String.valueOf(tee.getRating()));
                ratTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
                tableRow.addView(ratTextView);
                // add the row
                tableLayout.addView(tableRow);

                // click on game
                tableRow.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cardView.setVisibility(View.VISIBLE);
                        tableLayout.setVisibility(View.GONE);

                        titl.setText(tee.getTitle());
                        ratl.setText(String.valueOf(tee.getRating()));
                        publ.setText(tee.getPublisher());
                    }
                });
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        setGamesList((List<games>) getIntent().getSerializableExtra("gamesL"));
        setUserList((List<users>) getIntent().getSerializableExtra("isLogged"));
        setCurrUser(getIntent().getStringExtra("EXTRA_MESSAGE"));


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
                intentLoadNewAdd.putExtra("isLogged", (Serializable) userList);
                intentLoadNewAdd.putExtra("EXTRA_MESSAGE", currUser);
                GamesActivity.this.startActivity(intentLoadNewAdd);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(GamesActivity.this, ProfileActivity.class);
                intentLoadNewActivity.putExtra("gamesL",(Serializable) gamesList);
                intentLoadNewActivity.putExtra("isLogged", (Serializable) userList);
                intentLoadNewActivity.putExtra("EXTRA_MESSAGE", currUser);
                GamesActivity.this.startActivity(intentLoadNewActivity);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewHome = new Intent(GamesActivity.this, MainActivity.class);
                intentLoadNewHome.putExtra("gamesL",(Serializable) gamesList);
                intentLoadNewHome.putExtra("isLogged", (Serializable) userList);
                intentLoadNewHome.putExtra("EXTRA_MESSAGE", currUser);
                GamesActivity.this.startActivity(intentLoadNewHome);
            }
        });
        shelfBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadShelfs = new Intent(GamesActivity.this, ShelfActivity.class);
                intendLoadShelfs.putExtra("gamesL",(Serializable) gamesList);
                intendLoadShelfs.putExtra("isLogged", (Serializable) userList);
                intendLoadShelfs.putExtra("EXTRA_MESSAGE", currUser);
                GamesActivity.this.startActivity(intendLoadShelfs);

            }
        });
        genreBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGenre = new Intent(GamesActivity.this, GenreActivity.class);
                intendLoadGenre.putExtra("gamesL",(Serializable) gamesList);
                intendLoadGenre.putExtra("isLogged", (Serializable) userList);
                intendLoadGenre.putExtra("EXTRA_MESSAGE", currUser);
                GamesActivity.this.startActivity(intendLoadGenre);

            }
        });
        friendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadFriend = new Intent(GamesActivity.this, FriendsActivity.class);
                intendLoadFriend.putExtra("gamesL",(Serializable) gamesList);
                intendLoadFriend.putExtra("isLogged", (Serializable) userList);
                intendLoadFriend.putExtra("EXTRA_MESSAGE", currUser);
                GamesActivity.this.startActivity(intendLoadFriend);

            }
        });
//        playSw.setOnClickListener(View v);



    }


}

