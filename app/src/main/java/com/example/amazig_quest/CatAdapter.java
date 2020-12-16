package com.example.amazig_quest;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class CatAdapter extends FirebaseRecyclerAdapter<
        Categorie, CatAdapter.CatViewholder> {

    private FirebaseRecyclerOptions<Categorie> mData;

    public CatAdapter(
            @NonNull FirebaseRecyclerOptions<Categorie> options) {
        super(options);
        this.mData = options;
    }


    @Override
    protected void onBindViewHolder(@NonNull CatViewholder holder,
                                    int position, @NonNull Categorie model) {

        holder.CatNaam.setText(model.getCatNaam());

        Glide.with(holder.itemView.getContext())
                .load(model.getCatImage())
                .into(holder.CatImage);

    }


    @NonNull
    @Override
    public CatViewholder onCreateViewHolder(@NonNull ViewGroup parent,
                                            int viewType) {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data, parent, false);
        return new CatAdapter.CatViewholder(view);
    }



    static class CatViewholder
            extends RecyclerView.ViewHolder {

        TextView CatNaam;
        ImageView CatImage;
        CardView cardView;


        public CatViewholder(@NonNull View itemView) {
            super(itemView);
            CatNaam = itemView.findViewById(R.id.tvCatNaam);
            CatImage = itemView.findViewById(R.id.ivCatImage);
            cardView = itemView.findViewById(R.id.cvCard);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View itemView) {
                    startActivity(intent);
                }
            });
        }
    }

}