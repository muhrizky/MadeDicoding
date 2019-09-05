package com.muhrizqi.submission2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.RecycleViewHolder> {

    private ArrayList<Movie> movies;
    private Context context;

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;

    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup,false);
        return new RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder recycleViewHolder, final int i) {
        recycleViewHolder.tvTitle.setText(movies.get(i).getTitle());
        recycleViewHolder.tvOverview.setText(movies.get(i).getOverview());
        Glide.with(context).load(movies.get(i).getPoster_path())
                .into(recycleViewHolder.imagePhoto);
        recycleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.DETAIL_MOVIE_EXTRA, getMovies().get(i));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class RecycleViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvOverview;
        ImageView imagePhoto;

        public RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.txt_movie_name);
            tvOverview = itemView.findViewById(R.id.text_detail_description_movie);
            imagePhoto = itemView.findViewById(R.id.image_detail_movie);
        }
    }
}
