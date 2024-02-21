package com.example.tp_leboncoin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class CameraAdAddActivity extends AppCompatActivity {

    // Define the button and imageview type variable
    Button camera_open_id;
    Button gallery_open_id;
    ImageView click_image_id;

    ActivityResultLauncher<Intent> cameraActivityResultLauncher = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                Bitmap image = (Bitmap) data.getExtras().get("data");
                click_image_id.setImageBitmap(image);
            }
        }
    });

    ActivityResultLauncher<Intent> galleryActivityResultLauncher = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                Uri image = (Uri) result.getData().getData();
                click_image_id.setImageURI(image);
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ad); // Complete with the identifier of your activity

        camera_open_id = findViewById(R.id.BoutonCamera);
        gallery_open_id = findViewById(R.id.BoutonImage);
        click_image_id = findViewById(R.id.Image_Ajout);

        // Camera_open button is for open the camera and add the setOnClickListener in this button
        camera_open_id.setOnClickListener(v -> {
            Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraActivityResultLauncher.launch(camera);
        });

        gallery_open_id.setOnClickListener(v -> {
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            galleryActivityResultLauncher.launch(gallery);
        });

        Button send = findViewById(R.id.Bouton_Ajout);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView image = findViewById(R.id.Image_Ajout);
                TextView title = findViewById(R.id.Titre_Ajout);
                TextView address = findViewById(R.id.Adress_Ajout);

                Intent intent = new Intent(CameraAdAddActivity.this, AdListViewActivity.class);
                intent.putExtra("image", R.drawable.Image_Ajout); // Add a drawable image because image management is not implemented.
                intent.putExtra("title", title.getText().toString());
                intent.putExtra("address", address.getText().toString());
                startActivity(intent);
            }
        });
    }
}
