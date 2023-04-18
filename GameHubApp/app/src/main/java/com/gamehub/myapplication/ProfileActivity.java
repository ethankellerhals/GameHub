package com.gamehub.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button editProfileBtn = findViewById(R.id.editProfileButton);
        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(ProfileActivity.this, EditProfileActivity.class);
                ProfileActivity.this.startActivity(intentLoadNewActivity);

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
            }
        });
    }
}