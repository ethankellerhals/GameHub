package com.gamehub.myapplication;
import java.io.IOException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.media.Image;
import android.provider.MediaStore.Images;
import android.net.Uri;
import android.graphics.Bitmap;
import android.widget.ImageView;

public class EditProfileActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView profilePictureImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //profilePictureImageView = findViewById(R.id.profilePicture);
//        Button saveChangesBtn = findViewById(R.id.saveChangesButton);
//        saveChangesBtn.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               finish();
//           }
//        });
    }

    public void selectNewProfilePicture(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();

            try {
                Bitmap bitmap = Images.Media.getBitmap(getContentResolver(), imageUri);
                ImageView profilePic = findViewById(R.id.profilePicture);
                profilePic.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}