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
import android.widget.TextView;

public class EditProfileActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageView profilePictureImageView;
    TextView profilePic, editUsername;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        profilePic = findViewById(R.id.profilePicture);

    }

    public void selectNewProfilePicture(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            uploadProfileCoverPhoto
            try {
                Bitmap bitmap = Images.Media.getBitmap(getContentResolver(), imageUri);
                ImageView profilePic = findViewById(R.id.profilePicture);
                profilePic.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void pickFromGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, IMAGEPICK_GALLERY_REQUEST);

    }

    private void uploadProfileCoverPhoto(final Uri uri) {
        String filePath =
    }
}