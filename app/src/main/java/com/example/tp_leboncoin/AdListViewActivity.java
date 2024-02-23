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
        Cursor cursor = dbManager.fetch();
        CursorAdapter adapter = new DbAdAdapter(this, cursor, R.layout.item_recyclerview_ad);
        adapter.notifyDataSetChanged();

        data.clear();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String title = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.TITLE));
                String address = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.ADDRESS));
                String image = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.IMAGE));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.DESC));
                data.add(new DbAdModel(title, address, image, description));
            } while (cursor.moveToNext());

            // Fermez le curseur après avoir parcouru toutes les lignes
            cursor.close();
        } else {
            // Aucune donnée dans le curseur
            Log.d("Cursor", "Aucune donnée dans le curseur");
        }

        RecyclerView recyclerView = findViewById(R.id.RecyclerView);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);




        recyclerView.setAdapter(new RecyclerViewAdAdapter(data, new RecyclerViewAdAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DbAdModel item) {
                Intent lancementActicity= new Intent(AdListViewActivity.this,AdViewActivity.class);
                String title = item.getTitle();
                String address = item.getAddress();
                String img = item.getImage();
                String description = item.getDesc();
                lancementActicity.putExtra("title",title);
                lancementActicity.putExtra("adresse",address);
                lancementActicity.putExtra("image",img);
                lancementActicity.putExtra("description",description);

                startActivity(lancementActicity);
            }
        }) {
        });


    }

    public interface OnItemClickListener {
        void onItemClick(AdModel item);
    }
}
