package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.TopMoviesItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.viewHolder> {
    List<TopMoviesItem> topMoviesItems;
    Context context;

    public FilmAdapter(List<TopMoviesItem> topMoviesItems, Context context) {
        this.topMoviesItems = topMoviesItems;
        this.context = context;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        TopMoviesItem film = topMoviesItems.get(position);
        holder.tv_movieTitle.setText(film.getTitle());
        holder.tv_genre.setText((CharSequence) film.getGenres());
        holder.tv_rating.setText((CharSequence) film.getRating());
    }

    @Override
    public int getItemCount() {
        return topMoviesItems.size();
    }

    public void setTopMoviesItems(List<TopMoviesItem> topMoviesItems) {
        this.topMoviesItems = topMoviesItems;
        notifyDataSetChanged();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tv_movieTitle,tv_genre,tv_rating;
        ImageView ivThumbnail;
        Button favoriteButton;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tv_movieTitle = itemView.findViewById(R.id.tv_movieTitle);
            tv_genre = itemView.findViewById(R.id.tv_genre);
            tv_rating = itemView.findViewById(R.id.tv_rating);
            favoriteButton = itemView.findViewById(R.id.favoriteButton);

        }
    }
}
