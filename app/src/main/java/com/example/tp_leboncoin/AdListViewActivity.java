package com.example.tp_leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdListViewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_ad);

        AdModel Annonce1 = new AdModel("cailloux", "Lahure", R.drawable.ic_launcher_foreground);
        AdModel Annonce2 = new AdModel("béton", "Lahure", R.drawable.ic_launcher_foreground);
        AdModel Annonce3 = new AdModel("métaux", "Lahure", R.drawable.ic_launcher_foreground);

        ArrayList<AdModel> liste_annonce = new ArrayList<>();

        ListView listView = findViewById(R.id.listView);

        liste_annonce.add(Annonce1);
        liste_annonce.add(Annonce2);
        liste_annonce.add(Annonce3);

        if(getIntent() != null)
        {
            Intent i = getIntent();
            String TITLE = i.getStringExtra ("Titre");
            String ADRESSE = i.getStringExtra ("Adresse");
            int IMAGE = i.getIntExtra("image",R.drawable.ic_launcher_background);

            AdModel Annonce4 = new AdModel(TITLE, ADRESSE,IMAGE);

            liste_annonce.add(Annonce4);
        }

        AdAdapter adapter = new AdAdapter(this,liste_annonce);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Intent lancementActicity= new Intent(AdListViewActivity.this,AdViewActivity.class);
                AdModel ad = (AdModel) parent.getItemAtPosition(position);
                String title = ad.getTitle();
                String address = ad.getAddress();
                int img = ad.getImage();
                lancementActicity.putExtra("title",title);
                lancementActicity.putExtra("adresse",address);
                lancementActicity.putExtra("image",img);

                startActivity(lancementActicity);
            }
        });


    }
}
