package com.gamehub.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class FriendsActivity extends AppCompatActivity {

    ImageButton profileBtn;
    ImageButton logBtn;
    ImageButton homeBtn;
    Button shelfBtn;
    Button gamesBtn;
    Button genreBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        // after clicking the profile button, take to profile page
        profileBtn = (ImageButton) findViewById(R.id.profileButton);
        // shelf button, take to shelf page
        shelfBtn = findViewById(R.id.shelfButton);
        // game button, take to game page
        gamesBtn = findViewById(R.id.gameButton);
        // genre button, take to genre page
        genreBtn = findViewById(R.id.genreButton);
        // log button, take to log page
        logBtn = (ImageButton) findViewById(R.id.addButton);
        // home button, take to home page
        homeBtn = (ImageButton) findViewById(R.id.homeButton);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewAdd = new Intent(FriendsActivity.this, LogActivity.class);
                FriendsActivity.this.startActivity(intentLoadNewAdd);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(FriendsActivity.this, ProfileActivity.class);
                FriendsActivity.this.startActivity(intentLoadNewActivity);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewHome = new Intent(FriendsActivity.this, MainActivity.class);
                FriendsActivity.this.startActivity(intentLoadNewHome);
            }
        });
        shelfBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadShelfs = new Intent(FriendsActivity.this, ShelfActivity.class);
                FriendsActivity.this.startActivity(intendLoadShelfs);

            }
        });
        gamesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGames = new Intent(FriendsActivity.this, GamesActivity.class);
                FriendsActivity.this.startActivity(intendLoadGames);

            }
        });
        genreBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGenre = new Intent(FriendsActivity.this, GenreActivity.class);
                FriendsActivity.this.startActivity(intendLoadGenre);

            }
        });

        // write friends

        // get friends
        Button friend1 = (Button) findViewById(R.id.friend1button);
        Button friend2 = (Button) findViewById(R.id.friend2button);
        Button friend3 = (Button) findViewById(R.id.friend3button);
        Button friend4 = (Button) findViewById(R.id.friend4button);
        Button random1 = (Button) findViewById(R.id.random1);
        Button random2 = (Button) findViewById(R.id.random2);

        friend1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // inflate the popup window layout
                View popupView = getLayoutInflater().inflate(R.layout.popup_info_friend1, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // let popup window handle touch events
                PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window at a specific location on the screen
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                // get a reference to the TextView and set its text
                TextView infoTextView = popupView.findViewById(R.id.infoTextView);
                infoTextView.setText("Favorite Games");

                // get a reference to the Button and set its OnClickListener
                Button closeButton = popupView.findViewById(R.id.closeButton);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // close the popup window
                        popupWindow.dismiss();
                    }
                });
            }
        });
        friend2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // inflate the popup window layout
                View popupView = getLayoutInflater().inflate(R.layout.popup_info_friend2, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // let popup window handle touch events
                PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window at a specific location on the screen
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                // get a reference to the TextView and set its text
                TextView infoTextView = popupView.findViewById(R.id.infoTextView);
                infoTextView.setText("Favorite Games");

                // get a reference to the Button and set its OnClickListener
                Button closeButton = popupView.findViewById(R.id.closeButton);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // close the popup window
                        popupWindow.dismiss();
                    }
                });
            }
        });
        friend3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // inflate the popup window layout
                View popupView = getLayoutInflater().inflate(R.layout.popup_info_friend3, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // let popup window handle touch events
                PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window at a specific location on the screen
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                // get a reference to the TextView and set its text
                TextView infoTextView = popupView.findViewById(R.id.infoTextView);
                infoTextView.setText("Favorite Games");

                // get a reference to the Button and set its OnClickListener
                Button closeButton = popupView.findViewById(R.id.closeButton);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // close the popup window
                        popupWindow.dismiss();
                    }
                });
            }
        });
        friend4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // inflate the popup window layout
                View popupView = getLayoutInflater().inflate(R.layout.popup_info_friend4, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // let popup window handle touch events
                PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window at a specific location on the screen
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                // get a reference to the TextView and set its text
                TextView infoTextView = popupView.findViewById(R.id.infoTextView);
                infoTextView.setText("Favorite Games");

                // get a reference to the Button and set its OnClickListener
                Button closeButton = popupView.findViewById(R.id.closeButton);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // close the popup window
                        popupWindow.dismiss();
                    }
                });
            }
        });
        random1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
        random2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
    }
}