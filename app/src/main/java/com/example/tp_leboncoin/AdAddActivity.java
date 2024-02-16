package com.example.tp_leboncoin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AdAddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ad);

        EditText Adress_add = findViewById(R.id.Adress_Ajout);
        EditText Titre_add = findViewById(R.id.Titre_Ajout);
        ImageView image_add = findViewById(R.id.Image_Ajout);
        Button Send = findViewById(R.id.Bouton_Ajout);

        image_add.setImageResource(R.drawable.ic_launcher_background);

        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lancementSecondeActivite = new Intent(AdAddActivity.this, AdListViewActivity.class);
                String TITLE = Titre_add.getText().toString();
                String ADRESS = Adress_add.getText().toString();
                lancementSecondeActivite.putExtra("Adresse",ADRESS);
                lancementSecondeActivite.putExtra("Titre",TITLE);
                startActivity(lancementSecondeActivite);
            }
        });

    }
}
