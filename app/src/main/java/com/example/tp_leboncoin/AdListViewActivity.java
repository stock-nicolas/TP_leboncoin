package com.example.tp_leboncoin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdListViewActivity extends AppCompatActivity{
    private List<DbAdModel> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview_ad);

        data = new ArrayList<>();

        DBManager dbManager = DBManager.getDBManager(this);
        dbManager.open();
        //dbManager.init();
        Cursor cursor = dbManager.fetch();
        CursorAdapter adapter = new DbAdAdapter(this, cursor, R.layout.item_recyclerview_ad);
        adapter.notifyDataSetChanged();

        data.clear();

        while (cursor != null && cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.TITLE));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.ADDRESS));
            String image = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.IMAGE));

            data.add(new DbAdModel(title, address, image));
        }

        if (cursor != null) {
            cursor.close(); // Assurez-vous de fermer le curseur après avoir fini de l'utiliser
        }

        /*if(getIntent().hasExtra("Titre"))
        {
            Intent i = getIntent();
            String TITLE = i.getStringExtra ("Titre");
            String ADRESSE = i.getStringExtra ("Adresse");
            String IMAGE = i.getIntExtra("image",R.drawable.ic_launcher_background);

            AdModel Annonce4 = new AdModel(TITLE, ADRESSE,IMAGE);

            //liste_annonce.add(Annonce4);
        }*/

        //AdAdapter adapter = new AdAdapter(this,liste_annonce);

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));



        recyclerView.setAdapter(new RecyclerViewAdAdapter(data, new RecyclerViewAdAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DbAdModel item) {
                Intent lancementActicity= new Intent(AdListViewActivity.this,AdViewActivity.class);
                String title = item.getTitle();
                String address = item.getAddress();
                String img = item.getImage();
                lancementActicity.putExtra("title",title);
                lancementActicity.putExtra("adresse",address);
                lancementActicity.putExtra("image",img);

                startActivity(lancementActicity);
            }
        }) {
        });

        //recyclerView.setAdapter(adapter2);


        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
        });*/


    }

    public interface OnItemClickListener {
        void onItemClick(AdModel item);
    }
}
