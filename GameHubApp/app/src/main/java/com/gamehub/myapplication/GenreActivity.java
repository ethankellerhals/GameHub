package com.gamehub.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SearchView;

import java.sql.Array;
import java.util.List;
import java.util.ArrayList;
//import
import android.util.Log;
import android.view.LayoutInflater;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.widget.TextView;


public class GenreActivity extends AppCompatActivity {

    ImageButton profileBtn;
    ImageButton logBtn;
    ImageButton homeBtn;
    Button shelfBtn;
    Button gamesBtn;
    Button friendBtn;
    SearchView searchBar;
    private SearchController searchController;


    public List<games> gamesList = new ArrayList<>();
    public List<users> userList = new ArrayList<>();



    private ImageView gameCoverPopup;
    private TextView popUpTittle;
    private TextView popUpRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);
        gamesList = (List<games>) getIntent().getSerializableExtra("gamesL");
        userList = (List<users>) getIntent().getSerializableExtra("userL");




        searchController = new SearchController(gamesList, userList);
        RecyclerView recyclerView = findViewById(R.id.search_results_recyclerview);

        // after clicking the profile button, take to profile page
        profileBtn = (ImageButton) findViewById(R.id.profileButton);
        // shelf button, take to shelf page
        shelfBtn = findViewById(R.id.shelfButton);
        // game button, take to game page
        gamesBtn = findViewById(R.id.gameButton);
        // friend button, take to friend page
        friendBtn = findViewById(R.id.friendsButton);
        // log button, take to log page
        logBtn = (ImageButton) findViewById(R.id.addButton);
        // home button, take to home page
        homeBtn = (ImageButton) findViewById(R.id.homeButton);

        searchBar = findViewById(R.id.searchBarSearchView);
        List<SearchResult> dummyResults = new ArrayList<>();

        //dummyResults.add(new SearchResult("Ass", ResultType.GAME));
        //dummyResults.add(new SearchResult("money", ResultType.USER));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //SearchResultsAdapter adapter = new SearchResultsAdapter(dummyResults);

        SearchResultsAdapter adapter = new SearchResultsAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                List<SearchResult> results = new ArrayList<>();
                results.addAll(searchController.searchGames(query));
                results.addAll(searchController.searchUsers(query));

                adapter.setData(results);

                if (!results.isEmpty()) {
                    SearchResult firstResult = results.get(0);
                    View popupView = LayoutInflater.from(GenreActivity.this).inflate(R.layout.popup_game, null);
                    PopupWindow popupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    popupWindow.showAtLocation(searchBar, Gravity.CENTER, 0, 0);

                    gameCoverPopup = popupView.findViewById(R.id.game_cover_popup);
                    popUpTittle = popupView.findViewById(R.id.popUpTittle);
                    popUpRating = popupView.findViewById(R.id.popUpRating);

                    // Show the PopupWindow
//                    popupWindow.showAtLocation(onQueryTextSubmit, Gravity.CENTER, 0, 0);

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



                Log.d("11", "1");
//                SearchResultsAdapter adapter = new SearchResultsAdapter(results);
//                recyclerView.setAdapter(adapter);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                List<SearchResult> results = new ArrayList<>();
                results.addAll(searchController.searchGames(newText));
                results.addAll(searchController.searchUsers(newText));
//                SearchResultsAdapter adapter = new SearchResultsAdapter(results);
                recyclerView.setAdapter(adapter);
                adapter.setData(results);
                Log.d("1", "111");
                return true;
            }
        });

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewAdd = new Intent(GenreActivity.this, LogActivity.class);
                GenreActivity.this.startActivity(intentLoadNewAdd);
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(GenreActivity.this, ProfileActivity.class);
                GenreActivity.this.startActivity(intentLoadNewActivity);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewHome = new Intent(GenreActivity.this, MainActivity.class);
                GenreActivity.this.startActivity(intentLoadNewHome);
            }
        });
        shelfBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadShelfs = new Intent(GenreActivity.this, ShelfActivity.class);
                GenreActivity.this.startActivity(intendLoadShelfs);

            }
        });
        gamesBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadGames = new Intent(GenreActivity.this, GamesActivity.class);
                GenreActivity.this.startActivity(intendLoadGames);

            }
        });
        friendBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intendLoadFriend = new Intent(GenreActivity.this, FriendsActivity.class);
                GenreActivity.this.startActivity(intendLoadFriend);

            }
        });



    }


}