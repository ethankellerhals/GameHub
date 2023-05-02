package com.gamehub.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


public class ShelfActivity extends AppCompatActivity {

    ImageButton profileBtn;
    ImageButton logBtn;
    ImageButton homeBtn;
    Button gamesBtn;
    Button genreBtn;
    Button friendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelf);

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
                ShelfActivity.this.startActivity(intentLoadNewAdd);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(ShelfActivity.this, ProfileActivity.class);
                ShelfActivity.this.startActivity(intentLoadNewActivity);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewHome = new Intent(ShelfActivity.this, MainActivity.class);
                ShelfActivity.this.startActivity(intentLoadNewHome);
            }
        });
        gamesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGames = new Intent(ShelfActivity.this, GamesActivity.class);
                ShelfActivity.this.startActivity(intendLoadGames);

            }
        });
        genreBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGenre = new Intent(ShelfActivity.this, GenreActivity.class);
                ShelfActivity.this.startActivity(intendLoadGenre);

            }
        });
        friendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadFriend = new Intent(ShelfActivity.this, FriendsActivity.class);
                ShelfActivity.this.startActivity(intendLoadFriend);

            }
        });

        // assassins creed
        ImageButton topPlayBo = findViewById(R.id.top_play_as);
        topPlayBo.setOnClickListener(new View.OnClickListener() {
            // declare variables
            private ImageView gameCoverPopup;
            private TextView popUpTittle;
            private TextView popUpRating;

            @Override
            public void onClick(View v) {
                // Create a PopupWindow
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_game, null);
                PopupWindow popupWindow = new PopupWindow(popupView, 1000, 1700);

                // initalize the views
                gameCoverPopup = popupView.findViewById(R.id.game_cover_popup);
                popUpTittle = popupView.findViewById(R.id.popUpTittle);
                popUpRating = popupView.findViewById(R.id.popUpRating);

                // Show the PopupWindow
                popupWindow.showAtLocation(topPlayBo, Gravity.CENTER, 0, 0);

                // Set the image and text of the views
                gameCoverPopup.setImageResource(R.drawable.assassin_mir);
                popUpTittle.setText("Assassin Creed Mirage");
                popUpRating.setText("3.8");

                // get a reference to the Button and set its OnClickListener
                Button closeButton = popupView.findViewById(R.id.back_game_button);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // close the popup window
                        popupWindow.dismiss();
                    }
                });
            }
        });

        // fortnite
        ImageButton topPlayfn = findViewById(R.id.curr_play_fortnite);
        topPlayfn.setOnClickListener(new View.OnClickListener() {
            // declare variables
            private ImageView gameCoverPopup;
            private TextView popUpTittle;
            private TextView popUpRating;

            @Override
            public void onClick(View v) {
                // Create a PopupWindow
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_game, null);
                PopupWindow popupWindow = new PopupWindow(popupView, 1000, 1700);

                // initalize the views
                gameCoverPopup = popupView.findViewById(R.id.game_cover_popup);
                popUpTittle = popupView.findViewById(R.id.popUpTittle);
                popUpRating = popupView.findViewById(R.id.popUpRating);

                // Show the PopupWindow
                popupWindow.showAtLocation(topPlayBo, Gravity.CENTER, 0, 0);

                // Set the image and text of the views
                gameCoverPopup.setImageResource(R.drawable.fortnite);
                popUpTittle.setText("Fortnite");
                popUpRating.setText("4.2");

                // get a reference to the Button and set its OnClickListener
                Button closeButton = popupView.findViewById(R.id.back_game_button);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // close the popup window
                        popupWindow.dismiss();
                    }
                });
            }
        });

        // bo2
        ImageButton topPlaybo2 = findViewById(R.id.curr_play_bo2);
        topPlaybo2.setOnClickListener(new View.OnClickListener() {
            // declare variables
            private ImageView gameCoverPopup;
            private TextView popUpTittle;
            private TextView popUpRating;

            @Override
            public void onClick(View v) {
                // Create a PopupWindow
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_game, null);
                PopupWindow popupWindow = new PopupWindow(popupView, 1000, 1700);

                // initalize the views
                gameCoverPopup = popupView.findViewById(R.id.game_cover_popup);
                popUpTittle = popupView.findViewById(R.id.popUpTittle);
                popUpRating = popupView.findViewById(R.id.popUpRating);

                // Show the PopupWindow
                popupWindow.showAtLocation(topPlayBo, Gravity.CENTER, 0, 0);

                // Set the image and text of the views
                gameCoverPopup.setImageResource(R.drawable.bo2);
                popUpTittle.setText("Black Ops 2");
                popUpRating.setText("4.9");

                // get a reference to the Button and set its OnClickListener
                Button closeButton = popupView.findViewById(R.id.back_game_button);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // close the popup window
                        popupWindow.dismiss();
                    }
                });
            }
        });

        // rainbow
        ImageButton topPlayR6s = findViewById(R.id.top_play_R6Sedge);
        topPlayR6s.setOnClickListener(new View.OnClickListener() {
            // declare variables
            private ImageView gameCoverPopup;
            private TextView popUpTittle;
            private TextView popUpRating;

            @Override
            public void onClick(View v) {
                // Create a PopupWindow
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_game, null);
                PopupWindow popupWindow = new PopupWindow(popupView, 1000, 1700);

                // initalize the views
                gameCoverPopup = popupView.findViewById(R.id.game_cover_popup);
                popUpTittle = popupView.findViewById(R.id.popUpTittle);
                popUpRating = popupView.findViewById(R.id.popUpRating);

                // Show the PopupWindow
                popupWindow.showAtLocation(topPlayBo, Gravity.CENTER, 0, 0);

                // Set the image and text of the views
                gameCoverPopup.setImageResource(R.drawable.rainbowsix);
                popUpTittle.setText("Rainbow Six Siege");
                popUpRating.setText("3.8");

                // get a reference to the Button and set its OnClickListener
                Button closeButton = popupView.findViewById(R.id.back_game_button);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // close the popup window
                        popupWindow.dismiss();
                    }
                });
            }
        });

        // minecraft
        ImageButton topPlaymc = findViewById(R.id.curr_play_minecraft);
        topPlaymc.setOnClickListener(new View.OnClickListener() {
            // declare variables
            private ImageView gameCoverPopup;
            private TextView popUpTittle;
            private TextView popUpRating;

            @Override
            public void onClick(View v) {
                // Create a PopupWindow
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_game, null);
                PopupWindow popupWindow = new PopupWindow(popupView, 1000, 1700);

                // initalize the views
                gameCoverPopup = popupView.findViewById(R.id.game_cover_popup);
                popUpTittle = popupView.findViewById(R.id.popUpTittle);
                popUpRating = popupView.findViewById(R.id.popUpRating);

                // Show the PopupWindow
                popupWindow.showAtLocation(topPlayBo, Gravity.CENTER, 0, 0);

                // Set the image and text of the views
                gameCoverPopup.setImageResource(R.drawable.minecraft);
                popUpTittle.setText("Minecraft");
                popUpRating.setText("4.4");

                // get a reference to the Button and set its OnClickListener
                Button closeButton = popupView.findViewById(R.id.back_game_button);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // close the popup window
                        popupWindow.dismiss();
                    }
                });
            }
        });

        // csgo
        ImageButton topPlaycg = findViewById(R.id.top_play_csgo);
        topPlaycg.setOnClickListener(new View.OnClickListener() {
            // declare variables
            private ImageView gameCoverPopup;
            private TextView popUpTittle;
            private TextView popUpRating;

            @Override
            public void onClick(View v) {
                // Create a PopupWindow
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_game, null);
                PopupWindow popupWindow = new PopupWindow(popupView, 1000, 1700);

                // initalize the views
                gameCoverPopup = popupView.findViewById(R.id.game_cover_popup);
                popUpTittle = popupView.findViewById(R.id.popUpTittle);
                popUpRating = popupView.findViewById(R.id.popUpRating);

                // Show the PopupWindow
                popupWindow.showAtLocation(topPlayBo, Gravity.CENTER, 0, 0);

                // Set the image and text of the views
                gameCoverPopup.setImageResource(R.drawable.csgo);
                popUpTittle.setText("CounterStrike GO");
                popUpRating.setText("4.1");

                // get a reference to the Button and set its OnClickListener
                Button closeButton = popupView.findViewById(R.id.back_game_button);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // close the popup window
                        popupWindow.dismiss();
                    }
                });
            }
        });

        // currently playing button
        Button curr_p_b_s = findViewById(R.id.CurrentlyPlayingButton);
        curr_p_b_s.setOnClickListener(new View.OnClickListener() {
            // declare variables
            private ImageView game1view;
            private TextView game1txt;
            private ImageView game2view;
            private TextView game2txt;
            private ImageView game3view;
            private TextView game3txt;
            private ImageView game4view;
            private TextView game4txt;
            private ImageView game5view;
            private TextView game5txt;
            private ImageView game6view;
            private TextView game6txt;

            @Override
            public void onClick(View v) {
                // Create a PopupWindow
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.five_game_view, null);
                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // let popup window handle touch events
                PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // initalize the views
                game1view = popupView.findViewById(R.id.game1);
                    game1txt = popupView.findViewById(R.id.game1text);
                game2view = popupView.findViewById(R.id.game2);
                    game2txt = popupView.findViewById(R.id.game2text);
                game3view = popupView.findViewById(R.id.game3);
                    game3txt = popupView.findViewById(R.id.game3text);
                game4view = popupView.findViewById(R.id.game4);
                    game4txt = popupView.findViewById(R.id.game4text);
                game5view = popupView.findViewById(R.id.game5);
                    game5txt = popupView.findViewById(R.id.game5text);
                game6view = popupView.findViewById(R.id.game6);
                    game6txt = popupView.findViewById(R.id.game6text);

                // Show the PopupWindow
                popupWindow.showAtLocation(topPlayBo, Gravity.CENTER, 0, 0);

                // Set the image and text of the views
                game1view.setImageResource(R.drawable.fortnite);
                    game1txt.setText("Hours: 113");
                game2view.setImageResource(R.drawable.bo2);
                    game2txt.setText("Hours: 145");
                game3view.setImageResource(R.drawable.minecraft);
                    game3txt.setText("Hours: 99");
                game4view.setImageResource(R.drawable.gow);
                    game4txt.setText("Hours: 65");
                game5view.setImageResource(R.drawable.roblox);
                    game5txt.setText("Hours: 59");
                game6view.setImageResource(R.drawable.assassin_mir);
                    game6txt.setText("Hours: 37");


                // get a reference to the Button and set its OnClickListener
                Button closeButton = popupView.findViewById(R.id.back_self_page);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // close the popup window
                        popupWindow.dismiss();
                    }
                });
            }
        });

        // friends playing button
        Button fri_p_b_s = findViewById(R.id.TopWithFriendsButton);
        fri_p_b_s.setOnClickListener(new View.OnClickListener() {
            // declare variables
            private ImageView game1view;
            private TextView game1txt;
            private ImageView game2view;
            private TextView game2txt;
            private ImageView game3view;
            private TextView game3txt;
            private ImageView game4view;
            private TextView game4txt;
            private ImageView game5view;
            private TextView game5txt;
            private ImageView game6view;
            private TextView game6txt;

            @Override
            public void onClick(View v) {
                // Create a PopupWindow
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.five_game_view, null);
                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // let popup window handle touch events
                PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // initalize the views
                game1view = popupView.findViewById(R.id.game1);
                    game1txt = popupView.findViewById(R.id.game1text);
                game2view = popupView.findViewById(R.id.game2);
                    game2txt = popupView.findViewById(R.id.game2text);
                game3view = popupView.findViewById(R.id.game3);
                    game3txt = popupView.findViewById(R.id.game3text);
                game4view = popupView.findViewById(R.id.game4);
                    game4txt = popupView.findViewById(R.id.game4text);
                game5view = popupView.findViewById(R.id.game5);
                    game5txt = popupView.findViewById(R.id.game5text);
                game6view = popupView.findViewById(R.id.game6);
                    game6txt = popupView.findViewById(R.id.game6text);

                // Show the PopupWindow
                popupWindow.showAtLocation(topPlayBo, Gravity.CENTER, 0, 0);

                // Set the image and text of the views
                game1view.setImageResource(R.drawable.rainbowsix);
                    game1txt.setText("Friends: 13");
                game2view.setImageResource(R.drawable.assassin_mir);
                    game2txt.setText("Friends: 11");
                game3view.setImageResource(R.drawable.csgo);
                    game3txt.setText("Friends: 10");
                game4view.setImageResource(R.drawable.xdefi);
                    game4txt.setText("Friends: 10");
                game5view.setImageResource(R.drawable.roblox);
                    game5txt.setText("Friends: 9");
                game6view.setImageResource(R.drawable.batfei);
                    game6txt.setText("Friends: 5");


                // get a reference to the Button and set its OnClickListener
                Button closeButton = popupView.findViewById(R.id.back_self_page);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // close the popup window
                        popupWindow.dismiss();
                    }
                });
            }
        });


    }
}