package com.example.fetchpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.FeedViewHolder> {

    ArrayList<VendorFeeds> feeds;
    private ImageView imageFeed;


    public FeedsAdapter(Context context){

        // TODO: Add firebase codes here

    }



    @NonNull
    @Override
    public FeedsAdapter.FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.rv_feeds, parent, false);
        return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedsAdapter.FeedViewHolder holder, int position) {

        VendorFeeds feed = feeds.get(position);
        holder.bind(feed);

    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }



    public class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTitle;
        TextView tvDescription;

        public FeedViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.titleFeed);
            tvDescription= itemView.findViewById(R.id.descriptionFeed);
            imageFeed = itemView.findViewById(R.id.imageFeed);
            itemView.setOnClickListener(this);
        }

        public void bind(VendorFeeds feed) {

            tvTitle.setText(feed.getTitle());
            tvDescription.setText(feed.getDescription());
            showImage(feed.getImageUrl());

        }


        @Override
        public void onClick(View v) {

        }

        private void showImage(String url) {

            if (url != null && !(url.isEmpty())){
                Picasso.with(imageFeed.getContext())
                        .load(url)
                        .resize(160,167)
                        .centerCrop()
                        .into(imageFeed);

            }
        }
    }
}
