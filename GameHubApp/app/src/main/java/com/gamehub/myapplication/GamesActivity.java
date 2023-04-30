package com.gamehub.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamesActivity extends AppCompatActivity implements OnGameListReadyListener{

    ImageButton profileBtn;
    ImageButton logBtn;
    ImageButton homeBtn;
    Button shelfBtn;
    Button genreBtn;
    Button friendBtn;

    private List<users> userList = new ArrayList<>();
    private List<games> gamesList = new ArrayList<>();
    private List<String> tempGameList = new ArrayList<>();
    private static class LoadDataTask extends AsyncTask<Void, Void, List<String>> {

        private WeakReference<GamesActivity> activityReference;

        LoadDataTask(GamesActivity context) {
            activityReference = new WeakReference<>(context);
        }

        @Override
        protected List<String> doInBackground(Void... voids) {
            List<String> currList = new ArrayList<>();
            try {
                // Open the file from assets directory
                InputStream inputStream = activityReference.get().getAssets().open("gameDataset.csv");

                // Read the contents of the file
                Scanner scanner = new Scanner(inputStream);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    currList.add(line);
                    // Process the line
                }
            } catch (IOException e) {
                // Handle the error
            }
            return currList;
        }

        @Override
        protected void onPostExecute(List<String> result) {
            super.onPostExecute(result);
            GamesActivity activity = activityReference.get();
            if (activity == null || activity.isFinishing()) return;

            // Update the UI here
            // ...
            activity.setgame(result);
        }
    }
    @Override
    public void onGameListReady(List<games> gameList) {
        tempGameList = new ArrayList<>();
        for (games game : gameList) {
            tempGameList.add(game.toString());
        }
        createGame();
        // Now you can access tempGameList and gamesList
    }
    public void setgame(final OnGameListReadyListener listener) {
        new AsyncTask<Void, Void, List<games>>() {
            @Override
            protected List<games> doInBackground(Void... voids) {
                List<games> currList = new ArrayList<>();
                try {
                    // Open the file from assets directory
                    InputStream inputStream = getAssets().open("gameDataset.csv");

                    // Read the contents of the file
                    Scanner scanner = new Scanner(inputStream);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] tokens = line.split(",");
                        if (tokens.length == 4) {
                            double id = Double.parseDouble(tokens[0]);
                            String title = tokens[1];
                            String publisher = tokens[2];
                            double rating = Double.parseDouble(tokens[3]);
                            currList.add(new games(id, title, publisher, rating));
                        }
                    }
                } catch (IOException e) {
                    // Handle the error
                }
                return currList;
            }

            @Override
            protected void onPostExecute(List<games> currList) {
                listener.onGameListReady(currList);
            }
        }.execute();
    }



    public void createGame(){
        tempGameList.clear();
//        List<games> temp = new ArrayList<>();
//        int dex = 0;
//        double ID = 0.0;
//        String[] splitstr;
        // split list. Should be in order (car, performance, pickup) used https://stackoverflow.com/questions/7899525/how-to-split-a-string-by-space
        for(games game : gamesList){
            tempGameList.add(game.getTitle());
//            splitstr = this.tempGameList.get(dex).split("\\s+"); // ID, title, publisher,rating
//            games newGame = new games(ID, splitstr[1], splitstr[5], 0);
//            temp.add(newGame);
//            dex++;
//            ID++;
        }
//        gamesList = temp;
//        return temp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        setgame(this);
        TableLayout tableLayout = findViewById(R.id.allGamesTable);
        new LoadDataTask(this).execute();


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


        if(!gamesList.isEmpty()){
            for (games tee : gamesList) {
                TableRow tableRow = new TableRow(this);
                TextView nameTextView = new TextView(this);
                nameTextView.setText(tee.getTitle());
                TextView ageTextView = new TextView(this);
                ageTextView.setText(String.valueOf(tee.getID()));
                tableRow.addView(nameTextView);
                tableRow.addView(ageTextView);
                tableLayout.addView(tableRow);
            }
            System.out.println("full game list ");
        }
        else{
            System.out.println("Empty game list ");
            System.out.println("Number of games: " + gamesList.size());

        }
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewAdd = new Intent(GamesActivity.this, LogActivity.class);
                GamesActivity.this.startActivity(intentLoadNewAdd);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(GamesActivity.this, ProfileActivity.class);
                GamesActivity.this.startActivity(intentLoadNewActivity);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewHome = new Intent(GamesActivity.this, MainActivity.class);
                GamesActivity.this.startActivity(intentLoadNewHome);
            }
        });
        shelfBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadShelfs = new Intent(GamesActivity.this, ShelfActivity.class);
                GamesActivity.this.startActivity(intendLoadShelfs);

            }
        });
        genreBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGenre = new Intent(GamesActivity.this, GenreActivity.class);
                GamesActivity.this.startActivity(intendLoadGenre);

            }
        });
        friendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadFriend = new Intent(GamesActivity.this, FriendsActivity.class);
                GamesActivity.this.startActivity(intendLoadFriend);

            }
        });



    }

    @Override
    public void onGameListReady(List<String> gameList) {

    }
}

