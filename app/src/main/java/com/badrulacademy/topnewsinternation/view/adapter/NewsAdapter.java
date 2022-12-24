package com.badrulacademy.topnewsinternation.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.badrulacademy.topnewsinternation.R;
import com.badrulacademy.topnewsinternation.services.model.ModelDataClass;
import com.badrulacademy.topnewsinternation.view.ui.NewsWebView;
import com.bumptech.glide.Glide;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    Context mContext;
    List<ModelDataClass> mNewsList;

    public NewsAdapter(Context context, List<ModelDataClass> mNewsList) {
        this.mContext = context;
        this.mNewsList = mNewsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mHeading.setText(mNewsList.get(position).getTitle());
        holder.mContent.setText(mNewsList.get(position).getDescription());
        holder.mAuthor.setText(mNewsList.get(position).getAuthor());
        holder.mTime.setText(mNewsList.get(position).getPublishedAt());

        Glide.with(mContext).load(mNewsList.get(position).getUrlToImage())
                .into(holder.imageView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "CardView...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, NewsWebView.class);
                intent.putExtra("url", mNewsList.get(holder.getAdapterPosition()).getUrl());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mHeading, mContent, mAuthor, mTime;
        CardView cardView;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeading = itemView.findViewById(R.id.textView_mainHeading_id);
            mContent = itemView.findViewById(R.id.textView_content_id);
            mAuthor = itemView.findViewById(R.id.textView_authorName_id);
            mTime = itemView.findViewById(R.id.textView_publishedAt_id);
            cardView = itemView.findViewById(R.id.cardView_id);
            imageView = itemView.findViewById(R.id.imageView_id);
        }
    }
}
