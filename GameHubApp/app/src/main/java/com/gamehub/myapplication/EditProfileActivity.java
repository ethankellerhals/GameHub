package com.gamehub.myapplication;
import java.io.IOException;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.media.Image;

import android.net.Uri;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.graphics.BitmapFactory;
import android.widget.Button;
import android.provider.MediaStore;

public class EditProfileActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST_CODE = 1;
    private ImageView profilePictureImageView;
    private EditText usernameEditText;
    private EditText bioEditText;

    private String profilePicturePath;
    private String username;
    private String bio;

//    TextView profilePic, editUsername;
//    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

//        profilePic = findViewById(R.id.profilePicture);
//        profilePictureImageView = findViewById(R.id.profilePictureImageView);
//        usernameEditText = findViewById(R.id.usernameEditText);
//        //bioEditText = findViewById(R.id.bioEditText);

        profilePicturePath = loadProfilePicturePathFromStorage();
        Bitmap profilePictureBitmap = BitmapFactory.decodeFile(profilePicturePath);
        profilePictureImageView.setImageBitmap(profilePictureBitmap);
        username = loadUsernameFromStorage();
        usernameEditText.setText(username);
        //bio = loadBioFromStorage();
        //bioEditText.setText(bio);

        Button saveBtn = findViewById(R.id.saveButton);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                saveProfilePicturePathToStorage(profilePicturePath);
//                saveUsernameToStorage(usernameEditText.getText().toString());
                //saveBioToStorage(bioEditText.getText().toString());
                saveProfileInformationToStorage();
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button cancelBtn = findViewById(R.id.cancelButton);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

        Button changeProfilePictureBtn = findViewById(R.id.changeProfilePictureButton);
        changeProfilePictureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, PICK_IMAGE_REQUEST_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            Uri selectedImageUri = data.getData();
            // profilePicturePath = getRealPathFromUri(selectedImageUri);
            profilePicturePath = loadProfilePicturePathFromStorage();
            Bitmap profilePictureBitmap = BitmapFactory.decodeFile(profilePicturePath);
            profilePictureImageView.setImageBitmap(profilePictureBitmap);
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

    private void saveProfileInformationToStorage() {
        SharedPreferences.Editor editor = getSharedPreferences("profile", MODE_PRIVATE).edit();
        editor.putString("profile_picture_path", profilePicturePath);
        editor.putString("username", username);
        editor.putString("bio", bio);
        editor.apply();
    }



//    public void selectNewProfilePicture(View view) {
//        Intent intent = new Intent(Intent.ACTION_PICK, Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(intent, PICK_IMAGE_REQUEST);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//            imageUri = data.getData();
////            uploadProfileCoverPhoto
//            try {
//                Bitmap bitmap = Images.Media.getBitmap(getContentResolver(), imageUri);
//                ImageView profilePic = findViewById(R.id.profilePicture);
//                profilePic.setImageBitmap(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void pickFromGallery() {
//        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
//        galleryIntent.setType("image/*");
//        startActivityForResult(galleryIntent, IMAGEPICK_GALLERY_REQUEST);
//
//    }
//
//    private void uploadProfileCoverPhoto(final Uri uri) {
//        String filePath =
//    }
}