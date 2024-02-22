package com.example.tp_leboncoin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class AdAddActivity extends AppCompatActivity {

    private EditText Address_add;
    private EditText Titre_add;
    private ImageView image_add;
    private Button Send;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ad);

        dbHelper = new DBHelper(this);

        Address_add = findViewById(R.id.Adress_Ajout);
        Titre_add = findViewById(R.id.Titre_Ajout);
        image_add = findViewById(R.id.Image_Ajout);
        Send = findViewById(R.id.Bouton_Ajout);

        Glide.with(this).load("https://www.r-models.eu/6718/tissus-de-carbone-160gm-rg.jpg").into(image_add);


        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

    }

    private void insertData() {
        String title = Titre_add.getText().toString();
        String address = Address_add.getText().toString();
        String image = "https://www.r-models.eu/6718/tissus-de-carbone-160gm-rg.jpg";

        // Insertion dans la base de données
        long result = dbHelper.insertData(title, address, image);

        if (result != -1) {
            Toast.makeText(AdAddActivity.this, "Insertion réussie", Toast.LENGTH_SHORT).show();
            // Redirection vers une autre activité ou autre traitement si nécessaire
        } else {
            Toast.makeText(AdAddActivity.this, "Erreur lors de l'insertion", Toast.LENGTH_SHORT).show();
        }
    }
}
