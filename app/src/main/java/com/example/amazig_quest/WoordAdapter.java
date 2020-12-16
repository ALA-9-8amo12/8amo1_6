package com.example.amazig_quest;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class WoordAdapter extends FirebaseRecyclerAdapter<
        Categorie, WoordAdapter.WoordViewholder> {

    public WoordAdapter(
            @NonNull FirebaseRecyclerOptions<Categorie> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull WoordViewholder holder,
                                    int position, @NonNull Categorie model) {
        holder.Naam.setText(model.getNaam());
        holder.AmVertaling.setText(model.getAmVertaling());

        Glide.with(holder.itemView.getContext())
                .load(model.getImage())
                .into(holder.Image);
    }


    @NonNull
    @Override
    public WoordViewholder onCreateViewHolder(@NonNull ViewGroup parent,
                                            int viewType) {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.woordendata, parent, false);
        return new WoordAdapter.WoordViewholder(view);
    }

    static class WoordViewholder
            extends RecyclerView.ViewHolder {

        TextView Naam;
        TextView AmVertaling;
        ImageView Image;

        public WoordViewholder(@NonNull View itemView) {
            super(itemView);
            Naam = itemView.findViewById(R.id.tvNaam);
            AmVertaling = itemView.findViewById(R.id.tvAmVertaling);
            Image = itemView.findViewById(R.id.ivImage);
        }
    }

}