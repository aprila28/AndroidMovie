package com.alitv.alitvshows.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alitv.alitvshows.R;
import com.alitv.alitvshows.model.Result;
import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private Context context;
    private List<Result> resultList;

    public MovieAdapter(Context context, List<Result> resultList){
        this.context = context;
        this.resultList = resultList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.movie_item, parent, false);
        MovieAdapter.MyViewHolder viewHolder = new MovieAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.tv_title.setText(resultList.get(position).getTitle());
        holder.tv_description.setText(resultList.get(position).getOverview());
        Glide.with(context).load("https://image.tmdb.org/t/p/w185"+ resultList.get(position).getPosterPath()).into(holder.posterImg);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView posterImg;
        TextView tv_title, tv_description;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            posterImg = itemView.findViewById(R.id.movie_img_list);
            tv_title = itemView.findViewById(R.id.tv_title_list);
            tv_description = itemView.findViewById(R.id.tv_description_list);
        }
    }
}
