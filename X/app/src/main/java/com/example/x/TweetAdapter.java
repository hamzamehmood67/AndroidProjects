package com.example.x;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.TweetViewHolder> {

    private List<Tweet> tweetList;

    public TweetAdapter(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }

    @Override
    public TweetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tweet, parent, false);
        return new TweetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TweetViewHolder holder, int position) {
        Tweet tweet = tweetList.get(position);
        holder.author.setText(tweet.getAuthor());
        holder.content.setText(tweet.getContent());
        holder.likes.setText(String.valueOf(tweet.getLikes()));
        holder.retweets.setText(String.valueOf(tweet.getRetweets()));
    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }

    public class TweetViewHolder extends RecyclerView.ViewHolder {
        TextView author, content, timestamp, likes, retweets;

        public TweetViewHolder(View itemView) {
            super(itemView);
            author = itemView.findViewById(R.id.author);
            content = itemView.findViewById(R.id.content);

            likes = itemView.findViewById(R.id.likes);
            retweets = itemView.findViewById(R.id.retweets);
        }
    }
}

