package com.example.tp_leboncoin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class AdAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<AdModel> adModelArrayList;
    private final LayoutInflater inflater;


    public AdAdapter(Context context, ArrayList<AdModel> adModelArrayList){
        this.context=context;
        this.adModelArrayList=adModelArrayList;
        inflater = (LayoutInflater.from(context));

    }

    @Override
    public int getCount(){ return adModelArrayList.size();}

    @Override
    public Object getItem(int i){ return adModelArrayList.get(i);}

    @Override
    public long getItemId(int i){ return i;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        AdModel ad = (AdModel) getItem(i);

        view=inflater.inflate(R.layout.item_listview_ad,null);

        ImageView imageIV= view.findViewById(R.id.imageView);
        TextView titleTV= view.findViewById(R.id.textView);
        TextView addressTV= view.findViewById(R.id.textView2);

        imageIV.setImageResource(i);
        titleTV.setText(ad.getTitle());
        addressTV.setText(ad.getAddress());
        return view;
    }
}
