package com.gamehub.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


//        Button customizeBtn = findViewById(R.id.customizeButton);
//        customizeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //LayoutInflater inflater = getLayoutInflater();
//
////                View customizeFormView = getLayoutInflater().inflate(R.layout.profile_edit_form, null);
////                ViewGroup parent = (ViewGroup) findViewById(android.R.id.content);
////                parent.removeAllViews();
////                parent.addView(editFormView);
//
////                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
////                build.setView(editFormView);
////                builder.create().show();
//            }
//        });
    }


}