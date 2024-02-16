package com.example.tp_leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class AdListViewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_ad);

        AdModel Annonce1 = new AdModel("cailloux", "Lahure", 1);
        AdModel Annonce2 = new AdModel("béton", "Lahure", 2);
        AdModel Annonce3 = new AdModel("métaux", "Lahure", 3);

        ArrayList<AdModel> liste_annonce = new ArrayList<>();

        liste_annonce.add(Annonce1);
        liste_annonce.add(Annonce2);
        liste_annonce.add(Annonce3);

    }
}
