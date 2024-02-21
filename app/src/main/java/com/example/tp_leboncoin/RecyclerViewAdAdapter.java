package com.example.tp_leboncoin;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdAdapter extends RecyclerView.Adapter<RecyclerViewAdAdapter.RecyclerViewHolder>{

    public interface OnItemClickListener {
        void onItemClick(AdModel item);
    }
    private final List<AdModel> data;

    private final OnItemClickListener listener;
    public RecyclerViewAdAdapter(List<AdModel> data,OnItemClickListener listener) {this.data = data;this.listener = listener;}
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recyclerview_ad, parent, false);
        return new RecyclerViewHolder(view);
    }
    @Override

    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
// This method is called for each of the visible rows displayed in our RecyclerView. It is usually here that we update their appearance.
        AdModel ad = data.get(position);
        holder.bind(ad,listener);
    }
    @Override
    public int getItemCount() {return data.size();}
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView;
        public final TextView titleTextView;
        public final TextView addressTextView;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.textView);
            addressTextView = itemView.findViewById(R.id.textView2);
        }

        public void bind(final AdModel item, final OnItemClickListener listener) {
            titleTextView.setText(item.getTitle());
            addressTextView.setText(item.getAddress());
            imageView.setImageResource(item.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
