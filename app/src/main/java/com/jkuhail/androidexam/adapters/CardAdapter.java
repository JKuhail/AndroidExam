package com.jkuhail.androidexam.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.islamkhsh.CardSliderAdapter;
import com.jkuhail.androidexam.R;
import com.jkuhail.androidexam.models.Item;


import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CardAdapter extends CardSliderAdapter {

    private final List<Item> mItems;
    private final Context mContext;
    EventListener listener;

    public CardAdapter(Context mContext, List<Item> mItems, EventListener listener) {
        this.mItems = mItems;
        this.mContext = mContext;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @NotNull
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_card, parent, false);

        return new MovieViewHolder(view);
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void bindVH(@NotNull RecyclerView.ViewHolder viewHolder, final int i) {
        ImageView img = viewHolder.itemView.findViewById(R.id.item_image);
        TextView title = viewHolder.itemView.findViewById(R.id.item_title);
        TextView description = viewHolder.itemView.findViewById(R.id.item_about);
        Glide.with(mContext)
                .load(mItems.get(i).getThumb())
                .into(img);
        description.setText(mItems.get(i).getContent());
        title.setText(mItems.get(i).getTitle());
        viewHolder.itemView.setOnTouchListener((v, event) -> {
            listener.onSlide();
            return false;
        });

    }


    static class MovieViewHolder extends RecyclerView.ViewHolder {
        public MovieViewHolder(View view) {
            super(view);
        }
    }
    public  interface EventListener{
        void onSlide();
    }
}
