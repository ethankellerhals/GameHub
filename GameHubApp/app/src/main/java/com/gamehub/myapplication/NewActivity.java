package com.gamehub.myapplication;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class NewActivity extends AppCompatActivity {

    ImageButton profileBtn;
    ImageButton logBtn;
    ImageButton homeBtn;

    public Integer currIDCount = 1;
    Button saveUseBtn;
    EditText userNameText;
    EditText userFirstName;
    EditText userPassText;
    private List<users> userList = new ArrayList<>();
    public List<games> gamesList = new ArrayList<>();
    private List<String> tempGameList = new ArrayList<>();
    public int generateID(){
        return this.currIDCount++;
    }


    public NewActivity(){
        this.userList = userList;
//        this.tempGameList = setgame(tempGameList);
//        this.gamesList = createGame();
    }
    public void setUserList(List<users> userList){
        this.userList = userList;
    }
    //    public void setGamesList(List<games> gamesList){
//        this.gamesList = gamesList;
//    }
    public List<users> getUserList(){
        return this.userList;
    }
//    public List<games> getGamesList(){
//        return this.gamesList;
//    }


    public void createUser(){
        users newUser = new users(0 , "Jonnn", "Jon","abc123",  new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        userList.add(newUser);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newprofile);
        // after clicking the profile button, take to profile page
        profileBtn = (ImageButton) findViewById(R.id.profileButton);
        setUserList(userList);
        createUser();
        // log button, take to log page
        logBtn = (ImageButton) findViewById(R.id.addButton);
        // home button, take to home page
        homeBtn = (ImageButton) findViewById(R.id.homeButton);
        userNameText = findViewById(R.id.user_name_edit);
        userFirstName = findViewById(R.id.first_name_edit);
        saveUseBtn = findViewById(R.id.save_button);
        userPassText = findViewById(R.id.user_pass_edit);


        saveUseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(userList.size());
                if (!TextUtils.isEmpty(userNameText.getText().toString()) && !TextUtils.isEmpty(userPassText.getText().toString())) {
                    boolean nameTake = true;
                    for (users using : userList) {

                        if (userNameText.getText().toString().equals(using.getuserName())) {
                            nameTake = false;
                        }
                    }
                    if(nameTake){
                        Toast.makeText(NewActivity.this, "Welcome " + userNameText.getText().toString(), Toast.LENGTH_SHORT).show();
                        users newOne = new users(generateID(), userNameText.getText().toString() , userFirstName.getText().toString(),userPassText.getText().toString() , new ArrayList<>() , new ArrayList<>() , new ArrayList<>() );
                        userList.add(newOne);
                        Intent intentLoadNewAdd = new Intent(NewActivity.this, MainActivity.class);
                        NewActivity.this.startActivity(intentLoadNewAdd);
                    }
                    else{
                        Toast.makeText(NewActivity.this, "UserName Taken", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(NewActivity.this, ProfileActivity.class);
                NewActivity.this.startActivity(intentLoadNewActivity);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewHome = new Intent(NewActivity.this, NewActivity.class);
                NewActivity.this.startActivity(intentLoadNewHome);
            }
        });

    }
}
