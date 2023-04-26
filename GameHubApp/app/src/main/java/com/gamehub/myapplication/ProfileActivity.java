package com.gamehub.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.graphics.Bitmap;
import android.widget.TextView;
import android.widget.ImageView;
public class ProfileActivity extends AppCompatActivity {

    ImageButton logBtn;
    ImageButton homeBtn;
    Button shelfBtn;
    Button gamesBtn;
    Button genreBtn;
    Button friendBtn;
    private ImageView profilePictureImageView;
    private TextView usernameTextView;
    private TextView bioTextView;

    private static final int EDIT_PROFILE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profilePictureImageView = findViewById(R.id.profilePicture);
        usernameTextView = findViewById(R.id.username);
        //bioTextView = findViewById(R.id.bio);

        String profilePicturePath = loadProfilePicturePathFromStorage();
        Bitmap profilePictureBitmap = BitmapFactory.decodeFile(profilePicturePath);
        profilePictureImageView.setImageBitmap(profilePictureBitmap);
        String username = loadUsernameFromStorage();
        usernameTextView.setText(username);
        String bio = loadBioFromStorage();
        bioTextView.setText(bio);


        Button editProfileBtn = findViewById(R.id.editProfileButton);
        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intentLoadNewActivity = new Intent(ProfileActivity.this, EditProfileActivity.class);
               // ProfileActivity.this.startActivity(intentLoadNewActivity);

//                LayoutInflater inflater = getLayoutInflater();
//
//                View customizeFormView = getLayoutInflater().inflate(R.layout.activity_edit_profile, null);
//                ViewGroup parent = (ViewGroup) findViewById(android.R.id.content);
//                parent.removeAllViews();
//                parent.addView(editFormView);
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
//                build.setView(editFormView);
//                builder.create().show();


                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivityForResult(intent, EDIT_PROFILE_REQUEST_CODE);


//                // shelf button, take to shelf page
//                shelfBtn = findViewById(R.id.shelfButton);
//                // game button, take to game page
//                gamesBtn = findViewById(R.id.gameButton);
//                // genre button, take to genre page
//                genreBtn = findViewById(R.id.genreButton);
//                // friend button, take to friend page
//                friendBtn = findViewById(R.id.friendsButton);
//                // log button, take to log page
//                logBtn = (ImageButton) findViewById(R.id.addButton);
//                // home button, take to home page
//                homeBtn = (ImageButton) findViewById(R.id.homeButton);
//                logBtn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intentLoadNewAdd = new Intent(ProfileActivity.this, LogActivity.class);
//                        ProfileActivity.this.startActivity(intentLoadNewAdd);
//                    }
//                });
//                homeBtn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intentLoadNewHome = new Intent(ProfileActivity.this, MainActivity.class);
//                        ProfileActivity.this.startActivity(intentLoadNewHome);
//                    }
//                });
//                shelfBtn.setOnClickListener(new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        Intent intendLoadShelfs = new Intent(ProfileActivity.this, ShelfActivity.class);
//                        ProfileActivity.this.startActivity(intendLoadShelfs);
//
//                    }
//                });
//                gamesBtn.setOnClickListener(new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        Intent intendLoadGames = new Intent(ProfileActivity.this, GamesActivity.class);
//                        ProfileActivity.this.startActivity(intendLoadGames);
//
//                    }
//                });
//                genreBtn.setOnClickListener(new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        Intent intendLoadGenre = new Intent(ProfileActivity.this, GenreActivity.class);
//                        ProfileActivity.this.startActivity(intendLoadGenre);
//
//                    }
//                });
//                friendBtn.setOnClickListener(new View.OnClickListener(){
//                    @Override
//                    public void onClick(View v){
//                        Intent intendLoadFriend = new Intent(ProfileActivity.this, FriendsActivity.class);
//                        ProfileActivity.this.startActivity(intendLoadFriend);
//
//                    }
//                });

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT_PROFILE_REQUEST_CODE && resultCode == RESULT_OK) {
            String profilePicturePath = loadProfilePicturePathFromStorage();
            Bitmap profilePictureBitmap = BitmapFactory.decodeFile(profilePicturePath);
            profilePictureImageView.setImageBitmap(profilePictureBitmap);
            String username = loadUsernameFromStorage();
            usernameTextView.setText(username);
            String bio = loadBioFromStorage();
            bioTextView.setText(bio);
        }
    }

    private String loadProfilePicturePathFromStorage() {
        SharedPreferences preferences = getSharedPreferences("profile", MODE_PRIVATE);
        return preferences.getString("profile_picture_path", "");
    }

    private String loadUsernameFromStorage() {
        SharedPreferences preferences = getSharedPreferences("profile", MODE_PRIVATE);
        return preferences.getString("username", "");
    }

    private String loadBioFromStorage() {
        SharedPreferences preferences = getSharedPreferences("profile", MODE_PRIVATE);
        return preferences.getString("bio", "");
    }
}