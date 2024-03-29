package com.example.tp_leboncoin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class AdViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ad);
        Intent i = getIntent();
        String TITLE = i.getStringExtra ("title");
        String ADRESSE = i.getStringExtra ("adresse");
        String IMAGE = i.getStringExtra("image");
        String DESCRIPTION = i.getStringExtra("description");

        TextView Title = findViewById(R.id.textView5);
        TextView Adresse = findViewById(R.id.textView6);
        ImageView Image = findViewById(R.id.imageView3);
        TextView Description = findViewById(R.id.Desc_View);

        Title.setText(TITLE);
        Adresse.setText(ADRESSE);
        Description.setText(DESCRIPTION);
        Glide.with(this).load(IMAGE).into(Image);

    }
}
