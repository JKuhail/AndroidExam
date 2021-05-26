package com.jkuhail.androidexam;

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


import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CardAdapter extends CardSliderAdapter {

    private List<Item> mItems;
    private Context mcontext;
    EventListener listener;

    public CardAdapter(Context mcontext, List<Item> mItems, EventListener listener) {
        this.mItems = mItems;
        this.mcontext = mcontext;
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

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
        Glide.with(mcontext)
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
