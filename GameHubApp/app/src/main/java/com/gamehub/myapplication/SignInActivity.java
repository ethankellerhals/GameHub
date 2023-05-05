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
public class SignInActivity extends AppCompatActivity {

    ImageButton profileBtn;
    ImageButton logBtn;
    ImageButton homeBtn;

    Button sinUpBtn;
    Button sinInBtn;
    Button saveUseBtn;
    EditText userNameText;
    EditText passWordText;
    public Boolean isLogged;
    public String currUser;
    private List<users> userList = new ArrayList<>();
    public List<games> gamesList = new ArrayList<>();
    public List<users> tempFriendList = new ArrayList<>();
    public List<games> tempGameList = new ArrayList<>();


    public SignInActivity(){
        this.userList = userList;
        this.isLogged = false;
        this.currUser = currUser;

    }
    public void setUserList(List<users> userList){
        this.userList = userList;
    }

    public List<users> getUserList(){
        return this.userList;
    }


    public void createUser(){
        users newUser = new users(0 , "Jonnn", "Jon","abc123", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        userList.add(newUser);
        users newUser2 = new users(0 , "Jon", "Jon","abc", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        tempFriendList.add(newUser2);
        newUser.setMyFriends(tempFriendList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        // after clicking the profile button, take to profile page
        profileBtn = (ImageButton) findViewById(R.id.profileButton);
        // shelf button, take to shelf page
        setUserList(userList);
        createUser();
        // log button, take to log page
        logBtn = (ImageButton) findViewById(R.id.addButton);
        // home button, take to home page
        homeBtn = (ImageButton) findViewById(R.id.homeButton);
        profileBtn.setVisibility(View.GONE);
        logBtn.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);
        sinInBtn = findViewById(R.id.sign_in_button);
        sinUpBtn = findViewById(R.id.sign_up_text_view);
        userNameText = findViewById(R.id.email_edit_text);
        passWordText = findViewById(R.id.password_edit_text);
        sinInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(userList.size());
                if (!TextUtils.isEmpty(userNameText.getText().toString()) && !TextUtils.isEmpty(passWordText.getText().toString())) {
                    System.out.println(userNameText.getText().toString());
                    System.out.println(passWordText.getText().toString());
                    for (users using : userList) {
                        System.out.println(using.getuserName());
                        System.out.println(using.getPassword());
                        if (userNameText.getText().toString().equals(using.getuserName()) && passWordText.getText().toString().equals(using.getPassword())) {
                            Toast.makeText(SignInActivity.this, "Welcome " + using.getuserName(), Toast.LENGTH_SHORT).show();
                            isLogged = true;
                            String use = userNameText.getText().toString();
                            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                            intent.putExtra("EXTRA_MESSAGE", use);
                            startActivity(intent);
//                            Intent intentLoadNewAdd = new Intent(SignInActivity.this, MainActivity.class);
//                            SignInActivity.this.startActivity(intentLoadNewAdd);
                            return;
                        }
                    }

                    Toast.makeText(SignInActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        sinUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intentLoadNewAdd = new Intent(SignInActivity.this, NewActivity.class);
                        SignInActivity.this.startActivity(intentLoadNewAdd);
            }
        });



    }
}

